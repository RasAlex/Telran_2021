package telran.timer.controller;

import telran.timer.model.Timer;
import telran.timer.model.TimerAutostart;
import telran.timer.model.TimerMySleep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SleepInterruptApp {
    public static void main(String[] args) throws IOException, InterruptedException {
 //       Timer timer = new Timer();
 //       TimerMySleep timer = new TimerMySleep();
        TimerAutostart timer = new TimerAutostart();
        Thread thread = new Thread(timer);
        //thread.setDaemon(true);
        //thread.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("Enter time interval or q for exit");
            String input  = br.readLine();
            if ("q".equalsIgnoreCase(input)){
                //thread.stop(); Это не безопасно.
                //thread.interrupt(); // все методы, которые переводят тред в состояние ожидания генерят InterruptedException
                timer.getThread().interrupt();
                break;

            } else {
                timer.setClockPeriod(Integer.parseInt(input));
            }
        }
        //thread.join();
        timer.getThread().join();
        //System.out.println("Main thread finish...");
        System.out.println(Thread.currentThread().getName() + " thread finish");
    }
}
