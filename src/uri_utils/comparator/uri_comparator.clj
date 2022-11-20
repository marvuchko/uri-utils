(ns uri-utils.comparator.uri-comparator
  (:require [uri-utils.parser.uri-regex-parser :as p]))

;;;;; Helper functions for handling URI strings

(defn- str->str-ci
  "Converts string into case insensitive string."
  [raw-str should-ignore]
  (if should-ignore
    (.toLowerCase (String/valueOf raw-str))
    (String/valueOf raw-str)))

;;;;; Publically available functions

(defn uri-equals
  "Checks if two URIs are equal."
  [first-uri second-uri & should-ignore]
  (let [first (p/str->uri first-uri)
        second (p/str->uri second-uri)]
    (and
     (= (str->str-ci (get first :schema) should-ignore)
        (str->str-ci (get second :schema) should-ignore))
     (= (str->str-ci (get first :host) should-ignore)
        (str->str-ci (get second :host) should-ignore))
     (= (str->str-ci (get first :path) should-ignore)
        (str->str-ci (get second :path) should-ignore)))))