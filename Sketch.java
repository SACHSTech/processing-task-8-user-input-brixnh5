import processing.core.PApplet;
import processing.core.PImage;


public class Sketch extends PApplet {

  float fltCircleX = 0;
  float fltCircleY = 0;

  PImage imgStars;
  PImage imgCloud;

  int intGrassR = 0;
  int intGrassG = 150;
  int intGrassB = 0;

  public void settings() {
    size(800, 800);

    imgStars = loadImage("stars.png");
    imgStars.resize(100,100);

    imgCloud = loadImage("cloud.png");
    imgCloud.resize(120,80);
  }

  public void setup() {
    background(174, 192, 207);
    size(800, 800);
  }

  public void draw() { 

    // replaces grass every second
    fill(intGrassR, intGrassG, intGrassB); 
    rect(0,700,800,100);

    // draws and moves a circle according to user input
    if (keyPressed){
      if (keyCode == UP) {
        fltCircleY--;
      }
  
      else if (keyCode == DOWN) {
        fltCircleY++;
      }
  
      else if (keyCode == LEFT) {
        fltCircleX--;
      }
  
      else if (keyCode == RIGHT) {
        fltCircleX++;
      }
    }
    
    // draws circles
    fill(100, 100, 100);
    ellipse(fltCircleX, fltCircleY, 20, 20);

    //reset background
    if (keyPressed && key == ' '){
      background(174, 192, 207);
      intGrassR = 0;
      intGrassG = 150;
      intGrassB = 0;
    }
  }

  public void keyPressed(){
    // set background to a colour if a key is pressed
    if (key == 'r'){
      background(255, 0, 0);
    }
    else if(key == 'g'){
      background(0, 255, 0);
    }
    else if(key == 'b'){
      background(0, 0, 255);
    }
  }

  public void keyReleased(){

    // control key input to change grass colour on key release
    if(keyCode == CONTROL){
      int random = (int) (Math.random() * 2);
      // changes grass randomly from green to pink
      if (random == 0){
        intGrassR = 255;
        intGrassG = 192;
        intGrassB = 203;
      }
      else {
        intGrassR = 0;
        intGrassG = 150;
        intGrassB = 0;
      }
    }
  }
  
  public void mouseClicked() {
    // draw building at mouse location when clicked
    fill(153, 153, 153);
    rect(mouseX, mouseY, 150, 800);

    // draw windows by looping through the height of the building drawn
    for (int i = 0; i < 800 - mouseY; i += 70){
      fill(40);
      ellipse(mouseX + 40, mouseY + 40 + i, 45, 45);
      ellipse(mouseX + 110, mouseY + 40 + i, 45, 45);
    }
  }

  public void mouseDragged(){
    // draws stars when mouse is dragged 
    image(imgStars, mouseX, mouseY);
  }

  public void mousePressed(){
    // the first half of a mouse press will draw a cloud 
    if (mousePressed){
      image(imgCloud, random(0, width - 120), random(0, 300));
    }
  }

  public void mouseReleased(){ 
    // the second half of a mouse press will draw another cloud
    image(imgCloud, random(0, width - 120), random(0, 300));
  }
 
  public void mouseWheel(){
    noStroke();
    // draws a tree at the mouse's x position
    fill(101,67, 33);
    rect(mouseX - 10, 570, 20, 800);

    stroke(0);
    fill(1, 68, 33); 
    ellipse(mouseX + 25, 565, 50, 50);
    ellipse(mouseX - 25, 565, 50, 50);
    ellipse(mouseX , 545, 50, 50);
  }
}
