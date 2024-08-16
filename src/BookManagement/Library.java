package BookManagement;

import java.util.ArrayList;
import java.util.List;


public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String isbn, String title, String author, int copies) {
        Book newBook = new Book(isbn, title, author, copies);
        books.add(newBook);
    }

    public int findBookByISBN(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isbn.equals(isbn)) ;
            return i;
        }
        return -1;
    }

    public void checkOutBook(int bookIndex) {
        if (bookIndex >= 0 && bookIndex < books.size()) {
            Book book = books.get(bookIndex);
            if (book.availableCopies > 0) {
                book.availableCopies--;
                System.out.println("LibraryManagement.Book checked out successfully.");
            } else {
                System.out.println("No copies available to check out.");
            }
        } else {
            System.out.println("Invalid book index.");
        }
    }

    public void checkInBook(int bookIndex) {
        if (bookIndex >= 0 && bookIndex < books.size()) {
            Book book = books.get(bookIndex);
            book.availableCopies++;
            System.out.println("LibraryManagement.Book checked in successfully.");
        } else {
            System.out.println("Invalid book index.");
        }
    }

    public void displayBookDetails(int bookIndex) {
        if (bookIndex >= 0 && bookIndex < books.size()) {
            books.get(bookIndex).displayBookDetails();
        } else {
            System.out.println("Invalid book index.");
        }
    }

    public static void main(String[] arg) {
        Library library = new Library();
        library.addBook("8988765-333", "abc", "sds", 3);
        library.addBook("987656789-876", "fgabc", "sdsds", 33);

        int index = library.findBookByISBN("8988765-333");
        if (index != -1) {
            System.out.println("LibraryManagement.Book found:");
            library.displayBookDetails(index);
        } else {
            System.out.println("LibraryManagement.Book not found.");
        }

        library.checkOutBook(index);
        library.displayBookDetails(index);

        library.checkInBook(index);
        library.displayBookDetails(index);

    }

}
