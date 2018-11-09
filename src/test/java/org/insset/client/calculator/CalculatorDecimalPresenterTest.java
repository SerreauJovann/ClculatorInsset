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
    public void testFieldDesimal() {
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        assertEquals("3",String.valueOf(imp.convertRomanToArabe("a")));
    }
    @Test  
    public void testconvertDateYears() {
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        assertEquals("XV/III/MX",imp.convertDateYears("a"));
    }
    
    @Test
    public void testCOnvertEntierToRomain() {
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        String a = imp.convertArabeToRoman(10);
        assertEquals("X",a);
    }
        @Test
    public void testCOnvertEntierallRomain() {
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        assertEquals("M",imp.convertArabeToRoman(1000));
        assertEquals("CM",imp.convertArabeToRoman(900));
        assertEquals("D",imp.convertArabeToRoman(500));
        assertEquals("CD",imp.convertArabeToRoman(400));
        assertEquals("C",imp.convertArabeToRoman(100));
        assertEquals("XC",imp.convertArabeToRoman(90));
        assertEquals("L",imp.convertArabeToRoman(50));
        assertEquals("XL",imp.convertArabeToRoman(40));
        assertEquals("X",imp.convertArabeToRoman(10));
        assertEquals("IX",imp.convertArabeToRoman(9));
        assertEquals("V",imp.convertArabeToRoman(5));
        assertEquals("IV",imp.convertArabeToRoman(4));
        assertEquals("I",imp.convertArabeToRoman(1));
        
    }
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCOnvertEntierToRomainValInco() {
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        String a = imp.convertArabeToRoman(-1);
    }
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCOnvertEntierToRomainValNULL() {
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        String a = imp.convertArabeToRoman(null);
    }
    @Test
    public void testAddvalue(){
        int val = 5;
        int modif = 5;
        int finalval = 10;
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        assertEquals(finalval,imp.addValue(val, modif)); 
    }
    
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testAddvalueNullVAL(){
        int val = 5;
        int modif = 5;
        int finalval = 10;
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        imp.addValue(null, modif);
    }
    
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testAddvalueNullMOdif(){
        int val = 5;
        int modif = 5;
        int finalval = 10;
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        imp.addValue(val, null);
    }
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testAddvalueNullLimite(){
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        imp.addValue(0, 5);
    }
        @org.junit.Test(expected = IllegalArgumentException.class)
    public void testAddvalueNullLimiteOver(){
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        imp.addValue(5, 0);
    }
    
    
    @Test
    public void testRemovevalue(){
        int val = 10;
        int modif = 5;
        int finalval = 5;
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        assertEquals(finalval,imp.removeValue(val, modif)); 
    }
    
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testRemovevalueNullVAL(){
        int val = 5;
        int modif = 5;
        int finalval = 10;
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        imp.addValue(null, modif);
    }
    
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testRemovevalueOdif(){
        int val = 5;
        int modif = 5;
        int finalval = 10;
        RomanConverterServiceImpl imp = new RomanConverterServiceImpl();
        imp.addValue(val, null);
    }
    
}
