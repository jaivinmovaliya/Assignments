package BookManagement;

// Define the LibraryManagement.Book structure with required fields
public class Book {
    String isbn;
    String title;
    String author;
    int availableCopies;

    public Book(String isbn, String title, String author, int availableCopies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public void displayBookDetails() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available Copies: " + availableCopies);
    }
}

