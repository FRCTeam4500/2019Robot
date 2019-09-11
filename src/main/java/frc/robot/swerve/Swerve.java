/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.swerve;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Swerve extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private double length, width;
    private WheelModule fl, fr, bl, br;

    public Swerve(double length, double width, WheelModule fl, WheelModule fr, WheelModule bl,
            WheelModule br) {
        this.length = length;
        this.width = width;
        this.fl = fl;
        this.fr = fr;
        this.bl = bl;
        this.br = br;
    }

    public void moveRobotCentric(double x, double y, double w) {

    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
