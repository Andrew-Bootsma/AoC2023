(ns clojure-sandbox.day1.AoC1b (:require [clojure.java.io :as io]) (:require [clojure.string :as str]))

(defn readFile []
  (with-open [rdr (io/reader "src/clojure_sandbox/inputs/AoCinput1.txt")]
    (reduce conj [] (line-seq rdr))))
(readFile)

(defn strToNum [s]
  (Integer/parseInt s))

(defn numSplit [s]
    (re-seq #"\d|one|two|three|four|five|six|seven|eight|nine" s))

(defn reverseNumSplit [s]
  (re-find #"\d|eno|owt|eerht|ruof|evif|xis|neves|thgie|enin" s))

(defn convertStrToNum [s]
    (cond
      (= s "one") "1"
      (= s "two") "2"
      (= s "three") "3"
      (= s "four") "4"
      (= s "five") "5"
      (= s "six") "6"
      (= s "seven") "7"
      (= s "eight") "8"
      (= s "nine") "9"
      :else s))

(defn getFirstCalVal [s]
  (convertStrToNum (first (numSplit s)))
  )

(defn getLastCalVal [s]
  (convertStrToNum (str/reverse (reverseNumSplit (str/reverse s))))
  )

(defn getCalVal [s]
  (strToNum (apply str (getFirstCalVal s) (getLastCalVal s))))

(defn getCalValList [v]
  (map getCalVal v))

(apply + (getCalValList (readFile)))