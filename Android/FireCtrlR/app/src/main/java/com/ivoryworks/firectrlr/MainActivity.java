package com.ivoryworks.firectrlr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

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

        findViewById(R.id.btn_back).setOnClickListener(this);
        findViewById(R.id.btn_prev).setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.KEYCODE_VOLUME_DOWN:
            if (e.getAction() == KeyEvent.ACTION_DOWN) {
                dispatchKeyRight();
            }
            return true;
        case KeyEvent.KEYCODE_VOLUME_UP:
            if (e.getAction() == KeyEvent.ACTION_DOWN) {
                dispatchKeyLeft();
            }
            return true;
        default:
            break;
        }
        return super.dispatchKeyEvent(e);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.btn_back:
            dispatchKeyLeft();
            break;
        case R.id.btn_prev:
            dispatchKeyRight();
            break;
        default:
            break;
        }
    }

    private void writeKeyEvent(int keyCode) {
        FCKeyEvent keyEvent = new FCKeyEvent(System.currentTimeMillis(), keyCode);
        Map<String, Object> postValues = keyEvent.toMap();
        mDatabase.child("key_event").updateChildren(postValues);
    }

    private void dispatchKeyLeft() {
        writeKeyEvent(0x25);
    }

    private void dispatchKeyRight() {
        writeKeyEvent(0x27);
    }
}
