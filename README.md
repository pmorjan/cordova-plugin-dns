# cordova-plugin-dns

Plugin for Apache Cordova for performing simple DNS lookups.
Android only.

Installation
------------
````
cordova plugin add https://github.com/pmorjan/cordova-plugin-dns.git
````

Usage
-----

````
cordova.plugins.dns.resolve('www.google.com', function(ip) {
    alert(ip);
});

````

