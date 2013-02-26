/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author rchs.paulyates
 */
public class ContractArm extends CommandBase {
    
    public ContractArm() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        climber.setClimbingArm(RobotMap.REVERSE);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return climber.shortArmIsHolding() || climber.isDown();
    }

    // Called once after isFinished returns true
    protected void end() {
        climber.setClimbingArm(RobotMap.STOPPED);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        climber.setClimbingArm(RobotMap.STOPPED);
    }
}
