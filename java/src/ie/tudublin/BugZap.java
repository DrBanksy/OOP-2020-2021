package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet {
	public void settings() {
		size(500, 500);
	}

	public void setup() {
		reset();
	}

	float playerX, playerY;
	float playerSpeed = 5;
	float playerWidth = 40;
	float halfPlayerWidth = playerWidth / 2;

	float bugX, bugY, bugWidth;
	float halfBugWidth = 20 + (bugWidth / 2);

	int score = 0;

	void reset() {
		playerX = width / 2;
		playerY = height - 50;
		resetBug();
	}

	void resetBug() {
		bugX = random(halfBugWidth, width - halfBugWidth);
		bugY = 50;
		System.out.println("test");
	}

	void moveBug() {
		if((frameCount % 30) == 0) {
			bugX += random(-5, +5);
			if(bugX < halfBugWidth) {
				bugX = halfBugWidth;
			}

		}
	}
	

	void drawPlayer(float x, float y, float w) {
		stroke(255);
		float playerHeight = w / 2;
		line(x - halfPlayerWidth, y + playerHeight, x + halfPlayerWidth, y + playerHeight);
		line(x - halfPlayerWidth, y + playerHeight, x - halfPlayerWidth, y + playerHeight * 0.5f);
		line(x + halfPlayerWidth, y + playerHeight, x + halfPlayerWidth, y + playerHeight * 0.5f);

		line(x - halfPlayerWidth, y + playerHeight * 0.5f, x - (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f);
		line(x + halfPlayerWidth, y + playerHeight * 0.5f, x + (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f);

		line(x - (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f, x + (halfPlayerWidth * 0.8f),
				y + playerHeight * 0.3f);

		line(x, y, x, y + playerHeight * 0.3f);

	}

	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			if(playerX > halfPlayerWidth) {
				playerX -= playerSpeed;
			}
		}
		if (keyCode == RIGHT)
		{
			if(playerX < width - halfPlayerWidth )
				playerX += playerSpeed;
			
		}
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
			line(playerX, playerY, playerX, 0);
		}
	}	

	void drawBug(float x, float y) {
		// System.out.println(x);
		stroke(255);
		noFill();
		triangle(x, y, x - 15, y + 25, x + 15, y+ 25 );
		noStroke();
		fill(255);
		ellipse(x + 2, y + 15, 2, 2);
		ellipse(x - 2, y + 15, 2, 2);
		stroke(255);
		line(x - 5 , y+20, x+ 5, y+20);
	}



	public void draw() {
		background(0);
		fill(255);
		drawPlayer(playerX, playerY, playerWidth);
		drawBug(bugX, bugY);
		moveBug();
		System.out.println(bugWidth);
		text("Score: " + score, 20, 20);
	}
}
