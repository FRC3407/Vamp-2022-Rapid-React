package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  WPI_TalonSRX leftf = new WPI_TalonSRX(Constants.IDTalon.kLeftFront);
  WPI_TalonSRX leftb = new WPI_TalonSRX(Constants.IDTalon.kLeftBack);
  WPI_TalonSRX rightb = new WPI_TalonSRX(Constants.IDTalon.kRightBack);
  WPI_TalonSRX rightf = new WPI_TalonSRX(Constants.IDTalon.kRightFront);
 
  MotorControllerGroup left_motors = new MotorControllerGroup(leftf, leftb);
  MotorControllerGroup right_motors = new MotorControllerGroup(rightf, rightb);
 
  DifferentialDrive diffDrive = new DifferentialDrive(left_motors, right_motors);

  /** Creates a new ExampleSubsystem. */
  public DriveTrain() 
  {
    left_motors.setInverted(true);
    // FeedbackDevice.CTRE_MagEncoder_Relative
    this.rightf.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    this.leftf.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    
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
