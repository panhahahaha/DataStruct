package Testing;

import Database.Pokemon;
import Database.PokemonList;
import Database.Ribbon;
import Database.Account;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AccountTest extends DSUnitTesting {

	private String username;
	private int level;
	private ArrayList<Ribbon> ribbons;
	private Pokemon p1;
	private Pokemon p2;
	private Pokemon p3;
	private PokemonList pokemons;
	

	@Before
	public void initialise() {
		username = "Malfoy";
		level = 7;
		
		p1 = new Pokemon("Absol", Pokemon.Role.SPEEDSTER);
		p2 = new Pokemon("Pikachu", Pokemon.Role.ATTACKER);
		p3 = new Pokemon("Charizard", Pokemon.Role.ALLROUNDER);
		pokemons = new PokemonList(p1);
		p1.setNext(p2);
		p2.setNext(p3);
		ribbons = new ArrayList<Ribbon>(); {
			ribbons.add(new Ribbon("Pursuit", Ribbon.Rarity.GREEN,
					new GregorianCalendar(2024, 0, 25), p1));
			ribbons.add(new Ribbon("Electro Ball", Ribbon.Rarity.GOLD,
					new GregorianCalendar(2024, 5, 15), p2));
			ribbons.add(new Ribbon("Flame Charge", Ribbon.Rarity.GREEN,
					new GregorianCalendar(2024, 1, 21), p3));
			}
	}

	@Test
	public void testConstructor() {
		AssignmentMarker.marks.put("Account:Constructor", 2.0f);
		try {
			Account account = new Account(username, level);

			assertEquals("Checking that the username was correctly set", username, account.getUsername());
			assertEquals("Checking that the level was correctly set", level, account.getLevel());
			assertEquals("Checking that the key was correctly calculated", 7.1997622119999996, account.getKey(), 0.00001);
		}
		catch (Exception e) {
			fail("Checking that the Account constructor does not throw any exceptions");
		}
	}

	@Test
	public void toStringTest() {
		AssignmentMarker.marks.put("Account:toString", 3.0f);
		Account account = new Account(username, level);
		account.setPokemons(pokemons);
		account.setRibbons(ribbons);

		String rtnStr = "Account: Malfoy\n" +
				"\n" +
				"Ribbons: \n" +
				"\"Pursuit\", rarity: GREEN, obtained on: Jan 25, 2024\n" +
				"\"Electro Ball\", rarity: GOLD, obtained on: June 15, 2024\n" +
				"\"Flame Charge\", rarity: GREEN, obtained on: Feb 21, 2024\n" +
				"\n" +
				"Pokemons: \n" +
				"Absol, Role: SPEEDSTER\n" +
				"Pikachu, Role: ATTACKER\n" +
				"Charizard, Role: ALLROUNDER\n";

		assertEquals("Checking that toString returns the correct String", rtnStr, account.toString());
	}
}
