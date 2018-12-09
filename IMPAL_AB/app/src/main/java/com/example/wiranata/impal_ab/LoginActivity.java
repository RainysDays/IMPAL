package com.example.wiranata.impal_ab;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Cursor cursor;
    Button btnLogin;
    EditText txtUsername, txtPass;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button)findViewById(R.id.bLogin);
        txtUsername = (EditText)findViewById(R.id.etUsername);
        txtPass = (EditText)findViewById(R.id.etPassword);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = txtUsername.getText().toString();
                String pass = txtUsername.getText().toString();

                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TAB1_NAME + " WHERE " + DatabaseHelper.TAB1_COL2 + "=? AND " + DatabaseHelper.TAB1_COL3 + "=?", new String[]{uname, pass});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}