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
        // Get the closest angle equivalent to the target angle. Otherwise the wheel module is going
        // to spin a lot since it will be at
        // something like 3 pi and the target will be 0 pi; the motor will move 3 pi instead of just
        // 1 pi without this bit
        double shortestRadianToTarget = getShortestRadianToTarget(lastAngle, angle);
        double targetAngle = shortestRadianToTarget + lastAngle;


        // Sometimes it will be easier to reverse the speed instead of rotating the whole module by
        // pi radians.
        // These lines determine whether this is needed.
        double oppositeAngle = targetAngle + Math.PI;
        double shortestDistanceToOppositeAngle =
                getShortestRadianToTarget(lastAngle, oppositeAngle);
        double finalAngle;
        double finalSpeed;
        if (Math.abs(shortestDistanceToOppositeAngle) < Math.abs(shortestRadianToTarget)) {
            finalAngle = lastAngle + shortestDistanceToOppositeAngle;
            finalSpeed = -speed;
        } else {
            finalAngle = lastAngle + shortestRadianToTarget;
            finalSpeed = speed;
        }
        angleSetter.setAngle(finalAngle);
        speedSetter.setSpeed(finalSpeed);
        lastAngle = finalAngle;


    }

    private double customMod(double a, double n) {
        return a - Math.floor(a / n) * n;
    }

    private double getShortestRadianToTarget(double currentAngle, double targetAngle) {
        double actualDifference = targetAngle - currentAngle;
        double shortestDifference = customMod(actualDifference + Math.PI, 2 * Math.PI) - Math.PI;
        return shortestDifference;
    }

}
