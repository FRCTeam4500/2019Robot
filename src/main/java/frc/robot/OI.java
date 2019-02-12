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
import frc.robot.commands.Hatch_ExtendIntake;
import frc.robot.commands.Hatch_PopHatch;
import frc.robot.commands.Hatch_RetractIntake;
import frc.robot.commands.Hatch_UnpopHatch;
import frc.robot.commands.Elevator_SetLevel;
import frc.robot.commands.Swerve_GyroReset;
import frc.robot.commands.Cargo_Intake;
import frc.robot.commands.Cargo_Release;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	Joystick driveStick;
	Joystick controlStick;
    
    Button driveResetGyro;
	Button elevatorLow, elevatorMedium, elevatorHigh;
	Button armAngleLow, armAngleMedium, armAngleHigh;
	Button cargoIntake, cargoRelease;
	Button hatchExtendButton, hatchPopButton, hatchRetractButton, hatchUnpopButton;
	
    public OI() {
		driveStick = new Joystick(0);
        controlStick = new Joystick(1); 
          
		driveResetGyro = new JoystickButton(driveStick, 7);
		driveResetGyro.whenPressed(new Swerve_GyroReset());
        
        /*===============================
                Arm Buttons
        ===============================*/
		armAngleLow = new JoystickButton(controlStick, 7);
		armAngleLow.whenPressed(new Arm_SetRotation(0));
		armAngleMedium = new JoystickButton(controlStick, 9);
		armAngleMedium.whenPressed(new Arm_SetRotation(600));
		armAngleHigh = new JoystickButton(controlStick, 11);
		armAngleHigh.whenPressed(new Arm_SetRotation(2100.0));

		
		/*===============================
		Elevator Buttons
		===============================*/

        elevatorLow = new JoystickButton(driveStick, 12);
        elevatorLow.whenPressed(new Elevator_SetLevel(RobotMap.ELEVATORLOW));
        elevatorMedium = new JoystickButton(driveStick, 10);
        elevatorMedium.whenPressed(new Elevator_SetLevel(RobotMap.ELEVATORMEDIUM));
        elevatorHigh = new JoystickButton(driveStick, 8);
        elevatorHigh.whenPressed(new Elevator_SetLevel(RobotMap.ELEVATORHIGH));

		/*===============================
				Cargo Buttons
		===============================*/

		cargoIntake = new JoystickButton(driveStick, 1);
		cargoIntake.whenPressed(new Cargo_Intake(.8, .8));
		cargoIntake.whenReleased(new Cargo_Intake(0, 0));

		cargoRelease = new JoystickButton(driveStick, 2);
		cargoRelease.whenPressed(new Cargo_Release(.8, .8));
        cargoRelease.whenReleased(new Cargo_Release(0, 0));

        /*===============================
				Elevator Buttons
		===============================*/
        
		/*elevatorLow = new JoystickButton(controlStick, 11);
		elevatorLow.whenPressed(new Elevator_SetLevel(RobotMap.ELEVATORLOW));
		elevatorMedium = new JoystickButton(controlStick, 9);
		elevatorMedium.whenPressed(new Elevator_SetLevel(RobotMap.ELEVATORMEDIUM));
		elevatorHigh = new JoystickButton(controlStick, 7);
		elevatorHigh.whenPressed(new Elevator_SetLevel(RobotMap.ELEVATORHIGH));/*
		
		/*===============================
		Hatch Buttons
		===============================*/
		hatchExtendButton = new JoystickButton(driveStick, RobotMap.HATCH_EXTEND_BUTTON_CHANNEL);
		hatchExtendButton.whenPressed(new Hatch_ExtendIntake());
		hatchPopButton = new JoystickButton(driveStick, RobotMap.HATCH_POP_BUTTON_CHANNEL);
		hatchPopButton.whenPressed(new Hatch_PopHatch());
		hatchRetractButton = new JoystickButton(driveStick, RobotMap.HATCH_RETRACT_BUTTON_CHANNEL);
		hatchRetractButton.whenPressed(new Hatch_RetractIntake());
		hatchUnpopButton = new JoystickButton(driveStick, RobotMap.HATCH_UNPOP_BUTTON_CHANNEL);
		hatchUnpopButton.whenPressed(new Hatch_UnpopHatch());
		
    }

    public double getX() {
		return Math.abs(driveStick.getX()) > RobotMap.DEADZONE_XY ? driveStick.getX() : 0;
	}
	
	public double getY() {
		return Math.abs(driveStick.getY()) > RobotMap.DEADZONE_XY ? driveStick.getY() : 0;
	}
	
	public double getZ() {
		double z = driveStick.getZ();
		return Math.abs(z) > RobotMap.DEADZONE_Z ? (z*Math.pow(z, RobotMap.SENSITIVITY_Z)) / RobotMap.REDUCER_Z : 0;
	}
	
	public double getSlider() {
		return driveStick.getThrottle();
	}
}
