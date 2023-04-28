// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  PWMVictorSPX intake_motor = new PWMVictorSPX(Constants.IDVictor.kIntake);

  /** Creates a new Intake. */
  public Intake() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  /**
   * Sets the intake speed.
   * @param speed The speed the intake is run at.
   */
  public void setIntake(double speed) {
    intake_motor.set(speed);
  }
}
