package com.example.bradcampbell.app.hello1;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

/** View Model for the Hello1 view */
public class Hello1ViewModel implements Serializable {
    final DateFormat format = DateFormat.getDateInstance();
    private int serial = -1;
    public transient String updatedText;

    public Hello1ViewModel() {
        serial = 1;
    }

    public void updateSerial() {
        serial++;
    }

    public void updateText() {
        updatedText = String.format("Update #%s at %s", serial, format.format(new Date()));
    }
}
