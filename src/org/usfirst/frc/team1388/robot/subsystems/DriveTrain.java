package org.usfirst.frc.team1388.robot.subsystems;

import org.usfirst.frc.team1388.robot.RobotMap;
import org.usfirst.frc.team1388.robot.commands.Drive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	VictorSPX steerMotor = RobotMap.steerMotor;
	TalonSRX driveMotor = RobotMap.driveMotor;
	AnalogInput steerEncoder = RobotMap.steerEncoder;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Drive());
    	
    }
}

