/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.lift;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.components.IDoubleSolenoid;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private IDoubleSolenoid front, middle, back;

    public Lift(IDoubleSolenoid front, IDoubleSolenoid middle, IDoubleSolenoid back) {
        this.front = front;
        this.middle = middle;
        this.back = back;
    }

    public void extendFront() {
        front.extend();
    }

    public void retractFront() {
        front.retract();
    }

    public void toggleFront() {
        front.toggleExtension();
    }

    public void extendMiddle() {
        middle.extend();
    }

    public void retractMiddle() {
        middle.retract();
    }

    public void toggleMiddle() {
        middle.toggleExtension();
    }

    public void extendBack() {
        back.extend();
    }

    public void retractBack() {
        back.retract();
    }

    public void toggleBack() {
        back.toggleExtension();
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
