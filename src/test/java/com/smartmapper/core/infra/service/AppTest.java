package com.smartmapper.core.infra.service;

import com.smartmapper.AppMain;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void testAppHasAGreeting() {
        AppMain classUnderTest = new AppMain();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}