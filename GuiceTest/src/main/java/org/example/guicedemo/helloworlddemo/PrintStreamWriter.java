package org.example.guicedemo.helloworlddemo;

import javax.inject.Inject;
import java.io.PrintStream;

public class PrintStreamWriter implements MyDestination{

    @Inject
    public PrintStreamWriter(PrintStream destination) {
        this.destination = destination;
    }

    private PrintStream destination;

    @Override
    public void write(String string){
        destination.println(string);
    }
}
