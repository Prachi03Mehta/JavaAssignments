package library.model;

/**
 * Represents a physical Book resource.
 * Fine rate: Rs. 5 per overdue day.
 */
public class Book extends LibraryResource implements Printable {

    private static final double FINE_PER_DAY = 5.0;

    // Book-specific attribute
    private String genre;

    public Book(int resourceId, String title, String author, String genre) {
        super(resourceId, title, author);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * FINE_PER_DAY;
    }

    @Override
    public void printDetails() {
        System.out.println("---------- BOOK ----------");
        System.out.println(getBasicInfo());
        System.out.println("Genre       : " + genre);
        System.out.println("Fine Rate   : Rs. " + FINE_PER_DAY + " / day");
        System.out.println("---------------------------");
    }
}
