# vibrashank

[![Join the chat at https://gitter.im/christopherbalz/vibrashank](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/christopherbalz/vibrashank?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

![A John Deere Vibrashank Chisel Plow](http://i.imgur.com/cY2kW0J.jpg)
_"Because a good tool is a pleasure to use."_  That's a [Vibrashank](http://www.ebay.com/sch/i.html?_from=R40&_trksid=p2054897.m570.l1313.TR0.TRC0.H0.Xvibrashank.TRS0&_nkw=vibrashank&_sacat=0) [Chisel Plow](http://www.extension.org/pages/58733/video-clip:-chisel-plow-and-field-cultivator-to-prepare-fields-from-vegetable-farmers-and-their-sust#.VdDAAbRh3kE), characterized by tines made of solid spring steel that are used for [aerating farmland](https://books.google.com/books?id=r-xHAAAAYAAJ&dq=%22from+the+soil+up%22&focus=searchwithinvolume&q=aeration soil).

# Overview

`vibrashank` is a data-flow front-end web framework in ClojureScript that is based on data-flow architecture.  It is designed for maximum data flow and minimum fuss.  This means streams and re-compute over objects and state, API stability over time, and minimum boilerplate.  `vibrashank` rests on ReactJS without using its internals, employing [a singleton root Cursor](http://i.imgur.com/Lf7MNXE.jpg).  `vibrashank` uses CSP to organize and order client/server communication.  `vibrashank` is committed to allowing key-and-tranform libraries (REST alternatives) along the lines of Falcor, Relay, and Om.Next's, to be easily pluggable.

By "front-end" is meant code that either runs on the web browser, or runs on the server as a server-side rendering operation.


# Installation

## Get the Pre-requisites

If  you are not already set up with lein and clojure, you will need to do the following:

1. Install the latest version of the Java JDK (not the SE or JRE).  There is no generic link to the latest JDK, in a mark of lack of usability for developers, but here is [the download page for Java JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
  * There may be easier ways to install the jdk, such as with a brew cask (`Caskroom/cask/java`).
1. Install [lein](http://leiningen.org) in your preferred way, such as `brew install leiningen`.


## Get the Source Code

```{bash}
git clone git@github.com:christopherbalz/vibrashank.git
```

## Running

Also known as "Execution".  First do the steps in [Installation](#installation), then:

```{bash}
lein figwheel
```

### Execution Notes

For more refined commands, see the `lein` commands available for this environment at: https://github.com/reagent-project/reagent-template


## Developing

Do the [Installation](#installation) step and then the [Running](#running) step.  Then:

```{bash}
lein less auto
```


# Links

* Live Demo (currently not much, as this is a w.i.p.): http://glacial-tundra-2891.herokuapp.com/
* Chat: https://gitter.im/christopherbalz/vibrashank
* Wiki (same as link on right): https://github.com/christopherbalz/vibrashank/wiki
* Website: http://christopherbalz.github.io/vibrashank/


# Status

This project is just beginning.


# Contributing

See https://github.com/christopherbalz/vibrashank/wiki#contributing
