package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class HomeLifts extends Command {

    boolean finished = false;

    public HomeLifts() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	requires(Robot.rightLift);
	requires(Robot.leftLift);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
	finished = false;
	Robot.rightLift.getPIDController().disable();
	Robot.leftLift.getPIDController().disable();
	
	RobotMap.rightGripIn.set(true);
	RobotMap.rightGripOut.set(false);
	RobotMap.leftGripIn.set(true);
	RobotMap.leftGripOut.set(false);
	
	while (RobotMap.leftZeroSwitch.get() == true)
	    RobotMap.rightLiftMotor.set(0.4);
	RobotMap.rightLiftMotor.set(0.00);
	RobotMap.rightEncoderPrimary.reset();

	while (RobotMap.rightZeroSwitch.get() == true)
	    RobotMap.leftLiftMotor.set(-0.4);
	RobotMap.leftLiftMotor.set(0.00);
	RobotMap.leftEncoderPrimary.reset();
	
	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
	return finished;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
	Robot.rightLift.getPIDController().enable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
