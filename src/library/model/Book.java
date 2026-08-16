package library.model;

public class Book extends LibraryResource implements Printable {

    public Book(int resourceId, String title, String author) {
        super(resourceId, title, author);
    }

    // Fine = Rs. 5 per overdue day
    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 5;
    }

    // Print details
    @Override
    public void printDetails() {

        System.out.println("Resource Type: Book");

        // Calling protected method from parent
        displayBasicDetails();

        System.out.println("Fine Rate    : Rs. 5/day");
    }
}
