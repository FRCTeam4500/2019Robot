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

public class Auto_GetOffHAB extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Auto_GetOffHAB() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    
    // addSequential(new Command2());
    // these will run in order.
    addSequential(new Swerve_GyroSet(-180));
    addSequential(new Automation_DriveSwerve(0,-0.25,0));
    addSequential(new WaitCommand(0.5));
    addSequential(new Lift_ExtendBack());
    addSequential(new WaitCommand(0.5));
    addSequential(new Lift_ExtendFront());//this should happen while robot is in midair
    addSequential(new WaitCommand(0.5));
    addParallel(new Automation_DriveSwerve(0,-0,0));
    addParallel(new Lift_RetractBack());
    addParallel(new Lift_RetractFront());
    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}