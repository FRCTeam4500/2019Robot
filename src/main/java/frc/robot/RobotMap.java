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
     * =================== Drivetrain ===================
     */

    public final static int FLSPEEDPORT = 0, FLANGLEPORT = 0;
    public final static int FRSPEEDPORT = 0, FRANGLEPORT = 0;
    public final static int BLSPEEDPORT = 0, BLANGLEPORT = 0;
    public final static int BRSPEEDPORT = 0, BRANGLEPORT = 0;

    public final static double L = 0;
    public final static double W = 0;
    public final static double COUNTPERDEG = 0;

    public final static double angleP = 0, angleI = 0, angleD = 0, angleF = 0;
    public final static int angleV = 0, angleA = 0;

    /*
     * =================== Configuration ===================
     */

    public final static double DEADZONE_XY = 0.2;
    public final static double DEADZONE_Z = 0.4;
    public final static int TIMEOUT = 0;
    
     /*
     * =================== Auto ===================
     */

    public final static double wheelDiameter = 0;
	public final static double wheelBaseWidth = 0;
	public final static double wheelBaseDepth = 0;
	
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
    *====================== Hatch =========================
    */
	public static final int RIGHT_HATCH_SOLENOID = 0;
	public static final int LEFT_HATCH_SOLENOID_FORWARD_CHANNEL = 0;
	public static final int LEFT_HATCH_SOLENOID_REVERSE_CHANNEL = 0;
	public static final int RIGHT_HATCH_SOLENOID_REVERSE_CHANNEL = 0;
	public static final int RIGHT_HATCH_SOLENOID_FORWARD_CHANNEL = 0;
	public static final int MIDDLE_HATCH_SOLENOID_FORWARD_CHANNEL = 0;
	public static final int MIDDLE_HATCH_SOLENOID_REVERSE_CHANNEL = 0;

     /*
     * =================== Methods ===================
     */

     public static void dashboardDisplay() {
         SmartDashboard.putNumber("gyro", Robot.swerve.getGyro());
     }

}
