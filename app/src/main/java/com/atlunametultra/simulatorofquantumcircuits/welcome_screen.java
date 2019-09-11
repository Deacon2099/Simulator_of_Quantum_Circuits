package com.atlunametultra.simulatorofquantumcircuits;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class welcome_screen extends Activity {

    private View mContentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        mContentView = findViewById(R.id.welcome_screen);
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCicuitSetup();
            }
        });
    }

    private void goToCicuitSetup() {
        startActivity(new Intent(welcome_screen.this, circuit_setup.class));
    }
}
