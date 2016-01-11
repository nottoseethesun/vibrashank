(ns vibrashank.views
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]
              [freactive.core :as fcore]))


;; - - Util


(defn userMessage[ appData ]
  [:div (:user-message appData)]
)


;; - - Views


(defn home-page [ appData, uiData ]
  [:div [:h2 "Welcome to vibrashank"]
   [:div [:a {:href "#/todoapp"} "To-do List Application"]", an example web app built with vibrashank."]
   [:section.vs-footer
    [:div.vs-container
     [:div [:a {:href "#/about"} "About"]] ( userMessage appData )
     ]]])


(defn about-page [ appData, uiData ]

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
     [:div [:a {:href "https://github.com/christopherbalz/vibrashank"} "Project Home"]]
     ( userMessage appData )
     ]]])


(defn todoapp-page [ appData, uiData ]

  (defn isDoneText []
    (if (appData :isDone)
      [:span "D!"] [:span "Nd."]
    ))

  (defn handleDone [ event ]
    ;;(def dn (fcore/cursor appData :isDone))
    (def dn (appData :isDone))
    ;;(def appD (fcore/cursor (atom (appData :isDone)) (js/console.log) ))
    ;;(reset! (appD (not (appData :isDone)))
    ;;(js/console.log (appData :isDone))
    (swap! dn not) ;; (defn notAtom [ _ ] (atom (not _))))
    ;;(reset! dn (atom (not (appData :isDone))))
    ;;(update-in appData [:isDone] not)
    (js/console.log (appData :isDone))
    )

  [:div [:h2 "To-do List"][:p.vs-subtitle "A data flow app built with vibrashank"]
   [:section
    [:input {:type "checkbox" :onChange handleDone :defaultChecked (appData :isDone) } (isDoneText)]
    ]
   [:section.vs-footer
    [:div.vs-container
     [:a {:href "#/"} "Home"]] (userMessage appData) ]])


;; - - Switch the view based on the cursor.

(defn current-page [ app-cursor ]

  (let [cp (session/get :current-page)
        pageName (session/get :current-page-name)]

    (defn getPageData[ app-cursor pageName ]
      (get (:data (first app-cursor)) (keyword pageName)))

    ;; - - Debug begin:
    (js/console.log "page name: ")
    (js/console.log pageName)
    (js/console.log app-cursor)
    (println (getPageData app-cursor pageName) )
    ;; - - Debug end.

    [:div [cp (getPageData app-cursor pageName) ]]))
