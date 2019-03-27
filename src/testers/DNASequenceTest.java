package testers;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import classes.DNASequence;

public class DNASequenceTest {

	DNASequence DNASequenceL5, DNASequenceL5R, DNASequenceL10, DNASequenceL15, DNASequenceL20, DNASequence5,
		DNASequence6, DNASequence7, DNASequence8;

	@SuppressWarnings("rawtypes")
	ArrayList empty, onlyOne, allSame, contained1, contained2, contained3, contained4, contained5, notContained;


	// Methods annotated with @Before are repeatedly executed once before running each test method
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Before
	public void setUp() {
		DNASequenceL5 = new DNASequence("AGTCG", "dna");
		DNASequenceL5R = new DNASequence("GCTGA", "dna");
		DNASequenceL10 = new DNASequence("AGTCGGCTGA", "dna");
		DNASequenceL15 = new DNASequence("AGTCGGCTGACCCCC", "dna");
		DNASequenceL20 = new DNASequence("AGTCGGCTGACCCCCATATA", "dna");

		empty = new ArrayList();
		onlyOne = new ArrayList(Arrays.asList(DNASequenceL5));
		allSame = new ArrayList(Arrays.asList(DNASequenceL10, DNASequenceL10, DNASequenceL10));
		contained1 = new ArrayList(Arrays.asList(DNASequenceL5, DNASequenceL10));
		contained2 = new ArrayList(Arrays.asList(DNASequenceL5, DNASequenceL5R, DNASequenceL10));
		contained3 = new ArrayList(Arrays.asList(DNASequenceL5R, DNASequenceL5, DNASequenceL10));
		contained4 = new ArrayList(Arrays.asList(DNASequenceL10, DNASequenceL5));
		contained5 = new ArrayList(Arrays.asList(DNASequenceL10, DNASequenceL10));
		notContained = new ArrayList(Arrays.asList(DNASequenceL5, DNASequenceL5R));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testLongestSequence() {
		assertEquals(null, DNASequence.longestSequence(empty));
		assertNotNull(DNASequence.longestSequence(onlyOne));
		assertEquals(onlyOne.get(0), DNASequence.longestSequence(onlyOne));
		assertNotNull(DNASequence.longestSequence(allSame));
		assertEquals(allSame.get(0), DNASequence.longestSequence(allSame));
		assertNotNull(DNASequence.longestSequence(contained2));
		assertEquals(contained2.get(2), DNASequence.longestSequence(contained2));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testConcatenate() {
		assertNotNull(DNASequence.concatenate(empty));
		assertEquals(new DNASequence("", "dna"), DNASequence.concatenate(empty));
		assertNotNull(DNASequence.concatenate(onlyOne));
		assertEquals(DNASequenceL5, DNASequence.concatenate(onlyOne));
		assertNotNull(DNASequence.concatenate(notContained));
		assertEquals(DNASequenceL10, DNASequence.concatenate(notContained));
	}


	@SuppressWarnings("unchecked")
	@Test
	public void testExists() {
		assertFalse(DNASequenceL10.exists(empty));
		assertFalse(DNASequenceL10.exists(onlyOne));
		assertTrue(DNASequenceL5.exists(onlyOne));
		assertTrue(DNASequenceL10.exists(allSame));
		assertTrue(DNASequenceL10.exists(contained3));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testPrepend() {
		assertEquals(onlyOne, DNASequenceL5.prepend(empty));
		assertEquals(contained4, DNASequenceL10.prepend(onlyOne));
		assertEquals(allSame, DNASequenceL10.prepend(contained5));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testCompletelyContained() {
		assertFalse(DNASequence.someCompletelyContained(empty));
		assertFalse(DNASequence.someCompletelyContained(notContained));
		assertTrue(DNASequence.someCompletelyContained(contained1));
		assertTrue(DNASequence.someCompletelyContained(contained2));
		assertTrue(DNASequence.someCompletelyContained(contained3));
		assertTrue(DNASequence.someCompletelyContained(contained4));
		assertTrue(DNASequence.someCompletelyContained(contained5));
	}
}