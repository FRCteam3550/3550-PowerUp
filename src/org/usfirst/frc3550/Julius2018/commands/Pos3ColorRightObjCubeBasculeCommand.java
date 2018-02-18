
package org.usfirst.frc3550.Julius2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class Pos3ColorRightObjCubeBasculeCommand extends CommandGroup {

    public Pos3ColorRightObjCubeBasculeCommand() {
    	//System.out.println("Running Pos3ColorRightObjCubeBasculeCommand.java");
        
    	addSequential(new HoldCubeCommand());
    	addSequential(new DriveDistanceCommand(140, DriveDistanceCommand.DRIVE_FORWARD));
    	addSequential(new DropCubeCommand());
    }
}
