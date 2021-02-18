package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {

    // This is how the map function works!
    public float map1(float from, float start1, float stop1, float start2, float stop2) {
        float range1 = stop1 - start1;
        float range2 = stop2 - start2;
        float howFar = from - start1;

        return start2 + (howFar / range1) * range2;
    }

    // This is a demo of the map function
    public void drawGrid() {
        stroke(0, 255, 0);
        float border = width * 0.1f;
        textAlign(CENTER, CENTER);
        for (int i = -5; i <= 5; i++) {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            fill(255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);
        }
    }
    
    // Return the sum of all the elements in an array
    float sum(float[] array) {
        float sum = 0;
        for (float r : array) {
            sum += r;
        }
        return sum;
    }

    public void settings() {
        size(500, 500);

        // Testing the map function
        float f = map1(2, 0, 10, 0, width);
        println(f); // Should print 100

        f = map1(9, 0, 1, 0, 10);
        println(f); // Should print 90

        f = map1(250, 200, 300, 400, 500);
        println(f); // Should print 450

        f = map1(5, 0, 10, 1000, 2000);
        println(f); // Should print 1500

    }

    int mode = 0;

    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };
    String[] months = { "Jan", "Feb", "March", "April", "May", "June", "July", "August", "Sept", "Oct", "Nov", "Dec" };
    float[] arr = new float[100]; // 100 float array

    public void keyPressed() {
        // the value of mode will be the number of the
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(RGB);

        // Iterating over an array in Java
        for (int i = 0; i < rainfall.length; i++) {
            println(months[i] + "\t" + rainfall[i]);
        }

        // Enhanced for loop
        for (float f : rainfall) {
            println(f);
        }

        // What month had the most and least rainfall??
        // What is the total rainfall?
        // What is the average rainfall??

        float sum = 0;
        int minIndex = 0;
        int maxIndex = 0;
        sum = 0;
        float average = 0;
        for (int i = 0; i < rainfall.length; i++) {
            if (rainfall[i] < rainfall[minIndex]) {
                minIndex = i;
            }
            if (rainfall[i] > rainfall[maxIndex]) {
                maxIndex = i;
            }
            sum += rainfall[i];
        }

        average = sum / (float) rainfall.length;
        println("Least rainfall was in " + months[minIndex] + " with " + rainfall[minIndex]);
        println("Most rainfall was in " + months[maxIndex] + " with " + rainfall[maxIndex]);
        println("Average rainfall: " + average);

        // rect(x, y, w, -h);

        // Draw a bar chart of the rainfall!!
        // Use the map function

        colorMode(HSB);
        float w = width / (float) rainfall.length;
        for (int i = 0; i < rainfall.length; i++) {
            noStroke();
            fill(random(255), 255, 255);
            float x = map(i, 0, rainfall.length, 0, width);
            rect(x, height, w, -rainfall[i]);
        }
    }


    public void draw() {
        background(0);
        switch (mode) {
            case 0: {
                // Bar chart
                drawChart(rainfall, months);
                break;
            }
            case 1: {
                // Trend line
                drawTrendLine(rainfall, months);
                break;
            }
            case 2: {
                // Pie chart
                drawPieChart(rainfall, months);
                break;
            }
        }
    }

    public void drawChart(float[] rainfall, String[] months) {
        float border = width * .08f;
        float w = width / (float) rainfall.length;
        textAlign(CENTER, CENTER);
        float cgap = 255 / (float) rainfall.length;
        for( int i = 0 ; i < 120; i+=10) {
            float x = map(i, 0, 120, border, width - border);
            float rainValue = map(-rainfall[i/10], 0, 120, border, width - border);
            noStroke();
            fill(255);
            text(months[i/10], x, height - (border * 0.5f));
            text(i, border * 0.5f, height - x);
            fill(cgap * i/10, 255, 255);
            stroke(255);
            line(border - 5, x, border, x);
            rect(x, height - border, w * 0.9f, rainValue - border);
        }
        float x1 = map(0, 0, 120, border, width - border);
        fill(255);
        text(0, border * 0.5f, height - x1);
        stroke(255);
        strokeWeight(2);
        line(x1, border, x1, height - border);
    }

    public void drawTrendLine(float[] rainfall, String months[]){
        float border = width * .08f;
        float w = width / (float) rainfall.length;
        textAlign(CENTER, CENTER);
        float cgap = 255 / (float) rainfall.length;
        float l = map(0*10, 0, 120, border, width - border);
        stroke(255);
        line(l, border, l, height - border);
        line(l, height-border, width-border, height-border);

        //setting the markers and numbers
        for(int i = 0; i <= 12; i++) {
            float x = map(i*10, 0, 120, border, width - border);
            stroke(255);
            line(border - 5, height -x, border, height - x);
            text(i*10, border * 0.5f, height - x);
        }

        //setting the months and the markers
        for(int i = 0 ; i < months.length ; i ++)
		{
			float x = map(i, 0, months.length - 1, border, width - border);
			line(x, height - border, x, height - (border + 5));
			text(months[i], x, height - border * 0.5f);
		}

        for(int i = 0; i < months.length - 1; i++) {
            stroke(i*cgap, 255, 255);
            float x1 = map(i, 0, months.length - 1, border, width-border);
            float x2 = map(i+1, 0, months.length -1, border, width-border);

            float y1 = map(rainfall[i], 0, 120, height - border,border);
            float y2 = map(rainfall[i+1], 0, 120, height - border,border);
            
            line(x1, y1, x2, y2);
        }
        
    }

    public void drawPieChart(float[] rainfall, String[] months) {
        float runningSum = 0;
        float total = 0;
        float cx = width/2;
        float cy = height/2;
        float w = width *0.8f;

        for(int i = 0; i < rainfall.length; i++) {
            total += rainfall[i];
        }

        float cgap = 255 / (float) rainfall.length;
        for(int i = 0; i < months.length; i++) {
            fill(i*cgap, 255, 255);
            float next = runningSum + rainfall[i];
            float start = map(runningSum, 0, total, 0, TWO_PI);
            float end = map(next, 0, total, 0, TWO_PI);
            arc(cx, cy, w, w, start, end, ARC);
            runningSum = next;
            fill(255);
            System.out.println(runningSum);
            text(months[i], cos(start), sin(end) );
            
        }
    }

}
