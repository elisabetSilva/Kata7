
package kata7;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import java.util.Date;


public class Watch {
    private static final double secondStep = Math.PI * 2 / 60;
    private static final double minuteStep = secondStep / 60;
    private static final double hourStep = minuteStep / 12;
  
    private final List <Observer> observers = new ArrayList<>();
    
    private double seconds = Math.PI / 2;
    private double minutes = Math.PI / 2;
    private double hours = Math.PI / 2;
    
    public Watch(){
        Timer timer = new Timer();
        timer.schedule(timerTask(), 0, 1000);
    }

    private TimerTask timerTask() {
        return new TimerTask(){
          @Override
          public void run(){
              step();
              updateObservers();
          }
        };
    }
    
    private void step() {
        seconds = normalize(seconds + secondStep);
        minutes = normalize(minutes + minuteStep);
        hours = normalize(hours + hourStep);
    }

    private double normalize(double angle) {
        return (angle + Math.PI * 2) % (Math.PI * 2);
    }
    
    private void updateObservers() {
        for (Observer observer : observers) {
            observer.update(null, null);
        }
    }
    
    public void add(Observer observer) {
        observers.add(observer);
    }

    public double getSeconds() {
        return seconds;
    }

    public double getMinutes() {
        return minutes;
    }

    public double getHours() {
        return hours;
    }
}
