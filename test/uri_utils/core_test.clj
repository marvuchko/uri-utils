(ns uri-utils.core-test
  (:require [clojure.test :refer :all]
            [uri-utils.core :refer :all]))

(deftest uri-equals-test
  (testing 
   "If the same two URIs are equal."
    (is (true? 
         (uri-equals "www.google.com" 
                     "www.google.com")))))

(deftest uri-not-equals-test
  (testing
   "If the same two URIs are equal."
    (is (false? 
         (uri-equals "www.google.com" 
                     "WWW.GOOGLE.COM")))))

(deftest uri-case-insesnitive-equals-test
  (testing
   "If the same two URIs are equal."
    (is (true? 
         (uri-equals "www.google.com" 
                     "WWW.GOOGLE.COM" 
                     true)))))