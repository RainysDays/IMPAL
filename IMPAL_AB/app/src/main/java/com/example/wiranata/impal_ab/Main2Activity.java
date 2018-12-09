package com.example.wiranata.impal_ab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    int[] checkbox = {R.drawable.check_box,R.drawable.delete,R.drawable.edit};
    String[] menu = {"Nasi","Sayur","Ayam Goreng"};
    int[] harga = {3000,2000,7000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listView =(ListView)findViewById(R.id.ListView);

        CustomAdapter customAdapter=new CustomAdapter();

        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return checkbox.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.rowmain,null);

            CheckBox mycheckbox=(CheckBox) convertView.findViewById(R.id.checkbox);
            TextView mymenu =(TextView) convertView.findViewById(R.id.menu);
            TextView myharga=(TextView) convertView.findViewById(R.id.harga);

            mycheckbox.setBackgroundResource(checkbox[position]);
            mymenu.setText(menu[position]);
            myharga.setText(harga[position]);
            return convertView;
        }
    }
}
