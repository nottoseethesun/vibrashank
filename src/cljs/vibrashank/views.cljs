(ns vibrashank.views
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]))

(defn home-page []
  [:div [:h2 "Welcome to vibrashank"]
   [:div [:a {:href "#/about"} "go to about page"]]])

(defn about-page []
  [:div [:h2 "About vibrashank"]
   [:section [:a {:href "https://github.com/christopherbalz/vibrashank"} "Project Home"]]
   [:div [:a {:href "#/"} "go to the home page"]]])

(defn current-page [app-cursor]
  [:div [(session/get :current-page)]])
