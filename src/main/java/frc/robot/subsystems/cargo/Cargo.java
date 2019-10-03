/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.cargo;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.components.ISpeedSetter;

/**
 * Add your docs here.
 */
public class Cargo extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private ISpeedSetter leftGrab, topGrab, rightGrab;

    public Cargo(ISpeedSetter leftGrab, ISpeedSetter topGrab, ISpeedSetter rightGrab) {
        this.leftGrab = leftGrab;
        this.topGrab = topGrab;
        this.rightGrab = rightGrab;
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void setMotors(double sideSpeed, double topSpeed) {
        leftGrab.setSpeed(sideSpeed);
        topGrab.setSpeed(topSpeed);
        rightGrab.setSpeed(-sideSpeed);
    }
}
