import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestSingleLinkedQueue {

	QueueI<String> queue;

	@Before
	public void setUp() {
		queue = new CIrcularArray<String>();
		queue.enqueue("An");
	}

	@Test
	public void testAddDequeue() {
		assertEquals(queue.getFront(), "An");
		queue.dequeue();
		assertTrue(queue.isEmpty());
		queue.enqueue("Bob");
		assertEquals(queue.getFront(), "Bob");
	}

	@Test
	public void testIsEmpty() {
		System.out.println(queue.getFront());
		queue.dequeue();
		assertTrue(queue.isEmpty());

	}

}
