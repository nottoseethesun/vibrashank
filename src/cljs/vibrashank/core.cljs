(ns vibrashank.core
  (:refer-clojure :exclude [read-string])
  (:require [reagent.core :as reagent]
              [reagent.session :as session]
              [secretary.core :as secretary :include-macros true]
              [goog.events :as events]
              [goog.history.EventType :as EventType]
              [cljs.reader :refer [read-string]]
              [vibrashank.views]
              [vibrashank.routes]
              [vibrashank.history]
              [freactive.core])
    (:import goog.History))


;; -------------------------
;; Initialize app


(def vibrashank-initial-atom (atom {:vibrashank {:app-cursor {}, :util {}}} )) ;; Set up the initial atom for the vibrashank cursor.
;;(def my-atom (freactive.core/atom {:a {:b [{:x 0}]}}))
;;(freactive.core/cursor my-atom [:a :b])
;;(def vibrashank-cursor (freactive.core/cursor vibrashank-initial-atom :vibrashank))

;; @to-do: change to cursor below
(defn mount-root []
  (reagent/render [vibrashank.views/current-page [(:app-cursor vibrashank-initial-atom)]] (.getElementById js/document "app")))

(defn init! []
  (vibrashank.history/hook-browser-navigation!)
  (mount-root))
