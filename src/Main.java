import java.util.Scanner;

/**
 * Trent Moore
 * CEN 3024 – Software Development I
 * May 18, 2025
 * Main.java
 * This class provides a command‐line interface for the LibrarySystem.
 * It presents a menu to import patrons from a file, add or remove individual patrons,
 * list all patrons, and exit the application.
 */
public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final LibrarySystem sys = new LibrarySystem();

    /**
     * method: main
     * purpose: Launches the library management CLI, displays the menu,
     *          and routes user choices to the appropriate LibrarySystem actions.
     * arguments:
     *   args – array of command‑line arguments (not used)
     * return: void
     */
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("  1 = Import patrons from file");
            System.out.println("  2 = Add a single patron");
            System.out.println("  3 = Remove a patron");
            System.out.println("  4 = List all patrons");
            System.out.println("  5 = Exit");
            System.out.print("Choice: ");
            String choice = in.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Path to data file: ");
                    String path = in.nextLine();
                    try {
                        sys.importFromFile(path);
                        System.out.println("Imported patrons from file.");
                    } catch (Exception e) {
                        System.err.println("Import failed: " + e.getMessage());
                    }
                }
                case "2" -> {
                    System.out.print("ID: ");
                    String id = in.nextLine();
                    System.out.print("Name: ");
                    String name = in.nextLine();
                    System.out.print("Address: ");
                    String addr = in.nextLine();
                    System.out.print("Fine: ");
                    double fine;
                    try {
                        fine = Double.parseDouble(in.nextLine());
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid fine amount. Patron not added.");
                        break;
                    }
                    sys.addPatron(new Patron(id, name, addr, fine));
                    System.out.println("Patron added.");
                }
                case "3" -> {
                    System.out.print("ID to remove: ");
                    String idToRemove = in.nextLine();
                    if (sys.removePatron(idToRemove)) {
                        System.out.println("Removed.");
                    } else {
                        System.out.println("No such patron.");
                    }
                }
                case "4" -> sys.listPatrons();
                case "5" -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option.");
            }
        }

        in.close();
    }
}