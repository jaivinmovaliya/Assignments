package EnhancedLIbrary;
import java.util.*;


class Book {
    private static int nextBookId = 1;
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable = true;

    public Book(String title, String author) {
        this.bookId = "B" + nextBookId++;
        this.title = title;
        this.author = author;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void checkout() { isAvailable = false; }
    public void returnBook() { isAvailable = true; }
}

class Member {
    private String memberId;
    private String name;
    private List<Book> checkedOutBooks = new ArrayList<>();

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public void addCheckedOutBook(Book book) { checkedOutBooks.add(book); }
    public void returnBook(Book book) { checkedOutBooks.remove(book); }
}

class LibraryManagementSystem {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();
    private int nextMemberId = 1;

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.put(book.getBookId(), book);
    }

    public void addMember(String name) {
        String memberId = "M" + nextMemberId++;
        Member member = new Member(memberId, name);
        members.put(memberId, member);
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        throw new NoSuchElementException("Book with title " + title + " not found.");
    }

    public Book searchBookByAuthor(String author) {
        for (Book book : books.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        throw new NoSuchElementException("Book by author " + author + " not found.");
    }

    public void checkoutBook(String bookId, String memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null) {
            throw new NoSuchElementException("Book not found.");
        }
        if (member == null) {
            throw new NoSuchElementException("Member not found.");
        }
        if (book.isAvailable()) {
            book.checkout();
            member.addCheckedOutBook(book);
        } else {
            throw new IllegalStateException("Book is already checked out.");
        }
    }

    public void returnBook(String bookId, String memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null) {
            throw new NoSuchElementException("Book or Member not found.");
        }

        member.returnBook(book);
        book.returnBook();
    }
}



public class EnhancedLibraryManagement {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook("1984", "George Orwell");

        library.addMember("John Doe");

        Book book = library.searchBookByTitle("1984");
        System.out.println("Found book: " + book.getTitle() + " by " + book.getAuthor());

        library.checkoutBook(book.getBookId(), "M1");
        System.out.println("Book checked out successfully.");
    }
}



