(ns finn-bolig-statistikk.config
  (:require [cprop.core :as core]
            [cprop.source :as source]
            [mount.core :refer [defstate args] :as mount]))

(defstate configs
          :start
          (core/load-config
            :file "config.edn"))
