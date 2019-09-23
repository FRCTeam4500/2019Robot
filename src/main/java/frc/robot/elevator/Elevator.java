/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.elevator;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.components.IPositionSetter;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private IPositionSetter positionSetter;

    public Elevator(IPositionSetter positionSetter) {
        this.positionSetter = positionSetter;
    }

    protected void setLevel(int level) {
        positionSetter.setPosition(level);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
