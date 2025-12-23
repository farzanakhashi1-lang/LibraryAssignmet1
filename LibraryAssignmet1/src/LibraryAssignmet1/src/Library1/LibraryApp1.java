package Library1;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp1 {

    private ArrayList<Book1> books;
    private Scanner scanner;


    public LibraryApp1() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }


    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt();

            switch (choice) {
                case 1:
                    printAllBooks();
                    break;
                case 2:
                    addNewBook();
                    break;
                case 3:
                    searchBooksByTitle();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    deleteBookById();
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }


    private void printMenu() {
        System.out.println("\nWelcome to Library App!");
        System.out.println("1. Print all books");
        System.out.println("2. Add new book");
        System.out.println("3. Search books by title");
        System.out.println("4. Borrow a book");
        System.out.println("5. Return a book");
        System.out.println("6. Delete a book by id");
        System.out.println("7. Quit");
        System.out.print("Choose an option: ");
    }


    private void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
            return;
        }

        for (Book1 book : books) {
            System.out.println(book);
        }
    }


    private void addNewBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter year: ");
        int year = readInt();

        try {
            Book1 book = new Book1(title, author, year);
            books.add(book);
            System.out.println("Book added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    private void searchBooksByTitle() {
        System.out.print("Enter part of the title: ");
        String part = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Book1 book : books) {
            if (book.getTitle().toLowerCase().contains(part)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found.");
        }
    }


    private void borrowBook() {
        System.out.print("Enter book id: ");
        int id = readInt();

        Book1 book = findBookById(id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isAvailable()) {
            book.markAsBorrowed();
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is already borrowed.");
        }
    }


    private void returnBook() {
        System.out.print("Enter book id: ");
        int id = readInt();

        Book1 book = findBookById(id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            book.markAsReturned();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not borrowed.");
        }
    }


    private void deleteBookById() {
        System.out.print("Enter book id: ");
        int id = readInt();

        Book1 book = findBookById(id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        books.remove(book);
        System.out.println("Book deleted successfully.");
    }


    private Book1 findBookById(int id) {
        for (Book1 book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }


    private int readInt() {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.print("Please enter a number: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }


    public static void main(String[] args) {
        LibraryApp1 app = new LibraryApp1();
        app.run();
    }
}
