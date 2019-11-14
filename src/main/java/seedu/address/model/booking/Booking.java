package seedu.address.model.booking;

import seedu.address.model.common.Photo;
import seedu.address.model.itinerary.Budget;

import java.util.Optional;

/**
 * Abstract Class Booking
 */

public class Booking {
    private final Name name;
    private final String contact;
    private final Budget budget;
    private final String bookingPhoto;
    private final String PATH_DEFAULT = "C:\\Users\\Sakshi Pradyumn\\Desktop\\default value.png";

    public Booking(Name name, String contact, Budget budget, String bookingPhoto) {
        this.name = name;
        this.contact = contact;
        this.budget = budget;
        this.bookingPhoto = bookingPhoto;
    }

    public Booking(Name name, String contact, Budget budget) {
        this.name = name;
        this.contact = contact;
        this.budget = budget;
        this.bookingPhoto = PATH_DEFAULT;
    }

    public Name getName() {
        return this.name;
    }

    public String getContact() {
        return this.contact;
    }

    public Budget getBudget() {
        return this.budget;
    }

    public String getBookingPhoto() {
        return bookingPhoto;
    }

    /*
    public String description;

    public String getDescription() {
        return this.description;
    }
    */

    /**
     * Check if two bookings are the same
     *
     * @param otherBooking The other booking to check.
     * @return Boolean of whether the bookings are the same.
     */
    public boolean isSameBooking(Booking otherBooking) {
        if (otherBooking == this) {
            return true;
        } else {
            return otherBooking != null
                    && otherBooking.getName().equals(getName());
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Booking)) {
            return false;
        }

        Booking otherBooking = (Booking) other;
        return otherBooking.getName().equals(getName());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Name: ")
                .append(name.toString())
                .append("Contact: ")
                .append(contact.toString())
                .append(" Total Budget: ")
                .append(budget.toString())
                .append(" Image Path: ")
                .append(bookingPhoto == null ? "default image" : bookingPhoto);

        return builder.toString();
    }
}
