package Models;

import java.util.ArrayList;

public interface LibraryInterFace {
    Book[] createLib(int capacity, String filename);

    Book[] addBook(Book book, Book[] lib);

    Book takeBook(int cellNumber,Book[] lib);

    void displayBooks(Book[] lib);
}
