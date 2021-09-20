package telran.builder.controller;

public class StringBuilderAppl {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("Java"); // даёт ускорение производительности, если надо делать много конкатинаций
        builder.append(8);
        System.out.println(builder);
        String str = stringManipulation("mama");
        System.out.println(str);
    }


    private static String stringManipulation(String str) {
        StringBuilder builder = new StringBuilder(str);
        builder.append(" ").append("myla").append(" ").append("ramu");
        builder.reverse();
        return builder.toString();
    }
}
