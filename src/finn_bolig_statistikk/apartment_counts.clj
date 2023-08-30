(ns finn-bolig-statistikk.apartment-counts
  (:require [net.cgrand.enlive-html :as html]))

(def finn-url "https://www.finn.no/realestate/homes/search.html?filters=&location=0.20061")

(def scrape-tags ["Nye i dag"
                  "Til salgs"
                  "Solgt siste 3 dager"
                  "Kommer for salg"
                  "Brukt bolig"
                  "Nybygg"
                  "Leilighet"
                  "Enebolig"
                  "Tomannsbolig"
                  "Rekkehus"
                  "Prosjekt"
                  "Garasje/Parkering"
                  "Andre"
                  "Aksje"
                  "Andel"
                  "Eier (Selveier)"
                  "Forhandler"
                  "Privat"
                  "Oslo"
                  "Bjerke"
                  "Bygdøy - Frogner"
                  "Bøler"
                  "Ekeberg - Bekkelaget"
                  "Furuset"
                  "Gamle Oslo"
                  "Grefsen - Kjelsås"
                  "Grorud"
                  "Grünerløkka - Sofienberg"
                  "Hellerud"
                  "Helsfyr - Sinsen"
                  "Lambertseter"
                  "Manglerud"
                  "Nordstrand"
                  "Romsås"
                  "Røa"
                  "Sagene - Torshov"
                  "Sentrum"
                  "Sogn"
                  "Stovner"
                  "St.Hanshaugen - Ullevål"
                  "Søndre Nordstrand"
                  "Ullern"
                  "Uranienborg - Majorstuen"
                  "Vinderen"
                  "Østensjø"])

(def db-col-names
  [:dt
   :Nye_i_dag
   :Til_salgs
   :Solgt_siste_3_dager
   :Kommer_for_salg
   :Brukt_bolig
   :Nybygg
   :Leilighet
   :Enebolig
   :Tomannsbolig
   :Rekkehus
   :Prosjekt
   :Garasje_Parkering
   :Andre
   :Aksje
   :Andel
   :Eier_Selveier
   :Megler
   :Privat
   :Oslo
   :Bjerke
   :Bygdoy_Frogner
   :Boler
   :Ekeberg_Bekkelaget
   :Furuset
   :Gamle_Oslo
   :Grefsen_Kjelsas
   :Grorud
   :Grunerlokka_Sofienberg
   :Hellerud
   :Helsfyr_Sinsen
   :Lambertseter
   :Manglerud
   :Nordstrand
   :Romsas
   :Roa
   :Sagene_Torshov
   :Sentrum
   :Sogn
   :Stovner
   :StHanshaugen_Ulleval
   :Sondre_Nordstrand
   :Ullern
   :Uranienborg_Majorstuen
   :Vinderen
   :Ostensjo])

(defn get-value-from-div-map [divmap]
  (-> divmap
      first
      :content
      (nth 1)
      :content
      (nth 3)
      :content
      (nth 2)
      (clojure.string/replace #" " "")
      Integer/parseInt))

(defn get-tag-from-divmap [divmap]
  (-> divmap
      :content
      (nth 1)
      :content
      first))

(defn find-div-with-tag [div-maps tag]
  (filter #(= tag (get-tag-from-divmap %)) div-maps))

(defn get-count-for-tag-str [map tag-str]
  (let [map-content (find-div-with-tag map tag-str)]
    (if (> (count map-content) 0 )
      (get-value-from-div-map map-content)
      nil)))

(defn get-apartment-counts-as-map []
  (let [content (html/html-resource (java.net.URL. finn-url))
        all-div-input-toggle (html/select content [:div.input-toggle])
        result (map #(get-count-for-tag-str all-div-input-toggle %) scrape-tags)
        date-now (.format (java.text.SimpleDateFormat. "yyyy-MM-dd") (new java.util.Date))
        result-with-date (concat [date-now] result)]
    (zipmap db-col-names result-with-date)))
