(ns vibrashank.core
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]
              [secretary.core :as secretary :include-macros true]
              [goog.events :as events]
              [goog.history.EventType :as EventType]
              [vibrashank.views]
              [vibrashank.routes]
              [vibrashank.history])
    (:import goog.History))


;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [vibrashank.views/current-page] (.getElementById js/document "app")))

(defn init! []
  (vibrashank.history/hook-browser-navigation!)
  (mount-root))
