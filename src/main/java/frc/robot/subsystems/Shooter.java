// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.ShootCommand;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;

public class Shooter extends SubsystemBase {
  PWMVictorSPX shooter_motor = new PWMVictorSPX(Constants.IDVictor.kShooter);
  public static final DigitalInput m_shooter_sensor = new DigitalInput(Constants.DIOID.kShooterSensor);
  private Counter m_counter;
  public double rate;
  /** Creates a new Shooter. */
  public Shooter() 
  {
    shooter_motor.setInverted(true);
    m_counter = new Counter(m_shooter_sensor);
    m_counter.setExternalDirectionMode();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Sets the shooter speed.
   * @param speed The speed the shooter is run at.
   */
  public void setShooter(double speed)
  {
    shooter_motor.set(speed);
  }

  public void resetCounter()
  {
    m_counter.reset();
  }

  // public double getRate()
  // {
  //   return m_counter.getRate();
  // }

  public double getCounts()
  {
    return m_counter.get();
  }
  @Override
  public void initSendable(SendableBuilder builder) {
    super.initSendable(builder);
    builder.addDoubleProperty("shooterRate", this::getRate, null);
    builder.addDoubleProperty("shooterCurrent", this.shooter_motor::get, null);
  }

  public double getRate()
  {
    return rate;
  }

  public void setRate(double rate)
  {
    this.rate = rate;
  }
}
