/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.automation.Controllers;
import frc.robot.commands.Robot_Group_PreConfigure;
import frc.robot.subsystems.Cargo;
import frc.robot.automation.Automation_Group_Test;
import frc.robot.automation.Controllers;
import frc.robot.commands.Robot_Group_PreConfigure;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Hatch;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.PneumaticsCompressor;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.WheelModule;
import frc.robot.utility.CameraInstance;
import frc.robot.utility.automation.Vision;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    public static WheelModule fl, fr, bl, br;
    public static Swerve swerve;
    public static Elevator elevator;
	public static Arm arm;
    public static Cargo cargo;
    public static PneumaticsCompressor compress; 
	public static Hatch hatch;
    public static Lift lift;

    public static Vision vision;
    public static CameraInstance camOne;
    public static OI oi;

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        bl = new WheelModule(RobotMap.BLANGLEPORT, RobotMap.BLSPEEDPORT, "bl", false, true); 
		br = new WheelModule(RobotMap.BRANGLEPORT, RobotMap.BRSPEEDPORT, "br", false, false);
		fl = new WheelModule(RobotMap.FLANGLEPORT, RobotMap.FLSPEEDPORT, "fl", false, true); 
		fr = new WheelModule(RobotMap.FRANGLEPORT, RobotMap.FRSPEEDPORT, "fr", false, false);
        
        swerve = new Swerve(fl, fr, bl, br);
        elevator = new Elevator();
        arm = new Arm();
        cargo = new Cargo();
        hatch = new Hatch();
        lift = new Lift();
        // compress = new PneumaticsCompressor();
     

        vision = new Vision();
        camOne = new CameraInstance(CameraInstance.StreamType.SIMPLE,0);
        camOne.start();
        // Controllers.createControllers();

        oi = new OI();
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for
     * items like diagnostics that you want ran during disabled, autonomous,
     * teleoperated and test.
     *
     * <p>
     * This runs after the mode specific periodic functions, but before LiveWindow
     * and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
        if(elevator.requiresReset()){
            elevator.resetElevatorPosition();
        }
    }

    /**
     * This function is called once each time the robot enters Disabled mode. You
     * can use it to reset any subsystem information you want to clear when the
     * robot is disabled.
     */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        RobotMap.dashboardDisplay();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable chooser
     * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
     * remove all of the chooser code and uncomment the getString code to get the
     * auto name from the text box below the Gyro
     *
     * <p>
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons to
     * the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {
        // if (m_autonomousCommand != null) {
        // m_autonomousCommand.start();
        // }
        Command cmd = new Automation_Group_Test();
        cmd.start();
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // if (m_autonomousCommand != null) {
        // m_autonomousCommand.cancel();
        // }
        Command preconfigure = new Robot_Group_PreConfigure();
        preconfigure.start();
        preconfigure.close();
        swerve.enableDefaultCommand();
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        RobotMap.dashboardDisplay();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
        RobotMap.dashboardDisplay();
        arm.fullspeed();
    }
}
