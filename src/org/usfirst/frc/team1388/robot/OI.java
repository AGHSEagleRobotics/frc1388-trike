/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1388.robot;

import edu.wpi.first.wpilibj.XboxController;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	private XboxController driveController;
    //private XboxController opController;
    public OI() {
        driveController = new XboxController(0);
        //opController = new XboxController(1);
    }

    public XboxController getDriveController() {
    	return driveController;
    }
  /*  
    public XboxController getOpController() {
    	return opController;
    }*/
    
    //TODO add a deadband that works
    //double deadBandAmount = 0.05;
    public static double deadBand(double deadBandAmount, double x) {
    	if(Math.abs(x) < deadBandAmount) {
    		x = 0;
    	}
    	return x;
    }
    
    //takes two joystick axis inputs, converts them into a target angle, normalized to 0 to 360
    public static double getTargetAngle(double axisX, double axisY) {
    	double targetAngle = Math.atan2(axisX, -axisY);
    	
    	targetAngle *= 180/Math.PI;

    	if( targetAngle < 0 ){
    		return targetAngle + 360;
    	}
    	
    	return targetAngle;
    }
    
}
