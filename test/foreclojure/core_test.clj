(ns foreclojure.core-test
  (:require [clojure.test :refer :all]
            [foreclojure.core :refer :all]))

(deftest test-fibonacci-sequence
  (is (= (fibonacci-sequence 3) '(1 1 2)))
  (is (= (fibonacci-sequence 6) '(1 1 2 3 5 8)))
  (is (= (fibonacci-sequence 8) '(1 1 2 3 5 8 13 21))))

;; 27. Palindrome Detector
(deftest test-palindrome-detector
  (is (= false (palindrome-detector '(1 2 3 4 5))))
  (is (= true (palindrome-detector "racecar")))
  (is (= true (palindrome-detector [:foo :bar :foo])))
  (is (= true (palindrome-detector '(1 1 3 3 1 1))))
  (is (= false (palindrome-detector '(:a :b :c)))))

;; 38. Maximum value - [2020-10-10 Sat]
(deftest test-maximum-value
  (is (= (maximum-value 1 8 3 4) 8)))

;; 39. Interleave two seqs - [2020-10-11 Sun]
(deftest test-interleave-two-seqs
  (is (= (interleave-two-seqs[1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)))
  (is (= (interleave-two-seqs [1 2] [3 4 5 6]) '(1 3 2 4)))
  (is (= (interleave-two-seqs [1 2 3 4] [5]) [1 5]))
  (is (= (interleave-two-seqs [30 20] [25 15]) [30 25 20 15])))

;; 40. Interpose a seq
(deftest test-interpose-a-seq
  (is (= (interpose-a-seq 0 [1 2 3]) [1 0 2 0 3]))
  (is (= (apply str (interpose-a-seq ", " ["one" "two" "three"])) "one, two, three"))
  (is (= (interpose-a-seq :z [:a :b :c :d]) [:a :z :b :z :c :z :d])))

;; 41. Drop every nth item
(deftest test-drop-every-nth-item
  (is (= (drop-every-nth-item 3 [1 2 3 4 5 6 7 8]) [1 2 4 5 7 8]))
  (is (= (drop-every-nth-item 2 [:a :b :c :d :e :f]) [:a :c :e]))
  (is (= (drop-every-nth-item 4 [1 2 3 4 5 6]) [1 2 3 5 6])))

;; 42. Factorial fun
(deftest test-factorial-fun
  (is (= (factorial-fun 1) 1))
  (is (= (factorial-fun 3) 6))
  (is (= (factorial-fun 5) 120))
  (is (= (factorial-fun 8) 40320)))

;; 64. Intro to reduce
(deftest intro-to-reduce
  (is (= 15 (reduce + [1 2 3 4 5])))
  (is (=  0 (reduce + [])))
  (is (=  6 (reduce + 1 [2 3]))))
