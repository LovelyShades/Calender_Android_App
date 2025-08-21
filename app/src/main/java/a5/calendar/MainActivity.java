package a5.calendar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import a5.calendar.controller.CSVParser;
import a5.calendar.model.Event;
import a5.calendar.view.EventAdapter;

/**
 * MainActivity is the primary activity that displays a list of community events.
 * It loads events from a CSV file, displays them in a RecyclerView, and allows sorting.
 */
public class MainActivity extends AppCompatActivity {

    private EventAdapter eventAdapter;
    private List<Event> events;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Uses activity_main.xml

        // Initialize the RecyclerView; the XML must have a RecyclerView with id "recycler_view".
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load events from the CSV file via CSVParser.
        events = CSVParser.parseEvents(this);

        // Log the loaded events for debugging purposes.
        for (Event event : events) {
            Log.d("MainActivity", event.toString());
        }

        // Initialize the adapter and assign it to the RecyclerView.
        eventAdapter = new EventAdapter(events, this);
        recyclerView.setAdapter(eventAdapter);

        // Set up the sort buttons (ensure the button IDs match those in activity_main.xml).
        Button sortByDate = findViewById(R.id.sort_by_date);
        Button sortByName = findViewById(R.id.sort_by_name);
        Button sortByCategory = findViewById(R.id.sort_by_category);

        // Sort by Date: order by month, then day, then category, then name.
        sortByDate.setOnClickListener(v -> {
            events.sort((e1, e2) -> {
                int monthCompare = Integer.compare(e1.getMonth(), e2.getMonth());
                if (monthCompare != 0) return monthCompare;
                int dayCompare = Integer.compare(e1.getDay(), e2.getDay());
                if (dayCompare != 0) return dayCompare;
                int categoryCompare = e1.getCategory().compareTo(e2.getCategory());
                if (categoryCompare != 0) return categoryCompare;
                return e1.getName().compareTo(e2.getName());
            });
            eventAdapter.notifyDataSetChanged();
        });

        // Sort by Name: order by event name, then by date (month/day), then by category.
        sortByName.setOnClickListener(v -> {
            events.sort((e1, e2) -> {
                int nameCompare = e1.getName().compareTo(e2.getName());
                if (nameCompare != 0) return nameCompare;
                int monthCompare = Integer.compare(e1.getMonth(), e2.getMonth());
                if (monthCompare != 0) return monthCompare;
                int dayCompare = Integer.compare(e1.getDay(), e2.getDay());
                if (dayCompare != 0) return dayCompare;
                return e1.getCategory().compareTo(e2.getCategory());
            });
            eventAdapter.notifyDataSetChanged();
        });

        // Sort by Category: order by category, then by date, then by name.
        sortByCategory.setOnClickListener(v -> {
            events.sort((e1, e2) -> {
                int categoryCompare = e1.getCategory().compareTo(e2.getCategory());
                if (categoryCompare != 0) return categoryCompare;
                int monthCompare = Integer.compare(e1.getMonth(), e2.getMonth());
                if (monthCompare != 0) return monthCompare;
                int dayCompare = Integer.compare(e1.getDay(), e2.getDay());
                if (dayCompare != 0) return dayCompare;
                return e1.getName().compareTo(e2.getName());
            });
            eventAdapter.notifyDataSetChanged();
        });
    }
}
