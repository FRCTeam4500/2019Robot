/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.hatch.*;
import frc.robot.lift.*;
import frc.robot.swerve.*;
import frc.robot.arm.Arm;
import frc.robot.arm.Arm_DriveCommand;
import frc.robot.cargo.Cargo;
import frc.robot.cargo.Cargo_DriveCommand;
import frc.robot.compressor.Compressor;
import frc.robot.compressor.Compressor_ToggleCommand;
import frc.robot.elevator.*;

/**
 * Add your docs here.
 */
public class XboxOI implements IMainOI {

    private XboxController controller = new XboxController(0);

    JoystickButton aButton = new JoystickButton(controller, 1),
            bButton = new JoystickButton(controller, 2),
            xButton = new JoystickButton(controller, 3),
            yButton = new JoystickButton(controller, 4),
            leftBumper = new JoystickButton(controller, 5),
            rightBumper = new JoystickButton(controller, 6),
            specialLeft = new JoystickButton(controller, 7),
            specialRight = new JoystickButton(controller, 8);

    public XboxOI(Swerve swerve, Lift lift, Hatch hatch, Elevator elevator, Compressor compressor,
            Cargo cargo, Arm arm) {

        var drive = new DriveCommand(swerve, this);
        swerve.setDefaultCommand(drive);


        aButton.whenPressed(new Lift_ExtendMiddleCommand(lift));
        aButton.whenReleased(new Lift_RetractMiddleCommand(lift));

        bButton.whenPressed(new Lift_ExtendBackCommand(lift));
        bButton.whenReleased(new Lift_RetractBackCommand(lift));

        xButton.whenPressed(new Lift_ExtendFrontCommand(lift));
        xButton.whenReleased(new Lift_RetractFrontCommand(lift));

        leftBumper.whenPressed(new Hatch_ExtendNailCommand(hatch));
        leftBumper.whenReleased(new Hatch_RetractNailCommand(hatch));

        specialLeft.whenPressed(new Hatch_ExtendPanelCommand(hatch));
        specialLeft.whenReleased(new Hatch_RetractPanelCommand(hatch));

        specialRight.whenPressed(new Hatch_ExtendClawCommand(hatch));
        specialRight.whenReleased(new Hatch_RetractClawCommand(hatch));

        yButton.whenPressed(new Elevator_SetLevelCommand(elevator, RobotMap.ELEVATOR_MEDIUM));
        yButton.whenReleased(new Elevator_SetLevelCommand(elevator, RobotMap.ELEVATOR_LOW));

        rightBumper.whenPressed(new Compressor_ToggleCommand(compressor));

        cargo.setDefaultCommand(new Cargo_DriveCommand(cargo, this));

        arm.setDefaultCommand(new Arm_DriveCommand(arm, this));
    }

    @Override
    public double getX() {
        return withDeadzone(controller.getX(Hand.kLeft), 0.05);
    }

    @Override
    public double getY() {
        return -withDeadzone(controller.getY(Hand.kLeft), 0.05);
    }

    @Override
    public double getZ() {
        return -withDeadzone(controller.getX(Hand.kRight), 0.05);
    }

    private double withDeadzone(double input, double deadzone) {
        if (Math.abs(input) >= deadzone) {
            return input * 0.5;
        } else {
            return 0;
        }
    }

    @Override
    public double getCargoSideSpeed() {
        return getCargoSpeed();
    }

    @Override
    public double getCargoTopSpeed() {
        return getCargoSpeed();
    }

    private double getCargoSpeed() {
        if (controller.getPOV() == 0) {
            return -1;
        } else if (controller.getPOV() == 180) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public double getArmAngle() {
        if (controller.getPOV() == 270) {
            return Math.PI / 2;
        } else if (controller.getPOV() == 90) {
            return 0;
        } else {
            return Math.PI / 4;
        }
    }

    @Override
    public void close() {
        aButton.close();
        bButton.close();
        xButton.close();
        yButton.close();
        leftBumper.close();
        rightBumper.close();
        specialLeft.close();
        specialRight.close();
    }
}
