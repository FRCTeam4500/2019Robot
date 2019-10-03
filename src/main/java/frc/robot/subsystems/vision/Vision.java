/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.vision;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.components.IVision;

/**
 * Add your docs here.
 */
public class Vision extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private IVision vision;

    public Vision(IVision vision) {
        this.vision = vision;
    }

    public boolean hasValidTargets() {
        return vision.hasValidTargets();
    }

    public double getHorizontalOffsetFromCrosshair() {
        return vision.getHorizontalOffsetFromCrosshair();
    }

    public double getVerticalOffsetFromCrosshar() {
        return vision.getVerticalOffsetFromCrosshar();
    }

    public double getTargetArea() {
        return vision.getTargetArea();
    }

    public double getSkew() {
        return vision.getSkew();
    }

    public void setCameraMode(IVision.CameraMode mode) {
        vision.setCameraMode(mode);
    }

    public void setPipeline(int index) {
        vision.setPipeline(index);
    }

    public double getX() {
        return vision.getX();
    }

    public double getY() {
        return vision.getY();
    }

    public double getZ() {
        return vision.getZ();
    }

    public double getPitch() {
        return vision.getPitch();
    }

    public double getYaw() {
        return vision.getYaw();
    }

    public double getRoll() {
        return vision.getRoll();
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
