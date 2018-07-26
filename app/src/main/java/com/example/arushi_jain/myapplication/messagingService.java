package com.example.arushi_jain.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import static android.content.ContentValues.TAG;

public class messagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...
        Log.d(TAG, "Remote Message" + remoteMessage);
        Map<String, String> data = remoteMessage.getData();

        //you can get your text message here.
        String body= data.get("body");
        String title= data.get("title");
        Log.d(TAG, "Message data outside " + body);

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            // build notification
            Intent intentaccept = new Intent (this, AcceptClass.class);
            PendingIntent pendingintentaccept = PendingIntent.getActivity(this, 0,intentaccept,PendingIntent.FLAG_UPDATE_CURRENT);
            Intent intentreject = new Intent (this, RejectClass.class);
            PendingIntent pendingintentreject = PendingIntent.getActivity(this, 0,intentreject,PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setSmallIcon(R.drawable.favicon);
            builder.setContentTitle(title);
            builder.setContentText(body);
            builder.addAction(R.drawable.favicon, "Reject", pendingintentreject);
            builder.addAction(R.drawable.favicon, "Accept", pendingintentaccept);

            Intent intent = new Intent (this, NotificationClick.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addParentStack(NotificationClick.class);
            stackBuilder.addNextIntent(intent);

            PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

            builder.setContentIntent(pendingIntent);
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            nm.notify(0,builder.build());

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
               // scheduleJob();
            } else {
                // Handle message within 10 seconds
               // handleNow();
            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());

        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
}
