(ns finn-bolig-statistikk.core
  (:require [net.cgrand.enlive-html :as html]))

(def finn-url "https://www.finn.no/realestate/homes/search.html?filters=&location=0.20061")

(defn get-new-today-count [map]
  (let [new-today-map (filter
                        #(= "Nye i dag"
                            (-> %
                                :content
                                (nth 1)
                                :content
                                first))
                        (html/select map [:div.input-toggle]))]
    (-> new-today-map
        first
        :content
        (nth 1)
        :content
        (nth 3)
        :content
        (nth 2))))

(defn -main
  [& args]
  (let [content (html/html-resource (java.net.URL. finn-url))
        all-div-input-toggle (html/select content [:div.input-toggle])
        nye-i-dag (get-new-today-count all-div-input-toggle)]
    (println nye-i-dag)))
