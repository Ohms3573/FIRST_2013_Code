/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Paul
 */
public class Climber extends Subsystem {
    private Victor climbingMotor1 = new Victor(RobotMap.CLIMBER_MOTOR_1);
    private Victor climbingMotor2 = new Victor(RobotMap.CLIMBER_MOTOR_2);
    private DigitalInput climberUpSensor = new DigitalInput(RobotMap.CLIMBER_UP_SENSOR);
    private DigitalInput climberDownSensor = new DigitalInput(RobotMap.CLIMBER_DOWN_SENSOR);
    private DigitalInput shortArmSensor = new DigitalInput(RobotMap.SHORT_ARM_SENSOR);
    private DigitalInput longArmSensor = new DigitalInput(RobotMap.LONG_ARM_SENSOR);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setClimbingArm(int direction) {
        if (direction == RobotMap.STOPPED) {
            setClimbingArmSpeed(RobotMap.STOPPED);
        }
        else {
            direction = direction / Math.abs(direction);
            setClimbingArmSpeed(direction * RobotMap.CLIMBER_SPEED);
        }
    }
    
    private void setClimbingArmSpeed(double speed) {
        climbingMotor1.set(speed);
        climbingMotor2.set(speed);
    }
    
//    public void raiseClimbingArm(){
//        climbingMotor1.set(RobotMap.CLIMBER_SPEED);
//        climbingMotor2.set(RobotMap.CLIMBER_SPEED);
//    }
//    public void lowerClimbingArm(){
//        climbingMotor1.set(-RobotMap.CLIMBER_SPEED);
//        climbingMotor2.set(-RobotMap.CLIMBER_SPEED);
//    }
//    public void stopClimbingArm(){
//        climbingMotor1.set(RobotMap.STOPPED);
//        climbingMotor2.set(RobotMap.STOPPED);
//    }
    
    public boolean isDown(){
        return climberDownSensor.get();
    }
    
    public boolean isUp(){ 
        return climberUpSensor.get();
    }
    
    public boolean shortArmIsHolding() {
        return shortArmSensor.get();
    }
    
    public boolean longArmIsHolding() {
        return longArmSensor.get();
    }
}
