(ns go.tt
  ;  (:gen-class)
  (:import
    [org.joda.time DateTime]
    [java.util Date]
    [java.text SimpleDateFormat]))

(defn currenttime []
  (DateTime. ))

(defn square [x] (* x x))

(defn hello-world [x] (str "Hello "x))
