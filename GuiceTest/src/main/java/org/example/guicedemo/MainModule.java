package org.example.guicedemo;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.example.guicedemo.helloworlddemo.HelloWorldModule;
import org.example.guicedemo.helloworlddemo.MyDestination;
import org.example.guicedemo.helloworlddemo.PrintStreamWriter;
import org.example.guicedemo.helloworlddemo.StringWritingApplet;

import java.io.PrintStream;

public class MainModule extends AbstractModule {

    @Override
    protected void configure(){
        install(new HelloWorldModule());
    }

//    @Provides private String getString(){
//        return "Hello World!";
//    }
}
