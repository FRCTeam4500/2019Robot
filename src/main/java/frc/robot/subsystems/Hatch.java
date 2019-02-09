/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
* Add your docs here.
*/
public class Hatch extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  private DoubleSolenoid left, right, center;
  public Hatch(){
    left = new DoubleSolenoid(RobotMap.LEFT_HATCH_SOLENOID_FORWARD_CHANNEL, RobotMap.LEFT_HATCH_SOLENOID_REVERSE_CHANNEL);
    right = new DoubleSolenoid(RobotMap.RIGHT_HATCH_SOLENOID_FORWARD_CHANNEL,RobotMap.RIGHT_HATCH_SOLENOID_REVERSE_CHANNEL);
    center = new DoubleSolenoid(RobotMap.MIDDLE_HATCH_SOLENOID_FORWARD_CHANNEL, RobotMap.MIDDLE_HATCH_SOLENOID_REVERSE_CHANNEL);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
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
    }else{
      center.set(Value.kForward);
    }
  }
  
  public void extendSides(){
    left.set(Value.kForward);
    right.set(Value.kForward);
  }
  public void retractSides(){
    left.set(Value.kReverse);
    right.set(Value.kReverse);
  }
  public void toggleSides(){
    if(left.get() == Value.kForward){
      left.set(Value.kReverse);
      right.set(Value.kReverse);
    }else{
      left.set(Value.kForward);
      left.set(Value.kForward);
    }
  }
  
}
