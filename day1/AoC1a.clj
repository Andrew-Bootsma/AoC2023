(ns clojure-sandbox.day1.AoC1a (:require [clojure.java.io :as io]) (:require [clojure.string :as str]))

(defn readFile []
  (with-open [rdr (io/reader "src/clojure_sandbox/inputs/AoCinput1.txt")]
    (reduce conj [] (line-seq rdr))))
(readFile)

(defn firstDigit [s]
  (re-find #"\d" s))

(defn strToNum [s]
  (Integer/parseInt s))

(defn getCalVal [s]
  (strToNum (apply str  (firstDigit s) (firstDigit (str/reverse s)))))

(defn getCalValList [v]
  (map getCalVal v))

(apply + (getCalValList (readFile)))