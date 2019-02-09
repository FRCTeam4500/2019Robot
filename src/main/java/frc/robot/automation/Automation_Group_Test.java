/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.automation;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class Automation_Group_Test extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Automation_Group_Test() {
    requires(Robot.swerve);
    addSequential(new Automation_SetWheelAngle(0, 0, 1));
    addSequential(new Automation_xAlign());
    addSequential(new Automation_SetWheelAngle(0, 1, 0));
    addSequential(new Automation_xAlign());
  }
}
