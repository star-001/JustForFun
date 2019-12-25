package org.example.guicedemo.helloworlddemo;

import com.google.inject.Provider;
import org.example.guicedemo.MyApplet;

import javax.inject.Inject;
import java.io.PrintStream;

public class StringWritingApplet implements MyApplet {

    private MyDestination destination;
    private Provider<String> stringProvider;

    @Inject
    public StringWritingApplet(MyDestination destination, @Output Provider<String> stringProvider) {
        this.destination = destination;
        this.stringProvider = stringProvider;
    }





    private void writeString() {
                destination.write(stringProvider.get());
    }

    public void run() {
         writeString();
    }
}
