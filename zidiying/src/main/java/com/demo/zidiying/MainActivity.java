package com.demo.zidiying;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  TopBar topBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topBar = (TopBar) findViewById(R.id.topbar);
//        topBar.setLeftIsvisable(false);
        topBar.setOnTopbarClickListener(new TopBar.TopbarClickListrent() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this,"Left",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this,"right",Toast.LENGTH_SHORT).show();

            }
        });
    }

}
