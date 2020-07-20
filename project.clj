(defproject finn-bolig-statistikk "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [enlive "1.1.6"]]

  :main ^:skip-aot finn-bolig-statistikk.core
  :aot [finn-bolig-statistikk.core]
  :profiles {:uberjar {:uberjar-name "finn-bolig-statistikk.jar"}})
