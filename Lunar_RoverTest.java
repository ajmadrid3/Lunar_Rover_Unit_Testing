/**
 * A JUnit test class to test the class Lunar_Rover.
 * @author Andrew Madrid
 * @version 1.0 (11/19/17)
 * @since Version 0.5
 */
import org.junit.Test;
import static org.junit.Assert.*;
public class Lunar_RoverTest {

	/**
	 * Provides test cases for when the current state of the 
	 * Lunar Rover is in the IDEL state.
	 */
	@Test
	public void testchange_state1() {
		assertSame(Lunar_Rover.Motion_State.IDLE, Lunar_Rover.change_State(Lunar_Rover.Motion_State.IDLE, 2));
		assertEquals(Lunar_Rover.Motion_State.MOVE_FORWARD_CONSTANT, Lunar_Rover.change_State(Lunar_Rover.Motion_State.IDLE, 3));
		assertNotSame(Lunar_Rover.Motion_State.MOVE_BACKWARD_CONSTANT, Lunar_Rover.change_State(Lunar_Rover.Motion_State.IDLE, 10));
	}
	
	/**
	 * Provides test cases for when the current state of the 
	 * Lunar Rover is in the MOVE_FORWARD_CONSTANT state.
	 */
	@Test
	public void testchange_state2() {
		assertEquals(Lunar_Rover.Motion_State.DECELERATE, Lunar_Rover.change_State(Lunar_Rover.Motion_State.MOVE_FORWARD_CONSTANT, 2));
		assertSame(Lunar_Rover.Motion_State.MOVE_FORWARD_ACCELERATE, Lunar_Rover.change_State(Lunar_Rover.Motion_State.MOVE_FORWARD_CONSTANT, 1));
		assertNotSame(Lunar_Rover.Motion_State.MOVE_BACKWARD_CONSTANT, Lunar_Rover.change_State(Lunar_Rover.Motion_State.MOVE_FORWARD_CONSTANT, -1));
	}
	
	/**
	 * Provides test cases to see if the method prints the 
	 * current state in the console.
	 */
	@Test
	public void testprint_state() {
		assertTrue(Lunar_Rover.print_State(Lunar_Rover.Motion_State.IDLE));
		assertTrue(Lunar_Rover.print_State(Lunar_Rover.Motion_State.MOVE_BACKWARD_CONSTANT));
		assertTrue(Lunar_Rover.print_State(Lunar_Rover.Motion_State.MOVE_FORWARD_ACCELERATE));
	}
	
}
