package com.example.peter.easysakesearchmobile;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * API通信を行い、Jsonをパースする
 */
class ItemAsyncTaskGson extends AsyncTask<String, Void, String> {

    private final View view;
    private List<Maker> list;

    public List<Maker> getList() {
        return list;
    }

    ItemAsyncTaskGson(View view) {
        this.view = view;
    }

    /**
     * 非同期で行う処理
     *
     * @param uri uri
     * @return 処理結果
     */
    @Override
    protected String doInBackground(String... uri) {
        String result = null;

        // リクエストオブジェクトの生成
        Request request = new Request.Builder()
                .url(uri[0])
                .get()
                .build();

        // クライアントオブジェクトの生成
        OkHttpClient client = new OkHttpClient();

        // リクエストして結果を受け取る
        try {
            Response response = client.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * doInBackgroundの後の処理
     *
     * @param result 非同期処理の結果
     */
    @Override
    protected void onPostExecute(String result) {
        // Gsonの生成
        Gson gson = new GsonBuilder().create();
        // デシリアライズ
        Makers makers = gson.fromJson(result, new TypeToken<Makers>() {
        }.getType());
        list = makers.getMakers();

        GsonArrayAdapter adapter = new GsonArrayAdapter(view.getContext(), list);
        ListView listView = view.findViewById(R.id.item_list);
        listView.setAdapter(adapter);

    }

}
