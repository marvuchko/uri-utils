(ns uri-utils.comparator.uri-comparator
  (:require [uri-utils.parser.uri-regex-parser :as p]))

(defn- str->str-ci
  [raw-str should-ignore]
  (if should-ignore
    (.toLowerCase (String/valueOf raw-str))
    (String/valueOf raw-str)))

(defn uri-equals
  [first-uri second-uri & should-ignore]
  (let [first (p/string->uri first-uri)
        second (p/string->uri second-uri)]
    (and
     (= (str->str-ci (get first :schema) should-ignore)
        (str->str-ci (get second :schema) should-ignore))
     (= (str->str-ci (get first :host) should-ignore)
        (str->str-ci (get second :host) should-ignore))
     (= (str->str-ci (get first :path) should-ignore)
        (str->str-ci (get second :path) should-ignore)))))