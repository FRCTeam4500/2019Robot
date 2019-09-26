/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.swerve;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.components.IAngleGetter;
import frc.robot.components.IAngleSetter;
import frc.robot.components.ISpeedSetter;

/**
 * Add your docs here.
 */
public class WheelModule extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private IAngleSetter angleSetter;
    private ISpeedSetter speedSetter;
    private IAngleGetter angleGetter;
    private double lastAngle;

    public WheelModule(IAngleSetter angleSetter, ISpeedSetter speedSetter) {
        this.angleSetter = angleSetter;
        this.speedSetter = speedSetter;
    }

    public WheelModule(IAngleSetter angleSetter, ISpeedSetter speedSetter,
            IAngleGetter angleGetter) {
        this(angleSetter, speedSetter);
        this.angleGetter = angleGetter;
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void drive(double angle, double speed) {
        if (angleGetter != null) {
            lastAngle = angleGetter.getAngle();
        }
        double actualDifference = angle - lastAngle;
        double shortestDifference = customMod(actualDifference + Math.PI, 2 * Math.PI) - Math.PI;
        double finalAngle = lastAngle + shortestDifference;
        angleSetter.setAngle(finalAngle);
        speedSetter.setSpeed(speed);
        lastAngle = finalAngle;
    }

    private double customMod(double a, double n) {
        return a - Math.floor(a / n) * n;
    }
}
