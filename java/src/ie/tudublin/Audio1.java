package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet {

    Minim minim;
    AudioInput ai;//connect to microphone
    AudioPlayer ap;
    AudioBuffer ab; //samples

    float[] lerpedBuffer;

    public void settings()
    {
        size(512, 512);
    }
    float y = 200;
    float lerpedY = y;

    public void setup()
    {
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ap = minim.loadFile("heroplanet.mp3", width);
        ab = ap.mix; // mp3 file
        ap.play();
        // ab = ai.mix; // microphone
        lerpedBuffer = new float[width];
    }

    float lerpedAverage = 0;

    public void draw()
    {
        background(0);
        stroke(255);
        colorMode(HSB);
        float halfHeight = height/2;
        for(int i = 0; i < ab.size(); i++) {
            float c = map(i, 0, ab.size(), 0, 255);
            stroke(c, 255, 255);
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
            line(i, halfHeight - lerpedBuffer[i] * halfHeight,halfHeight + lerpedBuffer[i] * halfHeight, i);
        }

        //avg amplitude
        float sum = 0;
        float average = 0;
        for(int i = 0; i < ab.size(); i++) {
            sum = sum + Math.abs(ab.get(i));
        }
        

        average = sum /(float) ab.size();
        lerpedAverage = lerp(lerpedAverage, average, 0.1f);
        fill(0);
        strokeWeight(2);
        stroke(30, 255, 255);
        ellipse(width, 10, 20 + (lerpedAverage * 500), 20 + (lerpedAverage * 500));


        // ellipse(300, lerpedY, 30, 30);
        // y = random(-10, 10);
        // lerpedY = lerp(lerpedY, y, 0.1f);

        
    }   
}