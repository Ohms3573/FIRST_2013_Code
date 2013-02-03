/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author rchs.paulyates
 */
public class LaunchDisc extends CommandBase {
    private Timer launchTimer;
    private boolean spinningUpFlywheels;
    private boolean interruptible;
    
    public LaunchDisc() {
        requires(launcher);
        launchTimer = new Timer();
        spinningUpFlywheels = false;
        interruptible = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (!launcher.isOn()) {
            launcher.toggleLauncherFlywheels();
            launchTimer.start();
            spinningUpFlywheels = true;
            interruptible = true;
        }
        else {
            launcher.setAdvancer(RobotMap.FORWARD);
            launchTimer.start();
            interruptible = false;
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (spinningUpFlywheels) {
            if (launchTimer.get() >= RobotMap.FLYWHEEL_SPINUP_TIME) {
                spinningUpFlywheels = false;
                launchTimer.stop();
                launchTimer.reset();
                launcher.setAdvancer(RobotMap.FORWARD);
                launchTimer.start();
                interruptible = false;
            }
        }
        else {
            int advancerDirection = launcher.getAdvancerDirection();
            double time = launchTimer.get();
            if (advancerDirection == RobotMap.FORWARD) {
                if (time >= RobotMap.LAUNCHER_FORWARD_TIME) {
                    launcher.setAdvancer(RobotMap.STOPPED);
                    launchTimer.stop();
                    launchTimer.reset();
                    launcher.setAdvancer(RobotMap.REVERSE);
                    launchTimer.start();
                }
            }
            else if (advancerDirection == RobotMap.REVERSE) {
                if (time >= RobotMap.LAUNCHER_REVERSE_TIME) {
                    launcher.setAdvancer(RobotMap.STOPPED);
                    launchTimer.stop();
                    launchTimer.reset();
                }
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean result = false;
        if (!spinningUpFlywheels) {
            if (launcher.getAdvancerDirection() == RobotMap.STOPPED) {
                result = true;
            }
        }
        return result;
    }

    // Called once after isFinished returns true
    protected void end() {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
    
    public boolean isInterruptible() {
        return interruptible;
    }
}
