package frc.team2767.roadblock.command;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2767.roadblock.Robot;
import frc.team2767.roadblock.control.GameControls;
import frc.team2767.roadblock.subsystem.DriveSubsystem;

public class ArcadeDriveCommand extends Command {

  private static final DriveSubsystem DRIVE = Robot.DRIVE;
  private static GameControls controls;

  public ArcadeDriveCommand() {
    requires(DRIVE);
  }

  @Override
  protected void initialize() {
    controls = Robot.CONTROLS.getGameControls();
  }

  @Override
  protected void execute() {
    DRIVE.move(controls.leftYAxis(), controls.rightXAxis());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    DRIVE.stop();
  }
}
