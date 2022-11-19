(ns uri-utils.uri-common)

(defn uri-regex-pattern
  []
  #"(https?)?(:\/\/)?([a-zA-Z.]+)(\/[a-zA-Z]+)?([?])?(([a-zA-Z0-9]+=[a-zA-Z0-9]&?)+)?")
