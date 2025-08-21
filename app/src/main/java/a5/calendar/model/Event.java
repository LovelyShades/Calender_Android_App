package a5.calendar.model;

import androidx.annotation.NonNull;

/**
 * The Event class represents a community event with various attributes.
 */
@SuppressWarnings("unused")
public class Event {
    private final String category;
    private final String name;
    private final String location;
    private final int month;
    private final int day;
    private final String admissionPrice;
    private final String description;

    /**
     * Constructs an Event instance with the specified details.
     *
     * @param category The category of the event.
     * @param name The name of the event.
     * @param location The location where the event takes place.
     * @param month The month the event is held.
     * @param day The day of the event.
     * @param admissionPrice The admission price for the event.
     * @param description A detailed description of the event.
     */
    public Event(String category, String name, String location, int month, int day, String admissionPrice, String description) {
        this.category = category;
        this.name = name;
        this.location = location;
        this.month = month;
        this.day = day;
        this.admissionPrice = admissionPrice;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getAdmissionPrice() {
        return admissionPrice;
    }

    public String getDescription() {
        return description;
    }

    @NonNull
    @Override
    public String toString() {
        return "Event{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", month=" + month +
                ", day=" + day +
                ", admissionPrice='" + admissionPrice + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
