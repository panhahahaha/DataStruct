package Testing;

import Database.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Tests an implementation of AVL tree balancing. Don't
 * be complacent if not every form of rotation is tested,
 * or the tests don't test the complete tree! A different,
 * unseen set of nodes will be used for marking so stick to
 * the algorithm and do your own extra testing.
 * UNSEEN TESTS WILL ALSO TEST RIGHT ROTATIONS!
 */
public class AVLTest extends DSUnitTesting {
	private BinaryTree bt;
	private Account oberon, pippin, medraut, astaroth, lunete, guiomar, faust, sophronia, haidee, dulcinea, cosette, nelida;
	
	@Before
	public void initialise() {
		bt = new BinaryTree();
		Pokemon pikachu = new Pokemon("Pikachu", Pokemon.Role.ATTACKER);
		Calendar c = new GregorianCalendar(2024, 1, 28); // Ribbons can have the same date - we don't care for these tests
		Ribbon pikachuR1 = new Ribbon("Electro Ball", Ribbon.Rarity.GOLD, c, pikachu);
		
		PokemonList gl = new PokemonList(pikachu);
		ArrayList<Ribbon> rl = new ArrayList<Ribbon>(); rl.add(pikachuR1);
		
		oberon = new Account("Oberon", 7); oberon.setPokemons(gl); oberon.setRibbons(rl);
		pippin = new Account("Pippin", 10); pippin.setPokemons(gl); pippin.setRibbons(rl);
		medraut = new Account("Medraut", 8); medraut.setPokemons(gl); medraut.setRibbons(rl);
		astaroth = new Account("Astaroth", 9); astaroth.setPokemons(gl); astaroth.setRibbons(rl);
		lunete = new Account("Lunete", 12); lunete.setPokemons(gl); lunete.setRibbons(rl);
		guiomar = new Account("Guiomar", 14); guiomar.setPokemons(gl); guiomar.setRibbons(rl);
		faust = new Account("Faust", 4); faust.setPokemons(gl); faust.setRibbons(rl);
		sophronia = new Account("Sophronia", 6); sophronia.setPokemons(gl); sophronia.setRibbons(rl);
		haidee = new Account("Haidee", 5); haidee.setPokemons(gl); haidee.setRibbons(rl);
		cosette = new Account("Cosette", 3); cosette.setPokemons(gl); cosette.setRibbons(rl);
		dulcinea = new Account("Dulcinea", 3); dulcinea.setPokemons(gl); dulcinea.setRibbons(rl);
		nelida = new Account("Nelida", 1); nelida.setPokemons(gl); nelida.setRibbons(rl);
	}
	
	@Test
	public void addAVLStage1() {
		AssignmentMarker.marks.put("AVL:addAVLStage1", 3.0f);
		bt.addAVL(nelida);
		bt.addAVL(cosette);
		bt.addAVL(dulcinea);
		
		assertEquals("Check root after rotation", cosette, bt.root);
		assertEquals("Check root left", nelida, bt.root.getLeft());
		assertEquals("Check root right", dulcinea, bt.root.getRight());
		
		bt.addAVL(faust);
		bt.addAVL(haidee);
		
		assertEquals("Check root after rotation", cosette, bt.root);
		assertEquals("Check root left", nelida, bt.root.getLeft());
		assertEquals("Check root right", faust, bt.root.getRight());
		assertEquals("Check Faust's left", dulcinea, faust.getLeft());
		assertEquals("Check Faust's right", haidee, faust.getRight());
		
		bt.addAVL(sophronia);
		
		assertEquals("Check new root", faust, bt.root);
		assertEquals("Check root left", cosette, bt.root.getLeft());
		assertEquals("Check root right", haidee, bt.root.getRight());
		assertEquals("Check that Faust's old left subtree moved", dulcinea, cosette.getRight());
	}
	
	@Test
	public void addAVLStage4() {
		AssignmentMarker.marks.put("AVL:addAVLStage4", 3.0f);
		bt.addAVL(guiomar);
		bt.addAVL(lunete);
		bt.addAVL(pippin);
		
		assertEquals("Check root after rotation", lunete, bt.root);
		assertEquals("Check root left", pippin, bt.root.getLeft());
		assertEquals("Check root right", guiomar, bt.root.getRight());
		
		bt.addAVL(astaroth);
		bt.addAVL(medraut);
		
		assertEquals("Check root after rotation", lunete, bt.root);
		assertEquals("Check root left", astaroth, bt.root.getLeft());
		assertEquals("Check Astaroth's left", medraut, astaroth.getLeft());
		assertEquals("Check Astaroth's right", pippin, astaroth.getRight());
		assertNull("Check Pippin's left", pippin.getLeft());
		assertNull("Check Pippin's right", pippin.getRight());
		
		bt.addAVL(oberon);
		
		assertEquals("Check new root", astaroth, bt.root);
		assertEquals("Check Astaroth's right", lunete, astaroth.getRight());
		assertEquals("Check Astaroth's left", medraut, astaroth.getLeft());
		assertEquals("Check Medraut's left", oberon, medraut.getLeft());
	}
	
