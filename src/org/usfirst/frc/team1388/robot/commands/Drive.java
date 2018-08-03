/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1388.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1388.robot.Robot;
import org.usfirst.frc.team1388.robot.RobotMap;
import org.usfirst.frc1388.lib.SwerveModule;

/**
 * An example command.  You can replace me with your own command.
 */
public class Drive extends Command {
	public Drive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double speedY = Robot.oi.getDriveController().getY(Hand.kRight);
		double axisY = Robot.oi.getDriveController().getY(Hand.kLeft);
		double axisX = Robot.oi.getDriveController().getX(Hand.kLeft);
		
		
		
		RobotMap.driveTrainSwerveDrive.setDrivePwr(Robot.oi.deadBand(.05, speedY));
		RobotMap.driveTrainSwerveDrive.setSteerAngle(targetAngle);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		RobotMap.driveTrainSwerveDrive.setDrivePwr(0.0);
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
