package telran.goat.controller;

import telran.goat.model.Goat;

public class GoatAppl {
    public static void main(String[] args) {
        Goat goatlin1 = new Goat();
        for (int i = 1; i <= Goat.MAX_COUNT; i++) {
            Goat.count++;
        }
        System.out.println(Goat.count);
        Goat goatlin2 = new Goat();
        for (int i = 1; i <= Goat.MAX_COUNT; i++) {
            Goat.count++;
        }
        System.out.println(Goat.count);
        System.out.println(Goat.count);
        System.out.println(Math.PI);
    }
}
