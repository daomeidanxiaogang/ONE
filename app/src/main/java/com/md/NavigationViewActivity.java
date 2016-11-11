package com.md;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.imagedemo.R;

/**
 * Created by yuexingwu on 2016/10/24.
 */

 public class NavigationViewActivity extends Activity{


    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_layout);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_laout);
        mNavigationView = (NavigationView) findViewById(R.id.navi_all);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navi_blog:
                        Toast.makeText(NavigationViewActivity.this,"Blog",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navi_home:
                        Toast.makeText(NavigationViewActivity.this,"Home",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navi_notify:
                        Toast.makeText(NavigationViewActivity.this,"Notify",Toast.LENGTH_SHORT).show();
                        break;
                }
                item.setChecked(true);
                mDrawerLayout.closeDrawer(Gravity.LEFT);//外层的DrawerLayout
                return false;
            }
        });
        mNavigationView.getHeaderView(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NavigationViewActivity.this,"Pic",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
