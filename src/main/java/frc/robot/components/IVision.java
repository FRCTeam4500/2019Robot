/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components;

/**
 * Add your docs here.
 */
public interface IVision {
    enum CameraMode {
        VisionProcessor, DriverCamera
    }

    boolean hasValidTargets();

    double getHorizontalOffsetFromCrosshair();

    double getVerticalOffsetFromCrosshar();

    double getTargetArea();

    double getSkew();

    void setCameraMode(CameraMode mode);

    void setPipeline(int index);
}
