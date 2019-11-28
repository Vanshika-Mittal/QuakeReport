package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by vanshika on 12/5/17.
 *{@link EarthquakeAdapter} knows how to create a new list object for earthquakes
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{

    private static final String LOCATION_SEPARATOR = " of ";

    /**
     * Create a new {@link EarthquakeAdapter} object.
     * @param context is the current context that the adapter is being created in
     * @param words is the list of {@link Earthquake}s to be displayed.
     */
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Earthquake} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);

        //Setting the background on Magnitude textview based on its value.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        int magnitudeColour = getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColour);

        //Format the magnitude to show 1 decimal place
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());

        // Display this text on the magnitude TextView
        magnitudeTextView.setText(formattedMagnitude);

        //Original location string
        String originalLocation = currentEarthquake.getLocation();

        // The primary and offset location strings.
        String primaryLocation; String locationOffset;


        if (originalLocation.contains(LOCATION_SEPARATOR)){
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView primaryLocationTextView = (TextView) listItemView.findViewById(R.id.primary_location);
        // Get the version number from the current Earthquake object and
        // set this text on the location TextView
        primaryLocationTextView.setText(primaryLocation);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.location_offset);
        // Get the version number from the current Earthquake object and
        // set this text on the location TextView
        locationOffsetTextView.setText(locationOffset);

        //Create a new Date object from the time in milliseconds
        Date dateObject = new Date(currentEarthquake.getTimeInMilliSeconds());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);

        //Format the date string
        String formattedDate = formatDate(dateObject);

        // Get the version name from the current Earthquake object and
        // set this text on the date TextView
        dateTextView.setText(formattedDate);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);

        //Format the date string
        String formattedTime = formatTime(dateObject);

        // Get the version name from the current Earthquake object and
        // set this text on the date TextView
        timeTextView.setText(formattedTime);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a, Z");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude){
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat. format(magnitude);
    }

    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
