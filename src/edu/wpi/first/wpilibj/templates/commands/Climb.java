/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author rchs.paulyates
 */
public class Climb extends CommandBase {
    boolean isFinished = false;
    
    public Climb() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        for(int x=0; x<3; x++){
            while(!climber.isUp()){
                climber.raiseClimbingArm();
            }
            while(!climber.isDown()){
                climber.lowerClimbingArm();               
            }
        }
        isFinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
