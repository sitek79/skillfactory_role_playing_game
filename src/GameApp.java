import player.Player;
import player.Team;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

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
                System.out.println("3");
                play = false;
                Player player = new Player("Dude", 10, 10, 10, 10, 10, 10);
                Team team = new Team(player);
                //System.out.println(team.player.getName());
                //System.out.println(team.player.getDexterity());
                //System.out.println(team.player.getHealth());
                //System.out.println(team.player.getExperience());
                //System.out.println(team.player.getGold());
                //System.out.println(team.player.getStrength());
                //System.out.println(team.player.getLevel());
                // получаем параметры персонажа
                String name = team.player.getName();
                int dexterity = team.player.getDexterity();
                int health = team.player.getHealth();
                int exp = team.player.getExperience();
                long gold = team.player.getGold();
                int strength = team.player.getStrength();
                int level = team.player.getLevel();
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
