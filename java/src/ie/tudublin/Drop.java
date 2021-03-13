package ie.tudublin;


import processing.core.PApplet;
import java.util.Random;

public class Drop {
    float x, y, len, ySpeed;
    Random ran;
    float width;
    float height;
    float z;

    Drop(int width2, int height2) {
        this.width = width2;
        this.height = height2;
        setup();
    }
    
    void setup() {
        ran = new Random();

        x = ran.nextInt(((int)width - 1) + 1) + 1;
        //starting point range for rainfall, max 400 min -200
        y = ran.nextInt((int)height+200) -200;

        z = ran.nextInt(10) + 1;
        // len = ran.nextInt(10) + 20;
        len = PApplet.map(z , 0, 20, 10, 20);
        ySpeed = PApplet.map(z , 0, 20, 4, 10);
    }
    

    void fall() {
        y = y + ySpeed;
        //speed up or slow down rainfall
        ySpeed = ySpeed + 0.01f;

        if(y > height) {
            y = ran.nextInt(200) + 1;
            ySpeed = PApplet.map(z , 0, 20, 4, 10);
        }
    }

    void render(PApplet pa) {
        //adjust the last value for thickness
        float thick = PApplet.map(z, 0, 20, 1, 6);
        pa.strokeWeight(thick);
        pa.colorMode(pa.HSB);
        pa.stroke(ran.nextInt(255) + 1, 255, 255);
        pa.line(x, y, x, y+len);

    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    

    
}
