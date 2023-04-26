package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  WPI_TalonSRX leftf = new WPI_TalonSRX(0);
  WPI_TalonSRX leftb = new WPI_TalonSRX(1);
  WPI_TalonSRX rightf = new WPI_TalonSRX(3);
  WPI_TalonSRX rightb = new WPI_TalonSRX(2);
  MotorControllerGroup left_motors = new MotorControllerGroup(leftf, leftb);
  MotorControllerGroup right_motors = new MotorControllerGroup(rightf, rightb);
  DifferentialDrive diffDrive = new DifferentialDrive(left_motors, right_motors);

  /** Creates a new ExampleSubsystem. */
  public DriveTrain() 
  {
    left_motors.setInverted(true);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void arcadeDrive(double speed, double rotation)
  {
      diffDrive.arcadeDrive(speed, rotation);
  }
}
