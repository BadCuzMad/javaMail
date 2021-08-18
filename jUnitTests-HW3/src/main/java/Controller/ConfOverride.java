package Controller;

import Models.LibraryFactoryInterface;

import Models.LibraryInterFace;


public class ConfOverride extends com.google.inject.AbstractModule {

    @Override
    protected void configure(){
        bind(LibraryFactoryInterface.class).to(LibraryFactory.class);
        bind(LibraryInterFace.class).to(Library.class);
    }
}
