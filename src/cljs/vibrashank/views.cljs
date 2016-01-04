(ns vibrashank.views
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]))

(defn home-page []
  [:div [:h2 "Welcome to vibrashank"]
   [:div [:a {:href "#/about"} "go to about page"]]])

(defn about-page [appData, uiData]
  [:div [:h2 "About vibrashank"]
   [:section [:a {:href "https://github.com/christopherbalz/vibrashank"} "Project Home"]]
   [:div [:a {:href "#/"} "go to the home page"]] [:div uiData] ])

(defn current-page [app-cursor]
  (let [cp (session/get :current-page)
        pageName (session/get :current-page-name)]

  ;; - - Debug begin:
  (js/console.log pageName)
  (js/console.log app-cursor)
  (println (:data app-cursor))
  ;; - - Debug end.

  [:div [cp (:data ((keyword pageName) app-cursor)) (:ui ((keyword pageName) app-cursor)) ]]))

;; (:ui ((keyword pageName) app-cursor))
;; (:data (pageName app-cursor))
;; (:data ((keyword pageName) app-cursor))
