package frc.robot.subsystems;

import java.lang.annotation.Documented;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Transfer extends SubsystemBase {
  private final double transfer_speed = Constants.kTransferSpeed;
  PWMVictorSPX transfer_motor = new PWMVictorSPX(Constants.IDVictor.kTransfer);

  /** Creates a new Transfer. */
  public Transfer() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Runs the transfer at kTransferSpeed.
   */
  public void runTransfer()
  {
    transfer_motor.set(transfer_speed);
  }

  /**
   * Sets the transfer speed to 0.0.
   */
  public void stopTransfer()
  {
    transfer_motor.set(0.0);
  }
}
