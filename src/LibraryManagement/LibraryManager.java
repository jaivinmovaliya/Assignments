package LibraryManagement;
import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }


    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Borrowed: " + (isBorrowed ? "Yes" : "No");
    }
}

class Member {
    private String name;
    private int memberId;
    private String email;

    public Member(String name, int memberId, String email) {
        this.name = name;
        this.memberId = memberId;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Member ID: " + memberId + ", Email: " + email;
    }
}


class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void displayAllBooks() {
        System.out.println("Books in the Library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayAllMembers() {
        System.out.println("Members of the Library:");
        for (Member member : members) {
            System.out.println(member);
        }
    }
}

public class LibraryManager {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("1984", "George Orwell", "1 6789"));
        library.addBook(new Book("To Kill a  ", "  Lee", " 654321"));

        // Add members to the library
        library.addMember(new Member("Alice", 1, "asd@222.com"));
        library.addMember(new Member("Bob", 2, "bob@es.com"));

        library.displayAllBooks();

        library.displayAllMembers();
    }
}
