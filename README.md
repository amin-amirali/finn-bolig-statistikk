# finn-bolig-statistikk

Just another Clojure project.

# Initialising the DB
SQLite is being used as a DB.

Initialise it by creating the db file:
```bash
mkdir db
touch db/database.db
```

Create the table by by starting repl and running:
```clojure
(require '[clojure.java.jdbc :refer :all])
(db-do-commands config/db
                (create-table-ddl :finn_counts
                                  [[:ts :datetime :unique]
                                   [:Nye_i_dag :int]
                                   [:Til_salgs :int]
                                   [:Solgt_siste_3_dager :int]
                                   [:Kommer_for_salg :int]
                                   [:Brukt_bolig :int]
                                   [:Nybygg :int]
                                   [:Leilighet :int]
                                   [:Enebolig :int]
                                   [:Tomannsbolig :int]
                                   [:Rekkehus :int]
                                   [:Prosjekt :int]
                                   [:Garasje_Parkering :int]
                                   [:Andre :int]
                                   [:Aksje :int]
                                   [:Andel :int]
                                   [:Eier_Selveier :int]
                                   [:Megler :int]
                                   [:Privat :int]
                                   [:Oslo :int]
                                   [:Bjerke :int]
                                   [:Bygdoy_Frogner :int]
                                   [:Boler :int]
                                   [:Ekeberg_Bekkelaget :int]
                                   [:Furuset :int]
                                   [:Gamle_Oslo :int]
                                   [:Grefsen_Kjelsas :int]
                                   [:Grorud :int]
                                   [:Grunerlokka_Sofienberg :int]
                                   [:Hellerud :int]
                                   [:Helsfyr_Sinsen :int]
                                   [:Lambertseter :int]
                                   [:Manglerud :int]
                                   [:Nordstrand :int]
                                   [:Romsas :int]
                                   [:Roa :int]
                                   [:Sagene_Torshov :int]
                                   [:Sentrum :int]
                                   [:Sogn :int]
                                   [:Stovner :int]
                                   [:StHanshaugen_Ulleval :int]
                                   [:Sondre_Nordstrand :int]
                                   [:Ullern :int]
                                   [:Uranienborg_Majorstuen :int]
                                   [:Vinderen :int]
                                   [:Ostensjo :int]]))
```
