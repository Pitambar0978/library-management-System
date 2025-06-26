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
