(ns vibrashank.routes
  (:require
   [reagent.core :as reagent :refer [atom]]
   [reagent.session :as session]
   [secretary.core :as secretary :include-macros true]
   [vibrashank.views]))

(secretary/set-config! :prefix "#")

(secretary/defroute "/" []
  (session/put! :current-page #'vibrashank.views/home-page)
  (session/put! :current-page-name "home-page"))

(secretary/defroute "/about" []
  (session/put! :current-page #'vibrashank.views/about-page))

(secretary/defroute "/todoapp" []
  (session/put! :current-page #'vibrashank.views/todoapp-page))
