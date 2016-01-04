(ns vibrashank.views
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]))


(defn home-page [appData, uiData]
  [:div [:h2 "Welcome to vibrashank"]
   [:div [:a {:href "#/about"} "go to about page"]] (userMessage appData) ])


(defn about-page [appData, uiData]
  [:div [:h2 "About vibrashank"]
   [:section [:a {:href "https://github.com/christopherbalz/vibrashank"} "Project Home"]]
   [:div [:a {:href "#/"} "go to the home page"]] (userMessage appData) ])


(defn current-page [app-cursor]
  (let [cp (session/get :current-page)
        pageName (session/get :current-page-name)]

  ;; - - Debug begin:
  (js/console.log pageName)
  ;;(js/console.log app-cursor)
  ;; (println (getPageData app-cursor pageName) )
  ;; - - Debug end.

  [:div [cp (getPageData app-cursor pageName) ]]))


(defn getPageData[ app-cursor pageName ]
       (get (:data (first app-cursor)) (keyword pageName)))


(defn userMessage[ appData ]
  [:div (:user-message appData)]
)
