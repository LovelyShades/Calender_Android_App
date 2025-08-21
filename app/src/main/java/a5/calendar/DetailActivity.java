package a5.calendar;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

/**
 * DetailActivity displays a detailed event description.
 * It is launched when the user clicks on an event’s details button.
 */
public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_EVENT_DETAIL = "extra_event_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);  // Uses activity_detail.xml

        TextView detailTextView = findViewById(R.id.details_text_view);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(EXTRA_EVENT_DETAIL)) {
            String detail = intent.getStringExtra(EXTRA_EVENT_DETAIL);
            detailTextView.setText(detail);
        }
    }
}
