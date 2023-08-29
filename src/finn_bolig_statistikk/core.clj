(ns finn-bolig-statistikk.core
  (:gen-class)
  (:require [mount.core :as mount]
            [finn-bolig-statistikk.apartment-counts :as apartments]
            [finn-bolig-statistikk.db :as db]))

(defn -main
  [& args]
  (mount/start)
  (db/insert-row! (apartments/get-apartment-counts-as-map))
  (println (str "Row inserted.")))
