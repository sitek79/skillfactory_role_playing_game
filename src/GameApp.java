import player.Band;
import player.Player;
import player.Team;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;
import java.util.UnknownFormatConversionException;

public class GameApp {
    static boolean play = true;
    static String filePathToMenu = "src/startup_menu.txt";

    public static void main(String[] args) {
        //GameApp ga = new GameApp();

        String input = "Консольная стратегия. ";
        System.out.println(input + "Игровое Меню.");

        System.out.println(readMenuFile(filePathToMenu));

        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер пункта меню: ");
        int num = in.nextInt();
        System.out.printf("Ваш выбор: %d \n", num);
        in.close();

        switch (num) {
            case 1:
                System.out.println("1");
                play = false;
                break;

            case 2:
                System.out.println("2");
                play = false;
                break;

            case 3:
                play = false;
                // прочитаем файл конфигурации созданного персонажа
                try {
                    new FilePropertiesManager().getNameF();
                } catch (MissingFormatArgumentException e) {
                    e.printStackTrace();
                } catch (UnknownFormatConversionException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //Player player = new Player("Dude", 10, 10, 10, 10, 10, 10);
                // построим экземпляр класса
                try {
                    Player player = new Player(new FilePropertiesManager().getNameF(), 10, 10, 10, 10, 10, 10);
                    Band band = new Band(player);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // получаем параметры персонажа
                String name = band.player.getName();
                int dexterity = band.player.getDexterity();
                int health = band.player.getHealth();
                int exp = band.player.getExperience();
                long gold = band.player.getGold();
                int strength = band.player.getStrength();
                int level = band.player.getLevel();
                //System.out.printf("Name: %s  Age: %d  Dexterity: %.2f \n", name, dexterity, health, expe);
                System.out.printf("Name: %s  Dexterity: %d  Health: %d  Experience: %d  Gold: %d  Strength: %d  Level: %d  \n", name, dexterity, health, exp, gold, strength, level);
                break;
            default:
                throw new IllegalStateException("Неожиданное значение: " + num);
        }

        play = true;
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
}
