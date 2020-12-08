package com.example.gmail;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<Message> {
    private Context context;
    private List<Message> messages;

    public TextView from, subject, message, iconText, timestamp;
    public ImageView iconImp, imgProfile;
    public LinearLayout messageContainer;
    public RelativeLayout iconContainer, iconBack, iconFront;

    public MessageAdapter( Context context, int layoutToBeInflated,
                           List<Message> messages) {
        super(context, R.layout.message_list_row);
        this.context = context;
        this.messages = messages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.message_list_row, null);
        from = (TextView) view.findViewById(R.id.from);
        subject = (TextView) view.findViewById(R.id.txt_primary);
        message = (TextView) view.findViewById(R.id.txt_secondary);
        iconText = (TextView) view.findViewById(R.id.icon_text);
        timestamp = (TextView) view.findViewById(R.id.timestamp);
        iconBack = (RelativeLayout) view.findViewById(R.id.icon_back);
        iconFront = (RelativeLayout) view.findViewById(R.id.icon_front);
        iconImp = (ImageView) view.findViewById(R.id.icon_star);
        imgProfile = (ImageView) view.findViewById(R.id.icon_profile);
        messageContainer = (LinearLayout) view.findViewById(R.id.message_container);
        iconContainer = (RelativeLayout) view.findViewById(R.id.icon_container);

        from.setText(messages.get(position).getFrom());
        subject.setText(messages.get(position).getSubject());
        message.setText(messages.get(position).getMessage());
        timestamp.setText(messages.get(position).getTimestamp());

        return (view);
    }
}
