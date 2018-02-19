package com.erwin.listview.listviewtest;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    ArrayAdapter adaptador;
    ArrayList<String> array;
    String data[];
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista =(ListView) findViewById(R.id.lista);
        array = new ArrayList<String>();
        data = new String[]{
                "HOLA","Mundo"
        };
       /* adaptador=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                array);*/
        adapter = new CustomAdapter(this,
                R.layout.custom_item, array);
        lista.setAdapter(adapter);

    }

    public void onclickButtonAddItem(View view) {
        array.add("Manzana"+ view.getId()+1);

        adapter.notifyDataSetChanged();
        //adaptador.notifyAll();
    }
}
