/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.components.hardware;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.components.IVision;

/**
 * Add your docs here.
 */
public class LimelightVisionComponent implements IVision {

    private NetworkTable table;

    public LimelightVisionComponent() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
    }

    @Override
    public boolean hasValidTargets() {
        double value = getEntry("tv");
        if (value == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getHorizontalOffsetFromCrosshair() {
        return getEntry("tx");
    }

    @Override
    public double getVerticalOffsetFromCrosshar() {
        return getEntry("ty");
    }

    @Override
    public double getTargetArea() {
        return getEntry("ta");
    }

    @Override
    public double getSkew() {
        return getEntry("ts");
    }

    @Override
    public void setCameraMode(CameraMode mode) {
        if (mode == CameraMode.DriverCamera) {
            setEntry("camMode", 1);
        } else if (mode == CameraMode.VisionProcessor) {
            setEntry("camMode", 0);
        } // Maybe add exception for bad entry
    }

    @Override
    public void setPipeline(int index) {
        setEntry("pipeline", index);
    }

    private double getEntry(String key) {
        return table.getEntry(key).getDouble(0);
    }

    private void setEntry(String key, Number value) {
        table.getEntry(key).setNumber(value);
    }
}
