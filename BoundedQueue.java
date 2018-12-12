/*
 * 	Prateek Sarna - pxs180012
 * 	Nirbhay Sibal - nxs180002
 */

package pxs180012;

import java.util.Scanner;

public class BoundedQueue<T> {
	Object[] q;
	int front;
	int rear;

	// Constructor for queue of given size
	BoundedQueue(int size) {
		q = new Object[size];
		front = -1;
		rear = -1;
	}

	// add a new element x at the rear of the queue
	// returns false if the element was not added because the queue is full
	boolean offer(T x) {
		if (size() == q.length) { // queue is full if true
			return false;
		}
		if (isEmpty()) {
			front = 0;
			rear = 0;
		} else {
			rear = (rear + 1) % q.length;
		}
		q[rear] = x;
		return true;
	}

	// remove and return the element at the front of the queue
	// return null if the queue is empty
	T poll() {
		if (isEmpty()) {
			return null;
		}
		T element = (T) q[front];
		if (front == rear) {
			clear();
		} else {
			front = (front + 1) % q.length;
		}
		return element;
	}

	// return front element, without removing it (null if queue is empty)
	T peek() {
		if (isEmpty()) {
			return null;
		}
		return (T) q[front];
	}

	// return the number of elements in the queue
	int size() {
		if (isEmpty()) {
			return 0;
		} else {
			return ((front > rear) ? (q.length - front + rear + 1) : (rear - front + 1));
		}
	}

	// check if the queue is empty
	boolean isEmpty() {
		if (front == -1 && rear == -1) {
			return true;
		} else {
			return false;
		}
	}

	// void clear(): clear the queue (size=0)
	void clear() {
		front = -1;
		rear = -1;
	}

	// void toArray(T[] a):fill user supplied array with the elements of the queue,
	// in queue order
	void toArray(T[] a) {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
		} else {
			int cursor = front;
			for (int i = 0; i < size(); i++) {
				a[i] = (T) q[(i + cursor) % q.length];
			}
		}
	}

	public static void main(String[] args) {
		int n = 10;
		if (args.length > 0) {
			n = Integer.parseInt(args[0]);
		}

		BoundedQueue<Integer> q = new BoundedQueue<>(n);
		Scanner in = new Scanner(System.in);

		whileloop: while (in.hasNext()) {
			int com = in.nextInt();
			switch (com) {
			case 1: // Offer (Add element to queue)
				System.out.print("Enter element to add: ");
				System.out.println((q.offer(in.nextInt())) ? "" : false);
				break;
			case 2: // Poll (Remove element from queue)
				System.out.println("Element removed: " + q.poll());
				break;
			case 3: // Peek (Display first element of queue)
				System.out.println("Peek: " + q.peek());
				break;
			case 4: // Size (Display size of queue)
				System.out.println("Size: " + q.size());
				break;
			case 5: // isEmpty (Check if queue is empty)
				System.out.println("isEmpty : " + q.isEmpty());
				break;
			case 6: // Clear (clear the queue)
				q.clear();
				System.out.println("Queue cleared!");
				break;
			case 7: // toArray (Fill user supplied array with the elements of the queue, in queue
				// order)
				Integer[] a = new Integer[q.size()]; // Array is given the same size as the current size of queue 
				q.toArray(a);
				for (int i = 0; i < q.size(); i++)
					System.out.print("" + a[i] + " ");
				System.out.println("");
				break;
			default: // Exit loop
				break whileloop;
			}
		}
	}
}
