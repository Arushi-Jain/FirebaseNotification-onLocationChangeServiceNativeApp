package com.example.arushi_jain.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class AcceptClass extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"Accepted",Toast.LENGTH_SHORT).show();
        setContentView(R.layout.acceptlayout);
    }
}