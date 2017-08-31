package com.example.peter.easysakesearchmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 地域選択画面
 */
public class MainActivity extends AppCompatActivity {

    private static final String PREF_CODE_KEY = "pref_code";

    private ListView prefListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefListView = (ListView) findViewById(R.id.pref_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getPrefList());
        prefListView.setAdapter(adapter);

        prefListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ItemSelectActivity.class);
                intent.putExtra(PREF_CODE_KEY, position + 1);
                startActivity(intent);
            }
        });
    }

    /**
     * 都道府県のリストの取得
     */
    List<String> getPrefList() {
        List<String> prefList = new ArrayList<>();
        String[] prefName = getResources().getStringArray(R.array.prefectures);
        Collections.addAll(prefList, prefName);
        return prefList;
    }
}
