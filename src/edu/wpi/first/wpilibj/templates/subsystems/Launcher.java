/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ToggleLauncher;
import edu.wpi.first.wpilibj.Servo;

/**
 *
 * @author rchs.paulyates
 */
public class Launcher extends Subsystem {
    private Victor frontFlywheel;
    private Victor rearFlywheel;
    private Servo launcherAdvancer;
    
    private boolean spinningUpFlywheels;
    private boolean flywheelsSpunUp;
    private Timer spinUpTimer;
    
    private boolean isExtending;
    private Timer advancerTimer;
    
    public Launcher() {
        frontFlywheel = new Victor(RobotMap.FRONT_LAUNCHER_MOTOR_CHANNEL);
        rearFlywheel = new Victor(RobotMap.REAR_LAUNCHER_MOTOR_CHANNEL);
        launcherAdvancer = new Servo(RobotMap.LAUNCHER_ADVANCER_CHANNEL);
        spinningUpFlywheels = false;
        flywheelsSpunUp = false;
        spinUpTimer = new Timer();
        isExtending = false;
        advancerTimer = new Timer();
    }

    public void initDefaultCommand() {
        new ToggleLauncher();
    }
    
    private void setLauncherFlywheels(boolean state) {
        if (state == RobotMap.ON) {
            frontFlywheel.set(RobotMap.FRONT_LAUNCHER_SPEED);
            rearFlywheel.set(RobotMap.REAR_LAUNCHER_SPEED);
        }
        else {
            frontFlywheel.set(RobotMap.STOPPED);
            rearFlywheel.set(RobotMap.STOPPED);
        }
    }
    
    private void setAdvancer(int direction) {
        if (direction == 0) {
            launcherAdvancer.set(RobotMap.STOPPED);
        }
        else {
            direction = direction / Math.abs(direction);
            launcherAdvancer.set(direction * RobotMap.LAUNCHER_ADVANCER_POWER);
        }
    }
    
    public void triggerAdvancer() {
        System.out.println("Launcher: Triggering advancer");
        if (!isExtending) {
            launcherAdvancer.setAngle(45);
            isExtending = true;
            advancerTimer.start();
        }
    }
    
    public void stopAdvancer() {
        System.out.println("Launcher: Stopping advancer.");
        setAdvancer(RobotMap.STOPPED);
    }
    
    public boolean hasExtended() {
        boolean result = false;
        if (launcherAdvancer.getAngle()==45) {
            isExtending = false;
            launcherAdvancer.setAngle(0);
        }
        if(launcherAdvancer.getAngle() ==0){
            result = true;
        }
        return result;
    }
    
    public boolean isOn() {
        if(rearFlywheel.get() != 0 && frontFlywheel.get() != 0) {
            return(true);
        }
        else{
            return(false);
        }
    }
    
    public void spinUpFlywheels() {
        System.out.println("LAUNCHER: Spinning Up Flywheels");
        if (!isOn()) {
            setLauncherFlywheels(RobotMap.ON);
            spinningUpFlywheels = true;
            spinUpTimer.reset();
            spinUpTimer.start();
        }
    }
    
    public void stopFlywheels() {
        System.out.println("LAUNCHER: Stopping flywheels");
        setLauncherFlywheels(RobotMap.OFF);
        spinningUpFlywheels = false;
        flywheelsSpunUp = false;
    }
    
    public boolean flywheelsAreSpunUp() {
        if (spinningUpFlywheels && (spinUpTimer.get() > RobotMap.FLYWHEEL_SPINUP_TIME)) {
            System.out.println("LAUNCHER: Flywheels are spun up.");
            spinUpTimer.stop();
            spinUpTimer.reset();
            flywheelsSpunUp = true;
            spinningUpFlywheels = false;
        }
        return flywheelsSpunUp;
    }
}
