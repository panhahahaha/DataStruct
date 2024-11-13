package Testing;

import Database.Pokemon;
import Database.PokemonList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class PokemonListTest extends DSUnitTesting {

    private Pokemon p1;
    private Pokemon p2;
    private Pokemon p3;
    private PokemonList pList;

    @Before
    public void initialise() {
        p1 = new Pokemon("Blastoise", Pokemon.Role.DEFENDER);
        p2 = new Pokemon("Delphox", Pokemon.Role.ATTACKER);
        p3 = new Pokemon("Sableye", Pokemon.Role.SUPPORTER);
        pList = new PokemonList(null);
    }

    @Test
    public void getPokemonNullArg() {
        AssignmentMarker.marks.put("PokemonList:getPokemonNullArg", 1.0f);
        try {
            pList.getPokemon(null);

            fail("Checking that getPokemon throws an IllegalArgumentException when null arg supplied");
        }
        catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void getPokemon() {
        AssignmentMarker.marks.put("PokemonList:getPokemon", 2.0f);
        pList.head = p1;
        p1.setNext(p2);
        p2.setNext(p3);

        Assert.assertEquals("Checking that getPokemon returns the correct Database.Pokemon", p1, pList.getPokemon("Blastoise"));
        Assert.assertEquals("Checking that getPokemon returns the correct Database.Pokemon", p3, pList.getPokemon("Sableye"));
        assertNull("Checking that getPokemon returns null if pokemon not present", pList.getPokemon("Raichu"));
    }

    @Test
    public void addPokemon() {
        AssignmentMarker.marks.put("PokemonList:addPokemon", 2.0f);
        pList.addPokemon(p2);
        pList.addPokemon(p1);

        Assert.assertEquals("Checking that the head is correctly set", p2, pList.head);
        Assert.assertEquals("Checking next set correctly", p1, p2.getNext());
        assertNull("Checking next set correctly", p1.getNext());
    }

    @Test
    public void addPokemonExists() {
        AssignmentMarker.marks.put("PokemonList:addPokemonExists", 1.0f);
        pList.addPokemon(p1);
        pList.addPokemon(p1);

        assertNull("Checking that a duplicate pokemon is not added", p1.getNext());
    }

    @Test
    public void addPokemonNullArg() {
        AssignmentMarker.marks.put("PokemonList:addPokemonNullArg", 1.0f);
        try {
            pList.addPokemon(null);

            fail("Checking that addPokemon throws an IllegalArgumentException when null arg supplied");
        }
        catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void removePokemonNullArg() {
        AssignmentMarker.marks.put("PokemonList:removePokemonNullArg", 1.0f);
        try {
            String str = null;
            pList.removePokemon(str);
            Pokemon g = null;
            pList.removePokemon(g);

            fail("Checking that both removePokemon methods throw IllegalArgumentException when null args are supplied");
        }
        catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void removePokemonString() {
        AssignmentMarker.marks.put("PokemonList:removePokemonString", 2.0f);
        pList.head = p1;
        p1.setNext(p2);
        p2.setNext(p3);

        pList.removePokemon("Raichu");
        Assert.assertEquals("Checking that a non-existant name does not alter the list (1)", p1, pList.head);
        Assert.assertEquals("Checking that a non-existant name does not alter the list (2)", p2, pList.head.getNext());
        Assert.assertEquals("Checking that a non-existant name does not alter the list (3)", p3, pList.head.getNext().getNext());
        assertNull("Checking that a non-existant name does not alter the list (4)", pList.head.getNext().getNext().getNext());

        pList.removePokemon(p1.getName());
        Assert.assertEquals("Checking that the head is correctly replaced", p2, pList.head);

        p3.setNext(p1);
        p1.setNext(null);
        pList.removePokemon(p3.getName());
        Assert.assertEquals("Checking that middle pokemon removed correctly", p1, p2.getNext());

        pList.removePokemon(p1.getName());
        assertNull("Checking that last pokemon correctly removed", p2.getNext());
    }

    @Test
    public void removePokemonObject() {
        AssignmentMarker.marks.put("PokemonList:removePokemonObject", 2.0f);
        pList.head = p1;
        p1.setNext(p2);
        p2.setNext(p3);

        pList.removePokemon(new Pokemon("Raichu", Pokemon.Role.SPEEDSTER));
        Assert.assertEquals("Checking that a non-existant name does not alter the list (1)", p1, pList.head);
        Assert.assertEquals("Checking that a non-existant name does not alter the list (2)", p2, pList.head.getNext());
        Assert.assertEquals("Checking that a non-existant name does not alter the list (3)", p3, pList.head.getNext().getNext());
        assertNull("Checking that a non-existant name does not alter the list (4)", pList.head.getNext().getNext().getNext());

        pList.removePokemon(p1);
        Assert.assertEquals("Checking that the head is correctly replaced", p2, pList.head);

        p3.setNext(p1);
        p1.setNext(null);
        pList.removePokemon(p3);
        Assert.assertEquals("Checking that middle pokemon removed correctly", p1, p2.getNext());

        pList.removePokemon(p1);
        assertNull("Checking that last pokemon correctly removed", p2.getNext());
    }

    @Test
    public void toStringTest() {
        AssignmentMarker.marks.put("PokemonList:toString", 3.0f);
        Assert.assertEquals("Testing that toString with an empty list returns the correct String", pList.toString(), "Empty pokemon list");

        pList.head = p1;
        p1.setNext(p2);
        p2.setNext(p3);

        Assert.assertEquals("Testing that toString returns the correct String",
        		"Blastoise, Role: DEFENDER\n" + "Delphox, Role: ATTACKER\n" + "Sableye, Role: SUPPORTER", pList.toString());
    }
}