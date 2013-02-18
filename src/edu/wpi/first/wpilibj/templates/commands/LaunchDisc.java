/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author rchs.paulyates
 */
public class LaunchDisc extends CommandBase {
    private boolean spinningUpFlywheels;
    private boolean interruptible;
    private boolean stop;
    
    public LaunchDisc() {
        requires(launcher);
        spinningUpFlywheels = false;
        interruptible = false;
        stop = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("DISC LAUNCH: Launching Disc");
        if (!launcher.isOn()) {
            launcher.spinUpFlywheels();
            spinningUpFlywheels = true;
            interruptible = true;
        }
        else {
            launcher.triggerAdvancer();
            interruptible = false;
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (spinningUpFlywheels) {
            if (launcher.flywheelsAreSpunUp()) {
                spinningUpFlywheels = false;
                launcher.triggerAdvancer();
                interruptible = false;
            }
        }
        else if (launcher.isExtended()) {
            stop = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stop;
    }

    // Called once after isFinished returns true
    protected void end() {
        launcher.stopAdvancer();        
        System.out.println("DISC LAUNCH: Finished launching disc.");
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("DISC LAUNCH: Launching disc interrupted");
        launcher.stopAdvancer();
    }
    
    public boolean isInterruptible() {
        return interruptible;
    }
}