	@Test
	public void addAVLStage2() {
		AssignmentMarker.marks.put("AVL:addAVLStage2", 2.5f);
		// Stage 1 adds
		bt.addAVL(nelida);
		bt.addAVL(cosette);
		bt.addAVL(dulcinea);
		bt.addAVL(faust);
		bt.addAVL(haidee);
		bt.addAVL(sophronia);
		
		bt.addAVL(oberon);
		
		assertEquals("Check root right", sophronia, bt.root.getRight());
		assertEquals("Check Haidee's right", null, haidee.getRight());
		assertEquals("Check Sophronia's left", haidee, sophronia.getLeft());
		
		bt.addAVL(medraut);
		bt.addAVL(astaroth);
		
		assertEquals("Check Oberon's right", null, oberon.getRight());
		assertEquals("Check Medraut's left", oberon, medraut.getLeft());
		assertEquals("Check Medraut's right", astaroth, medraut.getRight());
		
		bt.addAVL(pippin);
		
		assertEquals("Check Astaroth's right", pippin, astaroth.getRight());
		assertEquals("Check root right", medraut, bt.root.getRight());
		assertEquals("Check that Medraut's old left subtree moved", oberon, sophronia.getRight());
		assertEquals("Check Medraut's left", sophronia, medraut.getLeft());
		assertEquals("Check Medraut's right", astaroth, medraut.getRight());
	}
	
	@Test
	public void addAVLStage5() {
		AssignmentMarker.marks.put("AVL:addAVLStage5", 2.5f);
		// Stage 4 adds
		bt.addAVL(guiomar);
		bt.addAVL(lunete);
		bt.addAVL(pippin);
		bt.addAVL(astaroth);
		bt.addAVL(medraut);
		bt.addAVL(oberon);
		
		bt.addAVL(sophronia);
		
		assertEquals("Check root left", oberon, bt.root.getLeft());
		assertEquals("Check Oberon left", sophronia, oberon.getLeft());
		assertEquals("Check Oberon right", medraut, oberon.getRight());
		assertNull("Check Medraut left", medraut.getLeft());
		assertNull("Check Medraut right", medraut.getRight());
		
		bt.addAVL(haidee);
		bt.addAVL(faust);
		
		assertEquals("Check Oberon left", haidee, oberon.getLeft());
		assertEquals("Check Haidee left", faust, haidee.getLeft());
		assertEquals("Check Haidee right", sophronia, haidee.getRight());
		assertNull("Check Sophronia left", sophronia.getLeft());
		assertNull("Check Sophronia right", sophronia.getRight());
		
		assertEquals("Check root hasn't changed", astaroth, bt.root);
		assertEquals("Check root right", lunete, bt.root.getRight());
	}
	
	@Test
	public void addAVLStage3() {
		AssignmentMarker.marks.put("AVL:addAVLStage3", 2.5f);
		// Stage 1 adds
		bt.addAVL(nelida);
		bt.addAVL(cosette);
		bt.addAVL(dulcinea);
		bt.addAVL(faust);
		bt.addAVL(haidee);
		bt.addAVL(sophronia);
		
		// Stage 2 adds
		bt.addAVL(oberon);
		bt.addAVL(medraut);
		bt.addAVL(astaroth);
		bt.addAVL(pippin);
		
		bt.addAVL(lunete);
		
		assertEquals("Check Pippin's right", lunete, pippin.getRight());
		assertEquals("Check Medraut's right", pippin, medraut.getRight());
		assertEquals("Check Pippin's left", astaroth, pippin.getLeft());
		assertEquals("Check Astaroth's left", null, astaroth.getLeft());
		assertEquals("Check Astaroth's right", null, astaroth.getRight());
		
		bt.addAVL(guiomar);
		
		assertEquals("Check root", medraut, bt.root);
		assertEquals("Check Medraut's left", faust, medraut.getLeft());
		assertEquals("Check Medraut's right", pippin, medraut.getRight());
		assertEquals("Check Faust's left", cosette, faust.getLeft());
		assertEquals("Check Faust's right", sophronia, faust.getRight());
		assertEquals("Check Sophronia's right", oberon, sophronia.getRight());
	}
	
	@Test
	public void addAVLStage6() {
		AssignmentMarker.marks.put("AVL:addAVLStage6", 2.5f);
		// Stage 1 adds
		bt.addAVL(guiomar);
		bt.addAVL(lunete);
		bt.addAVL(pippin);
		bt.addAVL(astaroth);
		bt.addAVL(medraut);
		bt.addAVL(oberon);
		
		// Stage 2 adds
		bt.addAVL(sophronia);
		bt.addAVL(haidee);
		bt.addAVL(faust);
		
		bt.addAVL(dulcinea);
		
		assertEquals("Check root's left", haidee, bt.root.getLeft());
		assertEquals("Check Haidee's right", oberon, haidee.getRight());
		assertEquals("Check Oberon's left", sophronia, oberon.getLeft());
		assertEquals("Check Faust's left", dulcinea, faust.getLeft());
		
		bt.addAVL(cosette);
		
		assertEquals("Check root's left", haidee, bt.root.getLeft());
		assertEquals("Check Haidee's left", dulcinea, haidee.getLeft());
		assertEquals("Check Haidee's right", oberon, haidee.getRight());
		assertEquals("Check Dulcinea's left", cosette, dulcinea.getLeft());
		assertEquals("Check Dulcinea's right", faust, dulcinea.getRight());
		assertNull("Check Faust's left", faust.getLeft());
		assertNull("Check Faust's right", faust.getRight());
		assertEquals("Check root's left", haidee, bt.root.getLeft());
		assertEquals("Check root's right", lunete, bt.root.getRight());
		assertEquals("Check Lunete's left", pippin, lunete.getLeft());
		
		bt.addAVL(nelida);
		
		assertEquals("Check new root", haidee, bt.root);
		assertEquals("Check root left", dulcinea, bt.root.getLeft());
		assertEquals("Check root right", astaroth, bt.root.getRight());
		assertEquals("Check Astaroth's left", oberon, astaroth.getLeft());
		assertEquals("Check Astaroth's right", lunete, astaroth.getRight());
		assertEquals("Check Cosette's left", nelida, cosette.getLeft());
	}
}
