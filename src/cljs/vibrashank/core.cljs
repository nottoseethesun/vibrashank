(ns vibrashank.core
  (:refer-clojure :exclude [read-string])
  (:require [reagent.core :as reagent]
              [secretary.core :as secretary :include-macros true]
              [goog.events :as events]
              [goog.history.EventType :as EventType]
              [cljs.reader :refer [read-string]]
              [vibrashank.views]
              [vibrashank.routes]
              [vibrashank.history]
              [freactive.core :as fcore])
    (:import goog.History))


;; -------------------------
;; Initialize app


;; Set up the initial atom for the vibrashank cursor.
(def vibrashank-initial-atom (fcore/atom {:vibrashank {
                                                       :app-cursor { :ui {:current-page "home"},
                                                                     :data {
                                                                            :about-page { :user-message "Thanks to the many open-source projects that inspired vibrashank." },
                                                                            :home-page  { :user-message ""  },
                                                                            :todoapp-page  { :user-message "Hint: You can use the browser back/foward button as well."  }
                                                                            }
                                                                     },
                                                       :util {} }
                                          } ))
;; Now make the cursor.
(def vibrashank-cursor (fcore/cursor vibrashank-initial-atom :vibrashank))

(defn mount-root []
  (reagent/render [vibrashank.views/current-page [(:app-cursor vibrashank-cursor)]] (.getElementById js/document "app")))

(defn init! []
  (vibrashank.history/hook-browser-navigation!)
  (mount-root))
