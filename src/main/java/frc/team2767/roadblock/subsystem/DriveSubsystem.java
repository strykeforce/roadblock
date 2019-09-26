package frc.team2767.roadblock.subsystem;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2767.roadblock.command.ArcadeDriveCommand;

public class DriveSubsystem extends Subsystem {

  public static final TalonSRX frontLeft = new TalonSRX(0);
  public static final TalonSRX backLeft = new TalonSRX(2);
  public static final TalonSRX frontRight = new TalonSRX(1);
  public static final TalonSRX backRight = new TalonSRX(3);
  public static final DiffDrive drive = new DiffDrive(frontLeft, backLeft, frontRight, backRight);

  public DriveSubsystem() {}

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new ArcadeDriveCommand());
  }

  public static void move(double linearSpeed, double rotate) {
    drive.arcadeDrive(linearSpeed, rotate);
  }

  public static void stop() {
    drive.arcadeDrive(0, 0);
  }
}
