/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.arm.IArmOI;
import frc.robot.cargo.ICargoOI;
import frc.robot.swerve.ISwerveOI;

/**
 * Add your docs here.
 */
public interface IMainOI extends ISwerveOI, ICargoOI, IArmOI {
}
