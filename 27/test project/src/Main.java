import processing.core.PApplet;

public class Main extends PApplet {
    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    public void settings(){
        size(200, 200);
    }

    public void setup(){
        ellipse(width/2,height/2,100,100);
    }
}
