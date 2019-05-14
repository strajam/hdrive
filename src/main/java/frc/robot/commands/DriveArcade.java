package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveArcade extends Command {
  public DriveArcade() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_drive.stop();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() { 
    double fwd = Robot.m_oi.m_main.getRawAxis("DriveForward"); //these 3 refer to JoystickExtreme
    double str = Robot.m_oi.m_main.getRawAxis("DriveStrafe");
    double rot = Robot.m_oi.m_main.getRawAxis("DriveRotation");
    Robot.m_drive.set(fwd, str, rot); //refers to DriveBase
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_drive.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
