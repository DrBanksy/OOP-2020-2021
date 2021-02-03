package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing2 extends PApplet
{

	//called initially
	public void settings()
	{
		size(500, 500);
	}

	//called once
	public void setup() {
		
	}
	
	//called 60 times a second
	public void draw()
	{	
		// background(255, 0, 0);
		// stroke(0, 255, 0); //pen color
		// line(10, 10, 150, 200);
		// line(490, 10, 250, 200);// x1, y1, x2, y2
		// ellipse(200,200,100,50); // cx, cy, w, h
		// fill(0, 255, 255);
		// noStroke();
		// fill(0);
		// text("Hello World", 300, 300);
		// rect(20,100,70,90); // tlx, tly, w, h
		// point(200,61);
		// triangle(200, 90, 300, 200, 10, 60);
		noStroke();
		background(255, 0, 0); 
		fill(255, 192 ,0);
		ellipse(250,300,400,400);
		fill(135, 206, 250);
		triangle(250, 50, 50, 400, 450, 400);
		fill(255, 192, 203);
		ellipse(250, 240, 200, mouseY); 
		fill(255,20,147);
		ellipse(250,240,70,mouseY);

	}
}
