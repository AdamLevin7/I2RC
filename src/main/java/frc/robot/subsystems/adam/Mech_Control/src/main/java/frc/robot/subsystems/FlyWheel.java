// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyWheel extends SubsystemBase {

  private final WPI_TalonSRX _flyWheelTalon;



  /** Creates a new DriveTrain. */
  public FlyWheel() {
    _flyWheelTalon = new WPI_TalonSRX(Constants.FlyWheelPortNumber.FlyWheelPort);
    _flyWheelTalon.setInverted(false);
    _flyWheelTalon.configFactoryDefault();
    _flyWheelTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0, 10);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    _flyWheelTalon.set(ControlMode.PercentOutput, RobotContainer.getJoystick().getY()); 
  }
  public double getEncoderVelocityTicksPerSecond(){
    return _flyWheelTalon.getSensorCollection().getPulseWidthVelocity()/4096.0*3.99;
  }
  public void resetEncoders() {
    _flyWheelTalon.setSelectedSensorPosition(0, 0, 10);
    
  }
}
