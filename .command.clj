#!/usr/bin/env bb

(def command-list-location
  (or
    (System/getenv "RIP_DEADCODE_COMMAND_LIST_URL")
    "https://raw.githubusercontent.com/minebreaker/command/master/list.yaml"
    "./list.yaml"))

(def separator "        ")

(as-> (slurp command-list-location) _
  (yaml/parse-string _)
  (map #(clojure.string/join separator [(:desc %) (:c %)]) _)
  (clojure.string/join "\n" _)
  (print _))
