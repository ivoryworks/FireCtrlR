package com.ivoryworks.firectrlr;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_0A).setOnClickListener(this);
        findViewById(R.id.btn_0B).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_0A:
                writeKeyCode(0x0A);
                break;
            case R.id.btn_0B:
                writeKeyCode(0x0B);
                break;
        }
    }

    private void writeKeyCode(int keyCode) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference keyCodeRef = database.getReference("key_code");
        DatabaseReference timeRef = database.getReference("time_stamp");

        keyCodeRef.setValue(keyCode);
        timeRef.setValue(System.currentTimeMillis());
    }
}
