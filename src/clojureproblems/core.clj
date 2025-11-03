(ns project.core
  (:require [clojure.string :as str]))

;; You can find those problems at https://4clojure.oxal.org/

;;; Problem 1, Nothing but the Truth
;; Difficulty: elementary
;; Complete the expression so it will evaluate to true.
;; -> (= __ true)
(= true true)


;;; Problem 2, Simple Math
;; Difficulty: elementary
;; Innermost forms are evaluated first.
;; -> (= (- 10 (* 2 3)) __)

(= (- 10 (* 2 3)) 4)


;;; Problem 3, Strings
;; Difficulty: elementary
;; Clojure strings are Java strings, so you can use Java string methods on them.
;; -> (= __ (.toUpperCase "hello world"))

(= (str "HELLO WORLD") (.toUpperCase "hello world"))


;;; Problem 4, Lists
;; Difficulty: elementary
;; Lists can be constructed with either a function or a quoted form.
;; -> (= (list __) '(:a :b :c))

(= (list :a :b :c) '(:a :b :c))


;;; Problem 5, conj on lists
;; Difficulty: elementary
;; When operating on a list, the conj function will return a new list with one or more items "added" to the front.
;; -> (= __ (conj '(2 3 4) 1))
;; -> (= __ (conj '(3 4) 2 1))

(= '(1 2 3 4) (conj '(2 3 4) 1))
(= '(1 2 3 4) (conj '(3 4) 2 1))


;;; Problem 6, Vectors
;; Difficulty: elementary
;; Vectors can be constructed several ways. You can compare them with lists.
;; -> (= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))


;;; Problem 7, conj on vectors
;; Difficulty: elementary
;; When operating on a Vector, the conj function will return a new vector with one or more items "added" to the end.
;; -> (= __ (conj [1 2 3] 4))
;; -> (= __ (conj [1 2] 3 4))

(= [1 2 3 4] (conj [1 2 3] 4))
(= [1 2 3 4] (conj [1 2] 3 4))


;;; Problem 8, Sets
;; Difficulty: elementary
;; Sets are collections of unique values.
;; -> (= __ (set '(:a :a :b :c :c :c :c :d :d)))
;; -> (= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))

(= '#{ :a :b :c :d } (set '(:a :a :b :c :c :c :c :d :d)))
(= '#{ :a :b :c :d } (clojure.set/union #{:a :b :c} #{:b :c :d}))


;;; Problem 9, conj on sets
;; Difficulty: elementary
;; When operating on a set, the conj function returns a new set with one or more keys "added".
;; -> (= #{1 2 3 4} (conj #{1 4 3} __))

(= #{1 2 3 4} (conj #{1 4 3} 2))


;;; Problem 10, Maps
;; Difficulty: elementary
;; Maps store key-value pairs. Both maps and keywords can be used as lookup functions. Commas are whitespace.
;; -> (= __ ((hash-map :a 10, :b 20, :c 30) :b))
;; -> (= __ (:b {:a 10, :b 20, :c 30}))

(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))


;;; Problem 11, conj on maps
;; Difficulty: elementary
;; When operating on a map, the conj function returns a new map with one or more key-value pairs "added".
;; -> (= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))


(= {:a 1, :b 2, :c 3} (conj {:a 1} {:b 2} [:c 3]))


;;; Problem 12, Sequences
;; Difficulty: elementary
;; All Clojure collections support sequencing. You can operate on sequences with functions like first, second, and last.
;; -> (= __ (first '(3 2 1)))
;; -> (= __ (second [2 3 4]))
;; -> (= __ (last (list 1 2 3)))

(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))


;;; Problem 13, rest
;; Difficulty: elementary
;; The rest function will return all the items of a sequence except the first.
;; -> (= __ (rest [10 20 30 40]))

(= [20 30 40] (rest [10 20 30 40]))


;;; Problem 14, Functions
;; Difficulty: elementary
;; Clojure has many different ways to create functions.
;; -> (= __ ((fn add-five [x] (+ x 5)) 3))
;; -> (= __ ((fn [x] (+ x 5)) 3))
;; -> (= __ (#(+ % 5) 3))
;; -> (= __ ((partial + 5) 3))

(= 8 ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn [x]  (+ x 5)) 3))
(= 8 (#(+ % 5) 3))
(= 8 ((partial + 5) 3))


;;; Problem 15, Double Down
;; Difficulty: elementary
;; Write a function which doubles a number.
;; -> (= (__ 2) 4)
;; -> (= (__ 3) 6)
;; -> (= (__ 11) 22)
;; -> (= (__ 7) 14)

(= ((fn [x] (* 2 x)) 2) 4)
(= ((fn d [x] (* 2 x)) 3) 6)
(= (#(* % 2) 11) 22)
(= ((partial * 2) 7) 14)


;;; Problem 16, Hello World
;; Difficulty: elementary
;; Write a function which returns a personalized greeting.
;; -> (= (__ "Dave") "Hello, Dave!")
;; -> (= (__ "Jenn") "Hello, Jenn!")
;; -> (= (__ "Rhea") "Hello, Rhea!")

(= ((fn [x] (str "Hello, " x "!")) "Dave") "Hello, Dave!")
(= ((fn greet [x] (str "Hello, " x "!")) "Jenn") "Hello, Jenn!")
(= (#(str "Hello, " % "!") "Rhea") "Hello, Rhea!")


;;; Problem 17, map
;; Difficulty: elementary
;; The map function takes two arguments: a function (f) and a sequence (s). Map returns a new sequence consisting of the result of applying f to each item of s. Do not confuse the map function with the map data structure.
;; -> (= __ (map #(+ % 5) '(1 2 3)))

(= '(6 7 8) (map #(+ % 5) '(1 2 3)))


;;; Problem 18, filter
;; Difficulty: elementary
;; The filter function takes two arguments: a predicate function (f) and a sequence (s). Filter returns a new sequence consisting of all the items of s for which (f item) returns true.
;; -> (= __ (filter #(> % 5) '(3 4 5 6 7)))

(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))


;;; Problem 19, Last Element
;; Difficulty: easy
;; Write a function which returns the last element in a sequence.
;; -> (= (__ [1 2 3 4 5]) 5)
;; -> (= (__ '(5 4 3)) 3)
;; -> (= (__ ["b" "c" "d"]) "d")
;; Special Restrictions : last


(= ((fn [s] (if (next s)
              (recur (next s))
              (first s))) [1 2 3 4 5]) 5)


;;; Problem 20, Penultimate Element
;; Difficulty: easy
;; Write a function which returns the second to last element from a sequence.
;; -> (= (__ (list 1 2 3 4 5)) 4)
;; -> (= (__ ["a" "b" "c"]) "b")
;; -> (= (__ [[1 2] [3 4]]) [1 2])

(= ((fn [x] (if (next (next x))
              (recur (next x))
              (first x))) (list 1 2 3 4 5)) 4)

(= ((fn [x] (if (next (next x))
              (recur (next x))
              (first x))) ["a" "b" "c"]) "b")

(= ((fn [x] (if (next (next x))
              (recur (next x))
              (first x))) [[1 2] [3 4]]) [1 2])


;;; Problem 21, Nth Element
;; Difficulty: easy
;; Write a function which returns the Nth element from a sequence.
;; -> (= (__ '(4 5 6 7) 2) 6)
;; -> (= (__ [:a :b :c] 0) :a)
;; -> (= (__ [1 2 3 4] 1) 2)
;; -> (= (__ '([1 2] [3 4] [5 6]) 2) [5 6])
;; Special Restrictions : nth


(= ((fn [s n] (if (zero? n)
                (first s)
                (recur (rest s) (dec n)))) '(4 5 6 7) 2) 6)

(= ((fn [s n] (if (zero? n)
                (first s)
                (recur (rest s) (dec n)))) [:a :b :c] 0) :a)

(= ((fn [s n] (if (zero? n)
                (first s)
                (recur (rest s) (dec n)))) [1 2 3 4] 1) 2)

(= ((fn [s n] (if (zero? n)
                (first s)
                (recur (rest s) (dec n)))) '([1 2] [3 4] [5 6]) 2) [5 6])


;;; Problem 22, Count a Sequence
;; Difficulty: easy
;; Write a function which returns the total number of elements in a sequence.
;; -> (= (__ '(1 2 3 3 1)) 5)
;; -> (= (__ "Hello World") 11)
;; -> (= (__ [[1 2] [3 4] [5 6]]) 3)
;; -> (= (__ '(13)) 1)
;; -> (= (__ '(:a :b :c)) 3)
;; Special Restrictions : count

(= ((fn cnt [x] (if (= x '[])
              0
              (+ 1 (cnt (rest x))))) '(1 2 3 3 1)) 5)

(= ((fn cnt [x] (if (= x '[])
              0
              (+ 1 (cnt (rest x))))) "Hello World") 11)

(= ((fn cnt [x] (if (= x '[])
              0
              (+ 1 (cnt (rest x))))) [[1 2] [3 4] [5 6]]) 3)

(= ((fn cnt [x] (if (= x '[])
              0
              (+ 1 (cnt (rest x))))) '(13)) 1)

(= ((fn cnt [x] (if (= x '[])
              0
              (+ 1 (cnt (rest x))))) '(:a :b :c)) 3)


;;; Problem 23, Reverse a Sequence
;; Difficulty: easy
;; Write a function which reverses a sequence.
;; -> (= (__ [1 2 3 4 5]) [5 4 3 2 1])
;; -> (= (__ (sorted-set 5 7 2 7)) '(7 5 2))
;; -> (= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])
;; Special Restrictions : reverse


(= ((fn rev [coll] (if (not-empty coll)
                     (cons (last coll) (rev (butlast coll)))
                     )) [1 2 3 4 5]) [5 4 3 2 1])

(= ((fn rev [coll] (if (not-empty coll)
                     (cons (last coll) (rev (butlast coll)))
                     )) (sorted-set 5 7 2 7)) '(7 5 2))

(= ((fn rev [coll] (if (not-empty coll)
                     (cons (last coll) (rev (butlast coll)))
                     )) [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])


;;; Problem 24, Sum It All Up
;; Difficulty: easy
;; Write a function which returns the sum of a sequence of numbers.
;; -> (= (__ [1 2 3]) 6)
;; -> (= (__ (list 0 -2 5 5)) 8)
;; -> (= (__ #{4 2 1}) 7)
;; -> (= (__ '(0 0 -1)) -1)
;; -> (= (__ '(1 10 3)) 14)

(= ((fn [coll] (apply + coll)) [1 2 3]) 6)
(= ((fn [coll] (apply + coll)) (list 0 -2 5 5)) 8)
(= ((fn [coll] (apply + coll)) #{4 2 1}) 7)
(= ((fn [coll] (apply + coll)) '(0 0 -1)) -1)
(= ((fn [coll] (apply + coll)) '(1 10 3)) 14)


;;; Problem 25, Find the odd numbers
;; Difficulty: easy
;; Write a function which returns only the odd numbers from a sequence.
;; -> (= (__ #{1 2 3 4 5}) '(1 3 5))
;; -> (= (__ [4 2 1 6]) '(1))
;; -> (= (__ [2 2 4 6]) '())
;; -> (= (__ [1 1 1 3]) '(1 1 1 3))

(= ((fn [coll] (filter odd? coll)) #{1 2 3 4 5}) '(1 3 5))
(= ((fn [coll] (filter odd? coll)) [4 2 1 6]) '(1))
(= ((fn [coll] (filter odd? coll)) [2 2 4 6]) '())
(= ((fn [coll] (filter odd? coll)) [1 1 1 3]) '(1 1 1 3))


;;; Problem 26, Fibonacci Sequence
;; Difficulty: easy
;; Write a function which returns the first X fibonacci numbers.
;; -> (= (__ 3) '(1 1 2))
;; -> (= (__ 6) '(1 1 2 3 5 8))
;; -> (= (__ 8) '(1 1 2 3 5 8 13 21))

(= (#(take % (map last (iterate (fn [[a b]] [b, (+ a b)]) [0 1]))) 3) '(1 1 2))
(= (#(take % (map last (iterate (fn [[a b]] [b, (+ a b)]) [0 1]))) 6) '(1 1 2 3 5 8))
(= (#(take % (map last (iterate (fn [[a b]] [b, (+ a b)]) [0 1]))) 8) '(1 1 2 3 5 8 13 21))

;;; Problem 27, Palindrome Detector
;; Difficulty: easy
;; Write a function which returns true if the given sequence is a palindrome. Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)
;; -> (false? (__ '(1 2 3 4 5)))
;; -> (true? (__ "racecar"))
;; -> (true? (__ [:foo :bar :foo]))
;; -> (true? (__ '(1 1 3 3 1 1)))
;; -> (false? (__ '(:a :b :c)))

(false? ((fn [coll] (= (seq coll) (reverse coll))) '(1 2 3 4 5)))
(true?  ((fn [coll] (= (seq coll) (reverse coll))) "racecar"))
(true?  ((fn [coll] (= (seq coll) (reverse coll))) [:foo :bar :foo]))
(true?  ((fn [coll] (= (seq coll) (reverse coll))) '(1 1 3 3 1 1)))
(false? ((fn [coll] (= (seq coll) (reverse coll))) '(:a :b :c)))


;;; Problem 28, Flatten a Sequence
;; Difficulty: easy
;; Write a function which flattens a sequence.
;; -> (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
;; -> (= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
;; -> (= (__ '((((:a))))) '(:a))
;; Special Restrictions : flatten

(= ((fn flat [coll] (if (sequential? coll)
                      (mapcat flat coll)
                      (list coll))) '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))

(= ((fn flat [coll] (if (sequential? coll)
                      (mapcat flat coll)
                      (list coll))) ["a" ["b"] "c"]) '("a" "b" "c"))

(= ((fn flat [coll] (if (sequential? coll)
                      (mapcat flat coll)
                      (list coll))) '((((:a))))) '(:a))


(defn ^:dynamic flat [coll] 
  (if (sequential? coll)
    (mapcat flat coll)
    (list coll)))

;; Now trace ALL recursive calls
(dotrace [flat] 
  (flat '((1 2) 3 [4 [5 6]])))


;;; Problem 29, Get the Caps
;; Difficulty: easy
;; Write a function which takes a string and returns a new string containing only the capital letters.
;; -> (= (__ "HeLlO, WoRlD!") "HLOWRD")
;; -> (empty? (__ "nothing"))
;; -> (= (__ "$#A(*&987Zf") "AZ")

(= ((fn getCaps [s] 
      (if (empty? s)
        ""
        (if (Character/isUpperCase (first s))
          (str (first s) (getCaps (rest s)))
          (getCaps (rest s))))) "HeLlO, WoRlD!") "HLOWRD")


(empty? ((fn getCaps [s] 
           (if (empty? s)
             ""
             (if (Character/isUpperCase (first s))
               (str (first s) (getCaps (rest s)))
               (getCaps (rest s))))) "nothing"))

(= ((fn getCaps [s] 
      (if (empty? s)
        ""
        (if (Character/isUpperCase (first s))
          (str (first s) (getCaps (rest s)))
          (getCaps (rest s))))) "$#A(*&987Zf") "AZ")


;;; Problem 30, Compress a Sequence
;; Difficulty: easy
;; Write a function which removes consecutive duplicates from a sequence.
;; -> (= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
;; -> (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
;; -> (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

(= (apply str ((fn [coll]
                 (map first
                      (partition-by identity coll))) "Leeeeeerrroyyy")) "Leroy")

(= ((fn [coll]
      (map first
           (partition-by identity coll))) [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))

(= ((fn [coll]
      (map first
           (partition-by identity coll))) [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

;;; Problem 31, Pack a Sequence
;; Difficulty: easy
;; Write a function which packs consecutive duplicates into sub-lists.
;; -> (= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
;; -> (= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
;; -> (= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))

(= ((fn [coll] (partition-by identity coll)) [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
(= ((fn [coll] (partition-by identity coll)) [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
(= ((fn [coll] (partition-by identity coll)) [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))


;;; Problem 32, Duplicate a Sequence
;; Difficulty: easy
;; Write a function which duplicates each element of a sequence.
;; -> (= (__ [1 2 3]) '(1 1 2 2 3 3))
;; -> (= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
;; -> (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
;; -> (= (__ [44 33]) [44 44 33 33])

(= (#(apply concat (map (fn [a] [a a]) %)) [1 2 3]) '(1 1 2 2 3 3))
(= (#(apply concat (map (fn [a] [a a]) %)) [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (#(apply concat (map (fn [a] [a a]) %)) [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
(= (#(apply concat (map (fn [a] [a a]) %)) [44 33]) [44 44 33 33])


;;; Problem 33, Replicate a Sequence
;; Difficulty: easy
;; Write a function which replicates each element of a sequence a variable number of times.
;; -> (= (__ [1 2 3] 2) '(1 1 2 2 3 3))
;; -> (= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b))
;; -> (= (__ [4 5 6] 1) '(4 5 6))
;; -> (= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
;; -> (= (__ [44 33] 2) [44 44 33 33])

(= ((fn [coll n] 
   (apply concat 
     (for [x coll] 
       (repeat n x)))) [1 2 3] 2) '(1 1 2 2 3 3))

(= ((fn [coll n] 
   (apply concat 
     (for [x coll] 
       (repeat n x)))) [:a :b] 4) '(:a :a :a :a :b :b :b :b))

(= ((fn [coll n] 
   (apply concat 
     (for [x coll] 
       (repeat n x)))) [4 5 6] 1) '(4 5 6))

(= ((fn [coll n] 
   (apply concat 
     (for [x coll] 
       (repeat n x)))) [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))

(= ((fn [coll n] 
   (apply concat 
     (for [x coll] 
       (repeat n x)))) [44 33] 2) [44 44 33 33])

;;; Problem 34, Implement range
;; Difficulty: easy
;; Write a function which creates a list of all integers in a given range.
;; -> (= (__ 1 4) '(1 2 3))
;; -> (= (__ -2 2) '(-2 -1 0 1))
;; -> (= (__ 5 8) '(5 6 7))
;; Special Restrictions : range

(= ((fn [a b] (take (- b a) (iterate inc a))) 1 4) '(1 2 3))
(= ((fn [a b] (take (- b a) (iterate inc a))) -2 2) '(-2 -1 0 1))
(= ((fn [a b] (take (- b a) (iterate inc a))) 5 8) '(5 6 7))


;;; Problem 35, Local bindings
;; Difficulty: elementary
;; Clojure lets you give local names to values using the special let-form.
;; -> (= __ (let [x 5] (+ 2 x)))
;; -> (= __ (let [x 3, y 10] (- y x)))
;; -> (= __ (let [x 21] (let [y 3] (/ x y))))

(= 7 (let [x 5] (+ 2 x)))
(= 7 (let [x 3, y 10] (- y x)))
(= 7 (let [x 21] (let [y 3] (/ x y))))


;;; Problem 36, Let it Be
;; Difficulty: elementary
;; Can you bind x, y, and z so that these are all true?
;; -> (= 10 (let __ (+ x y)))
;; -> (= 4 (let __ (+ y z)))
;; -> (= 1 (let __ z))


(= 10 (let [[x y z][7 3 1]] (+ x y)))
(= 4 (let  [[x y z][7 3 1]] (+ y z)))
(= 1 (let  [[x y z][7 3 1]] z))


;;; Problem 37, Regular Expressions
;; Difficulty: elementary
;; Regex patterns are supported with a special reader macro.
;; -> (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))


;;; Problem 38, Maximum value
;; Difficulty: easy
;; Write a function which takes a variable number of parameters and returns the maximum value.
;; -> (= (__ 1 8 3 4) 8)
;; -> (= (__ 30 20) 30)
;; -> (= (__ 45 67 11) 67)
;; Special Restrictions : max,max-key


(= ((fn [& nums]
      (last (sort nums))) 1 8 3 4) 8)

(= ((fn [& nums]
      (last (sort nums))) 30 20) 30)

(= ((fn [& nums]
      (last (sort nums))) 45 67 11) 67)

;;; Problem 39, Interleave Two Seqs
;; Difficulty: easy
;; Write a function which takes two sequences and returns the first item from each, then the second item from each, then the third, etc.
;; -> (= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
;; -> (= (__ [1 2] [3 4 5 6]) '(1 3 2 4))
;; -> (= (__ [1 2 3 4] [5]) [1 5])
;; -> (= (__ [30 20] [25 15]) [30 25 20 15])


(= ((fn [coll1 coll2]
      (mapcat list coll1 coll2)) [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))

(= ((fn [coll1 coll2]
      (mapcat list coll1 coll2)) [1 2] [3 4 5 6]) '(1 3 2 4))

(= ((fn [coll1 coll2]
      (mapcat list coll1 coll2)) [1 2 3 4] [5]) [1 5])

(= ((fn [coll1 coll2]
      (mapcat list coll1 coll2)) [30 20] [25 15]) [30 25 20 15])


;;; Problem 40, Interpose a Seq
;; Difficulty: easy
;; Write a function which separates the items of a sequence by an arbitrary value.
;; -> (= (__ 0 [1 2 3]) [1 0 2 0 3])
;; -> (= (apply str (__ ", " ["one" "two" "three"])) "one, two, three")
;; -> (= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])
;; Special Restrictions : interpose

(= ((fn [sep coll]
      (butlast (mapcat #(vector % sep) coll))) 0 [1 2 3]) [1 0 2 0 3])

(= (apply str ((fn [sep coll]
      (butlast (mapcat #(vector % sep) coll))) ", " ["one" "two" "three"])) "one, two, three")

(= ((fn [sep coll]
      (butlast (mapcat #(vector % sep) coll))) :z [:a :b :c :d]) [:a :z :b :z :c :z :d])


;;; Problem 41, Drop Every Nth Item
;; Difficulty: easy
;; Write a function which drops every Nth item from a sequence.
;; -> (= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
;; -> (= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
;; -> (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])

(= ((fn [coll n]
  (mapcat #(take (dec n) %) (partition-all n coll))) [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])

(= ((fn [coll n]
  (mapcat #(take (dec n) %) (partition-all n coll))) [:a :b :c :d :e :f] 2) [:a :c :e])

(= ((fn [coll n]
  (mapcat #(take (dec n) %) (partition-all n coll))) [1 2 3 4 5 6] 4) [1 2 3 5 6])


;;; Problem 42, Factorial Fun
;; Difficulty: easy
;; Write a function which calculates factorials.
;; -> (= (__ 1) 1)
;; -> (= (__ 3) 6)
;; -> (= (__ 5) 120)
;; -> (= (__ 8) 40320)

(= ((fn factorial [n]
      (if (<= n 1)
        1
        (* n (factorial (dec n))))) 1) 1)

(= ((fn factorial [n]
      (if (<= n 1)
        1
        (* n (factorial (dec n))))) 3) 6)

(= ((fn factorial [n]
      (if (<= n 1)
        1
        (* n (factorial (dec n))))) 5) 120)

(= ((fn factorial [n]
      (if (<= n 1)
        1
        (* n (factorial (dec n))))) 8) 40320)



;;; Problem 43, Reverse Interleave
;; Difficulty: medium
;; Write a function which reverses the interleave process into x number of subsequences.
;; -> (= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
;; -> (= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
;; -> (= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))



