package de.pmorjan.cordova.plugin.dns;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.*;

public class DNS extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
        throws JSONException {
        if (action.equals("resolve")) {
            String name = args.getString(0);
            this.resolve(name, callbackContext);
            return true;
        }
        return false;
    }

    private void resolve(final String name, final CallbackContext callbackContext) {

        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                if (name != null && name.length() > 0) {
                    try {
                        InetAddress address = InetAddress.getByName(name);
                        String host = address.getHostAddress();
                        callbackContext.success(host);
                    } catch (UnknownHostException e) {
                        callbackContext.error("");
                    }
                } else {
                    callbackContext.error("missing argument");
                }
            }
        });
    }
}
