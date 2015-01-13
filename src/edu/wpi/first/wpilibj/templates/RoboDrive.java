/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author robotics
 */
public class RoboDrive {
    
    double lft = 0.0;
    double rgt = 0.0;
    Talon left = new Talon(1);;
    Talon right = new Talon(10);;

    //////////////////////////////////////well commented
    public void arcadeDrive(Joystick joy){
               
        if (joy.getY() > 0.0) {
            if (joy.getX() > 0.0) {
                lft = joy.getY() - joy.getX();
                rgt = Math.max(joy.getY(), joy.getX());
            } else {
                lft = Math.max(joy.getY(), -joy.getX());
                rgt = joy.getY() + joy.getX();
            }
        } else {
            if (joy.getX() > 0.0) {
                lft = -Math.max(-joy.getY(), joy.getX());
                rgt = joy.getY() + joy.getX();
            } else {
                lft = joy.getY() - joy.getX();
                rgt = -Math.max(-joy.getY(), -joy.getX());
            }
        }
        left.set(-lft);
        right.set(rgt);
        
    }
    
}
