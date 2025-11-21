import java.util.ArrayList;
import java.util.Scanner;


class Book {
    String title;
    String author;
    boolean isAvailable;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; 
    }
}


class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<String> history = new ArrayList<>();

 
    void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

   
    void displayBooks() {
        System.out.println("\n===== Available Books =====");
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            System.out.println((i + 1) + ". " + b.title + " by " + b.author +
                    " | Available: " + (b.isAvailable ? "Yes" : "No"));
        }
    }

    void searchBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + b.title +
                        " by " + b.author +
                        " | Available: " + (b.isAvailable ? "Yes" : "No"));
                return;
            }
        }
        System.out.println("Book not found!");
    }


    void borrowBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (b.isAvailable) {
                    b.isAvailable = false;
                    history.add("Borrowed: " + b.title);
                    System.out.println("You borrowed: " + b.title);
                } else {
                    System.out.println("Book is already borrowed!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

   
    void returnBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (!b.isAvailable) {
                    b.isAvailable = true;
                    history.add("Returned: " + b.title);
                    System.out.println("You returned: " + b.title);
                } else {
                    System.out.println("Book was not borrowed!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    
    void showHistory() {
        System.out.println("\n===== Borrowing History =====");
        for (String record : history) {
            System.out.println(record);
        }
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

       
        library.addBook("Rich Dad Poor Dad", "Robert Kiyosaki");
        library.addBook("Wings of Fire", "APJ Abdul Kalam");
        library.addBook("To Kill a Mockingbird", "Harper Lee");

        int choice;

        System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");

        while (true) {
            System.out.println("\n1. Display Books");
            System.out.println("2. Search Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Borrowing History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter book title to search: ");
                    library.searchBook(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter book title to borrow: ");
                    library.borrowBook(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter book title to return: ");
                    library.returnBook(sc.nextLine());
                    break;

                case 5:
                    library.showHistory();
                    break;

                case 6:
                    System.out.println("Thank you for using the Library System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

