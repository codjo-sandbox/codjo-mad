package net.codjo.mad.common;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class TestUtil {
    public static final boolean JAVA_8 = System.getProperty("java.version").startsWith("1.8.");

    public static void assertJava8SystemProperty(String systemPropertyName, boolean expectedValue) {
        if (JAVA_8) {
            String actualValue = System.getProperty(systemPropertyName);
            assertEquals(systemPropertyName + " system property has wrong value in pom.xml for java 8 (actual string value: " +
                    ((actualValue == null) ? "null)" : "'" + actualValue + "')"),
                    expectedValue, Boolean.valueOf(actualValue));
        }
    }
}
