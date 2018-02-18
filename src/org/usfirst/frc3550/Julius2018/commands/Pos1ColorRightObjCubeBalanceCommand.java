
package org.usfirst.frc3550.Julius2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class Pos1ColorRightObjCubeBalanceCommand extends CommandGroup {

    public Pos1ColorRightObjCubeBalanceCommand() {
    	//System.out.println("Running Pos1ColorRightObjCubeBalanceCommand");
    	
    	addSequential(new HoldCubeCommand());
    	addSequential(new DriveDistanceCommand(240, DriveDistanceCommand.DRIVE_FORWARD));
    	//Not yet implemented: addSequential(new RotateController(90, 1));    // 0:Left     / 1:Right
    	addSequential(new DriveDistanceCommand(150, DriveDistanceCommand.DRIVE_FORWARD));
    	//Not yet implemented: addSequential(new RotateController(90, 0));
    	addSequential(new DriveDistanceCommand(40,  DriveDistanceCommand.DRIVE_FORWARD));
    	addSequential(new DropCubeCommand());
    }
    
}
