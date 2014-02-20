package com.twitter.university.yamba.api;

import android.os.Parcel;
import android.os.Parcelable;

public class TweetRequest implements Parcelable {
    private final String body;
    private final double latitude;
    private final double longitude;

    public TweetRequest(String body, double latitude, double longitude) {
        this.body = body;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private TweetRequest(Parcel in) {
        this(in.readString(), in.readDouble(), in.readDouble());
    }

    public String getBody() {
        return body;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "TweetRequest{" +
                "body='" + body + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.body);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
    }

    public static final Parcelable.Creator<TweetRequest> CREATOR
            = new Parcelable.Creator<TweetRequest>() {
        public TweetRequest createFromParcel(Parcel in) {
            return new TweetRequest(in);
        }

        public TweetRequest[] newArray(int size) {
            return new TweetRequest[size];
        }
    };
}
