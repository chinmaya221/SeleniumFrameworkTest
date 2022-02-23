package utils;

import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to access properties provided in the file designated by the test.propertiesfile system property.
 */
public class TestProperties {
    private static final Pattern PATTERN = Pattern.compile("\\$\\{([^}]+)\\}");

    private static Properties properties = null;

    public static String propertiesFile = System.getProperty("test.propertiesfile");

    private static void initTestProperties() {
        if (properties != null) {
            return;
        }
        
        properties = new Properties();
        
        if (propertiesFile != null) {
            File testProps = new File(propertiesFile);

            if (!testProps.exists()) {
                //throw new ConfigError(testProps.getAbsolutePath() + " does not exist!");
            } // end if

            Collection<String> processedFiles = new HashSet<String>();
            recursiveLoadProperties(testProps, properties, processedFiles);
            resolvePlaceholders();
        } else {
            //System.err.println("WARNING: No test.propertiesfile was specified");
        } // end if-else
    }

    private static void recursiveLoadProperties(File testPropsFile, Properties targetProps,
            Collection<String> processedFiles)
             {
        try {
            processedFiles.add(testPropsFile.getCanonicalPath());

            Properties props = loadProperties(testPropsFile);

            String testImportFileName = (String) props.remove("test.properties.import");

            if (testImportFileName != null) {
                File testImportFile = new File(testImportFileName);

                if (!testImportFile.exists()) {
                    // permit import relative to parent file
                    File parentDir = testPropsFile.getParentFile();
                    testImportFile = new File(parentDir, testImportFileName);

                    // try to see if parent relative file exists
                    if (!testImportFile.exists()) {
                        //throw new ConfigError("Import from " + testPropsFile.getAbsolutePath()
                           // + " file test.properties.import=" + testImportFileName + " does not exist!");
                    } // end if
                } // end if

                if (processedFiles.contains(testImportFile.getCanonicalPath())) {
                    System.err.println("WARNING: Recursive import from " + testPropsFile.getAbsolutePath()
                        + " ignored.");
                    System.err.println("         test.properties.import=" + testImportFile.getCanonicalPath());
                } else {
                    recursiveLoadProperties(testImportFile, targetProps, processedFiles);
                } // end if-else
            } // end if

            targetProps.putAll(props);
        } catch (IOException e) {
            //throw new ConfigError("Unable to read properties file " + testPropsFile.getAbsolutePath(), e);
        } // end try-catch
    } // end method recursiveLoadProperties

    private static Properties loadProperties(File testProps)
            throws FileNotFoundException, IOException {
        InputStream tcin = new FileInputStream(testProps);
        Properties props = new Properties();

        try {
            props.load(tcin);
        } finally {
            tcin.close();
        } // end try-finally

        return props;
    } // end method loadProperties

    private static void resolvePlaceholders() {
        Collection<String> keys = new HashSet<String>();

        // need a new collection for this
        for (Object key : properties.keySet()) {
            keys.add((String) key);
        } // end for

        // tracking collection for diagnostic and cycle detection purposes
        Map<String, String> workingKeys = new LinkedHashMap<String, String>();

        for (String key : keys) {
            workingKeys.clear();

            String value = properties.getProperty(key);
            workingKeys.put(key, value);

            String newValue = resolve(workingKeys, value);
            properties.put(key, newValue);
        } // end for
    } // end method resolvePlaceholders

    private static String resolve(Map<String, String> workingKeys, String value) {
        Matcher matcher = PATTERN.matcher(value);
        StringBuffer buf = new StringBuffer(value.length() * 2);

        while (matcher.find()) {
            String property = matcher.group(1);

            // detect recursive property evaluation
            if (workingKeys.containsKey(property)) {
                System.err.println("WARNING: Recursive property evaluation!");

                for (Entry<String, String> entry : workingKeys.entrySet()) {
                    System.err.println("    " + entry.getKey() + "=" + entry.getValue());
                } // end for

                // leave the contents unchanged, replace matched region with itself
                matcher.appendReplacement(buf, Matcher.quoteReplacement(matcher.group()));

                continue;
            } // end if

            // try system properties first
            String replacement = System.getProperty(property);
            boolean update;

            // fallback to our own properties
            if (replacement == null) {
                replacement = properties.getProperty(property);
                update = true;
            } else {
                update = false;
            } // end if

            // leave matched string unchanged
            if (replacement == null) {
                replacement = matcher.group();
                System.err.println("WARNING: Placeholder not resolved! (" + replacement + ")");
            } else {
                // recursively resolve any additional placeholder references
                workingKeys.put(property, replacement);
                replacement = resolve(workingKeys, replacement);
                workingKeys.remove(property);

                // if we resolved one of our properties replace it now
                if (update) {
                    properties.put(property, replacement);
                } // end if
            } // end if

            replacement = Matcher.quoteReplacement(replacement);
            matcher.appendReplacement(buf, replacement);
        } // end while

        matcher.appendTail(buf);

        return buf.toString();
    } // end method resolve

    public static boolean getBoolean(String name, boolean defaultValue) {
        String value = getProperty(name);

        if (value == null) {
            return defaultValue;
        } // end if

        return Boolean.parseBoolean(value);
    } // end method getBoolean

    public static boolean getBoolean(String name) {
        return getBoolean(name, false);
    } // end method getBoolean

    public static int getInteger(String name, int defaultValue) {
        String value = getProperty(name);

        if (value == null) {
            return defaultValue;
        } // end if

        return Integer.parseInt(value);
    } // end method getInteger

    public static int getInteger(String name) {
        return getInteger(name, 0);
    } // end method getInteger

    public static String getProperty(String name, String defaultValue) {
        initTestProperties();
        
        String value = System.getProperty(name);

        value = StringUtils.trimToNull(value);

        if (value == null) {
            value = properties.getProperty(name);
            value = StringUtils.trimToNull(value);
        } // end if

        if (value == null) {
            value = defaultValue;
        } // end if-else

        return value;
    } // end method getProperty

    public static String getProperty(String name) {
        return getProperty(name, null);
    } // end method getProperty

    public static String getRequiredProperty(String key) {
        String value = getProperty(key);

        if (value == null) {
            //throw new ConfigError("property " + key + " was not defined.");
        } // end if

        return value;
    } // end method getRequiredProperty

} // end class TestProperties
