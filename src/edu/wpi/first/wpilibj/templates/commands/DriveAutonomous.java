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
public class DriveAutonomous extends CommandBase {
    public static final int REVERSE = 0;
    public static final int TURN = 1;
    //public static final int STOP = 2;
    public static int driveState;
    private Timer timer;
    private int endTime;
    
    public DriveAutonomous(int mode) {
        requires(driveTrain);
        driveState = mode;
        timer = new Timer();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
        switch(driveState){
            case REVERSE:
                driveTrain.driveBackward();
                endTime = 250;
                break;
            case TURN:
                driveTrain.turnAround();
                endTime = 1000;
                break;
//            case STOP:
//                driveTrain.stopMovement();
//                break;
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get()>endTime;
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrain.stopMovement();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
