Cordova plugin - S Pen event dispatcher
---------------------------

This plugin capture s pen events, and dispatch them to javascript via events.

This is a huge rewrite based on [Breezeemr's work](https://github.com/Breezeemr/cordova-plugin-spen).

Currently using S Pen SDK 2.3 (more info [here](http://developer.samsung.com/s-pen-sdk)).

## Installation and usage

To install this plugin, follow the [Command-line Interface Guide](http://cordova.apache.org/docs/en/edge/guide_cli_index.md.html#The%20Command-line%20Interface).

This should looks like :

```
cordova plugin add https://github.com/jmcouillard/cordova-plugin-spen.git
```

From the javascript, initialize the plugin using the following command L

```
window.SpenPlugin.addEvents(successCallback, failCallback);
```

## Development

Here are a few tips to help developpement of this plugin.

### View emulator logs related to the plugin

```
adb logcat -s "Spen"
```

## Todos

- Add relative position values (relX and relY), which will be floating numbers between 0 and 1.
- Add hover listener using `setSPenHoverListener()`, using [this approach](https://github.com/SamsungDeveloper/PhotoDesk/blob/master/src/com/samsung/photodesk/editor/ImageEditorActivity.java).