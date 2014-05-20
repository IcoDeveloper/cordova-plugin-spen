// Javascript file imported automatically by cordova module loader (when isntalled correctly)

var SpenPlugin = function() {
    //alert("Init SCanevas");
};

SpenPlugin.prototype.addEvents = function(successCallback, errorCallback) {

    if (errorCallback == null) { errorCallback = function() {}}
   
    if (typeof errorCallback != "function")  {
        console.log("SpenPlugin.showCanvas failure: failure parameter not a function");
        return
    }
    if (successCallback == null) { successCallback = function() {}}
    
    if (typeof successCallback != "function") {
        console.log("SpenPlugin.showCanvas failure: success callback parameter must be a function");
        return
    }
    
    return cordova.exec(successCallback, errorCallback, 'SpenPlugin', 'addEvents', []);
};

module.exports = new SpenPlugin();
