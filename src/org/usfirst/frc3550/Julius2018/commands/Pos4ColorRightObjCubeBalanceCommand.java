
package org.usfirst.frc3550.Julius2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class Pos4ColorRightObjCubeBalanceCommand extends CommandGroup {

    public Pos4ColorRightObjCubeBalanceCommand() {
    	//System.out.println("Running Pos4ColorRightObjCubeBalanceCommand.java");
        
    	addSequential(new HoldCubeCommand());
    	addSequential(new DriveDistanceCommand(325, DriveDistanceCommand.DRIVE_FORWARD));
    	//Not yet implemented: addSequential(new RotateController(90,   1));    // 0:Left     / 1:Right
    	addSequential(new DriveDistanceCommand(7,   DriveDistanceCommand.DRIVE_FORWARD));
    	addSequential(new DropCubeCommand());
    }
}
