// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {
public Joystick joystick = new Joystick(0);
public static final DriveSubsystem driveSubsystem = new DriveSubsystem();
  public RobotContainer() {
    joystick.setYChannel(Axis.RIGHT_Y.id);
    joystick.setXChannel(Axis.LEFT_X.id);
    driveSubsystem.setDefaultCommand(new ArcadeDriveCommand(joystick, driveSubsystem));
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }


  public enum Axis {
    LEFT_X(1),
    LEFT_Y(0),
    RIGHT_X(5),
    RIGHT_Y(4),
    TUNER(0),
    LEFT_TRIGGER(2),
    RIGHT_TRIGGER(3);

    private final int id;
    Axis(int id){
      this.id = id;
    }
  }

  public enum Shoulder {
    LEFT(5),
    RIGHT(6);

    private final int id;

    Shoulder(int id){
      this.id = id;
    }
  }

  public enum Button{
    A(1),
    B(2),
    X(3),
    Y(4),
    START(7),
    BACK(8);

    private final int id;
    Button(int id){
      this.id = id;
    }
  }

  public double leftYAxis(){
    return joystick.getRawAxis(1)*-1;
  }

  public double rightXAxis(){
    return joystick.getRawAxis(2);
  }
}
