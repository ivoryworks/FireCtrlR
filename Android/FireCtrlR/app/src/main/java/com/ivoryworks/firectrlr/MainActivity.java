package com.ivoryworks.firectrlr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeKeyCode(0x0A);
    }

    private void writeKeyCode(int keyCode) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference keyCodeRef = database.getReference("key_code");
        keyCodeRef.setValue(keyCode);

        DatabaseReference timeRef = database.getReference("time_stamp");
        timeRef.setValue(System.currentTimeMillis());
    }
}
