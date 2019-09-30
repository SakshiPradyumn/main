package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.ReadOnlyTravelPal;
import seedu.address.model.TravelPal;
import seedu.address.model.itinerary.trip.Trip;
import seedu.address.model.person.Person;

/**
 * An Immutable TravelPal that is serializable to JSON format.
 */
@JsonRootName(value = "travelpal")
class JsonSerializableTravelPal {

    public static final String MESSAGE_DUPLICATE_PERSON = "Persons list contains duplicate person(s).";
    public static final String MESSAGE_DUPLICATE_TRIP = "Trip list contains duplicate trip(s).";
    public static final String MESSAGE_CLASHING_TRIP = "Trip list contains clashing trip";

    private final List<JsonAdaptedPerson> persons = new ArrayList<>();
    private final List<JsonAdaptedTrip> trips = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableTravelPal} with the given persons.
     */
    @JsonCreator
    public JsonSerializableTravelPal(@JsonProperty("persons") List<JsonAdaptedPerson> persons, List<JsonAdaptedTrip> trips) {
        this.persons.addAll(persons);
        this.trips.addAll(trips);
    }

    /**
     * Converts a given {@code ReadOnlyTravelPal} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableTravelPal}.
     */
    public JsonSerializableTravelPal(ReadOnlyTravelPal source) {
        persons.addAll(source.getPersonList().stream().map(JsonAdaptedPerson::new).collect(Collectors.toList()));
        trips.addAll(source.getTripList().stream().map(JsonAdaptedTrip::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code TravelPal} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public TravelPal toModelType() throws IllegalValueException {
        TravelPal travelPal = new TravelPal();
        for (JsonAdaptedPerson jsonAdaptedPerson : persons) {
            Person person = jsonAdaptedPerson.toModelType();
            if (travelPal.hasPerson(person)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_PERSON);
            }
            travelPal.addPerson(person);
        }
        for(JsonAdaptedTrip jsonAdaptedTrip : trips) {
            Trip trip = jsonAdaptedTrip.toModelType();
            if(travelPal.hasTrip(trip)){
                throw new IllegalValueException(MESSAGE_DUPLICATE_TRIP);
            } if (travelPal.hasClashingTrip(trip)){
                throw new IllegalValueException(MESSAGE_CLASHING_TRIP);
            }
            travelPal.addTrip(trip);
        }
        return travelPal;
    }

}
