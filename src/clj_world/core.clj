(ns clj-world.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (->> (iota/seq x)
    (clojure.core.reducers/filter identity) ;; filter out empty lines
    (clojure.core.reducers/map  #(->> (clojure.string/split % #"[\t]" -1)
                                   (filter (fn [^String s] (not (.isEmpty s)))) ;; Remove empty fields
                                   count))
    (clojure.core.reducers/fold +)))
