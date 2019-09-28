/*----------------------------------------------------------------------------*/
/* Copy//right (c) 2018 FIRST. All //rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/*
 * Add your docs here.
 */
public class Hatch extends Subsystem {

    private DoubleSolenoid nailPiston, panelPiston, clawPiston;

    public Hatch() {
        panelPiston = new DoubleSolenoid(0, RobotMap.HATCH_PANEL_SOLENOID_FORWARD_CHANNEL,
                RobotMap.HATCH_PANEL_SOLENOID_REVERSE_CHANNEL);
        nailPiston = new DoubleSolenoid(0, RobotMap.HATCH_NAIL_SOLENOID_FORWARD_CHANNEL,
                RobotMap.HATCH_NAIL_SOLENOID_REVERSE_CHANNEL);
        clawPiston = new DoubleSolenoid(1, RobotMap.HATCH_CLAW_SOLENOID_FORWARD_CHANNEL,
                RobotMap.HATCH_CLAW_SOLENOID_REVERSE_CHANNEL);
    }

    @Override
    public void initDefaultCommand() {
        // setDefaultCommand(new MySpecialCommand());
    }

    public void extendNail() {
        nailPiston.set(Value.kForward);
    }

    public void retractNail() {
        nailPiston.set(Value.kReverse);
    }

    public void toggleNail() {
        if (nailPiston.get() == Value.kForward) {
            nailPiston.set(Value.kReverse);
        } else {
            nailPiston.set(Value.kForward);
        }
    }

    public void extendClaw() {
        clawPiston.set(Value.kForward);
    }

    public void retractClaw() {
        clawPiston.set(Value.kReverse);
    }

    public void toggleClaw() {
        if (clawPiston.get() == Value.kForward) {
            clawPiston.set(Value.kReverse);
        } else {
            clawPiston.set(Value.kForward);
        }
    }

    public void extendPanel() {
        panelPiston.set(Value.kForward);
    }

    public void retractPanel() {
        panelPiston.set(Value.kReverse);
    }

    public void togglePanel() {
        if (panelPiston.get() == Value.kForward) {
            panelPiston.set(Value.kReverse);
        } else {
            panelPiston.set(Value.kForward);
        }
    }

}
