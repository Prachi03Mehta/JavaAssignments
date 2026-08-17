package library.model;

/**
 * Represents a Digital Resource (e-book, dataset, recording, etc.).
 * Fine rate: Rs. 2 per overdue day.
 */
public class DigitalResource extends LibraryResource implements Printable {

    private static final double FINE_PER_DAY = 2.0;

    // DigitalResource-specific attribute
    private String fileFormat;

    public DigitalResource(int resourceId, String title, String author, String fileFormat) {
        super(resourceId, title, author);
        this.fileFormat = fileFormat;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * FINE_PER_DAY;
    }

    @Override
    public void printDetails() {
        System.out.println("------ DIGITAL RESOURCE ------");
        System.out.println(getBasicInfo());
        System.out.println("File Format : " + fileFormat);
        System.out.println("Fine Rate   : Rs. " + FINE_PER_DAY + " / day");
        System.out.println("-------------------------------");
    }
}
