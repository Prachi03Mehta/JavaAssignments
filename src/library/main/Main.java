package library.main;

import library.model.LibraryResource;
import library.model.Book;
import library.model.DigitalResource;
import library.model.Printable;
import library.util.InputValidator;

public class Main {

    public static void main(String[] args) {

        // Create at least five objects
        LibraryResource[] resources = new LibraryResource[5];

        resources[0] = new Book(
                101,
                "Java Programming",
                "James Gosling"
        );

        resources[1] = new Book(
                102,
                "Data Structures",
                "Mark Allen"
        );

        resources[2] = new DigitalResource(
                103,
                "Machine Learning Basics",
                "Andrew Ng"
        );

        resources[3] = new DigitalResource(
                104,
                "Artificial Intelligence",
                "Stuart Russell"
        );

        resources[4] = new Book(
                105,
                "Computer Networks",
                "Andrew Tanenbaum"
        );

        // Overdue days for each resource
        int[] overdueDays = {5, 0, 7, 3, 10};

        double totalFine = 0;

        System.out.println("==========================================");
        System.out.println("       " + LibraryResource.getLibraryName());
        System.out.println("==========================================");

        // Display details and calculate fine
        for (int i = 0; i < resources.length; i++) {

            System.out.println("\n------------------------------------------");

            // Validate Resource ID
            if (!InputValidator.validateResourceId(
                    resources[i].getResourceId())) {

                System.out.println("Invalid Resource ID!");
                continue;
            }

            // Validate overdue days
            if (!InputValidator.validateFineDays(overdueDays[i])) {

                System.out.println("Invalid Fine Days!");
                continue;
            }

            // Print details
            Printable printable = (Printable) resources[i];
            printable.printDetails();

            // Calculate fine
            double fine =
                    resources[i].calculateFine(overdueDays[i]);

            System.out.println("Overdue Days : " + overdueDays[i]);
            System.out.println("Fine         : Rs. " + fine);

            totalFine += fine;
        }

        System.out.println("\n==========================================");
        System.out.println("Total Fine of All Resources: Rs. " + totalFine);
        System.out.println("==========================================");

        // Display total resources
        LibraryResource.displayTotalResources();
    }
}