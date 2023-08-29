(defproject finn-bolig-statistikk "0.1.0"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [enlive "1.1.6"]                           ; webscraper
                 [cprop "0.1.19"]                           ; get configs from file/resource
                 [mount "0.1.17"]                           ; state
                 [clj-time "0.15.2"]                        ; working with time
                 [org.clojure/java.jdbc "0.7.12"]           ; db
                 [mysql/mysql-connector-java "8.0.33"]      ; specifically with mysql
                 [org.clojure/tools.logging "1.2.4"]        ; logging
                 ]
  :main ^:skip-aot finn-bolig-statistikk.core
  :aot [finn-bolig-statistikk.core]
  :profiles {:uberjar {:uberjar-name "finn-bolig-statistikk.jar"}}
  :jvm-opts ["-Duser.timezone=UTC"])
