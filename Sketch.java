import processing.core.PApplet;

public class Sketch extends PApplet {

  // global variables 

  // Initialize Size
  public float width = 1200f;
  public float height = 800f;

  // Scale Factor 
  public float wScaleF = width / 400f;
  public float hScaleF = height / 400f;

  // Sun and Moon Size
  public int sunSize = 150;
  public int moonSize = 110;

  // Star Size Scale
  public float starScale = 0.35f;

  // Circle Size 
  public float circleX = 0;
  public float circleY = 300 * hScaleF;

  // Day and Night setting
  public boolean day = true;
  public boolean night = false;

  // Timelapse Speed
  public int speed = 3;

  public void settings() {

    size((int)width, (int)height);
  }

  public void setup() {
    background(210, 255, 173);
  }

  public void draw() {

    if (day) {
      background(122, 229, 250);
    }
    else if (night) {
      background(0);
    }

    if (day) {
      fill(250, 215, 122);
    }
    else if (night) {
      fill(255);
    }

    // Circle Drawing
    if (day) {
      ellipse(circleX, circleY, sunSize, sunSize);
    }
    else if (night) {
      ellipse(circleX, circleY, moonSize, moonSize);
    }

    // Change State 
    circleX += speed;
    circleY = (float) ((0.0055 / wScaleF) * (Math.pow(circleX - width / 2, 2)) + (50 * hScaleF));
 
    // Reset State
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

    // Grass 
    fill(23, 130, 29); 
    rect(0, 300 * hScaleF, width, height - 300);

    // Dirt
    fill(64, 42, 22);
    rect(0, 320 * hScaleF, width, height - 300);
  }
}
