/**
 * Trent Moore
 * CEN 3024 – Software Development I
 * May 18, 2025
 * Patron.java
 *
 * Models a library patron, encapsulating their unique ID, full name,
 * mailing address, and any outstanding fine amount.
 */
public class Patron {
    /** Unique identifier for this patron */
    private final String id;

    /** Full name of the patron */
    private final String fullName;

    /** Mailing address of the patron */
    private final String address;

    /** Outstanding fine amount owed by the patron */
    private double fineAmount;

    /**
     * Constructs a new Patron with the given attributes.
     *
     * @param id          unique identifier for the patron
     * @param fullName    patron's full name
     * @param address     patron's mailing address
     * @param fineAmount  initial fine amount owed
     */
    public Patron(String id, String fullName, String address, double fineAmount) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.fineAmount = fineAmount;
    }

    /**
     * Retrieves this patron's unique identifier.
     *
     * @return the patron ID
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves this patron's full name.
     *
     * @return the patron's full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Retrieves the current fine amount owed by this patron.
     *
     * @return the fine amount
     */
    public double getFineAmount() {
        return fineAmount;
    }

    /**
     * Returns a string representation of the patron, formatted as:
     * "ID | FullName | Address | $FineAmount"
     *
     * @return formatted string of patron details
     */
    @Override
    public String toString() {
        return String.format("%s | %s | %s | $%.2f",
                id, fullName, address, fineAmount);
    }
}