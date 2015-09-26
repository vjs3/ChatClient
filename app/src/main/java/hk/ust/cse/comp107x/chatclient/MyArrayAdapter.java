package hk.ust.cse.comp107x.chatclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vishwajeet Srivastava on 23/9/15.
 */
public class MyArrayAdapter extends ArrayAdapter<Message> {
    private final Context context;
    private final ArrayList<Message> messages;

    public MyArrayAdapter(Context context, ArrayList<Message> messages) {
        super(context, R.layout.message, messages);
        this.context = context;
        this.messages = messages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View messageView;

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Change the layout based on who the message is from
        if (messages.get(position).fromMe()) {

            messageView= inflater.inflate(R.layout.mymessage, parent, false);
            TextView msgView= (TextView)messageView.findViewById(R.id.mymessageTextView);
            msgView.setText(messages.get(position).getMessage());
            TextView timeView= (TextView)messageView.findViewById(R.id.mytimeTextView);
            timeView.setText(messages.get(position).getTime());


        } else {

            messageView= inflater.inflate(R.layout.message, parent, false);
            TextView msgView= (TextView)messageView.findViewById(R.id.messageTextView);
            msgView.setText(messages.get(position).getMessage());
            TextView timeView= (TextView)messageView.findViewById(R.id.timeTextView);
            timeView.setText(messages.get(position).getTime());


        }

        return messageView;
    }
}
