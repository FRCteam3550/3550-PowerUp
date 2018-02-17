//// RobotBuilder Version: 2.0
////
//// This file was generated by RobotBuilder. It contains sections of
//// code that are automatically generated and assigned by robotbuilder.
//// These sections will be updated in the future when you export to
//// Java from RobotBuilder. Do not put any code or make any change in
//// the blocks indicating autogenerated code or it will be lost on an
//// update. Deleting the comments indicating the section will prevent
//// it from being updated in the future.
//
//package org.usfirst.frc3550.Julius2018.commands;
//
//import org.usfirst.frc3550.Julius2018.Robot;
//
////import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.command.CommandGroup;
//
////public final float INCHES2MM = 25.4;
//
///**
// *
// */
//public class Pos2ColorRightObjCubeBascule2Command extends CommandGroup {
//
//    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
// 
//    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
//
//    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
//    public Pos2ColorRightObjCubeBascule2Command() {
//
//    	addSequential(new DriveDistanceCommand(60, 1)); // 0:Backward / 1:Forward
//    	addSequential(new RotateController(90, 1));    // 0:Left     / 1:Right
//    	addSequential(new DriveDistanceCommand(50,  1)); // 0:Backward / 1:Forward
//    	addSequential(new RotateController(90, 0));
//    	addSequential(new DriveDistanceCommand(80, 1));
//    	addSequential(new OuvrePince());
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    	System.out.println("Running Pos2ColorRightObjCubeBascule2Command.java");
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}
