package com.example.zhou.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.send_notice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(MainActivity.this)
                        .setContentTitle("这是一条通知标题")
                        .setContentText("通知的内容，这是内容！")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)//状态栏的图标
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))//下拉看到的图标
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)//点击通知的时候在通知栏消失此通知
//                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))//播放系统声音
//                        .setVibrate(new long[]{0, 500, 300, 500})//震动
//                        .setLights(Color.GREEN, 500, 500)//LED灯闪烁
//                        .setStyle(new NotificationCompat.BigTextStyle().bigText("这里可以填写长内容，这里可以填写长内容，这里可以填写长内容，这里可以填写长内容，这里可以填写长内容，这里可以填写长内容"))
//                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.mipmap.notification)))//设置图片
//                        .setPriority(NotificationCompat.PRIORITY_MAX)//设置重要程度
                        .setDefaults(NotificationCompat.DEFAULT_ALL)//根据手机设置默认的
                        .build();
                manager.notify(1, notification);
            }
        });
    }
}
