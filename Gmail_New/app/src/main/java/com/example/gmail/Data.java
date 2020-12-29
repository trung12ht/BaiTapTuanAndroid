package com.example.gmail;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Message> getData() {
        List<Message> l = new ArrayList<>();

        l.add(new Message(1, "Google Alerts", "Google Alert - android", "Now android supports multiple voice recogonization", "10:30 AM", "https://api.androidhive.info/json/google.png", false, false, 1));

        return l;
    }
}
