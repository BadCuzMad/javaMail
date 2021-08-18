package Controller;

import Models.Book;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MockVoidMethod {
    @Mock
    Library library = Mockito.mock(Library.class);
    @Test
    public void outputTest() {
        Book[] arr = library.createLib(100, "books.txt");
        Mockito.doNothing().when(library).displayBooks(Mockito.isA(Book[].class));
        library.displayBooks(arr);
        Mockito.verify(library,Mockito.times(1)).displayBooks(arr);
    }
}
