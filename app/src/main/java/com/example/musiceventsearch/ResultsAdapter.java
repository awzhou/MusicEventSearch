package com.example.musiceventsearch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class ResultsAdapter extends ArrayAdapter{
    private Context context;
    private int resource;
    private List<Event> eventList;

    public ResultsAdapter(@NonNull Context context, int resource, List<Event> eventList) {
        super(context, resource, eventList);
        this.context = context;
        this.resource = resource;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //just like we did with fragments:
        //inflate a layout, wire widgets, insert data, return the layout
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_eventlist, parent, false);
        }

        TextView textViewName = convertView.findViewById(R.id.textView_eventItem_name);

        Event currentEvent = eventList.get(position);
        textViewName.setText(currentEvent.toString());

        return convertView;
    }
}
