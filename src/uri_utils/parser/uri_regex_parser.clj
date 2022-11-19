(ns uri-utils.parser.uri-regex-parser
  (:require [uri-utils.uri-common :as c]))

(defn- param->map
  [param]
  (let [[name value] (.split (String/valueOf param) "=")]
      {:name name :value value}))

(defn- query->map
  [query]
  (let [query-list (.split (String/valueOf query) "&")]
    (into [] (map param->map query-list))))

(defn string->uri
  [raw-uri]
  (let [[_ schema _ host path _ query] (re-find (c/uri-regex-pattern) raw-uri)]
    {:schema schema
     :host host
     :path path
     :query (query->map query)}))