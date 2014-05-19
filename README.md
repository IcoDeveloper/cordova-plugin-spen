cordova-plugin-spen
---------------------------

This plugin capture pen events, and dispatch them to 

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
adb logcat -s "S PEN"
```