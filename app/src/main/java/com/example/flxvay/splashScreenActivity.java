package com.example.flxvay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.flxvay.Sessions.SessionManger;


public class splashScreenActivity extends AppCompatActivity {
    SessionManger sessionManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sessionManger = new SessionManger(this);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(4000);

                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                   //RegisterActivityIntent();

                    check();
                }
            }

        };
        thread.start();
    }


    private void check() {
        if (sessionManger.isLogin()){
            Intent Mainintent= new Intent(splashScreenActivity.this,MainActivity.class);
            startActivity(Mainintent);
            finish();
        }else {
         RegisterActivityIntent();
        }
    }
    private void RegisterActivityIntent(){
        Intent intentSplash = new Intent(splashScreenActivity.this, RegisterActivity.class);
        startActivity(intentSplash);
        finish();
    }
}