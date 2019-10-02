/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.dashboard;

import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import frc.robot.components.IVision;

/**
 * Add your docs here.
 */
public class VisionDashboardDecorator extends DashboardDecorator implements IVision {

    private CameraMode lastSetCameraMode;
    private int lastSetPipeline;

    public VisionDashboardDecorator(String name, String subsystem, IVision vision) {
        super(name, subsystem);
        this.vision = vision;
    }

    private IVision vision;

    @Override
    public boolean hasValidTargets() {
        return vision.hasValidTargets();
    }

    @Override
    public double getHorizontalOffsetFromCrosshair() {
        return vision.getHorizontalOffsetFromCrosshair();
    }

    @Override
    public double getVerticalOffsetFromCrosshar() {
        return vision.getVerticalOffsetFromCrosshar();
    }

    @Override
    public double getTargetArea() {
        return vision.getTargetArea();
    }

    @Override
    public double getSkew() {
        return vision.getSkew();
    }

    @Override
    public void setCameraMode(CameraMode mode) {
        lastSetCameraMode = mode;
        vision.setCameraMode(mode);
    }

    @Override
    public void setPipeline(int index) {
        lastSetPipeline = index;
        vision.setPipeline(index);
    }

    @Override
    public double getX() {
        return vision.getX();
    }

    @Override
    public double getY() {
        return vision.getY();
    }

    @Override
    public double getZ() {
        return vision.getZ();
    }

    @Override
    public double getYaw() {
        return vision.getYaw();
    }

    @Override
    public double getPitch() {
        return vision.getPitch();
    }

    @Override
    public double getRoll() {
        return vision.getRoll();
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addBooleanProperty("Has Valid Targets", this::hasValidTargets, null);
        builder.addDoubleProperty("Horizontal Offset From Crosshair",
                this::getHorizontalOffsetFromCrosshair, null);
        builder.addDoubleProperty("Vertical Offset From Crosshair",
                this::getVerticalOffsetFromCrosshar, null);
        builder.addDoubleProperty("Target Area", this::getTargetArea, null);
        builder.addDoubleProperty("Skew", this::getSkew, null);
        builder.addStringProperty("Last Set Camera Mode",
                () -> (lastSetCameraMode != null) ? lastSetCameraMode.toString() : "None", null);
        builder.addDoubleProperty("Last Set Pipeline", () -> lastSetPipeline, null);
        builder.addDoubleProperty("3D X", this::getX, null);
        builder.addDoubleProperty("3D Y", this::getY, null);
        builder.addDoubleProperty("3D Z", this::getZ, null);
        builder.addDoubleProperty("3D Yaw", this::getYaw, null);
        builder.addDoubleProperty("3D Pitch", this::getPitch, null);
        builder.addDoubleProperty("3D Roll", this::getRoll, null);
    }
}
