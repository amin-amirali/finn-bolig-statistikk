(ns finn-bolig-statistikk.core
  (:gen-class)
  (:require [net.cgrand.enlive-html :as html]
            [mount.core :as mount]
            [finn-bolig-statistikk.config :as config]
            [finn-bolig-statistikk.apartment-counts :as apartments]))

(defn get-data []
  (apartments/get-apartment-counts))

(defn -main
  [& args]
  (mount/start)
  (get-data))
