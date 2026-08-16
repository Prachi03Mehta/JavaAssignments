package library.model;

public class DigitalResource extends LibraryResource implements Printable {

    public DigitalResource(int resourceId, String title, String author) {
        super(resourceId, title, author);
    }

    // Fine = Rs. 2 per overdue day
    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2;
    }

    // Print details
    @Override
    public void printDetails() {

        System.out.println("Resource Type: Digital Resource");

        // Calling protected method from parent
        displayBasicDetails();

        System.out.println("Fine Rate    : Rs. 2/day");
    }
}