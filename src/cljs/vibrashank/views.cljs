(ns vibrashank.views
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]))

(defn home-page []
  [:div [:h2 "Welcome to vibrashank"]
   [:div [:a {:href "#/about"} "go to about page"]]])

(defn about-page [appData, uiData]
  [:div [:h2 "About vibrashank"]
   [:section [:a {:href "https://github.com/christopherbalz/vibrashank"} "Project Home"]]
   [:div [:a {:href "#/"} "go to the home page"]] [:div (:user-text appData)] ])

(defn current-page [app-cursor]
  [:div [(session/get :current-page) (:data ((keyword :current-page) app-cursor)) (:ui ((keyword :current-page) app-cursor)) ]])
