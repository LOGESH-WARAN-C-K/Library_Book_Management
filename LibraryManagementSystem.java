import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    private List<Book> books;
    private List<User> users;
    private Staff staff;
    private Purchase purchase;
    private Return bookReturn;

    public LibraryManagementSystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.staff = new Staff("Admin");
        this.purchase = new Purchase();
        this.bookReturn = new Return();
    }

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added: " + title + " by " + author);
        System.out.println();
    }

    public void addUser(String name) {
        users.add(new User(name));
        System.out.println("User added: " + name);
        System.out.println();
    }

    public void displayBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " - Available: " + (book.isAvailable() ? "Yes" : "No"));
        }
        System.out.println();
    }

    public void displayUsers() {
        System.out.println("Users:");
        for (User user : users) {
            System.out.println(user.getName());
        }
        System.out.println();
    }

    public void borrowBook(String userName, String bookTitle) {
        User user = findUser(userName);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        Book book = findBook(bookTitle);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is not available for borrowing.");
            return;
        }

        user.borrowBook(book);
        book.setAvailable(false);
        System.out.println(book.getTitle() + " has been borrowed by " + user.getName() + ".");
        System.out.println();
    }

    public void returnBook(String userName, String bookTitle) {
        User user = findUser(userName);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        Book book = findBook(bookTitle);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!user.getBorrowedBooks().contains(book)) {
            System.out.println("This book is not borrowed by " + user.getName() + ".");
            return;
        }

        user.returnBook(book);
        book.setAvailable(true);
        System.out.println(book.getTitle() + " has been returned by " + user.getName() + ".");
        System.out.println();
    }

    public void processPurchase(String bookTitle) {
        Book book = findBook(bookTitle);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        purchase.addBookToLibrary(book);
        System.out.println(book.getTitle() + " purchased successfully.");
        System.out.println();
    }

    public void processReturn(String userName, String bookTitle) {
        User user = findUser(userName);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        Book book = findBook(bookTitle);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!user.getBorrowedBooks().contains(book)) {
            System.out.println("This book is not borrowed by " + user.getName() + ".");
            return;
        }

        bookReturn.returnBookToLibrary(user, book);
        user.returnBook(book);
        book.setAvailable(true);
        System.out.println(book.getTitle() + " has been returned by " + user.getName() + ".");
        System.out.println();
    }

    private User findUser(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManagementSystem library = new LibraryManagementSystem();

        while (true) {
            System.out.println("Library Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Add User");
            System.out.println("4. Display Users");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Process Purchase");
            System.out.println("8. Process Return");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    library.addUser(userName);
                    break;
                case 4:
                    library.displayUsers();
                    break;
                case 5:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    library.borrowBook(userName, bookTitle);
                    break;
                case 6:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    bookTitle = scanner.nextLine();
                    library.returnBook(userName, bookTitle);
                    break;
                case 7:
                    System.out.print("Enter book title to purchase: ");
                    bookTitle = scanner.nextLine();
                    library.processPurchase(bookTitle);
                    break;
                case 8:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    System.out.print("Enter book title to return: ");
                    bookTitle = scanner.nextLine();
                    library.processReturn(userName, bookTitle);
                    break;
                case 9:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }
        }
    }
}
