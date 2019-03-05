/*----------------------------------------------------------------------------*/
/* Copy//right (c) 2018 FIRST. All //rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
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

    public Hatch(){
        //left = new DoubleSolenoid(RobotMap.LEFT_HATCH_SOLENOID_FORWARD_CHANNEL, RobotMap.LEFT_HATCH_SOLENOID_REVERSE_CHANNEL);
        panelPiston = new DoubleSolenoid(RobotMap.HATCH_PANEL_SOLENOID_FORWARD_CHANNEL,RobotMap.HATCH_PANEL_SOLENOID_REVERSE_CHANNEL);
        nailPiston = new DoubleSolenoid(RobotMap.HATCH_NAIL_SOLENOID_FORWARD_CHANNEL, RobotMap.HATCH_NAIL_SOLENOID_REVERSE_CHANNEL);
        clawPiston = new DoubleSolenoid( RobotMap.HATCH_CLAW_SOLENOID_FORWARD_CHANNEL,RobotMap.HATCH_CLAW_SOLENOID_REVERSE_CHANNEL);
    }
    @Override
    public void initDefaultCommand() {
        // setDefaultCommand(new MySpecialCommand());
    }

    public void extendnailPiston(){
        nailPiston.set(Value.kForward);
    }

    public void retractnailPiston(){
        nailPiston.set(Value.kReverse);
    }
    public void togglenailPiston(){
        if(nailPiston.get() == Value.kForward){
            nailPiston.set(Value.kReverse);
        } else {
            nailPiston.set(Value.kForward);
        }

    }
   
    public void extendclawPiston(){
        clawPiston.set(Value.kForward);
    }
    
    public void retractclawPiston(){
        clawPiston.set(Value.kReverse);
    }

   
   
    public void toggleclawPiston (){
        if (clawPiston.get() == Value.kForward){
            clawPiston.set(Value.kReverse);
        } else {
            clawPiston.set(Value.kForward);
        }
        
    }
    public void extendSides(){
        panelPiston.set(Value.kForward);
    }

    public void retractSides(){
        //left.set(Value.kReverse);
        //right.set(Value.kReverse);
        panelPiston.set(Value.kReverse);
    }

    public void togglepanelPiston(){
        if(panelPiston.get() == Value.kForward){//right.get() == Value.kForward){
            //left.set(Value.kReverse);
            //right.set(Value.kReverse);
            panelPiston.set(Value.kReverse);
        } else {
            //left.set(Value.kForward);
            //right.set(Value.kForward);
            panelPiston.set(Value.kForward);
        }
    }
    
}
