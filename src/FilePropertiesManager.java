public class FilePropertiesManager {
    private static int SOME_INT_VALUE = 1;
    private static String SOME_STRING_VALUE;
    private static int[] SOME_INT_ARRAY;
    private static double SOME_DOUBLE_VALUE;

    public FilePropertiesManager() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(new File("config/example.ini")));

        SOME_INT_VALUE = Integer.valueOf(props.getProperty("SOME_INT_VALUE", "1"));
        SOME_STRING_VALUE = props.getProperty("SOME_STRING_VALUE");
        SOME_DOUBLE_VALUE = Double.valueOf(props.getProperty("SOME_DOUBLE_VALUE", "1.0"));

        // Предположим, что в настройках находится список целых через точку с запятой
        String[] parts = props.getProperty("SOME_INT_ARRAY").split(";");
        SOME_INT_ARRAY = new int[parts.length];
        for (int i = 0; i < parts.length; ++i)
        {
            SOME_INT_ARRAY[i] = Integer.valueOf(parts[i]);
        }
}
