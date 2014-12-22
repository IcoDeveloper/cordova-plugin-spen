Cordova plugin - S Pen event dispatcher
---------------------------

This plugin capture s pen events, and dispatch them to javascript via events.

This is a huge rewrite based on [Breezeemr's work](https://github.com/Breezeemr/cordova-plugin-spen).

Tested with the last Samsung Galaxy Note 10.1 (2014 Edition)

This plugin grabs coordinates, pressure and time of pen events.

## Installation and usage

To install this plugin, follow the [Command-line Interface Guide](http://cordova.apache.org/docs/en/edge/guide_cli_index.md.html#The%20Command-line%20Interface).

This should looks like :

```
cordova plugin add https://github.com/danturi/cordova-plugin-spen.git
```

From the javascript, initialize the plugin using the following command :

```
SpenPlugin.addEvents();
```
Add the event listeners using the following commands:

```
document.addEventListener("ACTION_DOWN", function(event) {});
document.addEventListener("ACTION_MOVE", function(event) {});
document.addEventListener("ACTION_UP", function(event) {});
```
