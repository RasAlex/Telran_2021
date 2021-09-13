package telran.wrapper.controller;

import com.sun.deploy.ui.AboutDialog;

public class CalculatorAppl {
    public static void main(String[] args) {
       // double res = calculator(0, 0, null);
        if(args.length !=3){
            System.out.println("Wrong numbers of args");
            return;
        }
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double res =calculator(a, b, args[2]);
            System.out.println(res);

    }
    //Из статик метода нельзя вызвать НЕстатик методы
    //Из НЕстатик метода можно вызвать статик метод
    public static double calculator(double a, double b, String oper) {
        switch (oper) {
            case "add":
                return a + b;
            case "sub":
                return a - b;
            case "mul":
                return a * b;
            case "div":
                return a / b;
            default:
                return Double.NaN;
        }
    }

}