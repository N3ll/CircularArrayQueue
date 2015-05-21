public class CIrcularArray<T> implements QueueI<T> {
	private T[] queue;
	private int front;
	private int back;
	private static final int DEFAULT_CAPACITY = 25;

	public CIrcularArray() {
		this(DEFAULT_CAPACITY);
	}

	public CIrcularArray(int capacity) {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[capacity + 1];
		queue = temp;
		front = 0;
		back = capacity;

	}

	@Override
	public void enqueue(T newEntry) {
		ensureCapacity();
		back = (back + 1) % queue.length;
		queue[back] = newEntry;
	}

	@Override
	public T dequeue() {
		T temp = null;
		if (!isEmpty()) {
			temp = queue[front];
			queue[front] = null;
			front = (front + 1) % queue.length;
		}
		return temp;
	}

	@Override
	public T getFront() {
		T temp = null;
		if (!isEmpty())
			temp = queue[front];
		return temp;
	}

	@Override
	public boolean isEmpty() {
		return front == ((back + 1) % queue.length);
	}

	@Override
	public void clear() {
		while (!isEmpty()) {
			dequeue();
		}

	}

	private void ensureCapacity() {
		if (front == (back + 2) % queue.length) {
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;

			@SuppressWarnings("unchecked")
			T[] temp = (T[]) new Object[2 * oldSize];
			queue = temp;

			for (int i = 0; i < oldSize - 1; i++) {

				queue[i] = oldQueue[front];
				front = (front + 1) % oldSize;
			}
			front = 0;
			back = oldSize - 2;
		}
	}
}
