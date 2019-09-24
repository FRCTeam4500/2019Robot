/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.arm.*;
import frc.robot.cargo.*;
import frc.robot.compressor.*;
import frc.robot.elevator.*;
import frc.robot.hatch.*;
import frc.robot.lift.*;
import frc.robot.swerve.*;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    enum SubsystemType {
        Dashboard, Hardware
    }

    /**
     * This function is run when the robot is first started up and should be used for any
     * initialization code.
     */
    private Swerve swerve;
    private IMainOI oi;
    private Lift lift;
    private Hatch hatch;
    private Elevator elevator;
    private Compressor compressor;
    private Cargo cargo;
    private Arm arm;

    @Override
    public void robotInit() {

        setupDashboardSubsystems();
        // setupCustomSubsystems();

        oi = new XboxOI(swerve, lift, hatch, elevator, compressor, cargo, arm);
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for items like
     * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
     *
     * <p>
     * This runs after the mode specific periodic functions, but before LiveWindow and
     * SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {

    }

    /**
     * This function is called once each time the robot enters Disabled mode. You can use it to
     * reset any subsystem information you want to clear when the robot is disabled.
     */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select between different
     * autonomous modes using the dashboard. The sendable chooser code works with the Java
     * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
     * uncomment the getString code to get the auto name from the text box below the Gyro
     *
     * <p>
     * You can add additional auto modes by adding additional commands to the chooser code above
     * (like the commented example) or additional comparisons to the switch structure below with
     * additional strings & commands.
     */
    @Override
    public void autonomousInit() {

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

    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {

    }

    private void setupSubsystems(SubsystemType swerveType, SubsystemType liftType,
            SubsystemType hatchType, SubsystemType elevatorType, SubsystemType compressorType,
            SubsystemType cargoType, SubsystemType armType) {
        if (swerveType == SubsystemType.Hardware) {
            swerve = DefaultSwerveFactory.MakeSwerve();
        } else {
            swerve = DashboardSwerveFactory.MakeSwerve();
        }

        if (liftType == SubsystemType.Hardware) {
            lift = DefaultLiftFactory.MakeLift();
        } else {
            lift = DashboardLiftFactory.MakeLift();
        }

        if (hatchType == SubsystemType.Hardware) {
            hatch = DefaultHatchFactory.MakeHatch();
        } else {
            hatch = DashboardHatchFactory.MakeHatch();
        }

        if (elevatorType == SubsystemType.Hardware) {
            elevator = DefaultElevatorFactory.MakeElevator();
        } else {
            elevator = DashboardElevatorFactory.MakeElevator();
        }

        if (compressorType == SubsystemType.Hardware) {
            compressor = DefaultCompressorFactory.MakeCompressor();
        } else {
            compressor = DashboardCompressorFactory.MakeCompressor();
        }

        if (cargoType == SubsystemType.Hardware) {
            cargo = DefaultCargoFactory.MakeCargo();
        } else {
            cargo = DashboardCargoFactory.MakeCargo();
        }

        if (armType == SubsystemType.Hardware) {
            arm = DefaultArmFactory.MakeArm();
        } else {
            arm = DashboardArmFactory.MakeArm();
        }
    }

    private void setupDashboardSubsystems() {
        setupSubsystems(SubsystemType.Dashboard, SubsystemType.Dashboard, SubsystemType.Dashboard,
                SubsystemType.Dashboard, SubsystemType.Dashboard, SubsystemType.Dashboard,
                SubsystemType.Dashboard);
    }

    @SuppressWarnings("unused") // Code is here as a helper method for quick switching
    private void setupHardwareSubsystems() {
        setupSubsystems(SubsystemType.Hardware, SubsystemType.Hardware, SubsystemType.Hardware,
                SubsystemType.Hardware, SubsystemType.Hardware, SubsystemType.Hardware,
                SubsystemType.Hardware);
    }

    @SuppressWarnings("unused") // Code is here as a helper method for quick switching
    private void setupCustomSubsystems() {
        setupSubsystems(SubsystemType.Hardware, // Swerve
                SubsystemType.Dashboard, // Lift
                SubsystemType.Dashboard, // Hatch
                SubsystemType.Dashboard, // Elevator
                SubsystemType.Hardware, // Compressor
                SubsystemType.Dashboard, // Cargo
                SubsystemType.Dashboard); // Arm
    }

    @Override
    public void close() {
        oi.close();
    }
}
