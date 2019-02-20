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
import frc.robot.commands.Auto_GetOffHAB;
import frc.robot.commands.Cargo_Intake;
import frc.robot.commands.Cargo_Release;
import frc.robot.commands.ElevatorArm_SetHatchLevelAndZeroArm;
import frc.robot.commands.Elevator_SetLevel;
import frc.robot.commands.Hatch_PopHatch;
import frc.robot.commands.Hatch_RetractAndUnpop;
import frc.robot.commands.Hatch_RetractIntake;
import frc.robot.commands.Hatch_ToggleIntake;
import frc.robot.commands.Hatch_UnpopHatch;
import frc.robot.commands.Lift_ExtendBack;
import frc.robot.commands.Lift_ExtendFront;
import frc.robot.commands.Lift_ExtendMiddle;
import frc.robot.commands.Lift_RetractBack;
import frc.robot.commands.Lift_RetractFront;
import frc.robot.commands.Lift_RetractMiddle;
import frc.robot.commands.Lift_ToggleMiddle;
import frc.robot.commands.Swerve_GyroReset;
import frc.robot.commands.Swerve_ToggleFieldCentric;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    Joystick driveStick;
    Joystick controlStick;

    Button driveResetGyro, toggleFieldCentric;
	Button elevatorLow, elevatorMedium, elevatorHigh;
	Button armAngleLow, armAngleMedium, armAngleHigh;
	Button cargoIntake, cargoRelease, armPickUp;
	Button hatchExtendButton, hatchPopButton, hatchRetractButton, hatchUnpopButton;
	Button frontControl, frontRetract, backControl, backRetract, middleControl;
    Button elevatorHatch;
    Button getOffHabButton;
    public OI() {
		driveStick = new Joystick(0);
        controlStick = new Joystick(1); 
        
		driveResetGyro = new JoystickButton(driveStick, 7);
        driveResetGyro.whenPressed(new Swerve_GyroReset());
        
        toggleFieldCentric = new JoystickButton(driveStick, 12);
        toggleFieldCentric.whenPressed(new Swerve_ToggleFieldCentric());
        toggleFieldCentric.whenReleased(new Swerve_ToggleFieldCentric());
        
        /*===============================
        Arm Buttons
        ===============================*/
		armAngleLow = new JoystickButton(controlStick, 7);
		armAngleLow.whenPressed(new Arm_SetRotation(0));
		armAngleMedium = new JoystickButton(controlStick, 9);
		armAngleMedium.whenPressed(new Arm_SetRotation(500));
		//armAngleHigh = new JoystickButton(controlStick, 11);
        //armAngleHigh.whenPressed(new Arm_SetRotation(2100.0));
        armPickUp = new JoystickButton(controlStick,1 );
        armPickUp.whenReleased(new Arm_SetRotation(650));
        armPickUp.whenPressed(new Arm_SetRotation(2100));
        
		
		/*===============================
		Elevator Buttons
		===============================*/
        
        elevatorLow = new JoystickButton(controlStick, 12);
        elevatorLow.whenPressed(new Elevator_SetLevel(RobotMap.ELEVATORLOW));
        elevatorMedium = new JoystickButton(controlStick, 10);
        elevatorMedium.whenPressed(new Elevator_SetLevel(RobotMap.ELEVATORMEDIUM));
        elevatorHigh = new JoystickButton(controlStick, 8);
        elevatorHigh.whenPressed(new Elevator_SetLevel(RobotMap.ELEVATORHIGH));
        elevatorHatch = new JoystickButton(controlStick, 5);
        //elevatorHatch.whenPressed(new Elevator_SetLevel(RobotMap.ELEVATORHATCH));
        elevatorHatch.whenPressed(new ElevatorArm_SetHatchLevelAndZeroArm());
		/*===============================
        Cargo Buttons
		===============================*/
        
		cargoIntake = new JoystickButton(controlStick, 1);
		cargoIntake.whenPressed(new Cargo_Intake(.8, .8));
        cargoIntake.whenReleased(new Cargo_Intake(0, 0));
        
        
		cargoRelease = new JoystickButton(controlStick, 2);
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
		hatchExtendButton = new JoystickButton(controlStick, 3);
		hatchExtendButton.whenPressed(new Hatch_ToggleIntake());
		hatchPopButton = new JoystickButton(controlStick, 4);
        hatchPopButton.whenPressed(new Hatch_PopHatch());
        hatchPopButton.whenReleased(new Hatch_RetractAndUnpop());
        //hatchPopButton.whenReleased(new Hatch_UnpopHatch());
                
        /*=============================
        Lift buttons
        ========================*/
        frontControl = new JoystickButton(driveStick, 3);
        frontControl.whenPressed(new Lift_ExtendFront());
        frontControl.whenReleased(new Lift_RetractFront());
        backControl = new JoystickButton(driveStick, 4);
        backControl.whenPressed(new Lift_ExtendBack());
        backControl.whenReleased(new Lift_RetractBack());
        middleControl = new JoystickButton(driveStick, 10);
        middleControl.whenPressed(new Lift_ToggleMiddle());
        
        /*==================================
        * Sandstorm Button 🐸
        ======================================*/
        getOffHabButton = new JoystickButton(driveStick, 8);
        getOffHabButton.whenPressed(new Auto_GetOffHAB());
    }
    
    public double getX() {
		return Math.abs(driveStick.getX()) > RobotMap.DEADZONE_XY ? driveStick.getX() : 0;
	}
	
	public double getY() {
		return Math.abs(driveStick.getY()) > RobotMap.DEADZONE_XY ? driveStick.getY() : 0;
	}
	
	public double getZ() {
        double z = driveStick.getZ();
        // double adjustedZ = RobotMap.SENSITIVITY_Z % 2 == 0  ? Math.signum(z) * Math.pow(z, RobotMap.SENSITIVITY_Z);
		return Math.abs(z) > RobotMap.DEADZONE_Z ? (z*Math.pow(z, RobotMap.SENSITIVITY_Z)) / RobotMap.REDUCER_Z : 0;
	}
	
	public double getSlider() {
		return driveStick.getThrottle();
	}
}
