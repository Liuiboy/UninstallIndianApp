package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.log.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout startScan;
    private RelativeLayout inScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

       // findViewById(R.id.in_scan).setVisibility(View.INVISIBLE);
        //findViewById(R.id.start_scan).setVisibility(View.VISIBLE)

    }

    public void scanApp(View view) {
        findViewById(R.id.start_scan).setVisibility(View.INVISIBLE);
        findViewById(R.id.in_scan).setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(5000);
                    findViewById(R.id.in_scan).setVisibility(View.INVISIBLE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
