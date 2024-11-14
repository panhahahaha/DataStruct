package Testing;

import Database.Pokemon;
import Database.Ribbon;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class RibbonTest extends DSUnitTesting {

	private String name;
	private Ribbon.Rarity rarity;
	private Calendar obtained;
	private Pokemon pokemon;

	@Before
	public void initialise() {
		name = "Snow Warning";
		rarity = Ribbon.Rarity.BLUE;
		obtained = new GregorianCalendar(2024, 4, 4);
		pokemon = new Pokemon("Ninetales", Pokemon.Role.ATTACKER);
	}

	@Test
	public void testConstructor() {
		AssignmentMarker.marks.put("Ribbon:Constructor", 2.0f);
		try {
			Ribbon r = new Ribbon(name, rarity, obtained, pokemon);

			assertEquals("Checking that the name was correctly set", name, r.getName());
			assertEquals("Checking that the rarity was correctly set", rarity, r.getRarity());
			assertEquals("Checking that the obtained date was correctly set", obtained, r.getObtained());
			assertEquals("Checking that the parent pokemon was correctly set", pokemon, r.getPokemon());
		}
		catch (Exception e) {
			fail("Checking that the User constructor does not throw any exceptions");
		}
	}

	@Test
	public void toStringTest() {
		AssignmentMarker.marks.put("Ribbon:toString", 3.0f);
		Ribbon r = new Ribbon(name, rarity, obtained, pokemon);
		assertEquals("Checking that tostring returns the correct string", "\"Snow Warning\", rarity: BLUE, " +
				"obtained on: May 04, 2024", r.toString());
	}
}
