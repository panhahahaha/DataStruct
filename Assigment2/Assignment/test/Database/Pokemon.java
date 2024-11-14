package Database;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class to represent a Pokemon.
 * Created for Data Structures AnDe 2024
 *
 * @version 1.0
 */
public class Pokemon {

    public enum Role {
        SPEEDSTER, ALLROUNDER, ATTACKER, DEFENDER, SUPPORTER
    }

    private String name;
    private Role role;
    private Pokemon next;

    public Pokemon() {
    }

    public Pokemon(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public void setNext(Pokemon p) {
        this.next = p;
    }

    public String getName() {
        return name;
    }
    public Role getRole(){
        return role;
    }

    public String toString() {
        String sb = new String(this.name + ",Role:" + this.role);
        return sb;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }
}
