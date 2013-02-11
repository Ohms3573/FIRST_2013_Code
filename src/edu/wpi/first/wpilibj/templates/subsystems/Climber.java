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
    private Victor climbingMotor1 = new Victor(RobotMap.CLIMBER_MOTOR_1_CHANNEL);
    private Victor climbingMotor2 = new Victor(RobotMap.CLIMBER_MOTOR_2_CHANNEL);
    private DigitalInput climberUpSensor = new DigitalInput(RobotMap.CLIMBER_UP_SENSOR_CHANNEL);
    private DigitalInput climberDownSensor = new DigitalInput(RobotMap.CLIMBER_DOWN_SENSOR_CHANNEL);
    private DigitalInput shortArmSensor = new DigitalInput(RobotMap.SHORT_ARM_SENSOR_CHANNEL);
    private DigitalInput longArmSensor = new DigitalInput(RobotMap.LONG_ARM_SENSOR_CHANNEL);

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
