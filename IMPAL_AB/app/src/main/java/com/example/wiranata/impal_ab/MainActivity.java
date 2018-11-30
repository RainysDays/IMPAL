package com.example.wiranata.impal_ab;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView list;
    String menumain[] = {"Nasi"};
    int hargamain[] = {2000};
    int checkboxmain[] = {R.drawable.check_box};
    int editmenu[] = {R.drawable.edit};
    int deletemenu[] = {R.drawable.delete};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list =findViewById(R.id.listmain);
        MyAdapter adapter = new MyAdapter(this, menumain, hargamain, checkboxmain, editmenu, deletemenu);
        list.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String mymenumain[];
        int myhargamain[];
        int mycheckboxmain[];
        int myeditmenu[];
        int mydeletemenu[];

        MyAdapter(Context c, String[] menumain,int[] hargamain,int[] checkboxmain, int[] editmenu,int[] deletemenu){
            super(c, R.layout.rowmain);
            this.mycheckboxmain = checkboxmain;
            this.mydeletemenu = deletemenu;
            this.myeditmenu = editmenu;
            this.myhargamain = hargamain;
            this.mymenumain = menumain;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowmain = layoutInflater.inflate(R.layout.rowmain, parent,false);
            CheckBox mycheckboxmain = rowmain.findViewById(R.id.checkboxmain);
            TextView myhargamain = rowmain.findViewById(R.id.hargamain);
            TextView mymenumain = rowmain.findViewById(R.id.menumain);
            Button mydeletemenu = rowmain.findViewById(R.id.deletemenu);
            Button myeditmenu = rowmain.findViewById(R.id.editmenu);
            mycheckboxmain.setBackgroundResource(checkboxmain[position]);
            mydeletemenu.setBackgroundResource(deletemenu[position]);
            myeditmenu.setBackgroundResource(editmenu[position]);
            myhargamain.setText(hargamain[position]);
            mymenumain.setText(menumain[position]);
            return rowmain;
        }
    }
}
