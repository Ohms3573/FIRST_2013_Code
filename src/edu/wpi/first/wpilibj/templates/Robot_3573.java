/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.ExampleCommand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot_3573 extends IterativeRobot {

    private Scheduler autonomousScheduler;
    private Scheduler teleopScheduler;
    private Timer autonomousTimer;
    private Timer teleopTimer;
//    private AutoCommand autoComm;
    
    public void robotInit() {
        // Initialize all subsystems
        CommandBase.init();
//        autoComm = new AutoCommand();
        autonomousTimer = new Timer();
        autonomousScheduler = Scheduler.getInstance();
        teleopTimer = new Timer();
        teleopScheduler = Scheduler.getInstance();
    }

    public void autonomousInit() {
        autonomousTimer.start();
        autonomousScheduler.run();
        System.out.println("Autonomous Enabled");
//        autoComm.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        if(autonomousTimer.get() > .05){
            autonomousTimer.stop();
            autonomousTimer.reset();
            autonomousScheduler.run();
            autonomousTimer.start();
        }
    }
    
    public void autonomousContinuous() {}

    public void teleopInit() {
        teleopTimer.start();
//        if (autoComm.isRunning())
//            autoComm.cancel();
        System.out.println("Teleop Enabled");
        //SmartDashboard.putString("Mode", "Teleop");
//        new DriveWithJoystick().start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //SmartDashboard.putData("SchedulerData",Scheduler.getInstance());
        if(teleopTimer.get() > .05){
            teleopTimer.stop();
            teleopTimer.reset();
            teleopScheduler.run();
            teleopTimer.start();
        }
    }
    
    public void teleopContinuous() {}
    
    public void disabledInit() {
        //SmartDashboard.putString("Mode", "Disabled");
        System.out.println("Disabled Mode");
    }
    
    public void disabledPeriodic() {}
    public void disabledContinuous() {}
}
