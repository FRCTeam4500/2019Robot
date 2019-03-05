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
    
    private DoubleSolenoid center, outside, clawPiston;

    public Hatch(){
        //left = new DoubleSolenoid(RobotMap.LEFT_HATCH_SOLENOID_FORWARD_CHANNEL, RobotMap.LEFT_HATCH_SOLENOID_REVERSE_CHANNEL);
        outside = new DoubleSolenoid(RobotMap.OUTSIDE_HATCH_SOLENOID_FORWARD_CHANNEL,RobotMap.OUTSIDE_HATCH_SOLENOID_REVERSE_CHANNEL);
        center = new DoubleSolenoid(RobotMap.CENTER_HATCH_SOLENOID_FORWARD_CHANNEL, RobotMap.CENTER_HATCH_SOLENOID_REVERSE_CHANNEL);
        clawPiston = new DoubleSolenoid( RobotMap.HATCH_GRAB_SOLENOID_FORWARD_CHANNEL,RobotMap.HATCH_GRAB_SOLENOID_REVERSE_CHANNEL);
    }
    @Override
    public void initDefaultCommand() {
        // setDefaultCommand(new MySpecialCommand());
    }

    public void extendCenter(){
        center.set(Value.kForward);
    }

    public void retractCenter(){
        center.set(Value.kReverse);
    }
    public void toggleCenter(){
        if(center.get() == Value.kForward){
            center.set(Value.kReverse);
        } else {
            center.set(Value.kForward);
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
        outside.set(Value.kForward);
    }

    public void retractSides(){
        //left.set(Value.kReverse);
        //right.set(Value.kReverse);
        outside.set(Value.kReverse);
    }

    public void toggleOutside(){
        if(outside.get() == Value.kForward){//right.get() == Value.kForward){
            //left.set(Value.kReverse);
            //right.set(Value.kReverse);
            outside.set(Value.kReverse);
        } else {
            //left.set(Value.kForward);
            //right.set(Value.kForward);
            outside.set(Value.kForward);
        }
    }
    
}
