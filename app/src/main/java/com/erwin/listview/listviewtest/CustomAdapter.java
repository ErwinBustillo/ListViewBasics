package com.erwin.listview.listviewtest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by erwin on 2/13/2018.
 */

public class CustomAdapter extends ArrayAdapter<String> {
    Context context;
    int layoutResourceId;
    String data[] = null;
    ArrayList<String> datos;

    public CustomAdapter(Context context, int layoutResourceId, ArrayList<String> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.datos = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        DataHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new DataHolder();
            holder.textView = (TextView) row.findViewById(R.id.texto);
            holder.button = (Button) row.findViewById(R.id.button);

            row.setTag(holder);
        }
        else
        {
            holder = (DataHolder)row.getTag();
        }

        String dat = datos.get(position); //data[position];
        holder.textView.setText(dat);
        return row;
    }

    static class DataHolder
    {

        TextView textView;
        Button button;
    }
}
