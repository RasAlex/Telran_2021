package telran.timer.model;

import java.time.Instant;
import java.time.LocalTime;

public class TimerMySleep implements Runnable{
    int clockPeriod = 1;

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
                mySleep(clockPeriod*1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " aka mySleep" + " thread finish");
                System.out.println(Thread.currentThread().isInterrupted());
                break;
            }

        }

    }

    private void mySleep(long period) throws InterruptedException {
        Instant time = Instant.now();
        Instant finish = time.plusMillis(period);
        while (time.isBefore(finish)){
            if (Thread.interrupted()){   // меняет поле на false // Thread.currentThread().isInterrupted не меняет
                throw new InterruptedException("Hello from mySleep and bye bye");
            }
            time = Instant.now();
        }
    }
}
