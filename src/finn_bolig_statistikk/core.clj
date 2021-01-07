(ns finn-bolig-statistikk.core
  (:gen-class)
  (:require [mount.core :as mount]
            [finn-bolig-statistikk.config :as config]
            [finn-bolig-statistikk.apartment-counts :as apartments]
            [clojure.java.jdbc :refer :all]))

(defn get-data []
  (apartments/get-apartment-counts))

(defn upsert-row [db table row]
  (try (insert! db table row)
       (catch Exception e
         (update! db table row ["ts = ?" (:ts  row)]))))

(defn -main
  [& args]
  (mount/start)
  (let [finn-row (get-data)
        query-res (upsert-row config/db
                              :finn_counts
                              (zipmap apartments/db-col-names finn-row))]
    (println (interpose "," finn-row))))
