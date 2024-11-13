package Database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Class to represent an account.
 * Created for Data Structures, AnDe 2024
 * @version 1.0
 */
public class Account {

    private String username;
    private int level;
    private double key;
    private ArrayList<Ribbon> ribbons;
    private PokemonList pokemons;
	private Account left;
    private Account right;

    public Account(String username, int level) {

    }

    /**
     * DO NOT MODIFY THIS METHOD
     * This method uses the username and level to create a unique key.
     * As we don't want the username's hash to increase the level, it's first converted
     * to a floating point, then added to the level.
     * @return the unique key
     */
    public double calculateKey() {
        int hash = Math.abs(username.hashCode());
        // Calculate number of zeros we need
        int length = (int)(Math.log10(hash) + 1);
        // Make a divisor 10^x
        double divisor = Math.pow(10, length);
        // Return level.hash
        return level + hash / divisor;
    }
    
    
    public void addPokemon(Pokemon pokemon) {
    	
    }

    public void addRibbon(Ribbon ribbon) {
    	
    }

   
}
