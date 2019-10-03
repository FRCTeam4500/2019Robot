/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.cargo;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Add your docs here.
 */
public class Cargo_SetMotorsCommand extends InstantCommand {
    /**
     * Add your docs here.
     */
    private Cargo cargo;
    double sideSpeed, topSpeed;

    public Cargo_SetMotorsCommand(Cargo cargo, double sideSpeed, double topSpeed) {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(cargo);
        this.cargo = cargo;
        this.sideSpeed = sideSpeed;
        this.topSpeed = topSpeed;
    }

    // Called once when the command executes
    @Override
    protected void initialize() {
        cargo.setMotors(sideSpeed, topSpeed);
    }

}
