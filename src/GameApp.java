import player.Player;

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
                
                break;
        }

        // получаем параметры персонажа
        String name = "Tom";
        int age = 30;
        float height = 1.7f;
        System.out.printf("Name: %s  Age: %d  Height: %.2f \n", name, age, height);
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
