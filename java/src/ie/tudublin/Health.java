package ie.tudublin;

import processing.core.PApplet;

public class Health {
    float x, y;
    float dX, dY;
    float w = 50;
    float halfW = w / 2;
    YASC yasc;
    float rotation;

    public Health(YASC yasc, float x, float y, float dX, float dY) {
        int dice = (int)yasc.random(4);
        switch(dice)
        {
            case 0 :
                x = -halfW;
                y = yasc.random(halfW, yasc.height-halfW);
                dX = yasc.random(1, 4);
                dY = yasc.random(-1, 1);
        }
    }

    void render()
    {
        
        
    }

    void respawn() {

    }

}
