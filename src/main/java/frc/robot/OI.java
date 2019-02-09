/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Arm_SetRotation;
import frc.robot.commands.Swerve_GyroReset;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    Joystick driveStick;
    
    Button driveResetGyro;
	Button armAngleLow, armAngleMedium, armAngleHigh;
	

    public OI() {
	   	driveStick = new Joystick(0);
		// driveResetGyro = new JoystickButton(driveStick, 7);
		// driveResetGyro.whenPressed(new Swerve_GyroReset());
		
		armAngleLow = new JoystickButton(driveStick, 7);
		armAngleLow.whenPressed(new Arm_SetRotation(0));
		armAngleMedium = new JoystickButton(driveStick, 9);
		armAngleMedium.whenPressed(new Arm_SetRotation(900));
		armAngleHigh = new JoystickButton(driveStick, 11);
		armAngleHigh.whenPressed(new Arm_SetRotation(1800));


    }

    public double getX() {
		return Math.abs(driveStick.getX()) > RobotMap.DEADZONE_XY ? driveStick.getX() : 0;
	}
	
	public double getY() {
		return Math.abs(driveStick.getY()) > RobotMap.DEADZONE_XY ? driveStick.getY() : 0;
	}
	
	public double getZ() {
		return Math.abs(driveStick.getZ()) > RobotMap.DEADZONE_Z ? driveStick.getZ() : 0;
	}
	
	public double getSlider() {
		return driveStick.getThrottle();
	}
	

	
}
