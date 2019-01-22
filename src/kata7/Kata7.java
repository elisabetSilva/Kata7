
package kata7;

import javax.swing.JFrame;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Kata7 extends JFrame{

    public static void main(String[] args) throws IOException {
        
        new Kata7().launch();     
        
    }
    
    public Kata7 () throws IOException{
        Watch watch = new Watch();
        WatchDisplay watchDisplay = new WatchDisplay(background());
        WatchPresenter watchPresenter = new WatchPresenter(watch, watchDisplay);
        this.init();
        this.add(watchDisplay);
    }

    private Image background() throws IOException {
        return ImageIO.read(new File("background.jpg"));
    }
    
    private void launch() {
        this.setVisible(true);
    }

    private void init() {
        this.setTitle("Watch");
        this.setSize(400,400);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }   
}
