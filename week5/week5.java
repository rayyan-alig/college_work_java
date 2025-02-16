import java.util.*;

// Base class representing a Book (Encapsulation applied by using private attributes)
class Book {
    private String bookID;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    // Constructor to initialize book details
    public Book(String bookID, String title, String author, String genre) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true;
    }

    // Getters to access private attributes (Encapsulation)
    public String getBookID() { return bookID; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public boolean isAvailable() { return isAvailable; }
    
    // Setter to update book availability
    public void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }
    
    // Method demonstrating polymorphism (can be overridden by subclasses)
    public void displayDetails() {
        System.out.println("Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Available: " + isAvailable);
    }
}



// Derived class representing Fiction books (Inheritance applied). This means when an object of FictionBook is created, it calls the constructor of Book with the provided arguments.
class FictionBook extends Book {
    public FictionBook(String bookID, String title, String author) {
        super(bookID, title, author, "Fiction");
    }

    // Overriding the displayDetails method (Polymorphism)
    @Override
    public void displayDetails() {
        System.out.println("[Fiction] Book: " + getTitle() + " by " + getAuthor());
    }
}

// Derived class representing Non-Fiction books (Inheritance applied). This means when an object of NonFictionBook is created, it calls the constructor of Book with the provided arguments.
class NonFictionBook extends Book {
    public NonFictionBook(String bookID, String title, String author) {
        super(bookID, title, author, "Non-Fiction");
    }
}

// User class (Encapsulation applied using private attributes)
class User {
    private String userID;
    private String name;
    private List<Book> borrowedBooks;

    // Constructor to initialize user details
    public User(String userID, String name) {
        this.userID = userID;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters to access private attributes
    public String getUserID() { return userID; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    // Method to borrow a book (checks availability before borrowing)
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailability(false);
            System.out.println(name + " borrowed " + book.getTitle());
        } else {
            System.out.println("Sorry, " + book.getTitle() + " is not available.");
        }
    }

    // Method to return a borrowed book
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailability(true);
            System.out.println(name + " returned " + book.getTitle());
        } else {
            System.out.println("This book was not borrowed by " + name);
        }
    }
}

// Catalog class to manage books (Encapsulation used to manage book collection)
class Catalog {
    private List<Book> books;

    public Catalog() {
        this.books = new ArrayList<>();
    }

    // Method to add books to catalog
    public void addBook(Book book) {
        books.add(book);
    }

    // Display only available books
    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                book.displayDetails(); // Polymorphism applied here
            }
        }
    }

    // Method to find a book by its ID
    public Book findBookById(String bookID) {
        for (Book book : books) {
            if (book.getBookID().equals(bookID)) {
                return book;
            }
        }
        return null;
    }
}

// Main class to test the system
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalog catalog = new Catalog();
        
        // Adding books through user input
        System.out.println("Enter number of books to add:");
        int numBooks = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numBooks; i++) {
            System.out.println("Enter book ID, title, author, and genre (Fiction/Non-Fiction):");
            String bookID = scanner.nextLine();
            String title = scanner.nextLine();
            String author = scanner.nextLine();
            String genre = scanner.nextLine();
            if (genre.equalsIgnoreCase("Fiction")) {
                catalog.addBook(new FictionBook(bookID, title, author)); // Inheritance applied
            } else {
                catalog.addBook(new NonFictionBook(bookID, title, author)); // Inheritance applied
            }
        }
        
        // Creating users
        System.out.println("Enter number of users:");
        int numUsers = scanner.nextInt();
        scanner.nextLine();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < numUsers; i++) {
            System.out.println("Enter user ID and name:");
            String userID = scanner.nextLine();
            String name = scanner.nextLine();
            users.add(new User(userID, name));
        }
        
        // Interactive borrowing and returning system
        while (true) {
            System.out.println("Choose an option: 1) Borrow Book 2) Return Book 3) Display Books 4) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Enter user ID and book ID to borrow:");
                String userID = scanner.nextLine();
                String bookID = scanner.nextLine();
                User user = users.stream().filter(u -> u.getUserID().equals(userID)).findFirst().orElse(null);
                Book book = catalog.findBookById(bookID);
                if (user != null && book != null) {
                    user.borrowBook(book);
                } else {
                    System.out.println("Invalid user ID or book ID.");
                }
            } else if (choice == 2) {
                System.out.println("Enter user ID and book ID to return:");
                String userID = scanner.nextLine();
                String bookID = scanner.nextLine();
                User user = users.stream().filter(u -> u.getUserID().equals(userID)).findFirst().orElse(null);
                Book book = catalog.findBookById(bookID);
                if (user != null && book != null) {
                    user.returnBook(book);
                } else {
                    System.out.println("Invalid user ID or book ID.");
                }
            } else if (choice == 3) {
                catalog.displayAvailableBooks();
            } else {
                break;
            }
        }
        scanner.close();
    }
}
