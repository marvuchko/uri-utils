(ns uri-utils.parser.uri-regex-parser
  (:require [uri-utils.uri-common :as c]))

;;;;; Helper functions for processing the URI string query

(defn- param->map
  "Transforms a single query param into map."
  [param]
  (let [[name value] (.split (String/valueOf param) "=")]
      {:name name :value value}))

(defn- query->map
  "Transforms query parameter list into map."
  [query]
  (let [query-list (.split (String/valueOf query) "&")]
    (into [] (map param->map query-list))))


;;;;; Publically available URI parser functions

(defn str->uri
  "Transforms URI string into a map."
  [raw-uri]
  (let [[_ schema _ host path _ query] (re-find (c/uri-str->re-mtch raw-uri))]
    {:schema schema
     :host host
     :path path
     :query (query->map query)}))