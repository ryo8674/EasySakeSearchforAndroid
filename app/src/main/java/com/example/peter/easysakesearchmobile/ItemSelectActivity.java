package com.example.peter.easysakesearchmobile;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class ItemSelectActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_select);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        FragmentManager fragmentManager = getSupportFragmentManager();
        ItemFragmentPagerAdapter adapter = new ItemFragmentPagerAdapter(fragmentManager);

        pager.setAdapter(adapter);

        TabLayout tabs = (TabLayout)findViewById(R.id.item_tabs);
        tabs.setupWithViewPager(pager);
    }
}
