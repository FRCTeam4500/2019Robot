/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Hatch_Group_Grab extends CommandGroup {
    
    public Hatch_Group_Grab() {
        addSequential(new Arm_SetRotation(0));
        addSequential(new Hatch_ClawExtend());        
        addSequential(new Hatch_PanelExtend());        
        addSequential(new WaitCommand(.25));
        addSequential(new Hatch_ClawRetract());
        addSequential(new WaitCommand(.25));        
        addSequential(new Elevator_SetLevel(4000));        
    }
}
    