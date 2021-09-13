package telran.wrapper.controller;
/*
каждому примитиву в Яве соответствует свой Класс
byte -->  Byte
short --> Short
char --> Character
int -->Integer
long --> Long
float --> Float
double --> Double
boolean --> Boolean
 */
public class WrapperClassesAppl {
    public static void main(String[] args) {
        Integer x = 42; //Это автобоксинг.
        System.out.println(x);
        Integer y= x / 6; // автоматический анбоксинг --> Деление --> автоматический боксинг примитива в Класс
        System.out.println(y);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        String a = "55";
        String b = "87";
        /*
        Преобразование строки - это парсинг
        Все врапер классы имеют статичный метод parse
        docs.oracle.com  - информация о классах
         */
        int num1 = Integer.parseInt(a);
        int num2 = Integer.parseInt(b);
        int res = num1 +num2;
        System.out.println(res);
        String c = "true";
        boolean check = Boolean.parseBoolean(c);
        System.out.println(check);
        double d = 5. / 0;
        if (!Double.isNaN(d)  && !Double.isInfinite(d)) {
            System.out.println(d);
        }else{
            System.out.println("Wrong result");
        }
            }
        }

