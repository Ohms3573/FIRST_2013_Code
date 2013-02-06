/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

<<<<<<< HEAD
=======
import edu.wpi.first.wpilibj.DigitalInput;
>>>>>>> Climb Command and Climber Subsystem
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Paul
 */
public class Climber extends Subsystem {
    private Victor climbingMotor = new Victor(RobotMap.CLIMBER_MOTOR);
<<<<<<< HEAD
=======
    private DigitalInput climberUpButton = new DigitalInput(RobotMap.CLIMBER_UP_BUTTON);
    private DigitalInput climberDownButton = new DigitalInput(RobotMap.CLIMBER_DOWN_BUTTON);
>>>>>>> Climb Command and Climber Subsystem
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void raiseClimbingArm(){
<<<<<<< HEAD
        
    }
    public void lowerClimbingArm(){
        
    }
    
=======
        climbingMotor.set(RobotMap.CLIMBER_SPEED);
        
    }
    public void lowerClimbingArm(){
        climbingMotor.set(-RobotMap.CLIMBER_SPEED);
    }
    public void stopClimbingArm(){
        climbingMotor.set(0);
    }
    public boolean isDown(){
        return climberDownButton.get();
    }
    public boolean isUp(){
        return climberUpButton.get();
    }
>>>>>>> Climb Command and Climber Subsystem
}
