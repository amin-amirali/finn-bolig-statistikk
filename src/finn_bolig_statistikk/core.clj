(ns finn-bolig-statistikk.core
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

(defn get-count-for-tag-str [map tag-str]
  (let [new-today-map (filter #(= tag-str
                                  (-> %
                                      :content
                                      (nth 1)
                                      :content
                                      first))
                              map)]
    (-> new-today-map
        first
        :content
        (nth 1)
        :content
        (nth 3)
        :content
        (nth 2)
        (clojure.string/replace #" " "")
        Integer/parseInt)))

(defn -main
  [& args]
  (let [content (html/html-resource (java.net.URL. finn-url))
        all-div-input-toggle (html/select content [:div.input-toggle])
        ;nye-i-dag (get-count-for-tag-str all-div-input-toggle "Nye i dag")
        ]
    (doseq [tag scrape-tags]
      (println (str tag " " (get-count-for-tag-str all-div-input-toggle tag))))))
