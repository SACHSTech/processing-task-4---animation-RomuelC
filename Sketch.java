import processing.core.PApplet;

public class Sketch extends PApplet {

  // global variables 

  // initalize size
  public float width = 1200f;
  public float height = 800f;

  // scale factor 
  public float wScaleF = width / 400f;
  public float hScaleF = height / 400f;

  // circle size 
  public float circleX = 0;
  public float circleY = 300 * hScaleF;

  // day and night setting
  public boolean day = true;
  public boolean night = false;

  // timelapse speed
  public int speed = 5;

  // sun and moon size
  public int sunSize = 90;
  public int moonSize = 60;

  // star size scale
  public float starScale = 0.35f;


  public void settings() {
	  // put your size call here
    size((int)width, (int)height);
  }

  public void setup() {
    background(210, 255, 173);
  }

  public void draw() {
    // clear out old frames
    if (day) {
      background(115, 235, 255);
    }
    else if (night) {
      background(0);
    }

    // draw current frame based on state
    if (day) {
      fill(250, 253, 15);
    }
    else if (night) {
      fill(255);
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          // draw star
          pushMatrix();
          translate((j * 73) * wScaleF, (i * 100) * hScaleF); // center of the star
          beginShape();
          vertex(0 * starScale, -50 * starScale);
          vertex(14 * starScale, -20 * starScale);
          vertex(47 * starScale, -15 * starScale);
          vertex(23 * starScale, 7 * starScale);
          vertex(29 * starScale, 40 * starScale);
          vertex(0 * starScale, 25 * starScale);
          vertex(-29 * starScale, 40 * starScale);
          vertex(-23 * starScale, 7 * starScale);
          vertex(-47 * starScale, -15 * starScale);
          vertex(-14 * starScale, -20 * starScale);
          translate(50 * wScaleF,0);
          endShape(CLOSE);
          popMatrix();
        }
      }
    }

    // draw circle
    if (day) {
      ellipse(circleX, circleY, sunSize, sunSize);
    }
    else if (night) {
      ellipse(circleX, circleY, moonSize, moonSize);
    }

    // change state 
    circleX += speed;
    circleY = (float) ((0.0055 / wScaleF) * (Math.pow(circleX - width / 2, 2)) + (50 * hScaleF));
 
    // reset state
    if(circleX > width + 50) {
      circleX = 0;
      circleY = 300 * hScaleF;
      if (day) {
        day = false;
        night = true;
      }
      else if (night) {
        night = false;
        day = true;
      }
    }

    // ground 
    fill(0, 255, 0); 
    rect(0, 300 * hScaleF, width, height - 300);
  }

}