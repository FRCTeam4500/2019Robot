/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.vision;

/**
 * Add your docs here.
 */
public class Vision_SetPipelineCommand extends Vision_BaseCommand {

    private int index;

    public Vision_SetPipelineCommand(Vision vision, int index) {
        super(vision);
        this.index = index;
    }

    @Override
    protected void initialize() {
        vision.setPipeline(index);
    }
}
