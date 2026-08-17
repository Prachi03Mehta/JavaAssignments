package library.main;

import library.model.Book;
import library.model.DigitalResource;
import library.model.LibraryResource;
import library.service.ResourceService;
import library.util.InputValidator;

/**
 * Driver class for the Smart Library Resource Management System.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Smart Library Resource Management System ===\n");

        // ---------- Create at least five resource objects ----------
        LibraryResource[] resources = new LibraryResource[5];

        resources[0] = new Book(1, "Introduction to Algorithms", "T. Cormen", "Computer Science");
        resources[1] = new Book(2, "Clean Code", "Robert C. Martin", "Software Engineering");
        resources[2] = new DigitalResource(3, "Java Programming Notes", "Dr. A. Rao", "PDF");
        resources[3] = new DigitalResource(4, "IEEE Research Paper on AI", "Various Authors", "PDF");
        resources[4] = new Book(5, "Data Structures Simplified", "N. Patel", "Computer Science");

        // Overdue days corresponding (by index) to each resource above
        int[] overdueDays = {10, 0, 5, 15, 3};

        // ---------- Validate resource IDs ----------
        for (LibraryResource resource : resources) {
            if (!InputValidator.validateResourceId(resource.getResourceId())) {
                System.out.println("Invalid Resource ID: " + resource.getResourceId());
            }
        }

        ResourceService resourceService = new ResourceService();

        // ---------- Display complete details of every resource ----------
        System.out.println("----- Resource Details -----\n");
        resourceService.displayAllDetails(resources);

        // ---------- Calculate total fine of all overdue resources ----------
        System.out.println("\n----- Fine Calculation -----");
        double totalFine = resourceService.calculateTotalFine(resources, overdueDays);

        System.out.println();
        LibraryResource.displayTotalResources();
        System.out.printf("Total fine collected across all overdue resources: Rs. %.2f%n", totalFine);
    }
}
