/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.hatch;

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

    protected void extendNail() {
        nailPiston.extend();
    }

    protected void retractNail() {
        nailPiston.retract();
    }

    protected void toggleNailExtension() {
        nailPiston.toggleExtension();
    }

    protected void extendPanel() {
        panelPiston.extend();
    }

    protected void retractPanel() {
        panelPiston.retract();
    }

    protected void togglePanelExtension() {
        panelPiston.toggleExtension();
    }

    protected void extendClaw() {
        clawPiston.extend();
    }

    protected void retractClaw() {
        clawPiston.retract();
    }

    protected void toggleClawExtension() {
        clawPiston.toggleExtension();
    }

    @Override
    public void initDefaultCommand() {

    }
}
