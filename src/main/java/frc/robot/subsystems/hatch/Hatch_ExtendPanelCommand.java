/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.hatch;

/**
 * Add your docs here.
 */
public class Hatch_ExtendPanelCommand extends Hatch_BaseCommand {

    public Hatch_ExtendPanelCommand(Hatch hatch) {
        super(hatch);
    }

    @Override
    protected void initialize() {
        hatch.extendPanel();
    }
}