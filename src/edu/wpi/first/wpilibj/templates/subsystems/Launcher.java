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
    
    public void togglerAdvancer() {
        if (launcherAdvancer.get() == 0) {
            launcherAdvancer.set(RobotMap.LAUNCHER_ADVANCE_SPEED);
        }
        else {
            launcherAdvancer.set(0);
        }
    }
}
