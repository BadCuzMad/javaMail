package Controller;

import Models.LibraryFactoryInterface;
import Models.LibraryInterFace;

public final class LibraryFactory implements LibraryFactoryInterface {


    @Override
    public LibraryInterFace createClassLib() {
        return new Library();
    }
}