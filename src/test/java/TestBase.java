package service;

import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class TestBase {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStream() {
        System.setOut(System.out);
    }
}
