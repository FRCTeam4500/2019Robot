/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.awt.Button;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Swerve_GyroReset;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    Joystick driveStick;
    
    Button driveResetGyro;
	Button elevatorLow;
	Button elevatorMedium;
	Button elevatorHigh;

    public OI() {
        if (!driveStick.getName().equals("")) {
			driveResetGyro = new JoystickButton(driveStick, 7);
			elevatorLow = new JoystickButton(drivestick, 11);
			elevatorMedium = new JoystickButton(drivestick, 9);
			elevatorHigh = new JoystickButton (drivestick, 7)
			driveResetGyro.whenPressed(new Swerve_GyroReset());
			elevatorLow.whenPressed(new Elevator_SetLevel(RobotMap.ELEVATORLOW));
			elevatorMedium.whenPressed(new Elevator_SetLevel(RobotMap.ELEVATORMEDIUM));
			elevatorHigh.whenPressed(new Elevator_SetLevel(RobotMap.ELEVATORHIGH));
        }
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
