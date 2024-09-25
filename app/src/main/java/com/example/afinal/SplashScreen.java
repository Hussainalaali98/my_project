package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        if (Build.VERSION.SDK_INT>=21)
        {
            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        }

//        // eror here
//        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
//        final FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
//        // eror here
//
//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                if (firebaseUser != null)
//                {
//                    startActivity(new Intent(SplashScreen.this,CategoryActivity.class));
//                }
//                else {
//                    startActivity(new Intent(SplashScreen.this, Login.class));
//                }
//                finish();
//            }
//        }, SPLASH_TIME_OUT);
    }
}
