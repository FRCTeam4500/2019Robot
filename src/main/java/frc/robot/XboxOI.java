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

/**
 * Add your docs here.
 */
public class XboxOI implements IMainOI {

    private XboxController controller = new XboxController(0);

    public XboxOI(Swerve swerve, Lift lift, Hatch hatch) {

        var drive = new DriveCommand(swerve, this);
        swerve.setDefaultCommand(drive);

        var aButton = new JoystickButton(controller, 1);
        var bButton = new JoystickButton(controller, 2);
        var xButton = new JoystickButton(controller, 3);
        var yButton = new JoystickButton(controller, 4);
        var leftBumper = new JoystickButton(controller, 5);
        var rightBumper = new JoystickButton(controller, 6);
        var specialLeft = new JoystickButton(controller, 7);
        var specialRight = new JoystickButton(controller, 8);

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
    }

    @Override
    public double getX() {
        return withDeadzone(controller.getX(Hand.kLeft), 0.05);
    }

    @Override
    public double getY() {
        return withDeadzone(controller.getY(Hand.kLeft), 0.05);
    }

    @Override
    public double getZ() {
        return withDeadzone(controller.getX(Hand.kRight), 0.05);
    }

    private double withDeadzone(double input, double deadzone) {
        if (Math.abs(input) >= deadzone) {
            return input;
        } else {
            return 0;
        }
    }

}
