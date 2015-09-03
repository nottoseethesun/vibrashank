(ns vibrashank.history
  (:require
   [secretary.core :as secretary :include-macros true]
   [goog.events :as events]
   [goog.history.EventType :as EventType]
   [vibrashank.routes])
  (:import goog.History))

;; This must be called after routes have been defined
(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))
