package library.service;

import library.model.LibraryResource;
import library.model.Printable;
import library.util.InputValidator;

/**
 * Service layer class responsible for operating on collections
 * of LibraryResource objects: displaying details and totaling fines.
 */
public class ResourceService {

    /** Prints the details of every resource in the array (polymorphically). */
    public void displayAllDetails(LibraryResource[] resources) {
        for (LibraryResource resource : resources) {
            if (resource == null) {
                continue;
            }
            if (resource instanceof Printable) {
                ((Printable) resource).printDetails();
            }
        }
    }

    /**
     * Calculates the total fine due across all resources, given a
     * parallel array of overdue-day counts. Skips any entry whose
     * overdue days fail validation.
     */
    public double calculateTotalFine(LibraryResource[] resources, int[] overdueDaysArray) {
        double totalFine = 0.0;

        for (int i = 0; i < resources.length; i++) {
            LibraryResource resource = resources[i];
            int overdueDays = overdueDaysArray[i];

            if (resource == null) {
                continue;
            }
            if (!InputValidator.validateFineDays(overdueDays)) {
                System.out.println("Invalid overdue days for Resource ID "
                        + resource.getResourceId() + " - skipped.");
                continue;
            }
            if (overdueDays > 0) {
                double fine = resource.calculateFine(overdueDays);
                System.out.printf("Resource ID %d (\"%s\") is %d day(s) overdue - Fine: Rs. %.2f%n",
                        resource.getResourceId(), resource.getTitle(), overdueDays, fine);
                totalFine += fine;
            }
        }
        return totalFine;
    }
}
