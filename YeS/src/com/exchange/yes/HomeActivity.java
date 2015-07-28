package com.exchange.yes;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;



import com.gc.materialdesign.views.LayoutRipple;

public class HomeActivity extends FragmentActivity implements OnClickListener {

    private ImageView mBt1, mBt2, mBt3, mBt4;
    private ImageView mSelBg;
    private LinearLayout mTab_item_container;
    private FragmentManager mFM = null;

    LinearLayout content_container, content_container2;

    Intent m_Intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        init();

        changePerson();
    }

    private void init() {
        mTab_item_container = (LinearLayout) findViewById(R.id.tab_item_container);

        mBt1 = (ImageView) findViewById(R.id.tab_bt_1);
        mBt2 = (ImageView) findViewById(R.id.tab_bt_2);
        mBt3 = (ImageView) findViewById(R.id.tab_bt_3);
       

        mBt1.setOnClickListener(this);
        mBt2.setOnClickListener(this);
        mBt3.setOnClickListener(this);
       
        mSelBg = (ImageView) findViewById(R.id.tab_bg_view);
        LayoutParams lp = mSelBg.getLayoutParams();
        lp.width = mTab_item_container.getWidth() / 4;
        
        content_container = (LinearLayout) findViewById(R.id.content_container);
        content_container2 = (LinearLayout) findViewById(R.id.content_container2);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        LayoutParams lp = mSelBg.getLayoutParams();
        lp.width = mTab_item_container.getWidth() / 4;
    }

    private int mSelectIndex = 0;
    private View last, now;
    View v1, v2;

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
        case R.id.tab_bt_1:
            last = mTab_item_container.getChildAt(mSelectIndex);
            now = mTab_item_container.getChildAt(0);
            startAnimation(last, now);
            mSelectIndex = 0;

            changePerson();
            break;
        case R.id.tab_bt_2:
            last = mTab_item_container.getChildAt(mSelectIndex);
            now = mTab_item_container.getChildAt(1);
            startAnimation(last, now);
            mSelectIndex = 1;

            changeBussiness();
            break;
        case R.id.tab_bt_3:
            last = mTab_item_container.getChildAt(mSelectIndex);
            now = mTab_item_container.getChildAt(2);
            startAnimation(last, now);
            mSelectIndex = 2;

            changeMessage();
            break;
       
        default:
            break;
        }
    }

    private void startAnimation(View last, View now) {
        TranslateAnimation ta = new TranslateAnimation(last.getLeft(), now.getLeft(), 0, 0);
        ta.setDuration(300);
        ta.setFillAfter(true);
        mSelBg.startAnimation(ta);
    }

    /**
     * �л�fragement
     */
    private void changePerson() {
        Fragment f = new Home1Fra();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        ft.commit();
    }

    /**
     * �л�fragement
     */
    public void changeBussiness() {
        Fragment f = new Home2Fra();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        ft.commit();
    }

    /**
     * �л�fragement
     */
    public void changeMessage() {
        Fragment f = new Home3Fra();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        ft.commit();
    }

   
    private static Boolean isQuit = false;
    private Timer timer = new Timer();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isQuit == false) {
                isQuit = true;
                Toast.makeText(getBaseContext(), "�ٴε��ȷ���˳����", Toast.LENGTH_SHORT).show();
                TimerTask task = null;
                task = new TimerTask() {
                    @Override
                    public void run() {
                        isQuit = false;
                    }
                };
                timer.schedule(task, 2000);
            } else {
                finish();
            }
        } else {
        }
        return false;
    }

}
