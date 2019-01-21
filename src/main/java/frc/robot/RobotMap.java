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

    public final static int FLSPEEDPORT = null, FLANGLEPORT = null;
    public final static int FRSPEEDPORT = null, FRANGLEPORT = null;
    public final static int BLSPEEDPORT = null, BLANGLEPORT = null;
    public final static int BRSPEEDPORT = null, BRANGLEPORT = null;

    public final static double L = null;
    public final static double W = null;
    public final static double COUNTPERDEG = null;

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
