package com.example.arushi_jain.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class RejectClass extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"Rejected",Toast.LENGTH_SHORT).show();
        setContentView(R.layout.rejectlayout);
    }
}
