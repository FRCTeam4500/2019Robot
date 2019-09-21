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
import frc.robot.lift.Lift_ExtendBackCommand;
import frc.robot.lift.Lift_ExtendFrontCommand;
import frc.robot.lift.Lift_ExtendMiddleCommand;
import frc.robot.lift.Lift_RetractBackCommand;
import frc.robot.lift.Lift_RetractFrontCommand;
import frc.robot.lift.Lift_RetractMiddleCommand;

/**
 * Add your docs here.
 */
public class XboxOI implements IMainOI {

    private XboxController controller = new XboxController(0);

    public XboxOI() {
        var aButton = new JoystickButton(controller, 1);
        var bButton = new JoystickButton(controller, 2);
        var xButton = new JoystickButton(controller, 3);

        aButton.whenPressed(new Lift_ExtendMiddleCommand(Robot.lift));
        aButton.whenReleased(new Lift_RetractMiddleCommand(Robot.lift));

        bButton.whenPressed(new Lift_ExtendBackCommand(Robot.lift));
        bButton.whenReleased(new Lift_RetractBackCommand(Robot.lift));

        xButton.whenPressed(new Lift_ExtendFrontCommand(Robot.lift));
        xButton.whenReleased(new Lift_RetractFrontCommand(Robot.lift));
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
