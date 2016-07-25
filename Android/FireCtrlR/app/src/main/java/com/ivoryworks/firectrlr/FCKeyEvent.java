package com.ivoryworks.firectrlr;

import java.util.HashMap;
import java.util.Map;

public class FCKeyEvent {

    public long mTimeStamp;
    public int mKeyCode;

    public FCKeyEvent() {

    }

    public FCKeyEvent(long timeStamp, int keyCode ) {
        this.mTimeStamp = timeStamp;
        this.mKeyCode = keyCode;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put(String.valueOf(mKeyCode), mTimeStamp);

        return result;
    }
}
