/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.swerve;

import edu.wpi.first.wpilibj.command.Subsystem;
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

    public WheelModule(IAngleSetter angleSetter, ISpeedSetter speedSetter) {
        this.angleSetter = angleSetter;
        this.speedSetter = speedSetter;
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    protected void drive(double angle, double speed) {
        angleSetter.setAngle(angle);
        speedSetter.setSpeed(speed);
    }
}
