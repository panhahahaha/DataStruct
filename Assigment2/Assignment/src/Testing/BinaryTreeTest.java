package Testing;

import Database.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class BinaryTreeTest extends DSUnitTesting {
	public BinaryTree bt;

	// Start testing setup (see assignment spec for tree diagrams)
	Pokemon pikachu, charizard, blastoise, venusaur, absol, sableye, garchomp, comfey, leafeon;
	PokemonList pl1, pl2, pl3, pl4;

	Calendar c;
	Ribbon pikachuR1, pikachuR2, charizardR1, charizardR2, venusaurR1, venusaurR2, blastoiseR1, blastoiseR2, absolR1, absolR2, sableyeR1, sableyeR2, 
			garchompR1, garchompR2, comfeyR1, comfeyR2, leafeonR1, leafeonR2;

	ArrayList<Ribbon> rl1, rl2, rl3, rl4;

	Calendar dob;
	
	Account blitz, crown, echo, chrom, mystic, bin, perks, titan, lunar, quantum, nebula, crow;

	/**
	 * There's a LOT of setting up to do here. Refer to the assignment spec for
	 * a diagram explaining how this tree is constructed.
	 */
	@Before
	public void initialise() {
		pikachu = new Pokemon("Pikachu", Pokemon.Role.ATTACKER);
		charizard = new Pokemon("Charizard", Pokemon.Role.ALLROUNDER);
		blastoise = new Pokemon("Blastoise", Pokemon.Role.DEFENDER);
		venusaur = new Pokemon("Venusaur", Pokemon.Role.ATTACKER);
		absol = new Pokemon("Absol", Pokemon.Role.SPEEDSTER);
		sableye = new Pokemon("Sableye", Pokemon.Role.SUPPORTER);
		garchomp = new Pokemon("Garchomp", Pokemon.Role.ALLROUNDER);
		comfey = new Pokemon("Comfey", Pokemon.Role.SUPPORTER);
		leafeon = new Pokemon("Leafeon", Pokemon.Role.SPEEDSTER);

		pl1 = new PokemonList(absol); {
			pl1.addPokemon(pikachu);
		}
		pl2 = new PokemonList(venusaur); {
			pl2.addPokemon(charizard);
			pl2.addPokemon(blastoise);
		}
		pl3 = new PokemonList(leafeon);{
			pl3.addPokemon(comfey);
			pl3.addPokemon(garchomp);
		}
		
		
		pl4 = new PokemonList(sableye); {
		}
		

		c = new GregorianCalendar(2024, 2, 26); // Ribbons can have the same date - we don't care for these tests

		pikachuR1 = new Ribbon("Electro Ball", Ribbon.Rarity.GOLD, c, pikachu);
		pikachuR2 = new Ribbon("Thunder", Ribbon.Rarity.GREEN, c, pikachu);
		charizardR1 = new Ribbon("Flame Charge", Ribbon.Rarity.BLUE, c, charizard);
		charizardR2 = new Ribbon("Flamethrower", Ribbon.Rarity.GREEN, c, charizard);
		venusaurR1 = new Ribbon("Solar Beam", Ribbon.Rarity.GREEN, c, venusaur);
		venusaurR2 = new Ribbon("Petal Dance", Ribbon.Rarity.BLUE, c, venusaur);
		blastoiseR1 = new Ribbon("Surf", Ribbon.Rarity.BLUE, c, blastoise);
		blastoiseR2 = new Ribbon("Hydro Pump", Ribbon.Rarity.GOLD, c, blastoise);
		absolR1 = new Ribbon("Pursuit", Ribbon.Rarity.GOLD, c, absol);
		absolR2 = new Ribbon("Sucker Punch", Ribbon.Rarity.BLUE, c, absol);
		sableyeR1 = new Ribbon("Feint Attack", Ribbon.Rarity.GREEN, c, sableye);
		sableyeR2 = new Ribbon("Shadow Sneak", Ribbon.Rarity.GOLD, c, sableye);
		garchompR1 = new Ribbon("Earthquake", Ribbon.Rarity.BLUE, c, garchomp);
		garchompR2 = new Ribbon("Dragon Rush", Ribbon.Rarity.GOLD, c, garchomp);
		comfeyR1 = new Ribbon("Healing Aura", Ribbon.Rarity.GREEN, c, comfey);
		comfeyR2 = new Ribbon("Grass Knot", Ribbon.Rarity.GREEN, c, comfey);
		leafeonR1 = new Ribbon("Leaf Blade", Ribbon.Rarity.BLUE, c, leafeon);
		leafeonR2 = new Ribbon("Razor Wind", Ribbon.Rarity.GOLD, c, leafeon);

		rl1 = new ArrayList<Ribbon>(); {
			rl1.add(absolR2);
			rl1.add(pikachuR2);
		}
		rl2 = new ArrayList<Ribbon>(); {
			rl2.add(charizardR1);
			rl2.add(charizardR2);
			rl2.add(blastoiseR1);
			rl2.add(venusaurR2);
		}
		rl3 = new ArrayList<Ribbon>(); {
			rl3.add(leafeonR1);
			rl3.add(leafeonR2);
			rl3.add(comfeyR1);
			rl3.add(garchompR2);
		}
		rl4 = new ArrayList<Ribbon>(); {
			rl4.add(sableyeR1);
			rl4.add(sableyeR2);
		}
			
		blitz = new Account("blitz", 7);
		crown = new Account("crown", 10);
		echo = new Account("echo", 8);
		chrom = new Account("chrom", 9);
		mystic = new Account("mystic", 12);
		bin = new Account("bin", 14);
		perks = new Account("perks", 4);
		titan = new Account("titan", 6);
		lunar = new Account("lunar", 5);
		nebula = new Account("nebula", 3);
		quantum = new Account("quantum", 3);
		crow = new Account("crow", 1);

		blitz.setPokemons(pl1);
		blitz.setRibbons(rl1);
		blitz.setLeft(perks);
		blitz.setRight(crown);

		
		perks.setPokemons(pl3);
		perks.setRibbons(rl3);
		perks.setLeft(nebula);
		perks.setRight(titan);


		nebula.setPokemons(pl4);
		nebula.setRibbons(rl4);
		nebula.setLeft(crow);
		nebula.setRight(quantum);


		crow.setPokemons(pl4);
		crow.setRibbons(rl4);
		
		
		quantum.setPokemons(pl1);
		quantum.setRibbons(rl1);
		

		titan.setPokemons(pl1);
		titan.setRibbons(rl1);
		titan.setLeft(lunar);
		
		
		lunar.setPokemons(pl4);
		lunar.setRibbons(rl4);
		
		
		crown.setPokemons(pl3);
		crown.setRibbons(rl3);
		crown.setLeft(echo);
		crown.setRight(mystic);


		echo.setPokemons(pl4);
		echo.setRibbons(rl4);
		echo.setRight(chrom);


		chrom.setPokemons(pl2);
		chrom.setRibbons(rl2);


		mystic.setPokemons(pl1);
		mystic.setRibbons(rl1);
		mystic.setRight(bin);


		bin.setPokemons(pl2);
		bin.setRibbons(rl2);


		bt = new BinaryTree();
		bt.root = blitz;
	}

	@Test
	public void beFriendNullArg() {
		AssignmentMarker.marks.put("BinaryTree:beFriendNullArg", 1.0f);
		try {
			bt.beFriend(null);

			fail("Checking that beFriend throws an IllegalArgumentException when null arg supplied");
		}
		catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void beFriendDuplicate() {
		AssignmentMarker.marks.put("BinaryTree:beFriendDuplicate", 1.0f);
		assertFalse("Checking that beFriend returns false when account already in tree (1)", bt.beFriend(titan));
	}

	@Test
	public void beFriend() {
		AssignmentMarker.marks.put("BinaryTree:beFriend", 6.0f);
		BinaryTree emptyBT = new BinaryTree();
		Account bob = new Account("bob", 6);
		bob.setPokemons(pl1);
		bob.setRibbons(rl1);
		assertTrue("Checking that beFriend returns true when adding to an empty tree", emptyBT.beFriend(bob));
		assertEquals("Checking that the root has been correctly set", bob, emptyBT.root);

		assertTrue("Checking that beFriend returns true when adding a new account (1)", bt.beFriend(bob));
		assertEquals("Checking that Titan's right variable correctly set", bob, titan.getRight());

		titan.setRight(null);
		bob = new Account("bob", 7);
		bob.setPokemons(pl1);
		bob.setRibbons(rl1);
		assertTrue("Checking that beFriend returns true when adding a new account (2)", bt.beFriend(bob));
		assertEquals("Checking that Echos's left variable correctly set", bob, echo.getLeft());
	}

	@Test
	public void removeFriendNullArg() {
		AssignmentMarker.marks.put("BinaryTree:removeFriendNullArg", 1.0f);
		try {
			bt.removeFriend(null);

			fail("Checking that removeFriend throws an IllegalArgumentException when null arg supplied");
		}
		catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void removeFriendNonExistent() {
		AssignmentMarker.marks.put("BinaryTree:removeFriendNonExistent", 1.0f);
		Account bob = new Account("bob", 6);
		bob.setPokemons(pl1);
		bob.setRibbons(rl1);
		assertFalse("Checking that removeFriend returns false when account not in tree", bt.removeFriend(bob));
	}

	@Test
	public void removeFriend() {
		AssignmentMarker.marks.put("BinaryTree:removeFriend", 7.0f);
		assertTrue("Checking that removeFriend returns true when removing a account (1)", bt.removeFriend(chrom));
		assertEquals("Checking that Echo's right variable correctly set", null, echo.getRight());

		assertTrue("Checking that removeFriend returns true when removing a account (2)", bt.removeFriend(lunar));
		assertEquals("Checking that Titan's left variable correctly set", null, titan.getLeft());

	 	assertTrue("Checking that removeFriend returns true when removing a account (3)", bt.removeFriend(perks));
		assertEquals("Checking that Blitz's left correctly set (1)", quantum.getKey(), blitz.getLeft().getKey(), 0.01);
		assertEquals("Checking that Blitz's left correctly set (2)", quantum.getUsername(), blitz.getLeft().getUsername());
		assertEquals("Checking that Blitz's left correctly set (3)", quantum.getRibbons(), blitz.getLeft().getRibbons());

		assertTrue("Checking that removeFriend returns true when removing the root", bt.removeFriend(blitz));
		assertEquals("Checking that Titan is the new root", titan.getKey(), bt.root.getKey(), 0.01);
		assertEquals("Checking that Titan is the new root", titan.getUsername(), bt.root.getUsername());
		assertEquals("Checking that Titan is the new root", titan.getRibbons(), bt.root.getRibbons());
	}

	@Test
	public void countBetterPlayersNullArg() {
		AssignmentMarker.marks.put("BinaryTree:countBetterPlayersNullArg", 1.0f);
		try {
			bt.countBetterPlayers(null);

			fail("Checking that removeFriend throws an IllegalArgumentException when null arg supplied");
		}
		catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void countBetterPlayersNonExistent() {
		AssignmentMarker.marks.put("BinaryTree:countBetterPlayersNonExistent", 1.0f);
		Account bob = new Account("bob", 6);
		bob.setPokemons(pl1);
		bob.setRibbons(rl1);
		assertEquals("Checking that countBetterPlayers returns -1 when account not in tree", -1, bt.countBetterPlayers(bob));
	}

	@Test
	public void countBetterPlayers() {
		AssignmentMarker.marks.put("BinaryTree:countBetterPlayers", 4.0f);
		assertEquals("Checking that countBetterPlayers returns the correct number (1)", 11, bt.countBetterPlayers(crow));
		assertEquals("Checking that countBetterPlayers returns the correct number (2)", 0, bt.countBetterPlayers(bin));
		assertEquals("Checking that countBetterPlayers returns the correct number (3)", 6, bt.countBetterPlayers(titan));
		assertEquals("Checking that countBetterPlayers returns the correct number (4)", 3, bt.countBetterPlayers(chrom));

		Account astro = new Account("astro", 7);
		astro.setPokemons(pl1);
		astro.setRibbons(rl1);
		titan.setRight(astro);
		assertEquals("Checking that countBetterPlayers handles same-level accounts correctly", 5, bt.countBetterPlayers(astro));
	}

	@Test
	public void countWorsePlayersNullArg() {
		AssignmentMarker.marks.put("BinaryTree:countWorsePlayersNullArg", 1.0f);
		try {
			bt.countWorsePlayers(null);

			fail("Checking that countWorsePlayers throws an IllegalArgumentException when null arg supplied");
		}
		catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void countWorsePlayersNonExistent() {
		AssignmentMarker.marks.put("BinaryTree:countWorsePlayersNonExistent", 1.0f);
		Account bob = new Account("bob", 6);
		bob.setPokemons(pl1);
		bob.setRibbons(rl1);
		assertEquals("Checking that countWorsePlayers returns -1 when account not in tree", -1, bt.countWorsePlayers(bob));
	}

	@Test
	public void countWorsePlayers() {
		AssignmentMarker.marks.put("BinaryTree:countWorsePlayers", 4.0f);
		assertEquals("Checking that countWorsePlayers returns the correct number (1)", 0, bt.countWorsePlayers(crow));
		assertEquals("Checking that countWorsePlayers returns the correct number (2)", 11, bt.countWorsePlayers(bin));
		assertEquals("Checking that countWorsePlayers returns the correct number (3)", 5, bt.countWorsePlayers(titan));
		assertEquals("Checking that countWorsePlayers returns the correct number (4)", 8, bt.countWorsePlayers(chrom));

		Account bob = new Account("bob", 6);
		bob.setPokemons(pl1);
		bob.setRibbons(rl1);
		titan.setRight(bob);
		assertEquals("Checking that countWorsePlayers handles same-level accounts correctly", 5, bt.countWorsePlayers(bob));
	}

	@Test
	public void highestRibbonScore() {
		// HINT: you may want to add a method in the Account class to help with this test
		AssignmentMarker.marks.put("BinaryTree:highestRibbonScore", 4.0f);
		assertEquals("Checking that highestRibbonScore returns the correct account", chrom, bt.highestRibbonScore());

		// bin and chrom have the same ribbons.. lets set bin to have an additional ribbon
		// (addRibbon isnt' good enough as it adds to the same list chrom has)
		
		ArrayList<Ribbon> rl5 = new ArrayList<Ribbon>();{
			rl5.add(charizardR1);
			rl5.add(charizardR2);
			rl5.add(blastoiseR1);
			rl5.add(venusaurR2);
			rl5.add(blastoiseR2);
		}
		
		bin.setRibbons(rl5);
		assertEquals("Checking that highestRibbonScore returns the correct account", bin, bt.highestRibbonScore());
	}

	@Test
	public void addPokemonNullArg() {
		AssignmentMarker.marks.put("BinaryTree:addPokemonNullArg", 1.0f);
		try {
			bt.addPokemon(null, null);

			fail("Checking that addPokemon throws an IllegalArgumentException when null arg supplied");
		}
		catch (IllegalArgumentException e) {
		}
		try {
			bt.addPokemon("bob", null);

			fail("Checking that addPokemon throws an IllegalArgumentException when null arg supplied");
		}
		catch (IllegalArgumentException e) {
		}
		try {
			bt.addPokemon(null, absol);

			fail("Checking that addPokemon throws an IllegalArgumentException when null arg supplied");
		}
		catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void addPokemon() {
		AssignmentMarker.marks.put("BinaryTree:addPokemon", 4.0f);
		Pokemon metagross = new Pokemon("Metagross", Pokemon.Role.ALLROUNDER);
		bt.addPokemon("titan", metagross);

		assertEquals("Checking that addPokemon correctly adds a pokemon", absol, titan.getPokemons().head);
		assertEquals("Checking that addPokemon correctly adds a pokemon", pikachu, titan.getPokemons().head.getNext());
		assertEquals("Checking that addPokemon correctly adds a pokemon", metagross, titan.getPokemons().head.getNext().getNext());
	}

	@Test
	public void addRibbonNullArg() {
		AssignmentMarker.marks.put("BinaryTree:addRibbonNullArg", 1.0f);
		try {
			bt.addRibbon(null, null);

			fail("Checking that addRibbon throws an IllegalArgumentException when null arg supplied");
		}
		catch (IllegalArgumentException e) {
		}
		try {
			bt.addRibbon("bob", null);

			fail("Checking that addRibbon throws an IllegalArgumentException when null arg supplied");
		}
		catch (IllegalArgumentException e) {
		}
		try {
			bt.addRibbon(null, sableyeR1);

			fail("Checking that addRibbon throws an IllegalArgumentException when null arg supplied");
		}
		catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void addRibbon() {
		AssignmentMarker.marks.put("BinaryTree:addRibbon", 4.0f);
		bt.addRibbon("chrom", blastoiseR2);

		assertEquals("Checking that addRibbon correctly adds a ribbon", charizardR1, chrom.getRibbons().get(0));
		assertEquals("Checking that addRibbon correctly adds a ribbon", charizardR2, chrom.getRibbons().get(1));
		assertEquals("Checking that addRibbon correctly adds a ribbon", blastoiseR1, chrom.getRibbons().get(2));
		assertEquals("Checking that addRibbon correctly adds a ribbon", venusaurR2, chrom.getRibbons().get(3));
		assertEquals("Checking that addRibbon correctly adds a ribbon", blastoiseR2, chrom.getRibbons().get(4));
	}

	@Test
	public void levelUpNullArgs() {
		AssignmentMarker.marks.put("BinaryTree:levelUpNullArgs", 1.0f);
		try {
			bt.levelUp(null);

			fail("Checking that levelUp throws IllegalArgumentException when null args are supplied");
		}
		catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void levelUp() {
		AssignmentMarker.marks.put("BinaryTree:levelUp", 7.0f);
		bt.levelUp("titan");
		assertEquals("Checking that levelUp correctly modifies tree (1)", "blitz", bt.root.getUsername());

		bt.levelUp("blitz");
		assertEquals("Checking that levelUp correctly modifies tree (2)", "titan", bt.root.getUsername());
	}

	@Test
	public void toStringTest() {
		AssignmentMarker.marks.put("BinaryTree:toString", 3.0f);
		assertEquals("Checking that toString returns the correct String", outputString, bt.toString());
	}

	// Ridiculously long return string
	// yes this did suck to type out
	
	
	
	private String outputString = "Account: crow\n" +
			"\n" +
			"Ribbons: \n" +
			"\"Feint Attack\", rarity: GREEN, obtained on: Mar 26, 2024\n" +
			"\"Shadow Sneak\", rarity: GOLD, obtained on: Mar 26, 2024\n" +
			"\n" +
			"Pokemons: \n" +
			"Sableye, Role: SUPPORTER\n" +
			"\n" +
			"Account: nebula\n" +
			"\n" +
			"Ribbons: \n" +
			"\"Feint Attack\", rarity: GREEN, obtained on: Mar 26, 2024\n" +
			"\"Shadow Sneak\", rarity: GOLD, obtained on: Mar 26, 2024\n" +
			"\n" +
			"Pokemons: \n" +
			"Sableye, Role: SUPPORTER\n" +
			"\n" +
			"Account: quantum\n" +
			"\n" +
			"Ribbons: \n" +
			"\"Sucker Punch\", rarity: BLUE, obtained on: Mar 26, 2024\n" +
			"\"Thunder\", rarity: GREEN, obtained on: Mar 26, 2024\n" +
			"\n" +
			"Pokemons: \n" +
			"Absol, Role: SPEEDSTER\n" +
			"Pikachu, Role: ATTACKER\n" +
			"\n" +
			"Account: perks\n" +
			"\n" +
			"Ribbons: \n" +
			"\"Leaf Blade\", rarity: BLUE, obtained on: Mar 26, 2024\n" +
			"\"Razor Wind\", rarity: GOLD, obtained on: Mar 26, 2024\n" +
			"\"Healing Aura\", rarity: GREEN, obtained on: Mar 26, 2024\n" +
			"\"Dragon Rush\", rarity: GOLD, obtained on: Mar 26, 2024\n" +
			"\n" +
			"Pokemons: \n" +
			"Leafeon, Role: SPEEDSTER\n" +
			"Comfey, Role: SUPPORTER\n" +
			"Garchomp, Role: ALLROUNDER\n" +
			"\n" +
			"Account: lunar\n" +
			"\n" +
			"Ribbons: \n" +
			"\"Feint Attack\", rarity: GREEN, obtained on: Mar 26, 2024\n" +
			"\"Shadow Sneak\", rarity: GOLD, obtained on: Mar 26, 2024\n" +
			"\n" +
			"Pokemons: \n" +
			"Sableye, Role: SUPPORTER\n" +
			"\n" +
			"Account: titan\n" +
			"\n" +
			"Ribbons: \n" +
			"\"Sucker Punch\", rarity: BLUE, obtained on: Mar 26, 2024\n" +
			"\"Thunder\", rarity: GREEN, obtained on: Mar 26, 2024\n" +
			"\n" +
			"Pokemons: \n" +
			"Absol, Role: SPEEDSTER\n" +
			"Pikachu, Role: ATTACKER\n" +
			"\n" +
			"Account: blitz\n" +
			"\n" +
			"Ribbons: \n" +
			"\"Sucker Punch\", rarity: BLUE, obtained on: Mar 26, 2024\n" +
			"\"Thunder\", rarity: GREEN, obtained on: Mar 26, 2024\n" +
			"\n" +
			"Pokemons: \n" +
			"Absol, Role: SPEEDSTER\n" +
			"Pikachu, Role: ATTACKER\n" +
			"\n" +
			"Account: echo\n" +
			"\n" +
			"Ribbons: \n" +
			"\"Feint Attack\", rarity: GREEN, obtained on: Mar 26, 2024\n" +
			"\"Shadow Sneak\", rarity: GOLD, obtained on: Mar 26, 2024\n" +
			"\n" +
			"Pokemons: \n" +
			"Sableye, Role: SUPPORTER\n" +
			"\n" +
			"Account: chrom\n" +
			"\n" +
			"Ribbons: \n" +
			"\"Flame Charge\", rarity: BLUE, obtained on: Mar 26, 2024\n" +
			"\"Flamethrower\", rarity: GREEN, obtained on: Mar 26, 2024\n" +
			"\"Surf\", rarity: BLUE, obtained on: Mar 26, 2024\n" +
			"\"Petal Dance\", rarity: BLUE, obtained on: Mar 26, 2024\n" +
			"\n" +
			"Pokemons: \n" +
			"Venusaur, Role: ATTACKER\n" +
			"Charizard, Role: ALLROUNDER\n" +
			"Blastoise, Role: DEFENDER\n" +
			"\n" +
			"Account: crown\n" +
			"\n" +
			"Ribbons: \n" +
			"\"Leaf Blade\", rarity: BLUE, obtained on: Mar 26, 2024\n" +
			"\"Razor Wind\", rarity: GOLD, obtained on: Mar 26, 2024\n" +
			"\"Healing Aura\", rarity: GREEN, obtained on: Mar 26, 2024\n" +
			"\"Dragon Rush\", rarity: GOLD, obtained on: Mar 26, 2024\n" +
			"\n" +
			"Pokemons: \n" +
			"Leafeon, Role: SPEEDSTER\n" +
			"Comfey, Role: SUPPORTER\n" +
			"Garchomp, Role: ALLROUNDER\n" +
			"\n" +
			"Account: mystic\n" +
			"\n" +
			"Ribbons: \n" +
			"\"Sucker Punch\", rarity: BLUE, obtained on: Mar 26, 2024\n" +
			"\"Thunder\", rarity: GREEN, obtained on: Mar 26, 2024\n" +
			"\n" +
			"Pokemons: \n" +
			"Absol, Role: SPEEDSTER\n" +
			"Pikachu, Role: ATTACKER\n" +
			"\n" +
			"Account: bin\n" +
			"\n" +
			"Ribbons: \n" +
			"\"Flame Charge\", rarity: BLUE, obtained on: Mar 26, 2024\n" +
			"\"Flamethrower\", rarity: GREEN, obtained on: Mar 26, 2024\n" +
			"\"Surf\", rarity: BLUE, obtained on: Mar 26, 2024\n" +
			"\"Petal Dance\", rarity: BLUE, obtained on: Mar 26, 2024\n" +
			"\n" +
			"Pokemons: \n" +
			"Venusaur, Role: ATTACKER\n" +
			"Charizard, Role: ALLROUNDER\n" +
			"Blastoise, Role: DEFENDER";
}
