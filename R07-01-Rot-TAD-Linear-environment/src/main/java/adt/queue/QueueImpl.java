package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T resp = null;
		if (!isEmpty()) {
			resp = array[0];
		}
		return resp;
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return this.tail == (array.length-1);
	}

	private void shiftLeft() {
		for (int i = 0; i < tail; i++) {
            array[i] = array[i + 1];
        }
		tail--;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!isFull()) {
			array[++tail] = element;
		}else{
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
        }
		T resp = head();
		shiftLeft();

		return resp;
	}

}
