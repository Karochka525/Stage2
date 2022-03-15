package stage2.demo;

import stage2.practice.one.HanoiTower;
import stage2.practice.one.Parser;

public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Class.forName ("org.h2.Driver"));

        System.out.println("Проверка скобочной структуры выражания: ");
        System.out.println("[760÷(746-x){AVB}");
        System.out.println(Parser.validate("[760÷(746-x){AVB}"));
        System.out.println();

        HanoiTower.exchange(3);
        System.out.println();
       // System.out.println(Archivator.decompress(Archivator.compress("ABCD")));
    }
}
