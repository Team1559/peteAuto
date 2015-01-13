/*=======================================================

    This code assumes thta the drive system uses talons, but can
    be easily modified for jaguars, victors, whatever. 

  =======================================================*/
package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Auto extends IterativeRobot {

    //!\\ Should be moved into Wiring class!
    public final int LEFT = 10; //maybe this will help (?)
    public final int RIGHT = 1;//switched. See above.
    //controls
    Joystick joy;
    //Pneumatics to control shifting
    Solenoid shift1;
    Solenoid shift2;
    boolean override;
    double shiftPoint;
    
    //driving
    RoboDrive rd;
    int gear;
    public void robotInit() {
        gear = 1;
        rd = new RoboDrive();
        shift1 = new Solenoid(1);
        shift2 = new Solenoid(2);
    }
    
    

    public void disabled(){
        gear1();    
    }
    
    public void autonomousInit(){
        
    }
    
    public void autonomousPeriodic() {

    }

    public void teleopInit(){
        gear1();
    }
    
    public void teleopPeriodic() {
           shiftPoint = joy.getRawAxis(3);
           override = joy.getRawButton(1);
           if (joy.getAxis(Joystick.AxisType.kY) >= (shiftPoint - .1) && !override){
               gear1();
           }
           if (joy.getAxis(Joystick.AxisType.kY) >= (shiftPoint + .1) && !override){
               gear2();
           }
           if (override){
               gear1();
           }
    }

    public void testInit(){
        
    }
    
    public void testPeriodic() {
    
    }
    public void gear1(){
        shift1.set(false);
        shift2.set(true);
        System.out.println("GEAR 1");
    }
    
    public void gear2(){
        shift1.set(true);
        shift2.set(false);
        System.out.println("GEAR 2");
    }
    
    public double getSpeed(){
        //         0<speed<1
        return (rd.right.get() + rd.left.get())/2;
    
    }
}
