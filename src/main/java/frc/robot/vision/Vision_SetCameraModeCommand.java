/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.vision;

import frc.robot.components.IVision;

/**
 * Add your docs here.
 */
public class Vision_SetCameraModeCommand extends Vision_BaseCommand {

    private IVision.CameraMode mode;

    public Vision_SetCameraModeCommand(Vision vision, IVision.CameraMode mode) {
        super(vision);
        this.mode = mode;
    }

    @Override
    protected void initialize() {
        vision.setCameraMode(mode);
    }
}
