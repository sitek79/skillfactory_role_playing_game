import player.Band;
import player.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;
import java.util.UnknownFormatConversionException;
import java.util.stream.Stream;

public class GameApp {
    static boolean play = true;
    static String filePathToMenu = "src/startup_menu.txt";
    static int CHARACTER_CONFIGURATION_POINTS = 60;
    static int user_level = 1;
    static int gold = 100;

    public static void main(String[] args) {
        while (play) {
            // бесконечный цикл
        //GameApp ga = new GameApp();
        String input = "Консольная стратегия. ";
        System.out.println(input + "Игровое Меню.");

        System.out.println(readMenuFile(filePathToMenu));

        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер пункта меню: ");
        int num = in.nextInt();
        //System.out.printf("Ваш выбор: %d \n", num);
        //input.close();

            switch (num) {
                case 1:
                    System.out.println("1");
                    // ввод с консоли
                    Scanner inConfig = new Scanner(System.in);
                    System.out.println("Всего очков для распределения параметров: " + CHARACTER_CONFIGURATION_POINTS);
                    System.out.print("Введите имя: ");
                    String nameConfig = inConfig.nextLine();
                    //System.out.printf("Your name: %s \n", nameConfig);
                    System.out.print("Введите ловкость: ");
                    int dexterityConfig = inConfig.nextInt();
                    CHARACTER_CONFIGURATION_POINTS = CHARACTER_CONFIGURATION_POINTS - dexterityConfig;
                    System.out.printf("Ваша ловкость: %d Осталось очков: %d\n", dexterityConfig, CHARACTER_CONFIGURATION_POINTS);
                    System.out.print("Введите здоровье: ");
                    int healthConfig = inConfig.nextInt();
                    CHARACTER_CONFIGURATION_POINTS = CHARACTER_CONFIGURATION_POINTS - healthConfig;
                    System.out.printf("Ваша ловкость: %d Ваше здоровье: %d Осталось очков: %d\n", dexterityConfig, healthConfig, CHARACTER_CONFIGURATION_POINTS);
                    System.out.print("Введите опыт: ");
                    int experienceConfig = inConfig.nextInt();
                    CHARACTER_CONFIGURATION_POINTS = CHARACTER_CONFIGURATION_POINTS - experienceConfig;
                    System.out.printf("Ваша ловкость: %d Ваше здоровье: %d Опыт: %d Осталось очков: %d\n", dexterityConfig, healthConfig, experienceConfig, CHARACTER_CONFIGURATION_POINTS);
                    System.out.print("Введите начальную силу героя: ");
                    int strengthConfig = inConfig.nextInt();
                    CHARACTER_CONFIGURATION_POINTS = CHARACTER_CONFIGURATION_POINTS - strengthConfig;
                    System.out.printf("Ваша ловкость: %d Ваше здоровье: %d Опыт: %d Сила: %d Осталось очков: %d\n", dexterityConfig, healthConfig, experienceConfig, strengthConfig,CHARACTER_CONFIGURATION_POINTS);
                    //inConfig.close();

                    // подготовка строк
                    //app.name=Properties Sample Code
                    //app.version=1.01
                    String wrname = "user.name=" + nameConfig;
                    String wrdex = "user.dexterity=" + dexterityConfig;
                    String wrhlth = "user.health=" + healthConfig;
                    String wrexp = "user.experience=" + experienceConfig;
                    String wrgld = "user.gold=" + gold;
                    String wrstr = "user.strength=" + strengthConfig;
                    String wrlvl = "user.level=" + user_level;

                    // очистка файла
                    WriteProps wp = new WriteProps();
                    wp.trueClearFile();

                    // запись (добавление) новых строк в файл
                    wp.trueWriterString(wrname);
                    wp.trueWriterString(wrdex);
                    wp.trueWriterString(wrhlth);
                    wp.trueWriterString(wrexp);
                    wp.trueWriterString(wrgld);
                    wp.trueWriterString(wrstr);
                    wp.trueWriterString(wrlvl);

                    // вывод содержимого всего файла свойств
                    try {
                        Stream<String> lines = Files.lines(Paths.get("src/app.properties"));
                        lines.forEach(System.out::println);
                    } catch (Exception e) {
                        System.out.println("Ошибка чтения файла");
                    }

                    // вывод отдельных параметров конфигурации персонажа
                    ReadProps rp = new ReadProps();
                    System.out.println(rp.readProps("user.name"));
                    System.out.println(rp.readProps("user.dexterity"));
                    System.out.println(rp.readProps("user.health"));
                    System.out.println(rp.readProps("user.experience"));
                    System.out.println(rp.readProps("user.gold"));
                    System.out.println(rp.readProps("user.strength"));
                    System.out.println(rp.readProps("user.level"));

                    //
                    play = true;
                    break;

                case 2:
                    System.out.println("Начинаем битву...");
                    // прочитаем файл конфигурации созданного персонажа
                    //readConfigFile();

                    //Player player = new Player("Dude", 10, 10, 10, 10, 10, 10);
                    // построим экземпляр класса
                    try {
                        FilePropertiesManager fp = new FilePropertiesManager();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println(new FilePropertiesManager().getNameF());
                        Player player = new Player(new FilePropertiesManager().getNameF(), 10, 10, 10, 10, 10, 10);
                        Band band;
                        band = new Band(player);
                        // получаем параметры персонажа
                        String name = band.player.getName();
                        int dexterity = band.player.getDexterity();
                        int health = band.player.getHealth();
                        int exp = band.player.getExperience();
                        long gold = band.player.getGold();
                        int strength = band.player.getStrength();
                        int level = band.player.getLevel();

                        //System.out.printf("Name: %s  Age: %d  Dexterity: %.2f \n", name, dexterity, health, exp);
                        System.out.printf("Имя: %s  Ловкость: %d  Здоровье: %d  Опыт: %d  Золото: %d  Сила: %d  Уровень: %d  \n", name, dexterity, health, exp, gold, strength, level);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    play = true;
                    break;

                case 3:
                    System.out.println("2");
                    play = true;
                    break;

                case 4:
                    play = false;
                    break;
                default:
                    throw new IllegalStateException("Неожиданное значение: " + num);
            }
            System.out.println("Выходим");
        }
    }

    public static String readMenuFile(String filePathToMenu) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePathToMenu)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static String readConfigFile() {
        try {
            return new FilePropertiesManager().getNameF();
        } catch (MissingFormatArgumentException e) {
            e.printStackTrace();
        } catch (UnknownFormatConversionException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Ошибка чтения файла конфигурации персонажа";
    }
}
