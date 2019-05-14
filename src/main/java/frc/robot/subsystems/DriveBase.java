package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class DriveBase extends Subsystem { //sets up talons
  public WPI_TalonSRX Drive1 = new WPI_TalonSRX(1);
  public WPI_TalonSRX Drive2 = new WPI_TalonSRX(2);
  public WPI_TalonSRX Drive3 = new WPI_TalonSRX(3);

  public void set(double forward, double strafe, double rotate){
    if(rotate>0.1){ //prevents rotation under 10%
      Drive1.set(ControlMode.PercentOutput, rotate);
      Drive2.set(ControlMode.PercentOutput, -rotate);
    }
    else{
    Drive1.set(ControlMode.PercentOutput, forward); //goes forward
    Drive2.set(ControlMode.PercentOutput, forward); //goes forward
    Drive3.set(ControlMode.PercentOutput, strafe); //goes sideways w/o turning
    }
  }
  public void stop(){
    Drive1.set(ControlMode.PercentOutput, 0);
    Drive2.set(ControlMode.PercentOutput, 0);
    Drive3.set(ControlMode.PercentOutput, 0);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
