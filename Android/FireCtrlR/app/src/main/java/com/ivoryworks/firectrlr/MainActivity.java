package com.ivoryworks.firectrlr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        findViewById(R.id.btn_0A).setOnClickListener(this);
        findViewById(R.id.btn_0B).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_0A:
                writeKeyEvent(0x0A);
                break;
            case R.id.btn_0B:
                writeKeyEvent(0x0B);
                break;
        }
    }

    private void writeKeyEvent(int keyCode) {
        FCKeyEvent keyEvent = new FCKeyEvent(System.currentTimeMillis(), keyCode);
        Map<String, Object> postValues = keyEvent.toMap();
        mDatabase.child("key_event").setValue(postValues);
    }
}
