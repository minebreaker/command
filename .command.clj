#!/usr/bin/env bb

(def command-list-location
  (or
    (System/getenv "RIP_DEADCODE_COMMAND_LIST_URL")
    "https://raw.githubusercontent.com/minebreaker/command/master/list.yaml"
    "./list.yaml"))

(def separator "        ")
(def ws-len-td 40)

(defn join-command [map]
  (let [desc (:desc map)
        c (:c map)]
    (if (> (.length desc) ws-len-td)
      (str desc separator c)
      (str
        desc
        (clojure.string/join (repeat (- ws-len-td (.length desc)) " "))
        c))))

(as-> (slurp command-list-location) _
  (yaml/parse-string _)
  (map join-command _)
  (doseq [e _] (println e)))
