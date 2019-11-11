package seedu.address.model.booking;

import seedu.address.model.itinerary.Budget;

/**
 * Abstract Class Booking
 */

public class Booking {
    private final Name name;
    private final String contact;
    private final Budget budget;
    private final String type;

    public Booking(Name name, String contact, Budget budget, String type) {
        this.name = name;
        this.contact = contact;
        this.budget = budget;
        this.type = type;
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

    public String getType() {
        return this.type;
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
}
