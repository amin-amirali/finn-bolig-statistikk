(ns finn-bolig-statistikk.core
  (:gen-class)
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
                  "Megler"
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
  (let [map-content (find-div-with-tag map tag-str)
        tag-count (get-value-from-div-map map-content)]
     tag-count))

(defn -main
  [& args]
  (let [content (html/html-resource (java.net.URL. finn-url))
        all-div-input-toggle (html/select content [:div.input-toggle])
        result (map #(get-count-for-tag-str all-div-input-toggle %) scrape-tags)
        date-now (.format (java.text.SimpleDateFormat. "yyyy/MM/dd") (new java.util.Date))
        result-with-date (concat [date-now] result)]
    (println (interpose "," result-with-date))))
