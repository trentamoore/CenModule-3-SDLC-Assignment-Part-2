import java.io.*;
import java.util.*;

/**
 * Trent Moore
 * CEN 3024 – Software Development I
 * May 18, 2025
 * LibrarySystem.java
 *
 * Provides core operations for managing library patrons, including
 * importing from a file, adding, removing, and listing patrons.
 */
public class LibrarySystem {
    /**
     * Maintains insertion order of patrons by their unique ID.
     * Key: patron ID, Value: Patron object
     */
    private final Map<String, Patron> patrons = new LinkedHashMap<>();

    /**
     * Imports patron data from a text file. Each line in the file should
     * contain exactly four fields separated by hyphens:
     *   ID - FullName - Address - FineAmount
     *
     * @param path  file system path to the data file
     * @throws IOException if the file cannot be read
     */
    public void importFromFile(String path) throws IOException {
        // Use try-with-resources to ensure the reader is closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            // Read each line until end of file
            while ((line = br.readLine()) != null) {
                // Split into at most 4 parts: ID, name, address, fine
                String[] parts = line.split("-", 4);
                // Skip any malformed lines
                if (parts.length < 4) {
                    continue;
                }
                String id    = parts[0];
                String name  = parts[1];
                String addr  = parts[2];
                double fine  = Double.parseDouble(parts[3]);
                // Add or overwrite the patron entry by ID
                patrons.put(id, new Patron(id, name, addr, fine));
            }
        }
    }

    /**
     * Adds a single patron to the system. If a patron with the same ID
     * already exists, it will be replaced.
     *
     * @param p  Patron object to add
     */
    public void addPatron(Patron p) {
        patrons.put(p.getId(), p);
    }

    /**
     * Removes a patron by their unique ID.
     *
     * @param id  unique identifier of the patron to remove
     * @return true if a patron was removed, false if no matching ID was found
     */
    public boolean removePatron(String id) {
        return patrons.remove(id) != null;
    }

    /**
     * Prints all patrons to standard output in insertion order.
     * If no patrons are present, prints a message indicating the system is empty.
     */
    public void listPatrons() {
        if (patrons.isEmpty()) {
            System.out.println("No patrons in the system.");
        } else {
            // Leverage Patron.toString() for formatted output
            patrons.values().forEach(System.out::println);
        }
    }
}