package com.example.android.quakereport;

/**
 * Created by vanshika on 12/5/17.
 * An {@link Earthquake} object contains info on a certain earthquake
 */
public class Earthquake {

    //Magnitude of the earthquake
    private double mMagnitude;

    //Location of the earthquake
    private String mLocation;

    //Date of the earthquake
    private long mTimeInMilliSeconds;

    //Website URL of earthquake
    private String mUrl;

    /**
     * Constructs a new {@link Earthquake} object
     *
     * @param magnitude is the magnitude of the earthquake
     * @param location  is the city location of the earthquake
     * @param timeInMilliSeconds is the date the earthquake occurred
     * @param Url is the Website URL of the earthquake
     */
    public Earthquake(double magnitude, String location, long timeInMilliSeconds, String Url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliSeconds = timeInMilliSeconds;
        mUrl = Url;
    }

    /**
     * @return the magnitude of the earthquake
     */
    public double getMagnitude() {
        return mMagnitude;
    }

    /**
     * @return the location of the earthquake
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * @return the date the earthquake occurred
     */
    public long getTimeInMilliSeconds() {
        return mTimeInMilliSeconds;
    }

    /**
     * @return the web URL of the earthquake
     */
    public String getUrl() {
        return mUrl;
    }
}
