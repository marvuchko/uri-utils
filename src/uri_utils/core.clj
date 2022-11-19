(ns uri-utils.core
  (:require [uri-utils.comparator.uri-comparator :as cmp])
  (:gen-class))

(defn uri-equals
  [first second & case-sensitive]
  (if (nil? case-sensitive)
    (cmp/uri-equals first second) 
    (cmp/uri-equals first second case-sensitive)))