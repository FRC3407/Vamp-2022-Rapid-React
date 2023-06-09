// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  PWMVictorSPX shooter_motor = new PWMVictorSPX(Constants.IDVictor.kShooter);
  /** Creates a new Shooter. */
  public Shooter() 
  {
    shooter_motor.setInverted(true);
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
}
