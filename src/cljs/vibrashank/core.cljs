(ns vibrashank.core
    (:refer-clojure :exclude [atom read-string])
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]
              [secretary.core :as secretary :include-macros true]
              [goog.events :as events]
              [goog.history.EventType :as EventType]
              [freactive.core :refer
               [atom cursor lens-cursor update-in! update!]]
              [cljs.reader :refer [read-string]]
              [vibrashank.views]
              [vibrashank.routes]
              [vibrashank.history])
    (:require-macros
     [freactive.macros :refer [rx]])
    (:import goog.History))


;; -------------------------
;; Initialize app

(def Vibrashank {:app-cursor {}, :util {}})

(defn mount-root []
  (reagent/render [vibrashank.views/current-page [(:app-cursor Vibrashank)]] (.getElementById js/document "app")))

(defn init! []
  (vibrashank.history/hook-browser-navigation!)
  (mount-root))
