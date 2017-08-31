package com.example.peter.easysakesearchmobile;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 非同期処理の結果をリストに格納するためのアダプター
 */
class GsonArrayAdapter extends ArrayAdapter<Maker> {
    private final LayoutInflater inflater;

    /**
     * コンストラクタ
     *
     * @param context context
     * @param list    list
     */
    GsonArrayAdapter(@NonNull Context context, @NonNull List<Maker> list) {
        super(context, android.R.layout.simple_list_item_1, list);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if (convertView == null) {
            view = inflater.inflate(android.R.layout.simple_list_item_1, null);
            holder = new ViewHolder();
            holder.makerName = view.findViewById(android.R.id.text1);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Maker maker = getItem(position);
        if (maker != null) {
            holder.makerName.setText(maker.getName());
        }

        return view;
    }

    /**
     * ViewHolder
     */
    private class ViewHolder {
        TextView makerName;
    }
}
