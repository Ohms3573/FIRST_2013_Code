/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ToggleLauncher;

/**
 *
 * @author rchs.paulyates
 */
public class Launcher extends Subsystem {
    private Victor frontFlywheel;
    private Victor rearFlywheel;
    private Victor launcherAdvancer;
    
    public Launcher() {
        frontFlywheel = new Victor(RobotMap.FRONT_LAUNCHER_MOTOR);
        rearFlywheel = new Victor(RobotMap.REAR_LAUNCHER_MOTOR);
        launcherAdvancer = new Victor(RobotMap.LAUNCHER_ADVANCER);
    }

    public void initDefaultCommand() {
        new ToggleLauncher();
    }
    
    public void toggleLauncherFlywheels(){
        if (frontFlywheel.get() == 0) {
            frontFlywheel.set(RobotMap.FRONT_LAUNCHER_SPEED);
            rearFlywheel.set(RobotMap.REAR_LAUNCHER_SPEED);
        }
        else {
            frontFlywheel.set(0);
            rearFlywheel.set(0);
        }
    }
    
    public void setAdvancer(int direction) {
        if (direction == 0) {
            launcherAdvancer.set(0);
        }
        else {
            direction = direction / Math.abs(direction);
            launcherAdvancer.set(direction * RobotMap.LAUNCHER_ADVANCE_SPEED);
        }
    }
    
    public int getAdvancerDirection() {
        double advancerDirection = launcherAdvancer.get();
        int direction = 0;
        if (advancerDirection != 0) {
            advancerDirection = advancerDirection / RobotMap.LAUNCHER_ADVANCE_SPEED;
            if (advancerDirection > 0) {
                direction = RobotMap.FORWARD;
            }
            else if (advancerDirection < 0) {
                direction = RobotMap.REVERSE;
            }
        }
        return direction;
    }
    
    public boolean isOn() {
        return !(frontFlywheel.get() == 0);
    }
}
