/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.automation.Automation_DriveSwerve;

public class Auto_Group_GetOffHAB extends CommandGroup {
    /**
    * Add your docs here.
    */
    public Auto_Group_GetOffHAB() {
        addSequential(new Swerve_GyroSet(-180));
        addSequential(new Lift_ExtendFront());
        addSequential(new Automation_DriveSwerve(0,-0.45,0));
        
        addSequential(new WaitCommand(0.6));
        addSequential(new Lift_ExtendBack()); // this should happen while robot is in midair
        addSequential(new WaitCommand(1));
        addParallel(new Automation_DriveSwerve(0,-0,0));
        addSequential(new Lift_RetractBack());
        addParallel(new Lift_RetractFront());
    }
}
