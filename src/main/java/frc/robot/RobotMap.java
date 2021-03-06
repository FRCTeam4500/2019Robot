/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into to a variable name.
 * This provides flexibility changing wiring, makes checking the wiring easier and significantly
 * reduces the number of magic numbers floating around.
 */
public class RobotMap {

    /*
     * =================== Elevator ===================
     */

    public final static int ELEVATORMOTOR = 5;
    public final static int ELEVATORLOW = 10;
    public final static int ELEVATORMEDIUM = 13500; // 15000
    public final static int ELEVATORHIGH = 23000; // 26000
    public final static int ELEVATORMAX = 26127; // 25000
    public final static int ELEVATORHATCH = 4700;
    // public final static int ELEVATORHATCH = 1600;
    public static final int LIMIT_SWITCH_CHANNEL = 0;

    /*
     * =================== Arm ===================
     */

    public final static int ROTATIONALMOTOR = 12;
    public final static double ARMANGLE = 0;
    public final static int ARM_MAX = 2200;
    public final static int ARM_MIN = 0;

    /*
     * =================== Cargo ===================
     */

    public final static int LEFTGRAB = 11;
    public final static int RIGHTGRAB = 10;
    public final static int TOPGRAB = 13;


    /*
     * ====================== Hatch =========================
     */

    public static final int HATCH_PANEL_SOLENOID_FORWARD_CHANNEL = 0;
    public static final int HATCH_PANEL_SOLENOID_REVERSE_CHANNEL = 1;

    public static final int HATCH_NAIL_SOLENOID_FORWARD_CHANNEL = 2;
    public static final int HATCH_NAIL_SOLENOID_REVERSE_CHANNEL = 3;

    public static final int HATCH_CLAW_SOLENOID_FORWARD_CHANNEL = 2;
    public static final int HATCH_CLAW_SOLENOID_REVERSE_CHANNEL = 3;

    /*
     * =================== Drivetrain ===================
     */

    public final static int FLSPEEDPORT = 7, FLANGLEPORT = 6;
    public final static int FRSPEEDPORT = 4, FRANGLEPORT = 3;
    public final static int BLSPEEDPORT = 9, BLANGLEPORT = 8;
    public final static int BRSPEEDPORT = 1, BRANGLEPORT = 2;
    // units dont matter for L and W
    public final static double L = 29.75;
    public final static double W = 29.75;
    public final static double COUNTPERDEG = 16.2539;

    public final static double angleP = 1.03858, angleI = 0.004, angleD = 8, angleF = 0.51;
    public final static int angleV = 4012, angleA = 4012;

    /*
     * =================== Joystick Configuration ===================
     */

    public final static double DEADZONE_XY = 0.1;
    public final static double DEADZONE_Z = 0.3;
    // How sensitive the Z axis is.
    // 0 = no effect
    // 1 = square the output
    // 2 = cube the output
    public final static int SENSITIVITY_Z = 2;
    // Reduces the maximum output for the Z axis.
    // 1 = full speed
    // 2 = half speed
    // etc
    public final static int REDUCER_Z = 2;



    /*
     * =================== Vision Configuration ===================
     */

    public static double imgW;
    public static double imgH;
    public static double imgCenterW;
    public static double imgCenterH;
    public static double focalLength;
    public static final double FOV = 68.5;

    public final static double wheelDiameterCM = 7.62;
    public final static double robotRotationalRadiusCM = 42;

    /*
     * =================== Other ===================
     */

    public final static int TIMEOUT = 0;
    public final static int COMPRESSOR = 0;

    /*
     * =================== Auto ===================
     */

    // public final static double wheelDiameter = 0;
    // public final static double wheelDiameterMM = 0;
    // public final static double wheelBaseWidth = 0;
    // public final static double wheelBaseDepth = 0;

    public final static double flKv = 0;
    public final static double flKa = 0;

    public final static double frKv = 0;
    public final static double frKa = 0;

    public final static double blKv = 0;
    public final static double blKa = 0;

    public final static double brKv = 0;
    public final static double brKa = 0;
    public final static int ticksPerRotation = 0;

    /*
     * =================== Lift ========================
     */
    public static final int BACK_LIFT_SOLENOID_FORWARD_CHANNEL = 6;
    public static final int BACK_LIFT_SOLENOID_REVERSE_CHANNEL = 7;

    public static final int FRONT_LIFT_SOLENOID_FORWARD_CHANNEL = 5;
    public static final int FRONT_LIFT_SOLENOID_REVERSE_CHANNEL = 4;

    public static final int MIDDLE_LIFT_SOLENOID_FORWARD_CHANNEL = 0;
    public static final int MIDDLE_LIFT_SOLENOID_REVERSE_CHANNEL = 1;

    /*
     * =================== Methods ===================
     */

    public static void dashboardDisplay() {
        SmartDashboard.putNumber("gyro", Robot.swerve.getGyro());
        SmartDashboard.putNumber("Elevator Position",
                Robot.elevator.getElevatorMotor().getSelectedSensorPosition());
        SmartDashboard.putNumber("Elevator Position from Subsystem",
                Robot.elevator.getElevatorPosition());
        SmartDashboard.putNumber("Elevator Error",
                Robot.elevator.getElevatorMotor().getClosedLoopError());
        SmartDashboard.putNumber("ArmPosition", Robot.arm.getArmPosition());
        SmartDashboard.putNumber("ArmVelocity", Robot.arm.getArmVelocity());
        SmartDashboard.putNumber("ArmError", Robot.arm.getArmError());
    }
}
