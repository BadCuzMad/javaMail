package Controller;

import Models.Book;
import Models.LibraryInterFace;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;


public class Library implements LibraryInterFace {


    @Override
    public Book[] createLib(int capacity, String filename) throws IndexOutOfBoundsException {

        @NotNull final Type listBooksType = new TypeToken<ArrayList<Book>>() {
        }.getType();
        try {
            ArrayList<Book> arr = new Gson().fromJson(new BufferedReader(new FileReader(filename)), listBooksType);
            if (capacity < arr.size()) {
                throw new IndexOutOfBoundsException("Library should be at least size of 100");
            } else {
                Book[] retArr = new Book[capacity];
                for (int i = 0; i < arr.size(); i++) {
                    retArr[i] = arr.get(i);
                }
                return retArr;
            }
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Book[] addBook(Book book, Book[] lib) throws ArrayIndexOutOfBoundsException {
        if (Arrays.stream(lib).noneMatch(Objects::isNull)) {
            throw new ArrayIndexOutOfBoundsException("The library is full");
        } else {
            for (int i = 0; i < lib.length; i++) {
                if (lib[i] == null) {
                    lib[i] = book;
                }
            }
            return lib;
        }
    }

    @Override
    public Book takeBook(int cellNumber, Book[] lib) throws NoSuchElementException {
        if (lib[cellNumber] == null) {
            throw new NoSuchElementException("This cell is empty");
        } else {
            Book b = lib[cellNumber];
            lib[cellNumber] = null;
            return b;
        }
    }

    @Override
    public void displayBooks(Book[] lib) {
        for (Book book : lib) {
            System.out.println(book);
        }
    }
}
