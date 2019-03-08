/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Hatch_Group_Place extends CommandGroup {
    
    public Hatch_Group_Place() {
        addSequential(new Hatch_PanelExtend());        
        addSequential(new Hatch_NailExtend()); 
        addSequential(new Hatch_ClawRetract());       
        addSequential(new WaitCommand(1));
        addSequential(new Hatch_PanelRetract());
        addSequential(new Hatch_NailRetract()); 
        addSequential(new Hatch_ClawRetract());
    }
}
