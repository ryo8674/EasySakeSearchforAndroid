package com.example.peter.easysakesearchmobile;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 地域と酒造のリストを表示するフラグメント
 */
public class ItemFragment extends Fragment {

    private static final String PREF_CODE_KEY = "pref_code";
    private static final String PROTOCOL = "https";
    private static final String AUTHORITY = "www.sakenote.com";
    private static final String PATH = "api/v1/makers";
    private static final String USER_PARAMETER = "token";
    private static final String USER_KEY = "fac41bf690b41aff22987aa1ae6328cee32b867c";
    private static final String PREF_CODE_PARAMETER = "prefecture_code";

    private ListView itemListView;
    Bundle bundle;

    /**
     * Constructor
     */
    public ItemFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_select_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        bundle = getArguments();
        itemListView = view.findViewById(R.id.item_list);
        if (bundle != null) {
            //URIを生成
            Uri.Builder uriBuilder = new Uri.Builder();
            uriBuilder.scheme(PROTOCOL);
            uriBuilder.authority(AUTHORITY);
            uriBuilder.path(PATH);
            uriBuilder.appendQueryParameter(USER_PARAMETER, USER_KEY);
            uriBuilder.appendQueryParameter(PREF_CODE_PARAMETER, String.valueOf(bundle.get(PREF_CODE_KEY)));
            String utiStr = uriBuilder.toString();

            // 非同期処理開始
            final ItemAsyncTaskGson task = new ItemAsyncTaskGson(view);
            task.execute(utiStr);

            itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Maker maker = task.getList().get(position);
                    DetailFragment detailFragment = new DetailFragment();
                    bundle.putSerializable("maker", maker);
                    detailFragment.setArguments(bundle);

                    //次画面の呼び出し
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.container, detailFragment);

                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });

        } else {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, getPrefList());
            itemListView.setAdapter(adapter);

            itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // 次のフラグメントへ値を渡す
                    ItemFragment itemFragment = new ItemFragment();
                    bundle = new Bundle();
                    bundle.putInt(PREF_CODE_KEY, position + 1);
                    itemFragment.setArguments(bundle);

                    //次画面の呼び出し
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.container, itemFragment);

                    transaction.addToBackStack(null);
                    transaction.commit();

                }
            });
        }

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
