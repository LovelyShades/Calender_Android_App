package a5.calendar.controller;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import a5.calendar.model.Event;

/**
 * CSVParser reads and parses the events.csv file from the assets folder.
 */
public class CSVParser {

    private static final String TAG = "CSVParser";

    /**
     * Parses events from the CSV file.
     *
     * @param context The context used to access the assets folder.
     * @return A list of Event objects.
     */
    public static List<Event> parseEvents(Context context) {
        List<Event> events = new ArrayList<>();
        InputStream is = null;
        BufferedReader reader = null;
        try {
            is = context.getAssets().open("events.csv");
            reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                // Expected CSV format: category, name, location, month, day, admission price, description
                // Use split with limit 7 to capture the entire description even if it contains commas.
                String[] tokens = line.split(",", 7);
                if (tokens.length == 7) {
                    String category = tokens[0].trim();
                    String name = tokens[1].trim();
                    String location = tokens[2].trim();
                    int month = Integer.parseInt(tokens[3].trim());
                    int day = Integer.parseInt(tokens[4].trim());
                    String admissionPrice = tokens[5].trim();
                    String description = tokens[6].trim();
                    Event event = new Event(category, name, location, month, day, admissionPrice, description);
                    events.add(event);
                }
            }
        } catch (IOException | NumberFormatException e) {
            Log.e(TAG, "Error reading CSV file", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e(TAG, "Error closing reader", e);
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    Log.e(TAG, "Error closing input stream", e);
                }
            }
        }
        return events;
    }
}
