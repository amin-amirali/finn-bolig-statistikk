(defproject finn-bolig-statistikk "0.1.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [enlive "1.1.6"]                           ; webscraper
                 [cprop "0.1.17"]                           ; get configs from file/resource
                 [mount "0.1.16"]                           ; state
                 ]

  :main ^:skip-aot finn-bolig-statistikk.core
  :aot [finn-bolig-statistikk.core]
  :profiles {:uberjar {:uberjar-name "finn-bolig-statistikk.jar"}})
