package Database;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class to represent a ribbon earned for being skillful at a Pokemon. A ribbon comes in
 * three rarities: green, blue, gold The date the ribbon was
 * earned and its respective Pokemon is also stored.
 * Created for Data Structures AnDe 2024
 * @version 1.0
 */
public class Ribbon {

    private String name;
    public enum Rarity {
        GREEN, BLUE, GOLD
    }
    private Rarity rarity;
    private Calendar obtained;
    private Pokemon pokemon;

    public Ribbon() {}

    public Ribbon(String name, Rarity rarity, Calendar obtained, Pokemon pokemon) {
    }

    public String toString() {
        return null;
    }
}
