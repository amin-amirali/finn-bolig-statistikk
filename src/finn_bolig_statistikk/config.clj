(ns finn-bolig-statistikk.config
  (:require [cprop.core :refer [load-config]]
            [mount.core :refer [defstate args] :as mount]))

(defstate configs
  :start
  (load-config :resource "config/config.edn"))
