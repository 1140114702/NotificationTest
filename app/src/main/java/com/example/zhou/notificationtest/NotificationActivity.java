package com.example.zhou.notificationtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationActivity extends AppCompatActivity {

    @BindView(R.id.test)
    TextView test;
    @BindView(R.id.activity_notification)
    RelativeLayout activityNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
//        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        manager.cancel(1);
    }

    @OnClick({R.id.test, R.id.activity_notification})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.test:
                test.setText("111");
                break;
            case R.id.activity_notification:
                break;
        }
    }
}
