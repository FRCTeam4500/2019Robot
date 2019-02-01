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
    public final static int ELEVATORMOTOR = 5;
    public final static int ELEVATORLOW = 0;
    public final static int ELEVATORMEDIUM = 10;
    public final static int ELEVATORHIGH = 20;


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

    public final static double angleP = null, angleI = null, angleD = null, angleF = null;
    public final static int angleV = null, angleA = null;

    /*
     * =================== Configuration ===================
     */
    

    public final static double DEADZONE_XY = 0.2;
    public final static double DEADZONE_Z = 0.4;
    public final static int TIMEOUT = 0;
    
     /*
     * =================== Auto ===================
     */

    public final static double wheelDiameter = null;
	public final static double wheelBaseWidth = null;
	public final static double wheelBaseDepth = null;
	
	public final static double flKv = null;
	public final static double flKa = null;
	
	public final static double frKv = null;
	public final static double frKa = null;
	
	public final static double blKv = null;
	public final static double blKa = null;
	
	public final static double brKv = null;
	public final static double brKa = null;
	public final static int ticksPerRotation = null;

     /*
     * =================== Methods ===================
     */

     public static void dashboardDisplay() {
         SmartDashboard.putNumber("gyro", Robot.swerve.getGyro());
     }

}
