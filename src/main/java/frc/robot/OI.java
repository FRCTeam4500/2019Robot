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
import frc.robot.commands.Hatch_ExtendIntake;
import frc.robot.commands.Hatch_PopHatch;
import frc.robot.commands.Hatch_RetractIntake;
import frc.robot.commands.Hatch_UnpopHatch;
import frc.robot.commands.Swerve_GyroReset;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    Joystick driveStick;
    
    Button driveResetGyro;
	
	Button hatchExtendButton, hatchPopButton, hatchRetractButton, hatchUnpopButton;
    public OI() {
        if (!driveStick.getName().equals("")) {
			driveResetGyro = new JoystickButton(driveStick, 7);
			driveResetGyro.whenPressed(new Swerve_GyroReset());
			
			hatchExtendButton = new JoystickButton(driveStick, RobotMap.HATCH_EXTEND_BUTTON_CHANNEL);
			hatchExtendButton.whenPressed(new Hatch_ExtendIntake());
			hatchPopButton = new JoystickButton(driveStick, RobotMap.HATCH_POP_BUTTON_CHANNEL);
			hatchPopButton.whenPressed(new Hatch_PopHatch());
			hatchRetractButton = new JoystickButton(driveStick, RobotMap.HATCH_RETRACT_BUTTON_CHANNEL);
			hatchRetractButton.whenPressed(new Hatch_RetractIntake());
			hatchUnpopButton = new JoystickButton(driveStick, RobotMap.HATCH_UNPOP_BUTTON_CHANNEL);
			hatchUnpopButton.whenPressed(new Hatch_UnpopHatch());
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
