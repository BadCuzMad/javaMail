package Controller;

import Models.Author;
import Models.Book;
import Models.LibraryInterFace;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.NoSuchElementException;


public class MainTest {
    Injector injector = Guice.createInjector(new ConfOverride());
    LibraryInterFace lib = injector.getInstance(LibraryFactory.class).createClassLib();

    @Test(expected = IndexOutOfBoundsException.class)
    public void capacityTest() {
        lib.createLib(10, "books.txt");
    }

    @Test
    public void orderTest() {
        @NotNull final Type listBooksType = new TypeToken<Book[]>() {
        }.getType();
        try {
            Book[] arr = new Gson().fromJson(new BufferedReader(new FileReader("books.txt")), listBooksType);
            Book[] arr2 = lib.createLib(arr.length, "books.txt");
            Assert.assertArrayEquals(arr2,arr);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fillingTest() {
        Book[] arr = lib.createLib(1000, "books.txt");
        for(int i=100;i< arr.length;i++){
            Assert.assertNull(arr[i]);
        }

    }

    @Test
    public void infoTest() {
        Book[] arr = lib.createLib(100, "books.txt");
        lib.takeBook(1,arr);
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyCellTest() {
        Book[] arr = lib.createLib(1000, "books.txt");
        lib.takeBook(103,arr);
    }

    @Test
    public void isTakenBookCorrectTest() {
        Book[] arr = lib.createLib(100, "books.txt");
        Assert.assertEquals(arr[2], lib.takeBook(2, arr));
    }

    @Test
    public void placementTest() {
        Book[] arr = lib.createLib(1000, "books.txt");
        Book testBook = new Book();
        Author testAuthor = new Author();
        testAuthor.setName("testAuthor");
        testBook.setAuthor(testAuthor);
        testBook.setName("testName");
        lib.addBook(testBook,arr);
        Assert.assertEquals(lib.takeBook(101,arr),testBook);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void vacantCellsTest() {
        Book[] arr = lib.createLib(100, "books.txt");
        Book testBook = new Book();
        Author testAuthor = new Author();
        testAuthor.setName("testAuthor");
        testBook.setAuthor(testAuthor);
        testBook.setName("testName");
        lib.addBook(testBook,arr);
    }
}
/*Библиотека бросает исключение при создании, если ее вместимость меньше чем количество книг, возвращаемое фабрикой.
При создании библиотеки все книги расставлены по ячейкам в порядке как они возвращаются фабрикой книг. Остальные ячейки пусты.
При взятии книги информация о ней и ячейке выводится.
При попытке взять книгу из пустой ячейки библиотека бросает исключение.
При взятии книги возвращается именно та книга, что была в этой ячейке.
При добавлении книги она размещается в первой свободной ячейке.
Если при добавлении книги свободных ячеек нет, библиотека бросает исключение.
Вызов метода “напечатать в консоль содержимое” выводит информацию о содержимом ячеек библиотеки.*/