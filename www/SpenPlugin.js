var SpenPlugin = {
	addEvents : function() {
		cordova.exec(function(param) {
		}, function(error) {
			alert("Unable to initialize pen support: " + error);
		}, "SpenPlugin", "penEvents", []);
	}
};
