// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  //The speed at which the transfer motor runs
  public static double kTransferSpeed = 0.1; //1.0
  //The speed at which the intake motor runs
  public static double kIntakeSpeed = 0.7;
  //The speed at which the shooter motor will attempt to run in units/sec
  public static double kShooterSpeed = 1;
  //The delay before transfer 
  public static double kTransferDelay = 0.5;

  //Ids for inputs through the RIO's DIO
  public static class DIOID {
    public static final int kShooterSensor = 0;
  }

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  //Ids for all talon motor controllers
  public static class IDTalon {
    public static final int kLeftFront = 0;
    public static final int kLeftBack = 1;
    public static final int kRightBack = 2;
    public static final int kRightFront = 3;
  }
  //Ids for all victor motor controllers
  public static class IDVictor {
    public static final int kShooter = 0;
    public static final int kTransfer = 1;
    public static final int kIntake = 2;
  }
}
