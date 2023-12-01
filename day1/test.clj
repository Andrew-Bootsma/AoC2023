(defn numSplit [s]
    (let [result (vec (filter identity (re-seq #"\d+|one|two|three|four|five|six|seven|eight|nine" s)))]
        result))

(println (numSplit "eightwo"))