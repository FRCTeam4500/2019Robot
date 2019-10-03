/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.swerve;

import edu.wpi.first.wpilibj.command.Command;

public abstract class Swerve_BaseCommand extends Command {
    protected Swerve swerve;

    public Swerve_BaseCommand(Swerve swerve) {
        requires(swerve);
        this.swerve = swerve;
    }
}
