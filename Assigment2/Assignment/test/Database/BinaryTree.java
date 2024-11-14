package Database;

import java.util.ArrayList;

/**
 * Uses a binary search tree to store a database of
 * accounts. Nodes are ordered by user unique key (see the
 * Account class for more detail).
 * Created for Data Structures AnDe 2024
 * @version 1.0
 */
public class BinaryTree {
	public  Account bt;
	/**
	 * Making new friends is great. This method should add your new
	 * bestie to your database (tree). Remember that they should be
	 * added according to their key.
	 * @param friend The friend to be added
	 * @return true if  successfully added, false for all error cases
	 * @throws IllegalArgumentException if friend is null
	 */
	public boolean beFriend(Account friend) throws IllegalArgumentException {
	
	}

	private boolean beFriendHelper(Account node, Account current) {
		
	}

	/**
	 * Sometimes friendships don't work out. In those cases it's best
	 * to remove that "friend" altogether. This method should remove
	 * all trace of that "friend" in the database (tree).
	 * @param friend the "friend" to remove
	 * @return true if successfully removed, false for all error cases
	 * @throws IllegalArgumentException if "friend" is null
	 */
	public boolean removeFriend(Account friend) throws IllegalArgumentException {
		
	}

	private boolean removeFriendHelper(Account node, Account parent, double key) {
		
	}


	/**
	 * In your quest to be the very best you need to know how many
	 * of your friends are ranked higher than you. This method should
	 * return the number of higher ranked users than the provided reference
	 * user, or zero if there are none.
	 * @param reference The starting point in the search
	 * @return Number of higher ranked users or -1 if user not found
	 * @throws IllegalArgumentException if reference is null
	 */
	public int countBetterPlayers(Account reference) throws IllegalArgumentException {
		
	}

	private int countBetterPlayersHelper(Account node, double key) {
	
	}

	/**
	 * Bragging rights are well earned, but it's good to be sure that you're actually
	 * better than those over whom you're lording your achievements. This method
	 * should find all those friends who have a lower level than you, or zero if
	 * there are none (you suck).
	 * @param reference The starting point in the search
	 * @return Number of lower ranked users
	 * @throws IllegalArgumentException if reference is null
	 */
	public int countWorsePlayers(Account reference) throws IllegalArgumentException {
		
	}

	private int countWorsePlayersHelper(Account node, double key) {
		
	
	}

	/**
	 * The best player may not necessarily be measured by who has the highest level.
	 * Ribbons earned showcase skill on each Pokemon, so it would be good to know who has the
	 * most. This method should return the user with the highest ribbon score 
	 * Note: Ribbon score is calcualted by addding all ribbons togehter:
	 * GREEN = 1, BLUE = 2, GOLD = 3.
	 * @return the user with the highest ribbon score, or null if there are none
	 */
	public Account highestRibbonScore() {
		
	}

	private void highestRibbonScoreHelper(Account node) {
		
	}
	

	/**
	 * You or one of your friends unlocked a new pokemon! This method should add it to their
	 * PokemonList.
	 * @param username The user who has unlocked the pokemon
	 * @param pokemon The pokemon to be added
	 */
	public void addPokemon(String username, Pokemon pokemon) throws IllegalArgumentException {
		
	}



	/**
	 * You or one of your friends achieved a new ribbon! This method should add it to
	 * their ribbons.
	 * @param username The user who has earned a new ribbon
	 * @param ribbon The ribbon to be added   
	 */
	public void addRibbon(String username, Ribbon ribbon) throws IllegalArgumentException {
		
	}

	/**
	 * You or one of your friends has gained one level! This is great news, except that
	 * it may have ruined your tree structure! A node move may be in order.
	 * See the assignment specification for some additional hints
	 * @param username The user whose level has increased
	 */
	public void levelUp(String username) throws IllegalArgumentException {
		
	}

	/**
	 * As your friends list grows, adding with regular binary tree rules will
	 * result in an unbalanced and inefficient tree. One approach to fix this
	 * is to implement an add method that uses AVL balancing. This method should
	 * work in the same way as beFriend, but maintain a balanced tree according to
	 * AVL rules.
	 * HINT: You will likely want a rebalance method or multiple to help rotate the tree.
	 * @param friend The friend to be added
	 * @return true if  successfully added, false for all error cases
	 * @throws IllegalArgumentException if friend is null
	 */
	public boolean addAVL(Account friend) throws IllegalArgumentException {
		
	}
	private boolean addAVL(Account parent, boolean isRight, Account current, Account friend) {
		
	}
	

	/**
	 * A nice, neat print-out of your friends would look great in the secret scrap-book
	 * that you keep hidden underneath your pillow. This method should print out the
	 * details of each user, traversing the tree in order.
	 * @return A string version of the tree
	 */
	public String toString() {
		
	}

}
