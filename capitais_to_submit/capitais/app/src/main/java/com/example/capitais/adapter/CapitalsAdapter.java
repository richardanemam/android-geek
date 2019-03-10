package com.example.capitais.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.capitais.model.CapitalsModel;
import com.example.capitais.R;

import java.util.List;

public class CapitalsAdapter extends BaseAdapter {

    private final Context context;
    private final List<CapitalsModel> capitalsList;

    public CapitalsAdapter(Context context, List<CapitalsModel> capitalsList){
        this.context = context;
        this.capitalsList = capitalsList;
    }

    @Override
    public int getCount() {
        return this.capitalsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final CapitalsModel capitals = this.capitalsList.get(i);

        if(view == null){
            final LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            view = layoutInflater.inflate(R.layout.capitals_item, null);
        }

        final ImageView thumbnail = view.findViewById(R.id.iv_thumbnail);
        final TextView capital = view.findViewById(R.id.tv_capital_name);

        thumbnail.setImageResource(capitals.getThumbnail());
        capital.setText(capitals.getCity());

        return view;
    }
}
