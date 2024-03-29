// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3550.Julius2018;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3550.Julius2018.commands.*;
import org.usfirst.frc3550.Julius2018.subsystems.*;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends IterativeRobot {


	public static OI oi;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static DriveTrain driveTrain;
	public static PinceSubsystem pinceSubsystem;
	public static DigitalInput Cubedetect;
	public static GearsHandler gearsHandler;
	
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	//
	// AUTONOMOUS VARIABLES
	//
    Command autonomousCommand;
	public Command[] autonomousCommandArray;
	
	public final int AUTOCHOOSER_NB_OBJECTIVE          = 10;
	public final int AUTOCHOOSER_NB_COLORPOSITION      = 4;
	public final int AUTOCHOOSER_NB_POSITION           = 5;
	public final int AUTOCHOOSER_NB_TOTAL              = AUTOCHOOSER_NB_POSITION * AUTOCHOOSER_NB_COLORPOSITION * AUTOCHOOSER_NB_OBJECTIVE;
	
	public final int AUTOCHOOSER_POSITION_ENCODER      = AUTOCHOOSER_NB_OBJECTIVE*AUTOCHOOSER_NB_COLORPOSITION; //Le nombre multiplier par la position pour le selecteur d'autonomous
	public final int AUTOCHOOSER_COLORPOSITION_ENCODER = AUTOCHOOSER_NB_OBJECTIVE;  //Le nombre multiplier par la couleur pour le selecteur d'autonomous
	public final int AUTOCHOOSER_OBJECTIVE_ENCODER     = 1; //Le nombre multiplier par l'objectif pour le selecteur d'autonomous 
	
    public SendableChooser<Integer> PositionRobotAuto;
	public SendableChooser<Integer> ActionAutonome;
	public SendableChooser<Command> CommandeBrutAuto;

    public int CoteBasculeAuto;
	public int CoteBalanceAuto;

	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
    	RobotMap.init();
    	// SmartDashboard.putData(driveTrain);
    	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	driveTrain = new DriveTrain();
    	pinceSubsystem = new PinceSubsystem();
    	gearsHandler = new GearsHandler();
        //Cubedetect = new DigitalInput();
        CameraServer.getInstance().startAutomaticCapture();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();


        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
	    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
	
		//
		// Sets the autonomous commands to be ready for use
		//
        autonomousCommandArray = new Command[AUTOCHOOSER_NB_TOTAL];
		autonomousCommandArrayInit();
		
		// > Starting position < combobox
        PositionRobotAuto = new SendableChooser<>();
        
		PositionRobotAuto.addDefault("OverrideCommandeManuel", (Integer)(0 * AUTOCHOOSER_POSITION_ENCODER));
		PositionRobotAuto.addObject ("position 1",             (Integer)(1 * AUTOCHOOSER_POSITION_ENCODER));
		PositionRobotAuto.addObject ("position 2",             (Integer)(2 * AUTOCHOOSER_POSITION_ENCODER));
		PositionRobotAuto.addObject ("position 3",             (Integer)(3 * AUTOCHOOSER_POSITION_ENCODER));
		PositionRobotAuto.addObject ("position 4",             (Integer)(4 * AUTOCHOOSER_POSITION_ENCODER));
		
		SmartDashboard.putData("Position robot autonome", PositionRobotAuto);
		
		// > Objective < combobox
		ActionAutonome = new SendableChooser<>();
		
		ActionAutonome.addDefault("Rien Faire",                (Integer)(0  * AUTOCHOOSER_OBJECTIVE_ENCODER));
		ActionAutonome.addObject("AutoLine",                 (Integer)(1  * AUTOCHOOSER_OBJECTIVE_ENCODER));
		ActionAutonome.addObject("Bascule",            (Integer)(2  * AUTOCHOOSER_OBJECTIVE_ENCODER));
		ActionAutonome.addObject("Bascule special", (Integer)(3  * AUTOCHOOSER_OBJECTIVE_ENCODER));
		ActionAutonome.addObject("balance",            (Integer)(4  * AUTOCHOOSER_OBJECTIVE_ENCODER));
		//ActionAutonome.addObject("Autre action",      (Integer)(5  * AUTOCHOOSER_OBJECTIVE_ENCODER));
		// Add if need more
		
		SmartDashboard.putData("Objectif autonome", ActionAutonome);
		
		// Auto Commands MANUAL combobox
		CommandeBrutAuto = new SendableChooser<>();
		
		// **faire HYPER attention d'avoir le bon index en modifiant/rajoutant des commandes** 
		
		CommandeBrutAuto.addDefault("Ne fais rien",
				                    autonomousCommandArray[calcID(0, 0, 1)]);
				
		// Auto-line (Objective #1)
		CommandeBrutAuto.addObject ("Auto-line",
		                            autonomousCommandArray[calcID(1, 0, 1)]);
		
		
		//Cube dans la Bascule (Objective #2 et special #3)
		CommandeBrutAuto.addObject ("Bascule @ bascule Gauche @ Pos 1", 
		                            autonomousCommandArray[calcID(1, 0, 2)]); 
		CommandeBrutAuto.addObject ("Bascule @ bascule Gauche @ Pos 2a", 
		                            autonomousCommandArray[calcID(2, 0, 2)]);
		CommandeBrutAuto.addObject ("Bascule @ bascule Gauche @ Pos 2b", 
		                            autonomousCommandArray[calcID(2, 0, 3)]);
		CommandeBrutAuto.addObject ("Bascule @ bascule Gauche @ Pos 3", 
		                            autonomousCommandArray[calcID(3, 0, 2)]);
		CommandeBrutAuto.addObject ("Bascule @ bascule Gauche @ Pos 4", 
		                            autonomousCommandArray[calcID(4, 0, 2)]);
									
		CommandeBrutAuto.addObject ("Bascule @ bascule Droite @ Pos 1", 
		                            autonomousCommandArray[calcID(1, 1, 2)]); 
		CommandeBrutAuto.addObject ("Bascule @ bascule Droite @ Pos 2a", 
		                            autonomousCommandArray[calcID(2, 1, 2)]);
		CommandeBrutAuto.addObject ("Bascule @ bascule Droite @ Pos 2b", 
		                            autonomousCommandArray[calcID(2, 1, 3)]);
		CommandeBrutAuto.addObject ("Bascule @ bascule Droite @ Pos 3", 
		                            autonomousCommandArray[calcID(3, 1, 2)]);
		CommandeBrutAuto.addObject ("Bascule @ bascule Droite @ Pos 4", 
		                            autonomousCommandArray[calcID(4, 1, 2)]);
		
		// Cube dans la Balance (Objective #4)
		CommandeBrutAuto.addObject ("Balance @ balance Gauche @ Pos 1", 
		                            autonomousCommandArray[calcID(1, 0, 4)]); 
		CommandeBrutAuto.addObject ("Balance @ balance Gauche @ Pos 2", 
		                            autonomousCommandArray[calcID(2, 0, 4)]);
		CommandeBrutAuto.addObject ("Balance @ balance Gauche @ Pos 3", 
		                            autonomousCommandArray[calcID(3, 0, 4)]);
		CommandeBrutAuto.addObject ("Balance @ balance Gauche @ Pos 4", 
		                            autonomousCommandArray[calcID(4, 0, 4)]);
		
		CommandeBrutAuto.addObject ("Balance @ balance Droite @ Pos 1", 
		                            autonomousCommandArray[calcID(1, 2, 4)]); 
		CommandeBrutAuto.addObject ("Balance @ balance Droite @ Pos 2", 
		                            autonomousCommandArray[calcID(2, 2, 4)]);
		CommandeBrutAuto.addObject ("balance @ balance Droite @ Pos 3", 
		                            autonomousCommandArray[calcID(3, 2, 4)]);
		CommandeBrutAuto.addObject ("balance @ balance Droite @ pos 4", 
		                            autonomousCommandArray[calcID(4, 2, 4)]);
		
		//action 5...
		//CommandeBrutAuto.addObject ("action 5 @ bascule gauche balance gauche @ Pos 1", 
		//                            autonomousCommandArray[calcID(1, 0, 5)]); 
		
		
		SmartDashboard.putData("Selection Autonomes", CommandeBrutAuto);

        SmartDashboard.putBoolean("DetectCube", Robot.pinceSubsystem.IsCubeHere());
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
    	// TMP: Testing Trapez command directly
    	System.out.println("start autonomousInit");
    	autonomousCommand = new TrapezDistance();
    	autonomousCommand.start();
    	
    	if (true)
    	   return;
    	
	    //
		// Retrieve selected choices for the autonomous command
    	//
   	    Command CommandeBrutAutoCommand = (Command)CommandeBrutAuto.getSelected();
		int PositionRobotAutoIndex      = (Integer)PositionRobotAuto.getSelected();
		int ActionAutonomeIndex         = (Integer)ActionAutonome.getSelected();
		
		String tempGameData = DriverStation.getInstance().getGameSpecificMessage();
		int CoteBasculeAuto = 0;  // Default 0 = 'L'
		if (tempGameData.charAt(0) == 'R')
		{
			CoteBasculeAuto = 1;
		}
		//
		int CoteBalanceAuto = 0;  // Default 0 = 'L'
		if (tempGameData.charAt(1) == 'R')
		{
			CoteBalanceAuto = 2;
		}
		int configurationCotes = CoteBasculeAuto + CoteBalanceAuto;
		
		//
		// Selecting desired autonomous command
		//
        if (PositionRobotAutoIndex != 0) // Pas ManualOveride...
		{
   		    // Combine values to retrieve Command id
			int commandIndex = PositionRobotAutoIndex + ActionAutonomeIndex + configurationCotes;
			System.out.println("Combining posindex= "+ PositionRobotAutoIndex + 
					           " + obj= " + ActionAutonomeIndex + " + cotes= " + configurationCotes + 
					           " into " + commandIndex);
			
			autonomousCommand = autonomousCommandArray[commandIndex];
		}
		else if (PositionRobotAutoIndex == 0 && CommandeBrutAutoCommand != null ) 
		{
			autonomousCommand = CommandeBrutAutoCommand;
		}
		else 
		{
			System.out.println("An impossible error occurred at the Autonomous Command Choosing step (How did you?!?)");
			System.out.println("Setting autonomousCommand null");
			System.out.println("But really, please find the impossible error and fix it!");
			System.out.println("This error means that CommandeBrutAutoCommand or ActionAutonomeIndex is equals to null");
			System.out.println("This error is in Robot.java");
			System.out.println("Hopes that help fixing the _impossible_ error... ~Nathan");
			//System.out.println("And yes, I have too much time on my hand");
		}
		
		//
		//
		//
		if (autonomousCommand != null)
		{
			System.out.println("Starting Action");
			autonomousCommand.start();
		}
		else
		{
		    System.out.println("Not an existing action");
		}       
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
    	System.out.println("AutonomousPeriodic");
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        driveTrain.reset();
        RobotMap.ahrs.zeroYaw();
    }

    /**
     * This function is called periodically during operator control
     */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log();
	}
	
	//
	//  HELPER FUNCTIONS
	//
	
	private void log() {
		SmartDashboard.putNumber ("Left Distance",     driveTrain.getLeftDistance());
		SmartDashboard.putNumber ("Right Distance",    driveTrain.getRightDistance());
		SmartDashboard.putNumber ("LeftEncoder Rate",  driveTrain.getLeftRate());
		SmartDashboard.putNumber ("RightEncoder Rate", driveTrain.getRightRate());
		SmartDashboard.putBoolean("DetectCube",        Robot.pinceSubsystem.IsCubeHere());
		SmartDashboard.putBoolean("IMU_Connected",     RobotMap.ahrs.isConnected());
        SmartDashboard.putBoolean("IMU_IsCalibrating", RobotMap.ahrs.isCalibrating());
        SmartDashboard.putNumber ("IMU_Yaw",           RobotMap.ahrs.getYaw());
        SmartDashboard.putNumber ("IMU_Pitch",         RobotMap.ahrs.getPitch());
        SmartDashboard.putNumber ("IMU_Roll",          RobotMap.ahrs.getRoll());
	}
	
	public int calcID(int position, int colorConfig, int objective)
	{
		return (position * AUTOCHOOSER_POSITION_ENCODER) + (colorConfig * AUTOCHOOSER_COLORPOSITION_ENCODER) + (objective * AUTOCHOOSER_OBJECTIVE_ENCODER);
	}
	
	public void autonomousCommandArrayInit() //this is where the autonomousCommandArray gets its values, it is CRUCIAL to update it well
	{
		//for (int i = 0; i < 500; i++) 
		//{
		//	autonomousCommandArray[i] = null;
		//}
	
		autonomousCommandArray[calcID(0, 0, 1)] = new NeRienFaireCommand();
		
		//
		// IN SAME ORDER AS IN THE EXCEL STRATEGIC PLAN
		//
		
		autonomousCommandArray[calcID(1, 0, 1)] = new PosXColorXObjAutolineCommand();
		autonomousCommandArray[calcID(1, 2, 1)] = autonomousCommandArray[calcID(1, 0, 1)];
		//
		//autonomousCommandArray[calcID(2, 0, 1)] = autonomousCommandArray[calcID(1, 0, 1)]; // Not used
		//autonomousCommandArray[calcID(2, 2, 1)] = autonomousCommandArray[calcID(1, 0, 1)]; // Not used
		//
		autonomousCommandArray[calcID(3, 0, 1)] = autonomousCommandArray[calcID(1, 0, 1)];
		autonomousCommandArray[calcID(3, 2, 1)] = autonomousCommandArray[calcID(1, 0, 1)];
		//
		autonomousCommandArray[calcID(4, 0, 1)] = autonomousCommandArray[calcID(1, 0, 1)];
		autonomousCommandArray[calcID(4, 2, 1)] = autonomousCommandArray[calcID(1, 0, 1)];
		//
		autonomousCommandArray[calcID(1, 1, 1)] = autonomousCommandArray[calcID(1, 0, 1)];
		autonomousCommandArray[calcID(1, 3, 1)] = autonomousCommandArray[calcID(1, 0, 1)];
		//
		//autonomousCommandArray[calcID(2, 1, 1)] = autonomousCommandArray[calcID(1, 0, 1)]; // Not used
		//autonomousCommandArray[calcID(2, 3, 1)] = autonomousCommandArray[calcID(1, 0, 1)]; // Not used
		//
		autonomousCommandArray[calcID(3, 1, 1)] = autonomousCommandArray[calcID(1, 0, 1)];
		autonomousCommandArray[calcID(3, 3, 1)] = autonomousCommandArray[calcID(1, 0, 1)];
		//
		autonomousCommandArray[calcID(4, 1, 1)] = autonomousCommandArray[calcID(1, 0, 1)];
		autonomousCommandArray[calcID(4, 3, 1)] = autonomousCommandArray[calcID(1, 0, 1)];
		//
		//
		autonomousCommandArray[calcID(1, 0, 2)] = new Pos1ColorLeftObjCubeBasculeCommand();
		autonomousCommandArray[calcID(1, 2, 2)] = autonomousCommandArray[calcID(1, 0, 2)];
		//
		autonomousCommandArray[calcID(2, 0, 2)] = new Pos2ColorLeftObjCubeBascule1Command();
		autonomousCommandArray[calcID(2, 2, 2)] = autonomousCommandArray[calcID(2, 0, 2)];
		autonomousCommandArray[calcID(2, 0, 3)] = new Pos2ColorLeftObjCubeBascule2Command();
		autonomousCommandArray[calcID(2, 2, 3)] = autonomousCommandArray[calcID(2, 0, 3)];
		//
		autonomousCommandArray[calcID(3, 0, 2)] = new Pos3ColorLeftObjCubeBasculeCommand();
		autonomousCommandArray[calcID(3, 2, 2)] = autonomousCommandArray[calcID(3, 0, 2)];
		//
		autonomousCommandArray[calcID(4, 0, 2)] = new Pos4ColorLeftObjCubeBasculeCommand();
		autonomousCommandArray[calcID(4, 2, 2)] = autonomousCommandArray[calcID(4, 0, 2)];
		//
		autonomousCommandArray[calcID(1, 1, 2)] = new Pos1ColorRightObjCubeBasculeCommand();
		autonomousCommandArray[calcID(1, 3, 2)] = autonomousCommandArray[calcID(1, 1, 2)];
		//
		autonomousCommandArray[calcID(2, 1, 2)] = new Pos2ColorRightObjCubeBascule1Command();
		autonomousCommandArray[calcID(2, 3, 2)] = autonomousCommandArray[calcID(2, 1, 2)];
		autonomousCommandArray[calcID(2, 1, 3)] = new Pos2ColorRightObjCubeBascule2Command();
		autonomousCommandArray[calcID(2, 3, 3)] = autonomousCommandArray[calcID(2, 1, 3)];
		//
		autonomousCommandArray[calcID(3, 1, 2)] = new Pos3ColorRightObjCubeBasculeCommand();
		autonomousCommandArray[calcID(3, 3, 2)] = autonomousCommandArray[calcID(3, 1, 2)];
		//
		autonomousCommandArray[calcID(4, 1, 2)] = new Pos4ColorRightObjCubeBasculeCommand();
		autonomousCommandArray[calcID(4, 3, 2)] = autonomousCommandArray[calcID(4, 1, 2)];
		//
		//
		autonomousCommandArray[calcID(1, 0, 4)] = new Pos1ColorLeftObjCubeBalanceCommand();
		autonomousCommandArray[calcID(1, 1, 4)] = autonomousCommandArray[calcID(1, 0, 4)];
		//
		//autonomousCommandArray[calcID(2, 0, 4)] = new DummyCommand(2);                     // Not used
		//autonomousCommandArray[calcID(2, 1, 4)] = autonomousCommandArray[calcID(2, 0, 4)]; // Not used
		//
		//autonomousCommandArray[calcID(3, 0, 4)] = new DummyCommand(3);                     // Not used
		//autonomousCommandArray[calcID(3, 1, 4)] = autonomousCommandArray[calcID(3, 0, 4)]; // Not used
		//
		autonomousCommandArray[calcID(4, 0, 4)] = new Pos4ColorLeftObjCubeBalanceCommand();
		autonomousCommandArray[calcID(4, 1, 4)] = autonomousCommandArray[calcID(4, 0, 4)];
		//
		autonomousCommandArray[calcID(1, 2, 4)] = new Pos1ColorRightObjCubeBalanceCommand();
		autonomousCommandArray[calcID(1, 3, 4)] = autonomousCommandArray[calcID(1, 2, 4)];
		//
		//autonomousCommandArray[calcID(2, 2, 4)] = new DummyCommand(2);                     // Not used
		//autonomousCommandArray[calcID(2, 3, 4)] = autonomousCommandArray[calcID(2, 2, 4)]; // Not used
		//
		//autonomousCommandArray[calcID(3, 2, 4)] = new DummyCommand(3);                     // Not used
		//autonomousCommandArray[calcID(3, 3, 4)] = autonomousCommandArray[calcID(3, 2, 4)]; // Not used
		//
		autonomousCommandArray[calcID(4, 2, 4)] = new Pos4ColorRightObjCubeBalanceCommand();
		autonomousCommandArray[calcID(4, 3, 4)] = autonomousCommandArray[calcID(4, 2, 4)];
	}
}