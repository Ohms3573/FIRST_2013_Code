/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author rchs.paulyates
 */
public class ToggleLauncher extends CommandBase {
    
    private boolean spinningUpFlywheels;
    
    public ToggleLauncher() {
        requires(launcher);
        spinningUpFlywheels = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("TOGGLE: Toggling Launcher");
        if (!launcher.isOn()) {
            System.out.println("TOGGLE: Launcher was off, turning on.");
            launcher.spinUpFlywheels();
            spinningUpFlywheels = true;
        }
        else {
            launcher.stopFlywheels();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (spinningUpFlywheels && launcher.flywheelsAreSpunUp()) {
            spinningUpFlywheels = false;
        }
        return !spinningUpFlywheels;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("TOGGLE: Finished toggling launcher.");
        if(launcher.isOn()){
            System.out.println("TOGGLE: Flywheels Spinning.");
        }
        else{
            System.out.println("TOGGLE: Flywheels Off.");
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("TOGGLE: Launcher Toggling Interrupted.");
        if(launcher.isOn()){
            System.out.println("TOGGLE: Flywheels Spinning.");
        }
        else{
            System.out.println("TOGGLE: Flywheels Off.");
        }
    }
}
