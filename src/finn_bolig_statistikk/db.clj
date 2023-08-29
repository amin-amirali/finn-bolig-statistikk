(ns finn-bolig-statistikk.db
  (:require [finn-bolig-statistikk.config :as config]
            [mount.core :refer [defstate] :as mount]
            [clojure.java.jdbc :as j]
            [clj-time.coerce :refer [to-sql-time]]))

(def target-table :finn_apartment_counts)

(defstate db-spec
  :start {:dbtype "mysql"
          :dbname (:db-database config/configs)
          :user (:db-username config/configs)
          :password (:db-password config/configs)
          :host (:db-host config/configs)
          :port (:db-port config/configs)})

(defn insert-row! [row-as-map]
  (j/insert! db-spec target-table (update row-as-map :dt to-sql-time))
  )