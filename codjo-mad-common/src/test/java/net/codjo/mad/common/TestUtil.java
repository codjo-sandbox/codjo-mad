package net.codjo.mad.common;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class TestUtil {
    public static final boolean JAVA_8 = System.getProperty("java.version").startsWith("1.8.");
    private static final String JAVA_8_SUFFIX = "-jdk18";

    public static String getFileForJavaVersion(String defaultFile) {
        String result;
        if (TestUtil.JAVA_8) {
            int index = defaultFile.lastIndexOf('.');
            if (index >= 0) {
                result = defaultFile.substring(0, index) + JAVA_8_SUFFIX + defaultFile.substring(index);
            } else {
                result = defaultFile + JAVA_8_SUFFIX;
            }
        } else {
            result = defaultFile;
        }
        return result;
    }

    public static void assertJava8SystemProperty(String systemPropertyName, boolean expectedValue) {
        if (TestUtil.JAVA_8) {
            String actualValue = System.getProperty(systemPropertyName);
            assertEquals(systemPropertyName + " system property has wrong value in pom.xml for java 8 (actual string value: " +
                    ((actualValue == null) ? "null)" : "'" + actualValue + "')"),
                    expectedValue, Boolean.valueOf(actualValue));
        }
    }
}
