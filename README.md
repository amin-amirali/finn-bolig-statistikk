# finn-bolig-statistikk

Just another Clojure project.

# Initialising the DB
The app is using mysql. The target table looks like the following:
```sql
CREATE TABLE `finn_apartment_counts` (
    `dt` timestamp NOT NULL,
    `nye_i_dag` mediumint unsigned DEFAULT NULL,
    `til_salgs` mediumint unsigned DEFAULT NULL,
    `solgt_siste_3_dager` mediumint unsigned DEFAULT NULL,
    `kommer_for_salg` mediumint unsigned DEFAULT NULL,
    `brukt_bolig` mediumint unsigned DEFAULT NULL,
    `nybygg` mediumint unsigned DEFAULT NULL,
    `leilighet` mediumint unsigned DEFAULT NULL,
    `enebolig` mediumint unsigned DEFAULT NULL,
    `tomannsbolig` mediumint unsigned DEFAULT NULL,
    `rekkehus` mediumint unsigned DEFAULT NULL,
    `prosjekt` mediumint unsigned DEFAULT NULL,
    `garasje_parkering` mediumint unsigned DEFAULT NULL,
    `andre` mediumint unsigned DEFAULT NULL,
    `aksje` mediumint unsigned DEFAULT NULL,
    `andel` mediumint unsigned DEFAULT NULL,
    `eier_selveier` mediumint unsigned DEFAULT NULL,
    `megler` mediumint unsigned DEFAULT NULL,
    `privat` mediumint unsigned DEFAULT NULL,
    `oslo` mediumint unsigned DEFAULT NULL,
    `bjerke` mediumint unsigned DEFAULT NULL,
    `bygdoy_frogner` mediumint unsigned DEFAULT NULL,
    `boler` mediumint unsigned DEFAULT NULL,
    `ekeberg_bekkelaget` mediumint unsigned DEFAULT NULL,
    `furuset` mediumint unsigned DEFAULT NULL,
    `gamle_oslo` mediumint unsigned DEFAULT NULL,
    `grefsen_kjelsas` mediumint unsigned DEFAULT NULL,
    `grorud` mediumint unsigned DEFAULT NULL,
    `grunerlokka_sofienberg` mediumint unsigned DEFAULT NULL,
    `hellerud` mediumint unsigned DEFAULT NULL,
    `helsfyr_sinsen` mediumint unsigned DEFAULT NULL,
    `lambertseter` mediumint unsigned DEFAULT NULL,
    `manglerud` mediumint unsigned DEFAULT NULL,
    `nordstrand` mediumint unsigned DEFAULT NULL,
    `romsas` mediumint unsigned DEFAULT NULL,
    `roa` mediumint unsigned DEFAULT NULL,
    `sagene_torshov` mediumint unsigned DEFAULT NULL,
    `sentrum` mediumint unsigned DEFAULT NULL,
    `sogn` mediumint unsigned DEFAULT NULL,
    `stovner` mediumint unsigned DEFAULT NULL,
    `sthanshaugen_ulleval` mediumint unsigned DEFAULT NULL,
    `sondre_nordstrand` mediumint unsigned DEFAULT NULL,
    `ullern` mediumint unsigned DEFAULT NULL,
    `uranienborg_majorstuen` mediumint unsigned DEFAULT NULL,
    `vinderen` mediumint unsigned DEFAULT NULL,
    `ostensjo` mediumint unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```

Be sure to create a resource file, under `resources/config/config.edn`, containing the following:
```
{
 :db-host "your-host"
 :db-port your-port (likely 3306)
 :db-username "your-user"
 :db-password "your-pass"
 :db-database "your-db"
 }
```