/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Hatch_Group_RetractAndUnpop extends CommandGroup {
    /**
    * Add your docs here.
    */
    public Hatch_Group_RetractAndUnpop() {
        addSequential(new Hatch_RetractIntake());
        addSequential(new WaitCommand(0.25));
        addSequential(new Hatch_UnpopHatch());
    }
}
