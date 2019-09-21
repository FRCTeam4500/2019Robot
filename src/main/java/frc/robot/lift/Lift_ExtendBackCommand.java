/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.lift;

/**
 * Add your docs here.
 */
public class Lift_ExtendBackCommand extends Lift_BaseCommand {

    public Lift_ExtendBackCommand(Lift lift) {
        super(lift);
    }

    @Override
    protected void initialize() {
        lift.extendBack();
    }

}
