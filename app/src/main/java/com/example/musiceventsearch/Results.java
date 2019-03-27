package com.example.musiceventsearch;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Results implements Parcelable {
    private List<Event> event;

    public Results() {
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return event.toString();
    }

    protected Results(Parcel in) {
        if (in.readByte() == 0x01) {
            event = new ArrayList<Event>();
            in.readList(event, Event.class.getClassLoader());
        } else {
            event = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (event == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(event);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Results> CREATOR = new Parcelable.Creator<Results>() {
        @Override
        public Results createFromParcel(Parcel in) {
            return new Results(in);
        }

        @Override
        public Results[] newArray(int size) {
            return new Results[size];
        }
    };
}
