package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

  public static final TalonSRX frontLeft = new TalonSRX(0);
  public static final TalonSRX backLeft = new TalonSRX(2);
  public static final TalonSRX frontRight = new TalonSRX(1);
  public static final TalonSRX backRight = new TalonSRX(3);
  public static final DiffDrive drive = new DiffDrive(frontLeft, backLeft, frontRight, backRight);

  public DriveSubsystem() {}



  public void move(double linearSpeed, double rotate) {
    drive.arcadeDrive(linearSpeed, rotate);
  }

  public void stop() {
    drive.arcadeDrive(0, 0);
  }
}
