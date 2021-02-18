package ie.tudublin;

import processing.core.PApplet;

import java.sql.Time;
import java.util.Random;

public class Loops extends PApplet {

    public void settings() {
        size(500, 500);
        cx = width / 2;
        cy = height / 2;  
        alpha = 1;
        delta =1;
        angle = 0; 
        vel = 0;
        acc = 0;     
    }

    int mode = 0;
    int alpha;
    int delta;
    int time;
    boolean fade;
    float cx;
    float cy;
    float angle;
    float vel;
    float acc;

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(HSB);
        smooth();
        fade = false;
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
                
            
            // case 8:
            // {
            //     int numCircles = (int) mouseX / 10;
            //     float cgap = 255 / (float) numCircles;
            //     float gap = width / (float) numCircles;
            //     float w = width;
            //     for( int i = 0 ; i < numCircles ; i++) {
            //         fill(i * cgap, 255, 255);
            //         ellipse(cx, cy, w, w);
            //         w-=gap;
            //     }

            //     break;
            // }

            // case 9: 
            // {
            //     int sides = (mouseX / 50);
            //     float theta = TWO_PI / (float) sides;
            //     System.out.println(theta);
            //     float radius = 200;
            //     stroke(255);
            //     for(int i = 1 ; i <= sides ; i ++)
            //     {
            //         float x1 = sin(theta * (i - 1)) * radius;
            //         float y1 = cos(theta * (i - 1)) * radius;
            //         float x2 = sin(theta * i) * radius;
            //         float y2 = cos(theta * i) * radius;
            //         line(cx + x1, cy + y1, cx + x2, cy + y2);
            //     }
            // }

            case 8:
            {
                float gap = width * 0.1f;
                float halfGap = gap / 2.0f;
                colorMode(RGB);
                stroke(0, 255, 0);
                textAlign(CENTER, CENTER);
                for(int i = -5 ; i <=5 ; i ++)
                {
                    float x = map(i, -5, 5, gap, width - gap);				
                    line(x, gap, x, height - gap);
                    line(gap, x, width - gap, x);
                    fill(255);
                    text(i, x, halfGap);
                    text(i, halfGap, x);
                    
                }
                break;
            }

            // ********* cool lines *********
            // ********* useful for project *********
            
            case 9:
            {
                float numLines = 10;
                float w = width / numLines;
                float colorGap = 255 / (float) numLines;
                float border = width * 0.05f;
                colorMode(HSB);
                strokeWeight(2);
                smooth();
                for(int i = 0; i < numLines; i++) {
                        stroke((i * colorGap) % 255 , 255, alpha);
                        line(border, cy + cy/2, width, border * i);
                        twinkle(); 
                        
                }
                break;
            }

            // case 9 :
            // {
                
            //     int numOfSquares = (int) mouseX /10;
            //     float w = width / (float) numOfSquares;
            //     colorMode(HSB);
            //     fill(190, 255, 255);
            //     rect(cx, cy, 100, 100);


            //     for(int i = 0 ; i < numOfSquares ; i++ ) {
            //         for(int j = 0 ; j < numOfSquares; j++) {
            //             if((j + i) % 2 == 0) {
            //                 fill(190, 255, 255);
            //             } else {
            //                 fill(190, 255, 100);
            //             }
            //             rect(w * j, w * i, w, w);
            //         }
            //     }
                
            // }

            // case 9: 
            // {
                
            //     Random rand = new Random();
            //     int upperbound = 400;

            //     drawStar(cx, cy, 30, 100, 5);
            //     drawStar(200, 250, 30, 100, 40);
            //     drawStar(100, 150, 30, 100, 10);
                

            // }
            
            // case 9:
            // {
            //     acc = (float)0.01;
            //     acc = map((float)mouseX, (float)0, (float)width, (float)-0.01,(float) 0.01);
            //     noStroke();
            //     fill(240, 99, 164);
            //     rectMode(CENTER);
            //     translate(250, 250);
            //     rotate(angle);
            //     // rect(0, 0, 130, 60);
            //     drawStar(0, 0, 30, 70, 5);
            //     angle += vel;
            //     vel += acc;
                
            //     break;
            // }
            
            
                

        }
    }

    void twinkle() {
        //fade in and out
       if (alpha == 0 || alpha == 255) {
          delta= -delta;
        }
        alpha += delta;
      } 
    
    public void drawStar(float x, float y, float radius1, float radius2, int npoints) {
        float angle = TWO_PI / npoints;
        float halfAngle = angle / (float)2.0;
        colorMode(HSB);
        beginShape();
        for(float a = 0; a < TWO_PI ; a += angle) {
            stroke(255);
            fill(255, 255, 255);
            float sx = x + cos(a) * radius2;
            float sy = y + sin(a) * radius2;
            vertex(sx, sy);
            sx = x + cos(a+halfAngle) * radius1;
            sy = y + sin(a+halfAngle) * radius1;
            vertex(sx, sy);
        }
        endShape();      
    }

    public void drawLineGraph() {
        float border = width * 0.1f;
        stroke(255);
        line(border, border, border, height - border);
        for(int i = 0 ; i <= 150 ; i+=10 ){
            float y = map(i, 0, 150, height - border, border);
            line(border, y, border -5, y );
            text(i, border/2, y);
        }
        line(border, height - border, width - border, height - border);
    }

    public void drawGrid() {
        float y = 0;
        float x = 0;
        float spacing = 50;

        stroke(255);
        strokeWeight(2);

        x = 0;
        while(x < width) {
            line(x, 0, x, height);
            x += spacing;
        }

        y = 0;
        while(y < height) {
            line(0, y, width, y);
            y+=spacing;
        }
    }
    

    


    
}
