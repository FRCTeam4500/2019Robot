/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class RobotMap {
    // Arm
    public static final int ROTATIONAL_MOTOR = 12;
    public static final int ARM_MIN = 0;
    public static final int ARM_MAX = 2200;

    // Cargo
    public static final int LEFT_GRAB = 11;
    public static final int RIGHT_GRAB = 10;
    public static final int TOP_GRAB = 13;

    // Compressor
    public static final int COMPRESSOR = 0;

    // Elevator
    public final static int ELEVATOR_MOTOR = 5;
    public final static int ELEVATOR_LOW = 10;
    public final static int ELEVATOR_MEDIUM = 13500; // 15000
    public final static int ELEVATOR_HIGH = 23000; // 26000
    public final static int ELEVATOR_MAX = 26127; // 25000
    public final static int ELEVATOR_HATCH = 4700; // 1600

    // Hatch
    public static final int HATCH_PANEL_SOLENOID_FORWARD_CHANNEL = 0;
    public static final int HATCH_PANEL_SOLENOID_REVERSE_CHANNEL = 1;
    public static final int HATCH_NAIL_SOLENOID_FORWARD_CHANNEL = 2;
    public static final int HATCH_NAIL_SOLENOID_REVERSE_CHANNEL = 3;
    public static final int HATCH_CLAW_SOLENOID_REVERSE_CHANNEL = 2;
    public static final int HATCH_CLAW_SOLENOID_FORWARD_CHANNEL = 3;

    // Lift
    public static final int FRONT_LIFT_SOLENOID_FORWARD_CHANNEL = 0;
    public static final int FRONT_LIFT_SOLENOID_REVERSE_CHANNEL = 1;
    public static final int BACK_LIFT_SOLENOID_FORWARD_CHANNEL = 6;
    public static final int BACK_LIFT_SOLENOID_REVERSE_CHANNEL = 7;
    public static final int MIDDLE_LIFT_SOLENOID_FORWARD_CHANNEL = 0;
    public static final int MIDDLE_LIFT_SOLENOID_REVERSE_CHANNEL = 1;

    // Swerve
    public static final double ANGLE_P = 1.03858;
    public static final double ANGLE_I = 0.004;
    public static final double ANGLE_D = 8;
    public static final double ANGLE_F = 0.51;
    public static final int ANGLE_V = 4012;
    public static final int ANGLE_A = 4012;
    public static final int BL_ANGLE_PORT = 8;
    public static final int BR_ANGLE_PORT = 2;
    public static final int FL_ANGLE_PORT = 6;
    public static final int FR_ANGLE_PORT = 3;
    public static final int BL_SPEED_PORT = 9;
    public static final int BR_SPEED_PORT = 1;
    public static final int FL_SPEED_PORT = 7;
    public static final int FR_SPEED_PORT = 4;

    // Misc
    public static final int TIMEOUT = 0;
    public static final double TICKS_PER_DEGREE = 16.2539;
    public static final double TICKS_PER_RADIAN = TICKS_PER_DEGREE * 2 * Math.PI / 360;
}
