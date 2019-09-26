package frc.team2767.roadblock;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team2767.roadblock.control.Controls;
import frc.team2767.roadblock.subsystem.DriveSubsystem;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.strykeforce.thirdcoast.telemetry.TelemetryController;
import org.strykeforce.thirdcoast.telemetry.TelemetryService;

public class Robot extends TimedRobot {

  // Instantiate this before Subsystems because they use telemetry service.
  public static final TelemetryService TELEMETRY = new TelemetryService(TelemetryController::new);

  public static DriveSubsystem DRIVE;
  public static Controls CONTROLS;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public void robotInit() {
    logger.info("Today is {}", new Date());

    DRIVE = new DriveSubsystem();
    CONTROLS = new Controls();

    TELEMETRY.start();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }
}
