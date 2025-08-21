package a5.calendar.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import a5.calendar.DetailActivity;
import a5.calendar.R;
import a5.calendar.model.Event;

/**
 * EventAdapter binds Event data to the RecyclerView items.
 */
public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private final List<Event> events;
    private final Context context;

    /**
     * Constructs an EventAdapter.
     *
     * @param events  A list of Event objects.
     * @param context The context used to inflate layouts and launch activities.
     */
    public EventAdapter(List<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Event event = events.get(position);
        holder.bind(event);

        // Set a click listener on the details button to launch DetailActivity.
        holder.getDetailsButton().setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            // Construct a formatted string with all event details.
            String formattedDetails = "Date: " + event.getMonth() + "/" + event.getDay() + "\n" +
                    "Event: " + event.getName() + "\n" +
                    "Category: " + event.getCategory() + "\n" +
                    "Location: " + event.getLocation() + "\n" +
                    "Admission: " + event.getAdmissionPrice() + "\n\n" +
                    event.getDescription();
            intent.putExtra(DetailActivity.EXTRA_EVENT_DETAIL, formattedDetails);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
