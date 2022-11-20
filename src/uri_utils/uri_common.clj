(ns uri-utils.uri-common)

;;;;; Publically available commons functions.

(defn uri-str->re-mtch
  "Creates a regex matcher for the provided URI string."
  [uri-str]
  (re-matcher #"(https?)?(:\/\/)?([a-zA-Z.]+)(\/[a-zA-Z]+)?([?])?(([a-zA-Z0-9]+=[a-zA-Z0-9]&?)+)?" uri-str))