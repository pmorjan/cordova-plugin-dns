var argscheck = require('cordova/argscheck'),
         exec = require('cordova/exec'),
      cordova = require('cordova');

function DNS() {}

DNS.prototype.resolve = function(hostname, successCallback, errorCallback) {
    if (typeof hostname !== 'string' ||  hostname === null) hostname = 'localhost';
    exec(successCallback, errorCallback, 'DNS', 'resolve', [hostname]);
};

module.exports = new DNS();

