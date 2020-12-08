package com.dam.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Ventana
 *@author pablo
 * @see MainActivity
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirMain2(View view) {

        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
}