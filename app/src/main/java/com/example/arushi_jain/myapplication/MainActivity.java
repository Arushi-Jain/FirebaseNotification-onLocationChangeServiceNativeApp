package com.example.arushi_jain.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
  public static final String channelId1 = "Channel1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                shownotification(view);
            }
        });
    }
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startService(new Intent(this, MyService.class));

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void shownotification(View view) {
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String value = sharedpreferences.getString("token", "defaultValue");
        Log.d("MyToken", "Refreshed token: " + value);
        EditText tv = (EditText)findViewById(R.id.textview);
        tv.setText(value);
//        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
//            NotificationChannel channel1 = new NotificationChannel()
//        }
        // add action
        // Create the reply action and add the remote input.

//        Intent intentaccept = new Intent (this, AcceptClass.class);
//        PendingIntent pendingintentaccept = PendingIntent.getActivity(this, 0,intentaccept,PendingIntent.FLAG_UPDATE_CURRENT);
//        Intent intentreject = new Intent (this, RejectClass.class);
//        PendingIntent pendingintentreject = PendingIntent.getActivity(this, 0,intentreject,PendingIntent.FLAG_UPDATE_CURRENT);
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//        builder.setSmallIcon(R.drawable.favicon);
//        builder.setContentTitle("My title");
//        builder.setContentText("This is a default notification");
//        builder.addAction(R.drawable.favicon, "Reject", pendingintentreject);
//        builder.addAction(R.drawable.favicon, "Accept", pendingintentaccept);
//
//        Intent intent = new Intent (this, NotificationClick.class);
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//        stackBuilder.addParentStack(NotificationClick.class);
//        stackBuilder.addNextIntent(intent);
//
//        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
//
//        builder.setContentIntent(pendingIntent);
//        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        nm.notify(0,builder.build());
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
