/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.virtual;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import frc.robot.components.IAngleGetter;
import frc.robot.components.IAngleSetter;
import frc.robot.utility.PIDValues;

/**
 * Add your docs here.
 */
public class VirtualPIDAngleComponent implements IAngleGetter, IAngleSetter {
    private PIDController controller;
    private double angle;

    private static double min = 0;
    private static double max = 10;

    public VirtualPIDAngleComponent(PIDValues values) {
        controller = values.toPidController(new PIDSource() {

            @Override
            public void setPIDSourceType(PIDSourceType pidSource) {
            }

            @Override
            public double pidGet() {
                return getAngle();
            }

            @Override
            public PIDSourceType getPIDSourceType() {
                return PIDSourceType.kDisplacement;
            }
        }, this::addToAngle);
        controller.enable();
    }

    @Override
    public void setAngle(double angle) {
        controller.setSetpoint(angle);
    }

    @Override
    public double getAngle() {
        return angle;
    }

    private void addToAngle(double value) {
        if (value > max) {
            value = max;
        } else if (-min < value && value < min) {
            value = 0;
        } else if (value < -max) {
            value = -max;
        }
        angle += value;
    }
}