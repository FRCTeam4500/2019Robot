/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Hatch_Group_Grab extends CommandGroup {
    
    public Hatch_Group_Grab() {
        addSequential(new Hatch_ClawExtend());        
        addSequential(new Hatch_PanelExtend());        
        addSequential(new Hatch_ClawRetract());        
        addSequential(new Elevator_SetLevel(1000));        
    }
}
