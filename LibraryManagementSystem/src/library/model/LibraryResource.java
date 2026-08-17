package library.model;

/**
 * Abstract base class representing any resource held by the library
 * (a physical Book, a Journal, a Digital Resource, etc.).
 */
public abstract class LibraryResource {

    // ---------- Private data members ----------
    private int resourceId;
    private String title;
    private String author;

    // ---------- Static members ----------
    private static String libraryName = "Central University Library";
    private static int resourceCounter = 0;

    // ---------- Constructor ----------
    public LibraryResource(int resourceId, String title, String author) {
        this.resourceId = resourceId;
        this.title = title;
        this.author = author;
        resourceCounter++; // every construction increases the shared counter
    }

    // ---------- Abstract method ----------
    public abstract double calculateFine(int overdueDays);

    // ---------- Protected helper method ----------
    // Available to subclasses (e.g. for building printDetails() output)
    // but hidden from the outside world.
    protected String getBasicInfo() {
        return "Resource ID : " + resourceId + "\n"
             + "Title       : " + title + "\n"
             + "Author      : " + author + "\n"
             + "Library     : " + libraryName;
    }

    // ---------- Public getters and setters ----------
    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static String getLibraryName() {
        return libraryName;
    }

    public static void setLibraryName(String libraryName) {
        LibraryResource.libraryName = libraryName;
    }

    // ---------- Static method to display total resources ----------
    public static void displayTotalResources() {
        System.out.println("Total resources created so far: " + resourceCounter);
    }
}
