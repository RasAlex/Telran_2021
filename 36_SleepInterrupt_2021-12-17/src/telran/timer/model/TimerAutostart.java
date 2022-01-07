package telran.timer.model;

import java.time.LocalTime;

public class TimerAutostart implements Runnable{
    int clockPeriod = 1;
    Thread thread;

    public Thread getThread() {
        return thread;
    }

    public TimerAutostart() {
        thread = new Thread(this);
    //    thread.setDaemon(true);
        thread.start();
    }

    public int getClockPeriod() {
        return clockPeriod;
    }

    public void setClockPeriod(int clockPeriod) {
        this.clockPeriod = clockPeriod;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(clockPeriod*1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " aka TimerAutoStart" + " thread finish");
                System.out.println(Thread.currentThread().isInterrupted());
                break;
            }

        }

    }
}
