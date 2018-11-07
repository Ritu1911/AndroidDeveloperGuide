package com.kammo.alokrabi.be_a_android_developer.BroadcastReciever;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.kammo.alokrabi.be_a_android_developer.MainActivity;
import com.kammo.alokrabi.be_a_android_developer.R;

/**
 * Created by Kamala on 11/7/2017.
 */

public class AlermReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        long when = System.currentTimeMillis();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(context , MainActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        Uri alermSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Hey dear!!")
                .setContentText("See more videos and learn new things!!!")
                .setSound(alermSound)
                .setAutoCancel(true)
                .setWhen(when)
                .setPriority(Notification.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setVibrate(new long[] {1000,1000,1000,1000,1000});
        notificationManager.notify(0,builder.build());
    }
}
