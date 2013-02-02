/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Paul
 */
public class Climber extends Subsystem {
    private Victor climbingMotor = new Victor(RobotMap.CLIMBER_MOTOR);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void raiseClimbingArm(){
        
    }
    public void lowerClimbingArm(){
        
    }
    
}
