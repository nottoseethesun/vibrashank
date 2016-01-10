(ns vibrashank.views
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]))

;; - - Views

(defn home-page []
  [:div [:h2 "Welcome to vibrashank"]
   [:div [:a {:href "#/todoapp"} "To-do List Application"]", an example web app built with vibrashank."]
   [:section.vs-footer
    [:div.vs-container
     [:div [:a {:href "#/about"} "About"]]
     ]]])

(defn about-page []
  [:div [:h2 "About vibrashank"]
   [:section
    [:p "`vibrashank` is a front-end web framework in ClojureScript that is based on data-flow architecture.  It is designed for maximum data
flow and minimum fuss."]
    [:p "This means streams and re-compute over objects and state, API stability over time,
and minimum boilerplate.  `vibrashank` rests on ReactJS without using its internals,
employing " [:a {:href "http://i.imgur.com/Lf7MNXE.jpg"} "a singleton root Cursor"] ".
`vibrashank` uses CSP to organize and order client/server communication.
`vibrashank` is committed to allowing key-and-tranform libraries (REST alternatives) along the lines of Falcor, Relay, and Om.Next's, to be easily pluggable."
    ]]
   [:section.vs-footer
    [:div.vs-container
     [:div [:a {:href "#/"} "Home"]]
     [:div [:a {:href "https://github.com/christopherbalz/vibrashank"} "Project Home"]]]]])

(defn handleDone [ event ]
  (js/console.log event)
  )

(defn todoapp-page []
  [:div [:h2 "To-do List Data Flow App with vibrashank"]
   [:section
    [:input {:type "checkbox" :onChange handleDone} "Done!"]
    ]
   [:section.vs-footer
    [:div.vs-container
     [:a {:href "#/"} "Home"]]]])

;; - - Switch the view based on the cursor.

(defn current-page [app-cursor]
  [:div [(session/get :current-page)]])
