(ns uri-utils.core-test
  (:require [clojure.test :refer :all]
            [uri-utils.core :as c]))

;;;;; Testing the simple URIs

(deftest uri-equals-test
  (testing 
   "If the same two URIs are equal."
    (is (true? 
         (c/uri-equals "www.google.com" 
                     "www.google.com")))))

(deftest uri-not-equals-test
  (testing
   "If the same two URIs are equal."
    (is (false? 
         (c/uri-equals "www.google.com" 
                     "WWW.GOOGLE.COM")))))

(deftest uri-case-insesnitive-equals-test
  (testing
   "If the same two URIs are equal."
    (is (true? 
         (c/uri-equals "www.google.com" 
                     "WWW.GOOGLE.COM" 
                     true)))))

;;;;; Testing URIs with query params

(deftest uri-equals-query-test
  (testing
   "If the same two URIs are equal."
    (is (true?
         (c/uri-equals "http://www.google.com/search?q=Marko&age=27" 
                       "http://www.google.com/search?age=27&q=Marko")))))