/**
 * This class represents a state machine for a Lunar Rover.  The
 * rover has multiple motion states and will switch to another action 
 * depending on the action that is done in the state.
 * 
 * @author Andrew Madrid
 * @version 2.0 (11/19/17)
 * @since Version 0.5
 */
import java.util.Scanner;
public class Lunar_Rover 
{
	/** The states that the Lunar Rover can be in.*/
	public enum Motion_State {
		IDLE, MOVE_FORWARD_ACCELERATE, MOVE_FORWARD_CONSTANT, DECELERATE, MOVE_BACKWARD_ACCELERATE, MOVE_BACKWARD_CONSTANT
	}
	
	/**
	 * Changes the state that the Lunar Rover is in based on the action 
	 * that the user chooses.  Prints the action.
	 * @param current the current motion state that the Lunar Rover is in.
	 * @param choice the action that the user chose to do in the state.
	 * @return The new motion state that the Lunar Rover is in.
	 */
	public static Motion_State change_State(Motion_State current, int choice)
	{
		switch(current) {
			case IDLE:
				if(choice == 1) {
					System.out.println("Pressing Right Pedal Once.");
					current = Motion_State.MOVE_FORWARD_ACCELERATE;
				} else if(choice == 3) {
					System.out.println("Holding Right Pedal Down for 6 Seconds.");
					current = Motion_State.MOVE_FORWARD_CONSTANT;
				} else if(choice == 5) {
					System.out.println("Holding Left Pedal Down for 6 Seconds.");
					current = Motion_State.MOVE_BACKWARD_ACCELERATE;
				} else {
					System.out.println("Nothing Happened.");
					current = Motion_State.IDLE;
				}
				break;
			case MOVE_FORWARD_ACCELERATE:
				if(choice == 2) {
					System.out.println("Pressing Right Pedal Twice");
					current = Motion_State.DECELERATE;
				} else if(choice == 3) {
					System.out.println("Holding Right Pedal Down for 6 Seconds.");
					current = Motion_State.MOVE_FORWARD_CONSTANT;
				} else if(choice == 4) {
					System.out.println("Pressing Left Pedal Once.");
					current = Motion_State.MOVE_FORWARD_CONSTANT;
				} else {
					System.out.println("Nothing Happened.");
					current = Motion_State.MOVE_FORWARD_ACCELERATE;
				}
				break;
			case MOVE_FORWARD_CONSTANT:
				if(choice == 1) {
					System.out.println("Pressing Right Pedal Once.");
					current = Motion_State.MOVE_FORWARD_ACCELERATE;
				} else if(choice == 2) {
					System.out.println("Pressing Right Pedal Twice.");
					current = Motion_State.DECELERATE;
				} else {
					System.out.println("Nothing Happened.");
					current = Motion_State.MOVE_FORWARD_CONSTANT;
				}
				break;
			case DECELERATE:
				if(choice == 6) {
					System.out.println("Slowing Down to Speed 0.");
					current = Motion_State.IDLE;
				} else {
					System.out.println("Nothing Happened.");
					current = Motion_State.DECELERATE;
				}
				break;
			case MOVE_BACKWARD_ACCELERATE:
				if(choice == 1) {
					System.out.println("Pressing Right Pedal Once.");
					current = Motion_State.DECELERATE;
				} else if(choice == 4) {
					System.out.println("Pressing Left Pedal Once.");
					current = Motion_State.MOVE_BACKWARD_CONSTANT;
				} else {
					System.out.println("Nothing Happened.");
					current = Motion_State.MOVE_BACKWARD_ACCELERATE;
				}
				break;
			case MOVE_BACKWARD_CONSTANT:
				if(choice == 1) {
					System.out.println("Pressing Right Pedal Once.");
					current = Motion_State.DECELERATE;
				} else {
					System.out.println("Nothing Happened.");
					current = Motion_State.MOVE_BACKWARD_CONSTANT;
				}
			default:
				System.out.println();
		}
		return current;
	}
	
	/**
	 * Prints the motion state that the Lunar Rover is currently in.
	 * @param current the current motion state the Lunar Rover is in
	 * @return Boolean value when statement is printed, used only for JUnit testing.
	 */
	public static boolean print_State(Motion_State current)
	{
		System.out.println("You are currently in the " + current + " state.\n");
		return true;
	}
	
	/**
	 * Prompts the user to choose one of the listed actions to perform 
	 * on the Lunar Rover.  If an invalid error is entered, prompts the 
	 * user to reenter a new value.
	 */
	public static void main(String args[])
	{
		Motion_State current_State = Motion_State.IDLE;
		Scanner scnr = new Scanner(System.in);
		int action = 0;
		System.out.println("Welcome to the Lunar Rover\n");
		print_State(current_State);
		while(action != 7)
		{
			System.out.println("What would you like to do?\n");
			System.out.println("1: Press Right Pedal Once");
			System.out.println("2: Press Right Pedal Twice");
			System.out.println("3: Hold Right Pedal Down for 6 Seconds");
			System.out.println("4: Press Left Pedal Once");
			System.out.println("5: Hold Left Pedal Down for 6 Seconds");
			System.out.println("6: Let Speed Reach 0");
			System.out.println("7: Exit Program\n");
			
			System.out.print("Action: ");
			
			action = scnr.nextInt();
			if(action == 7) 
			{
				break;
			}
			else if(action < 1 || action > 7)
			{
				System.out.println("ERROR: Incorrect value entered.\n");
			}
			else
			{
				System.out.println("Performing action.");
				current_State = change_State(current_State, action);
				boolean print = print_State(current_State);
			}
		}
		System.out.println("Exiting Program");
	}
}
