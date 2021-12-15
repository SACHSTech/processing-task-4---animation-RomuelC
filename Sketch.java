import processing.core.PApplet;

public class Sketch extends PApplet {


  /**
   * state global variables
   *  
   * */ 
  public float circleY = -50;

	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	  // put your size call here
    size(200, 200);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  
    // clear out old frames
    background(32);

    // draw current frame based on state
    ellipse(100, circleY, 50, 50);
  
    // modify state
    circleY = circleY + 1;
  
    // reset state
    if(circleY > height+50) {
      circleY = 0;
    }
  }
  
  // define other methods down here.


}