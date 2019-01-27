/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    /*
     * =================== Elevator ===================
     */
    public final static int ELEVATOR_MOTOR = 0;
    public final static int ELEVATOR_LOW = 0;
    public final static int ELEVATOR_MEDIUM = 10;
    public final static int ELEVATOR_HIGH = 20;


    /*
     * =================== Drivetrain ===================
     */

    public final static int FL_SPEED_PORT = 0, FL_ANGLE_PORT = 0;
    public final static int FR_SPEED_PORT = 0, FR_ANGLE_PORT = 0;
    public final static int BL_SPEED_PORT = 0, BL_ANGLE_PORT = 0;
    public final static int BR_SPEED_PORT = 0, BR_ANGLE_PORT = 0;

    public final static double L = 0;
    public final static double W = 0;
    public final static double COUNT_PER_DEG = 0;

    public final static double ANGLE_P = 0, ANGLE_I = 0, ANGLE_D = 0, ANGLE_F = 0;
    public final static int ANGLE_V = 0, ANGLE_A = 0;
    
    /*
     * =================== Cargo ===================
     */

    public final static int LEFT_GRAB = 0;
    public final static int RIGHT_GRAB = 0;
    public final static int TOP_GRAB = 0;
    public final static int ANGLE_GRAB = 0;
    
    /*
     * =================== Configuration ===================
     */
    

    public final static double DEADZONE_XY = 0.2;
    public final static double DEADZONE_Z = 0.4;
    public final static int TIMEOUT = 0;
    
     /*
     * =================== Auto ===================
     */

    public final static double WHEEL_DIAMETER = 0;
	public final static double WHEEL_BASE_WIDTH = 0;
	public final static double WHEEL_BASE_DEPTH = 0;
	
	public final static double FL_KV = 0;
	public final static double FL_KA = 0;
	
	public final static double FR_KV = 0;
	public final static double FR_KA = 0;
	
	public final static double BL_KV = 0;
	public final static double BL_KA = 0;
	
	public final static double BR_KV = 0;
	public final static double BR_KA = 0;
	public final static int TICKS_PER_ROTATION = 0;

     /*
     * =================== Methods ===================
     */

     public static void dashboardDisplay() {
         SmartDashboard.putNumber("gyro", Robot.swerve.getGyro());
     }

}
