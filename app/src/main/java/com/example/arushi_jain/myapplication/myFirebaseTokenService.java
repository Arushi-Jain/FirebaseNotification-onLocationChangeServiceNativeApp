package com.example.arushi_jain.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


public class myFirebaseTokenService extends FirebaseInstanceIdService {
    public static final String MyPREFERENCES = "MyPrefs" ;
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("MyFirebaseToken", "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendMessageToActivity(refreshedToken);
    }
    private void sendMessageToActivity(String msg) {
        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("token", msg);
        editor.commit();
        Log.d("Message", "Refreshed token set to sharedpreference: ");
        Log.d("gETmESSAGE","gET TOKEN" + sharedpreferences.getString("token", "defaultValue"));
    }
}
