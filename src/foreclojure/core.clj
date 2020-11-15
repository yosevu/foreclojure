(ns foreclojure.core
  (:require [clojure.test :refer :all]))

;; (defn nothing-but-truth []
;;   "Problem 1: This is a clojure form. Enter a value which will make the form evaluate to true."
;;   (= true true))

;; (defn simple-math []
;;   "Problem 2: If you are not familiar with polish notation, simple arithmetic might seem confusing."
;;   (= (- 10 (* 2 3)) 4))

;; (defn my-flatten [coll]
;;   (reduce (fn [result element]
;;             (println result element)
;;             (println (not (coll? element)))
;;             (println (concat result element)),
;;             (println (first element))
;;             (if (not (coll? element))
;;               (concat result (list element))
;;               (my-flatten (first element))))
;;           '()
;;           coll))

;; 23. Reverse a sequence

;; 25. Find the odd numbers

;; 26. Fibonacci sequence
;; [2020-10-17 Sat]
(defn fib
  "Generate a lazy fibonacci sequence"
  ([]
   (fib 1 1))
  ([a b]
   (lazy-seq (cons a (fib b (+ a b))))))

(defn fibonacci-sequence
  "Write a function which returns the first X fibonacci numbers."
  [x]
  (take x (fib)))

(#(take % ((fn fib
             ([]
              (fib 1 1))
             ([a b]
              (lazy-seq (cons a (fib b (+ a b)))))))) 5)

;; anonymous functions can be named e.g. for recursive functions
;; multi-arity function expressions
;; how is a base case resolve in a lazy-seq (cons 1 (cons 1 (cons 2 (cons 3 ...)))

;; 27. Palindrome Detector
(defn palindrome-detector
  "Write a function which returns true if the given sequence is a palindrome."
  [x]
  (= (seq x) (reverse (seq x))))

;; Short version
;; #(= (seq %) (reverse (seq %)))

;; 36. Let it be
;; Can you bind x, y, and z so that these are all true?
(deftest test-let-it-be
  (is (= 10 (let [x 7 y 3 z 1] (+ x y))))
  (is (=  4 (let [x 7 y 3 z 1] (+ y z))))
  (is (=  1 (let [x 7 y 3 z 1] z))))

; let binds pairs of symbol-value pairs in a vector

;; 37. Regular expressoins
;; Regex patterns are supported with a special reader macro.
(deftest test-regular-expressions
  (is (= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce")))))

; re-seq returns a sequence of matches in a string

;; 38. Maximum value - [2020-10-10 Sat]
(defn maximum-value
  "Takes a variable number of parameters and returns the maximum value."
  [& vals]
  (reduce #(if (> %1 %2) %1 %2) vals))
  ;; (reduce (fn [max cur]
            ;; (if (> cur max) cur max)) vals)

; reduce applies f to first 2 items in coll if initial val is not passed as first arg

;; 39. Interleave two seqs - [2020-10-11 Sun]
(defn interleave-two-seqs
  "Write a function which takes two sequences and returns the first item from each,
   then the second item from each, then the third, etc."
  [coll-a coll-b]
  (mapcat #(conj [] %1 %2) coll-a coll-b))

;; 40. Interpose a seq
;; [2020-10-12 Mon]
(defn interpose-a-seq
  "Write a function which separates the items of a sequence by an arbitrary value."
  [sep coll]
  (drop-last (reduce #(conj %1 %2 sep) [] coll)))

;; 41. Drop every nth item
;; [2020-10-13 Tue]
(defn drop-every-nth-item
  "Write a function which drops every Nth item from a sequence."
  [n coll]
  (apply concat (partition-all (dec n) n coll)))

;; 42. Factorial fun
;; [2020-10-14 Wed]
(defn factorial-fun
  "Write a function which calculates factorials."
  [n]
  (reduce * (range 1 (inc n))))

;; 4Clojure solution
#(reduce * (range 1 (inc %)))
