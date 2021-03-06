(ns wh.common.text
  (:require [clojure.string :as str]))

(defn pluralize
  ([n singular] (pluralize n singular (str singular "s")))
  ([n singular plural] (if (= n 1) singular plural)))

(defn not-blank
  "Same as `not-empty` but checks strings aren't blank"
  [s]
  (when-not (str/blank? s) s))

(defn n-th [n]
  (str n
       (let [rem (mod n 100)]
         (if (and (>= rem 11) (<= rem 13))
           "th"
           (condp = (mod n 10)
             1 "st"
             2 "nd"
             3 "rd"
             "th")))))

(defn capitalize-words
  "Capitalize every word in a string
   Taken from https://clojuredocs.org/clojure.string/capitalize"
  [s]
  (->> (str/split (str s) #"\b")
       (map str/capitalize)
       str/join))
