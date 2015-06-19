var SpenPlugin = function() {
	cordova.exec.setNativeToJsBridgeMode(cordova.exec.nativeToJsModes.ONLINE_EVENT);
};

SpenPlugin.prototype.addEvents = function() {
	cordova.exec(function(param) {
	}, function(error) {
		alert("Unable to initialize pen support: " + error);
	}, "SpenPlugin", "penEvents", []);
}

module.exports = new SpenPlugin();
