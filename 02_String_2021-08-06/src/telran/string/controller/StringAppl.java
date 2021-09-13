package telran.string.controller;

import java.net.Socket;
import java.util.Locale;

// Семь примитивов, остальное объекты.
public class StringAppl {
    public static void main(String[] args) {
        //String str = new String("Hello World");
        String str  =  "Hello";
        char[] chars = {' ', 'w', 'o','r','l','d'}; //массив символов
        String str1 = new String(chars);
        System.out.println(str1);
        str = str + str1;
        //str =  str.concat(str1); // метод конкатенации
        System.out.println(str);
        System.out.println(str.length());
        for (int i = 0; i <str.length(); i++) {
            System.out.println(str.charAt(i));

        }
        String str2 = " WORLD";
        System.out.println(str1 == str2); // == - сравнивает ссылки
        System.out.println(str1.equals(str2)); // сравнение по существу объекта
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str2.toLowerCase());
        System.out.println(str1.toUpperCase());
        System.out.println(str.indexOf('l',5)); // поиск с начала
        System.out.println(str.indexOf("world"));
        System.out.println(str.lastIndexOf('l', 8));
        System.out.println(str.replace('l','L')); // замена символов
        System.out.println(str.replace("el", "ZZZZ")); // замена подстроки
        System.out.println(str.substring(3,6)); //левый край включается, а правый нет

    }
}
