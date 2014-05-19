package org.apache.cordova.plugin;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;

import com.jmcouillard.SPenEventGeneral;

import com.samsung.spen.lib.input.SPenEventLibrary;
import com.samsung.spensdk.applistener.SPenDetachmentListener;
import com.samsung.spensdk.applistener.SPenHoverListener;
import com.samsung.spensdk.applistener.SPenTouchListener;

/**
 * This class invokes SCanvas called from JavaScript.
 */
public class SpenPlugin extends CordovaPlugin {

	private static final String BACKGROUND_IMAGE_URL = "backgroundImageUrl";
	private static final String SAVEONLYFOREGROUND_IMAGE = "saveOnlyForegroundImage";
	private static final String FOREGROUND_IMAGE_DATA = "foregroundImageData"; 
	
	public static final String SCANVAS_LAUNCH = "com.rub.spen.SCANVAS_LAUNCH";
	public static final String SCANVAS_EVENTS = "com.jmcouillard.SPenEventGeneral.EVENTS";

	public static final int REQUEST_CODE = 1;
	
	public CallbackContext callback;

	public View frame;
	public SPenEventLibrary mSPenEventLibrary;

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		frame = (View) cordova.getActivity().findViewById(android.R.id.content);

        super.initialize(cordova, webView);
    }

	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException  {
		this.callback = callbackContext;
		
		if (action.equals("showCanvas")) {

			JSONObject obj = args.optJSONObject(0);
			if(obj != null) {
            	// backgroundImageUrl = obj.optString(BACKGROUND_IMAGE_URL);//return empty if not defined
            	// saveOnlyForegroundImage = obj.optBoolean(SAVEONLYFOREGROUND_IMAGE);//returns false if not defined
            	// foregroundImageData = obj.optString(FOREGROUND_IMAGE_DATA);// 

            	// if(backgroundImageUrl.isEmpty()) {
            	// 	//default file path
            	// 	backgroundImageUrl = null;
            	// }

            	// if(foregroundImageData.isEmpty()) {
            	// 	foregroundImageData = null;
            	// }
			}

			try {
				// Intent intent = new Intent(SCANVAS_LAUNCH);
				// intent.addCategory(Intent.CATEGORY_DEFAULT);

				// Bundle bundle = new Bundle();
				// bundle.putString("backgroundImageUrl", backgroundImageUrl);
				// bundle.putBoolean("saveOnlyForegroundImage", saveOnlyForegroundImage);
				// bundle.putString("foregroundImageData", foregroundImageData);
				
				// intent.putExtras(bundle);
				
				// this.cordova.startActivityForResult((CordovaPlugin) this, intent, REQUEST_CODE);
				// Log.d("Spen", "open SCanvas Called.");
			}
			catch (Exception ex) {
				Log.d("Spen", "Canvas Launching error.");
			}
		}

		else if (action.equals("addEvents")) {

			try {

				// Create events library
				mSPenEventLibrary = new SPenEventLibrary(); 

				// Register listeners in another type of View that is not SCanvasView-based.  
				mSPenEventLibrary.setSPenTouchListener(webView, new SPenTouchListener()
				{
					@Override
					public boolean onTouchFinger(View view, MotionEvent e) {
						fireEvent("onTouchFinger", createData(e));
						return true;
					}
					@Override
					public boolean onTouchPen(View view, MotionEvent e) {
						fireEvent("onTouchPen", createData(e));
						return true;
					}
					@Override
					public boolean onTouchPenEraser(View view, MotionEvent e) {
						fireEvent("onTouchPenEraser", createData(e));
						return true;
					}		
					@Override
					public void onTouchButtonDown(View view, MotionEvent e) {
						fireEvent("onTouchButtonDown", createData(e));
						return ;
					}
					@Override
					public void onTouchButtonUp(View view, MotionEvent e) {
						fireEvent("onTouchButtonUp", createData(e));
						return ;
					}			
				} );

				Log.d("Spen", "Spen events were correctcly added.");
			}
			catch (Exception ex) {
				Log.d("Spen", "add events Launching error.");
				Log.d("Spen", ex.getMessage());
			}
		}
		else {
			Log.d("Spen", "Invalid Action called");
			return false;
		}

		return true;
	}

	public JSONObject createData(MotionEvent e) {

		JSONObject data = new JSONObject();

		// Add type to data array
		try {
			data.put("x", e.getX());
			data.put("y", e.getY());
		} catch (JSONException ex) {
			Log.d("Spen", "Exception setting type on event data");
		}

		return data;
	}

	public void fireEvent(String type, JSONObject data) {

		// Parse data
		if (data == null) {
			data = new JSONObject();
		}

		// Add type to data array
		try {
			data.put("type", type);
		} catch (JSONException ex) {
			Log.d("Spen", "Exception setting type on event data");
		}

		// Define javascript code and target webview
		final String js = "javascript:try{cordova.fireDocumentEvent('"+type+"'" + (data != null  ? "," + data : "") +" );}catch(e){console.log('exception firing gesture event from native');};";
		final CordovaWebView webview = webView;

		// Send javascript to target
		webView.post(new Runnable() {
			@Override
			public void run() {
				webView.loadUrl(js);
			}
		});
	}

}
