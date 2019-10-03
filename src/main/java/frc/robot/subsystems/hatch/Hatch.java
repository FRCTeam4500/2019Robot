/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.hatch;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.components.IDoubleSolenoid;

/**
 * Add your docs here.
 */
public class Hatch extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private IDoubleSolenoid nailPiston, panelPiston, clawPiston;

    public Hatch(IDoubleSolenoid nailPiston, IDoubleSolenoid panelPiston,
            IDoubleSolenoid clawPiston) {
        this.nailPiston = nailPiston;
        this.panelPiston = panelPiston;
        this.clawPiston = clawPiston;
    }

    public void extendNail() {
        nailPiston.extend();
    }

    public void retractNail() {
        nailPiston.retract();
    }

    public void toggleNailExtension() {
        nailPiston.toggleExtension();
    }

    public void extendPanel() {
        panelPiston.extend();
    }

    public void retractPanel() {
        panelPiston.retract();
    }

    public void togglePanelExtension() {
        panelPiston.toggleExtension();
    }

    public void extendClaw() {
        clawPiston.extend();
    }

    public void retractClaw() {
        clawPiston.retract();
    }

    public void toggleClawExtension() {
        clawPiston.toggleExtension();
    }

    @Override
    public void initDefaultCommand() {

    }
}
