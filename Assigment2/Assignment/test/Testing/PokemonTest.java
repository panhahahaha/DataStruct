package Testing;

import Database.Pokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PokemonTest extends DSUnitTesting {
	private String name;
	private Pokemon.Role role;

	@Before
	public void initialise() {
		name = "Absol";
		role = Pokemon.Role.SPEEDSTER;
	}

	@Test
	public void testConstructor() {
		AssignmentMarker.marks.put("Pokemon:Constructor", 2.0f);
		try {
			Pokemon p = new Pokemon(name, role);

			assertEquals("Checking that the name has been correctly set", name, p.getName());
			assertEquals("Checking that the role has been correctly set", role, p.getRole());
		}
		catch (Exception e) {
			fail("Checking that the Pokemon constructor does not throw any exceptions");
		}
	}

	@Test
	public void toStringTest() {
		AssignmentMarker.marks.put("Pokemon:toString", 3.0f);
		Pokemon p = new Pokemon(name, role);

		assertEquals("Absol, Role: SPEEDSTER", p.toString());
	}
}
