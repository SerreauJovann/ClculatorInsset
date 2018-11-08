/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.calculator;

import com.google.gwt.core.client.GWT;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import org.insset.client.service.ExempleService;
import org.insset.client.service.ExempleServiceAsync;
import org.insset.client.service.RomanConverterServiceAsync;
import org.insset.server.RomanConverterServiceImpl;
import org.insset.shared.FieldVerifier;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author talend
 */
public class CalculatorDecimalPresenterTest {
    
    public CalculatorDecimalPresenterTest() {
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

    @Test
    
    /**
     * Tests the FieldVerifier.
     */
    public void testFieldDesimal() {
        assertFalse(FieldVerifier.isValidDecimal(null));
        assertTrue(FieldVerifier.isValidDecimal(5));
    }
    @Test
    public void testCOnvertEntierToRomain() {
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        String a = imp.convertArabeToRoman(10);
        assertEquals("X",a);
    }
    
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCOnvertEntierToRomainValInco() {
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        String a = imp.convertArabeToRoman(-1);
    }
}
