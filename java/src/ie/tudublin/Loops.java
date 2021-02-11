package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

    public void settings() {
        size(500, 500);
        cx = width / 2;
        cy = height / 2;        
    }

    int mode = 0;

    float cx;
    float cy;

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(HSB);
    }

    float offset = 0;

    public void draw() {
        background(0);
        noStroke();
        switch (mode)
        {
            case 0:
                fill(50, 255, 255);
                if(mouseX < cx) {
                    
                    rect(0, 0, cx, height);
                } else {
                    rect(cx, 0, cx, height);
                }
                break;
            
            case 1: 
            {
                if(mouseY < cy && mouseX < cx ){
                    fill(20, 255, 255);
                    rect(0, 0, cx, cy);
                } else if(mouseX > cx && mouseY < cy) {
                    fill(25, 255, 255);
                    rect(cx, 0, cx, cy);
                }
                if(mouseY > cy && mouseX < cx) {
                    fill(100, 255, 255);
                    rect(0, cy, cx, cy);
                } else if(mouseX > cx && mouseY > cy){
                    fill(120, 255, 255);
                    rect(cx, cy, cx, cy);
                }
                break;
            }
                
            
            case 2:
            {
                int numRects = (int)(mouseX / 10.0f);
                float w = width / (float) numRects;
                float cgap= 255 / (float) numRects;
                for(int i = 0; i < numRects; i++) {
                    fill(i*cgap, 255, 255);
                    rect(i*w, 0, w, height);
                }
                break;
            }
                
            
            case 3:
            {
                int numCircles = 10;
                float wi = width/ (float) numCircles;
                float colorgap= 255 / (float) numCircles;

                for(int i = 0; i < numCircles; i++) {
                    fill(i*colorgap, 255, 255);
                    ellipse(wi/2 + (i*wi), 200, 15, 15);
                }
                break;
            }
                
            
            case 4:
            {
                int numRects1 = 10;
                float width1 = width / (float) numRects1;
                float height1 = width / (float) numRects1;
                float colorgap1 = 255 / (float) numRects1;
                
                for(int i = 0 ; i < numRects1 ; i++) {
                    fill(i*colorgap1, 255, 255);
                    rect(i*width1, i*width1, width1, height1);
                }

                break;

            }
                
            
            case 5:
            {
                int numSmallRects = 12;
                float rectWidth =  (width / (float) numSmallRects) * 1.2f;
                float h= (width / (float) numSmallRects) * 1.2f;
                float cGap = 255 / (float) numSmallRects;

                for(int i = 0 ; i < numSmallRects/3 ; i++) {
                        fill(i*cGap, 255, 255);
                        rect(i*rectWidth, i*rectWidth, rectWidth, h);
                    
                }

                for(int i = 0 ; i < numSmallRects/3 ; i++) {
                        fill((i*cGap) + 190, 255);
                        rect((width - rectWidth) - (i*rectWidth), i*rectWidth, rectWidth, h);
                }
                
                for(int i = 0 ; i < numSmallRects/3 ; i++) {
                    fill((i*cGap) + 220, 255, 255);
                    rect(i*rectWidth, (height - h)-(i*rectWidth), rectWidth, h);
                }


                for(int i = 0 ; i < numSmallRects/3 ; i++) {
                    fill((i*cGap) + 100, 255, 255);
                    rect((width - rectWidth) - (i*rectWidth), (height - h)-(i*rectWidth), rectWidth, h);
                }

                fill(235, 255, 255);
                rect(4*rectWidth, 4*rectWidth, rectWidth*2, h);
                fill(5, 255, 255);
                rect(4*rectWidth, 5*rectWidth, rectWidth*2, h);
                break;
            
            }
                
            
            case 6:
            {
                int numLines = 5;
                float theta = TWO_PI / (float) numLines; //gives angles between the five lines
                float radius = 100;
                for(int i =0; i < numLines; i ++) {
                    float angle = theta * i;
                    float x = sin(angle) * radius;
                    float y = cos(angle) * radius;
                    stroke(230);
                    line(cx, cy, cx + x, cy + y);
                }

                break;
            }
                
            case 7:
            {
                offset += (mouseX /100);
                int numOfCircles = (int) mouseX / 10;
                float w = width / (float) numOfCircles;
                float colorgap= 255 / (numOfCircles + numOfCircles);

                for(int i = 0; i < numOfCircles; i++) {
                    for(int j = 0 ; j < numOfCircles ; j++) {
                        float c = (colorgap * (i +j) + offset) % 255;
                        fill(c, 255, 255);
                        ellipse(w/2 + (w * j), (w/2) + w * i , w, w);
                    }
                }
                break;
            }
                
            
            case 8:
            {
                int numCircles = (int) mouseX / 10;
                float cgap = 255 / (float) numCircles;
                float gap = width / (float) numCircles;
                float w = width;
                for( int i = 0 ; i < numCircles ; i++) {
                    fill(i * cgap, 255, 255);
                    ellipse(cx, cy, w, w);
                    w-=gap;
                }

                break;
            }

            case 9: 
            {
                int sides = (mouseX / 50);
                float theta = TWO_PI / (float) sides;
                float radius1 = 5;
                float radius2 = 70;
                for(int i = 1 ; i <=sides ; i++) {
                    float x1 = sin(theta + (i-1)) * radius2;
                    float y1 = cos(theta + (i-1)) * radius2;
                    float x2 = sin(theta + i) * radius1;
                    float y2 = cos(theta * i) * radius1;
                    stroke(255);
                    line(cx + x1, cx + y1, cx + x2, cx + y2);

                }
            }
            
            
                

        }
    }

    


    
}
