package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DiffDrive {

  private final TalonSRX f_left;
  private final TalonSRX b_left;
  private final TalonSRX f_right;
  private final TalonSRX b_right;
  private final double speedCap = 0.75;

  public DiffDrive(TalonSRX fl, TalonSRX bl, TalonSRX fr, TalonSRX br) {
    f_left = fl;
    b_left = bl;
    f_right = fr;
    b_right = br;
  }

  public void arcadeDrive(double speed, double rotation) {
    double leftSpeed;
    double rightSpeed;

    speed = Math.copySign(speed * speed, speed);
    rotation = Math.copySign(rotation * rotation, rotation);

    double max = Math.copySign(Math.max(Math.abs(speed), Math.abs(rotation)), speed);

    if (speed >= 0) {
      if (rotation >= 0) {
        leftSpeed = max;
        rightSpeed = speed - rotation;
      } else {
        leftSpeed = speed + rotation;
        rightSpeed = max;
      }
    } else {
      if (rotation >= 0) {
        leftSpeed = speed + rotation;
        rightSpeed = max;
      } else {
        leftSpeed = max;
        rightSpeed = speed - rotation;
      }
    }

    moveLeft(leftSpeed * speedCap);
    moveRight(rightSpeed * speedCap);
  }

  public void moveLeft(double s) {
    f_left.set(ControlMode.PercentOutput, s);
    b_left.set(ControlMode.PercentOutput, s);
  }

  public void moveRight(double s) {
    f_right.set(ControlMode.PercentOutput, s);
    b_right.set(ControlMode.PercentOutput, s);
  }
}
