# library-management-System


Book.java 

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


User.java

public class User {
    private String name;
    private int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String toString() {
        return "User ID: " + userId + ", Name: " + name;
    }
}


   Library.java

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



Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        lib.addBook(new Book("Core Java", "Sun Microsystems"));
        lib.addBook(new Book("DSA in Java", "Narasimha Karumanchi"));

        lib.registerUser(new User("Alice", 1));
        lib.registerUser(new User("Bob", 2));

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show Books");
            System.out.println("2. Show Users");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    lib.showBooks();
                    break;
                case 2:
                    lib.showUsers();
                    break;
                case 3:
                    System.out.print("Enter book title to issue: ");
                    String title = sc.nextLine();
                    System.out.print("Enter user ID: ");
                    int userId = sc.nextInt();
                    lib.issueBook(title, userId);
                    break;
                case 4:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    lib.returnBook(returnTitle);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}



