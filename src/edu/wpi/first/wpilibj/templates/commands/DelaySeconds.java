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
public class DelaySeconds extends CommandBase {
    
    Timer timer;
    double delayTime;
    
    public DelaySeconds(double time) {
        delayTime = 1000*time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer = new Timer();
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() >= delayTime;
    }

    // Called once after isFinished returns true
    protected void end() {
        timer.stop();
        timer.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
    
    /**
     *
     * @return false
     */
    public boolean isInterruptible() {
        return false;
    }
}
