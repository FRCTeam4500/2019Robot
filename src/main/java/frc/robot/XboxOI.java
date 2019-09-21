/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * Add your docs here.
 */
public class XboxOI implements IMainOI {

    private XboxController controller = new XboxController(0);

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
