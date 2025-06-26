import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered: " + user);
    }

    public void showBooks() {
        System.out.println("\nAvailable books:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void showUsers() {
        System.out.println("\nRegistered users:");
        for (User u : users) {
            System.out.println(u);
        }
    }

    public void issueBook(String title, int userId) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title) && !b.isIssued()) {
                b.issueBook();
                System.out.println("Book issued to User ID " + userId + ": " + b);
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    public void returnBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title) && b.isIssued()) {
                b.returnBook();
                System.out.println("Book returned: " + b);
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }
}
