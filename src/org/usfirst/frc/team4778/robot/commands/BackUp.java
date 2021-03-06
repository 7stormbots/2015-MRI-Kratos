package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class BackUp extends Command {

    boolean finished = false;

    public BackUp() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
	finished = false;
	// for (int i=0; i<10; i++) {
	// Robot.drive.arcadeDrive(0.75, 0);
	// Timer.delay(0.05);
	// }
	Timer.delay(0.15);
	RobotMap.rightDriveEncoder.reset();
	while (RobotMap.rightDriveEncoder.getDistance() < 18)
	    Robot.drive.arcadeDrive(0.75, 0);
	Robot.drive.arcadeDrive(0, 0);
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
	Robot.drive.arcadeDrive(0, 0);
	end();
    }
}
