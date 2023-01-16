package frc.robot.commands;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDriveCommand extends CommandBase {

private final DriveSubsystem driveSubsystem;
private final Joystick joystick;

  public ArcadeDriveCommand(Joystick joystick, DriveSubsystem driveSubsystem) {
    addRequirements(driveSubsystem);
    this.driveSubsystem = driveSubsystem;
    this.joystick = joystick;
  }

  @Override
public void initialize() {
    
  }

  @Override
public void execute() {
    driveSubsystem.move(-joystick.getX(), joystick.getY());
  }

  @Override
public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
      driveSubsystem.stop();
  }
}
