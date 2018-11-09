/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

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
public class RemiseServiceImplTest {
    
    public RemiseServiceImplTest() {
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
     * Test of remisePrice method, of class RemiseServiceImpl.
     */
    @Test
    public void remiseVAlide()
    {
        RemiseServiceImpl imp = new RemiseServiceImpl();
        assertEquals("Prix final: 5.0, Remise: 5.0",imp.remisePrice(Float.parseFloat("10"), Float.parseFloat("50")));
    }
    @Test(expected = IllegalArgumentException.class)
    public void remiseNull()
    {
        RemiseServiceImpl imp = new RemiseServiceImpl();
        assertEquals("5.0",imp.remisePrice(null, Float.parseFloat("50")));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void remiseNulla()
    {
        RemiseServiceImpl imp = new RemiseServiceImpl();
        assertEquals("5.0",imp.remisePrice(Float.parseFloat("10"),null));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void remiseINC()
    {
        RemiseServiceImpl imp = new RemiseServiceImpl();
        assertEquals("5.0",imp.remisePrice(Float.parseFloat("-5"), Float.parseFloat("50")));
    }
     @Test(expected = IllegalArgumentException.class)
    public void remiseIC()
    {
        RemiseServiceImpl imp = new RemiseServiceImpl();
        assertEquals("5.0",imp.remisePrice(Float.parseFloat("10"), Float.parseFloat("-5")));
    }
    @Test(expected = IllegalArgumentException.class)
    public void remiseINCPOS()
    {
        RemiseServiceImpl imp = new RemiseServiceImpl();
        imp.remisePrice(Float.parseFloat("1000000"), Float.parseFloat("50"));
    }
     @Test(expected = IllegalArgumentException.class)
    public void remiseICPOS()
    {
        RemiseServiceImpl imp = new RemiseServiceImpl();
        assertEquals("5.0",imp.remisePrice(Float.parseFloat("10"), Float.parseFloat("110")));
    }
    
    @Test
    public void inveseRemise()
    {
        RemiseServiceImpl imp = new RemiseServiceImpl();
        assertEquals("Prix depart: 50.0",imp.invertRemise(Float.parseFloat("25"), Float.parseFloat("50")));
    }
    @Test(expected = IllegalArgumentException.class)
    public void inveseRemiseNull()
    {
        RemiseServiceImpl imp = new RemiseServiceImpl();
        assertEquals("5.0",imp.invertRemise(null, Float.parseFloat("50")));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void inveseRemiseNulla()
    {
        RemiseServiceImpl imp = new RemiseServiceImpl();
        assertEquals("5.0",imp.invertRemise( Float.parseFloat("50"), null));
    }
    @Test(expected = IllegalArgumentException.class)
    public void inveseRemiseINC()
    {
        RemiseServiceImpl imp = new RemiseServiceImpl();
        assertEquals("5.0",imp.invertRemise(Float.parseFloat("-5"), Float.parseFloat("50")));
    }
    @Test(expected = IllegalArgumentException.class)
    public void inveseRemiseINCA()
    {
        RemiseServiceImpl imp = new RemiseServiceImpl();
        assertEquals("5.0",imp.invertRemise(Float.parseFloat("50"), Float.parseFloat("-5")));
    }
    @Test(expected = IllegalArgumentException.class)
    public void inveseRemiseINCPOS()
    {
        RemiseServiceImpl imp = new RemiseServiceImpl();
        assertEquals("5.0",imp.invertRemise(Float.parseFloat("1000000"), Float.parseFloat("50")));
    }
    @Test(expected = IllegalArgumentException.class)
    public void inveseRemiseINCPOSa()
    {
        RemiseServiceImpl imp = new RemiseServiceImpl();
        assertEquals("5.0",imp.invertRemise(Float.parseFloat("10"), Float.parseFloat("110")));
    } 
}
