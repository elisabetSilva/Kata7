
package kata7;

import java.awt.Point;
import static java.lang.Math.*;
import java.util.Observable;
import java.util.Observer;

public class WatchPresenter implements Observer{
    private final Watch watch;
    private final WatchDisplay watchDisplay;
    
    public WatchPresenter(Watch watch, WatchDisplay watchDisplay){
        this.watch = watch;
        this.watch.add(this);
        this.watchDisplay = watchDisplay;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        refresh();
    }

    private void refresh() {
        watchDisplay.paint(pointsOf(watch));
    }

    private Point[] pointsOf(Watch watch) {
        Point[] points = new Point[3];
        points[0] = pointsOf(watch.getSeconds(),120);
        points[1] = pointsOf(watch.getMinutes(),90);
        points[2] = pointsOf(watch.getHours(),60);
        return points;
    }

    private Point pointsOf(double angle, int length) {
        return new Point ((int)(length*cos(angle)), (int)(length*sin(angle)));
    } 
}
