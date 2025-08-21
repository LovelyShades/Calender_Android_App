package a5.calendar.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import a5.calendar.R;
import a5.calendar.model.Event;

/**
 * EventViewHolder holds references to the views in each event item.
 */
public class EventViewHolder extends RecyclerView.ViewHolder {

    private final TextView eventBlurb;
    private final Button detailsButton;

    public EventViewHolder(View itemView) {
        super(itemView);
        // Ensure these IDs match those defined in event_item.xml.
        eventBlurb = itemView.findViewById(R.id.event_blurb);
        detailsButton = itemView.findViewById(R.id.details_button);
    }

    /**
     * Binds the event information to the view.
     *
     * @param event the Event object to display.
     */
    public void bind(Event event) {
        // Create an abbreviated description (customize as needed).
        String blurb = event.getMonth() + "/" + event.getDay() + " - "
                + event.getCategory() + ": " + event.getName();
        eventBlurb.setText(blurb);
    }

    /**
     * Returns the button used to show details.
     *
     * @return the details button.
     */
    public Button getDetailsButton() {
        return detailsButton;
    }
}
