public class Book {
    private String title;
    private String author;
    private boolean issued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issueBook() {
        this.issued = true;
    }

    public void returnBook() {
        this.issued = false;
    }

    public String toString() {
        return title + " by " + author + (issued ? " (Issued)" : " (Available)");
    }
}
