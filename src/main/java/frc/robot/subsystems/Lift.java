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

/**
* Add your docs here.
*/
public class Lift extends Subsystem {
    
    private DoubleSolenoid front, back, middle;
    
    public Lift() {
        back = new DoubleSolenoid(RobotMap.FRONT_LIFT_SOLENOID_FORWARD_CHANNEL,RobotMap.FRONT_LIFT_SOLENOID_REVERSE_CHANNEL);
        front = new DoubleSolenoid(RobotMap.BACK_LIFT_SOLENOID_FORWARD_CHANNEL, RobotMap.BACK_LIFT_SOLENOID_REVERSE_CHANNEL);
        middle = new DoubleSolenoid(2,RobotMap.MIDDLE_LIFT_SOLENOID_FORWARD_CHANNEL, RobotMap.MIDDLE_LIFT_SOLENOID_REVERSE_CHANNEL);
    }
    
    @Override
    public void initDefaultCommand() {
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void extendFront(){
        front.set(Value.kForward);
    }
    
    public void retractFront(){
        front.set(Value.kReverse);
    }
    
    public void toggleFront(){
        if (front.get() == Value.kForward) {
            front.set(Value.kReverse);
        } else {
            front.set(Value.kForward);
        }
    }
    
    public void extendBack(){
        back.set(Value.kForward);
    }
    
    public void retractBack(){
        back.set(Value.kReverse);
    }
    
    public void toggleBack(){
        if (back.get() == Value.kForward) {
            back.set(Value.kReverse);
        } else {
            back.set(Value.kForward);
        }
    }
    
    public void extendMiddle(){
        middle.set(Value.kForward);
    }
    
    public void retractMiddle(){
        middle.set(Value.kReverse);
    }
    
    public void toggleMiddle(){
        if (middle.get()==Value.kForward) {
            middle.set(Value.kReverse);
        } else {
            middle.set(Value.kForward);
        }
    }
}
