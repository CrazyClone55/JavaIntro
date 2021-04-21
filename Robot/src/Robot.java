import java.awt.geom.Point2D;
import java.lang.Math;

public class Robot {
    private double speed; //assuming units per second
    private double xLoc;
    private double yLoc;
    private String name;
    private double direction; //positive angle, in degrees, 0-360


    //constructors
    public Robot(){ //constructor 1
        speed = 0.0;
        xLoc = 0.0;
        yLoc = 0.0;
        name = "robot";
        direction = 0.0;
    }

    public Robot(String name){ //constructor 2
        speed = 0.0;
        xLoc = 0.0;
        yLoc = 0.0;
        this.name = name;
        direction = 0.0;
    }

    public Robot(String name, double xLoc, double yLoc, double speed, double direction){ //constructor 3
        this.speed = speed;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.name = name;
        this.direction = direction;
    }
    

    //getters
    public double getSpeed(){
        return speed;
    }

    public double getXLoc(){
        return xLoc;
    }

    public double getYLoc(){
        return yLoc;
    }

    public String getName(){
        return name;
    }

    public double getDirection(){
        return direction;
    }


    //setters
    public void setSpeed(double speed){
        this.speed = speed;
    }

    public void setXLoc(double xLoc){
        this.xLoc = xLoc;
    }

    public void setYLoc(double yLoc){
        this.yLoc = yLoc;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDirection(double direction){
        this.direction = direction;
    }



    public void printLocation(){
        
        //print out the name and location of the robot
        System.out.println("Location of "+this.name+": "+"("+this.xLoc+", "+this.yLoc+")");
    }


    public double distanceTo(Robot otherBot){

        //cache the locations of the 2 bots
        double x1 = this.xLoc;
        double y1 = this.yLoc;
        
        double x2 = otherBot.xLoc;
        double y2 = otherBot.yLoc;

        //use distance formula method to find the distance between the 2 points
        double distance = Point2D.distance(x1, y1, x2, y2);

        //return distance
        return distance;

    }


    public void moveForward(){
        //assuming speed is in unit per second
        
        
        double distanceTraveled = speed;

        double radians = Math.toRadians(direction); //direction degrees to radians

        //trigonometry
        double changeX = Math.cos(radians) * distanceTraveled;

        double changeY = Math.sin(radians) * distanceTraveled;


        //if it is this stupid small number, change the change in x/y to 0 because it is irrelevant
        if (changeY == 2.4492935982947064E-16) {
            changeY = 0;
        }

        if (changeX == 2.4492935982947064E-16) {
            changeX = 0;
        }

        //add the change
        xLoc = xLoc + changeX;

        yLoc = yLoc + changeY;


    }

}
