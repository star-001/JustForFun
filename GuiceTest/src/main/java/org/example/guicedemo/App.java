package org.example.guicedemo;


import com.google.inject.Guice;

public class App
{
    /**
     * bootstrap:
     * parse command line
     * set up environment
     * kick off main logic
     */
    public static void main( String[] args )
    {
        MyApplet mainApplet  = Guice.createInjector(new MainModule())
                .getInstance(MyApplet.class);
                mainApplet.run();
    }

}
