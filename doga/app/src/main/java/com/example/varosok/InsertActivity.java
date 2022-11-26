package com.example.varosok;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;

public class InsertActivity extends AppCompatActivity {
    private Button visszagomb;
    private Button addgomb;
    private EditText nev;
    private EditText orszag;
    private EditText lakossag;

    private void init() {
        visszagomb = findViewById(R.id.backButton);
        addgomb = findViewById(R.id.addButton);
        nev = findViewById(R.id.nev);
        orszag = findViewById(R.id.orszag);
        lakossag = findViewById(R.id.lakossag);
    }
    private void felvetel() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String name = nev.getText().toString().trim();
        String country = orszag.getText().toString().trim();
        String lakossag1 = lakossag.getText().toString().trim();
        boolean errorBool = false;
        if (name.isEmpty()) {
            Toast.makeText(this, "A név megadása kötelező", Toast.LENGTH_SHORT).show();
            errorBool = true;
        }
        if (country.isEmpty()) {
            Toast.makeText(this, "Az ország megadása kötelező", Toast.LENGTH_SHORT).show();
            errorBool = true;
        }
        if (lakossag1.isEmpty()) {
            Toast.makeText(this, "A lakosság számának megadása kötelező", Toast.LENGTH_SHORT).show();
            errorBool = true;
        }
        if (errorBool) {
            return;
        }
        int lakossagint = Integer.parseInt(lakossag1);
        City city = new City(0, name, country, lakossagint);
        GsonBuilder gsonbuilder = new GsonBuilder();
        Gson converter = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String jsonfile = converter.toJson(city);
        try {
            Response response = RequestHandler.post(MainActivity.BASE_URL, jsonfile);
            if (response.getResponseCode() == 201) {
                Toast.makeText(this, "Város hozzáadva", Toast.LENGTH_SHORT).show();
                nev.setText("");
                orszag.setText("");
                lakossag.setText("");
            } else {
                String content = response.getContent();
                Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        init();
        visszagomb.setOnClickListener(view -> {
            Intent intent = new Intent(InsertActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        addgomb.setOnClickListener(view -> {
            felvetel();
        });
    }
}