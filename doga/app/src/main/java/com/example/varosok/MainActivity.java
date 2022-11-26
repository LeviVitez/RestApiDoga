package com.example.varosok;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button listButton;
    private Button newitemButton;
    protected final static String BASE_URL = "https://retoolapi.dev/u3Ci9z/varosok";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        listButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            startActivity(intent);
            finish();
        });
        newitemButton.setOnClickListener(view -> {
            Intent intent = new Intent( MainActivity.this, InsertActivity.class);
            startActivity(intent);
            finish();
        });
    }
    private void init() {
        listButton = findViewById(R.id.listBtn);
        newitemButton = findViewById(R.id.newitemBtn);
    }
}