//****************************************************************************************
//Author Name       :   Marcus Manvinder
//Date              :   Sept-25-2012
//Purpose           :   This Java script file provides an interface to interact from HTML to Canvas.
//Table referred    :   NA
//Table updated     :   NA
//Most Important Related Files: org.apache.cordova.plugin.SpenPlugin.Java
//****************************************************************************************


var SpenPlugin = function() {
    //alert("Init SCanevas");
};

//********************************************************************************************************************
// Function Name    :   showCanvas
// Author Name      :   Marcus Manvinder
// Date             :   Sept-25-2012
// Input Parameters :   successCallback - The the success callback function.
//                      errorCallback - The error callback function.
// Purpose          :   The overridden function showCanvas.
// ********************************************************************************************************************
SpenPlugin.prototype.showCanvas = function(successCallback, errorCallback) {

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

    return cordova.exec(successCallback, errorCallback, 'SpenPlugin', 'showCanvas', []);
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

