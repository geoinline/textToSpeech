package com.github.geoinline.texttospeech;

import com.github.geoinline.texttospeech.Kevin;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KevinTest {
    
    public KevinTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of speak method, of class Kevin.
     */
    @org.junit.Test
    public void testSpeak() {
        System.out.println("speak");
        String input = "Hello World!";
        Kevin instance = Kevin.Instance;
        instance.speak(input);
    }
    
}
