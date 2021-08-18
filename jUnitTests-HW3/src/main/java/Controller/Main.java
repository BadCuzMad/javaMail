package Controller;

import Models.Book;
import Models.LibraryInterFace;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ConfOverride());
        LibraryInterFace lib = injector.getInstance(LibraryFactory.class).createClassLib();
        for (String str : args) {
           lib.createLib(Integer.parseInt(str),str);
        }
    }
}
