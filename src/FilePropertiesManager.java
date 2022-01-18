import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FilePropertiesManager {
    private String name = "";
    private int dexterity;
    private int health;
    private int experience;
    private long gold;
    private int strength;
    private int level;

    Properties props = new Properties();

    //private static int[] SOME_INT_ARRAY;
    
    public FilePropertiesManager() throws IOException {
        //props.load(new FileInputStream(new File("src/save_game.cfg")));
        props.load(new FileInputStream(new File("src/app.properties")));

        //name = Integer.valueOf(props.getProperty("SOME_INT_VALUE", "nnm"));
        this.name = String.valueOf(props.getProperty("user.name"));
        //dexterity = props.getProperty("SOME_STRING_VALUE");
        this.dexterity = Integer.parseInt(props.getProperty("user.dexterity"));
        this.health = Integer.parseInt(props.getProperty("user.health"));
        this.experience = Integer.parseInt(props.getProperty("user.experience"));
        gold = Long.parseLong(props.getProperty("user.gold"));
        this.strength = Integer.parseInt(props.getProperty("user.strength"));
        this.level = Integer.parseInt(props.getProperty("user.level"));
        //SOME_DOUBLE_VALUE = Double.valueOf(props.getProperty("SOME_DOUBLE_VALUE", "1.0"));

        // Предположим, что в настройках находится список целых через точку с запятой
        /*String[] parts = props.getProperty("SOME_INT_ARRAY").split(";");
        SOME_INT_ARRAY = new int[parts.length];
        for (int i = 0; i < parts.length; ++i) {
            SOME_INT_ARRAY[i] = Integer.valueOf(parts[i]);
        }*/
    }

    public String getNameF() {
        name = String.valueOf(props.getProperty("user.name"));
        return name;
    }
    
    public void getAllProps() {
        System.out.println(name + dexterity + health + experience);
        System.out.printf("Name: %s \n" + name);
        //System.out.printf("Name: %s  Dexterity: %d  Health: %d  Experience: %d  Gold: %d  Strength: %d  Level: %d  \n" + name, dexterity, health, experience, gold, strength, level);
    }
}
