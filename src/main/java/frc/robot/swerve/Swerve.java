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
    private double rotationCoefficient = 1;
    private double r;

    public Swerve(double length, double width, WheelModule fl, WheelModule fr, WheelModule bl,
            WheelModule br) {
        this.length = length;
        this.width = width;
        this.fl = fl;
        this.fr = fr;
        this.bl = bl;
        this.br = br;
        r = Math.sqrt(width * width + length * length) / 2;
    }

    public void moveRobotCentric(double x, double y, double w) {
        double wkr = w * rotationCoefficient / r;

        double a = x + wkr * width / 2;
        double b = y + wkr * length / 2;
        double c = y - wkr * length / 2;
        double d = x - wkr * width / 2;

        double flSpeed = Math.sqrt(c * c + a * a);
        double frSpeed = Math.sqrt(a * a + b * b);
        double blSpeed = Math.sqrt(c * c + d * d);
        double brSpeed = Math.sqrt(b * b + d * d);

        double maxSpeed =
                Math.max(1, Math.max(flSpeed, Math.max(frSpeed, Math.max(blSpeed, brSpeed))));
        flSpeed /= maxSpeed;
        frSpeed /= maxSpeed;
        blSpeed /= maxSpeed;
        brSpeed /= maxSpeed;

        double blAngle = Math.atan2(-a, c);
        double brAngle = Math.atan2(-a, b);
        double flAngle = Math.atan2(-d, c);
        double frAngle = Math.atan2(-d, b);

        fl.drive(flAngle, flSpeed);
        fr.drive(frAngle, frSpeed);
        bl.drive(blAngle, blSpeed);
        br.drive(brAngle, brSpeed);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
