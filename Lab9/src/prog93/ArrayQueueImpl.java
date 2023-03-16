package prog93;

import java.util.Arrays;

public class ArrayQueueImpl {
	private int[] arr = new int[10];
	private int size = 0;
	private int front = -1;
	private int rear = 0;
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) {
		ArrayQueueImpl q = new ArrayQueueImpl();
		
		for(int i = 0; i < 15; i ++) {
			q.enqueue(i);
		}

		System.out.println("After enqueue: " + q);

		for(int i = 0; i < 14; i ++)
			q.dequeue();

		System.out.println("After dequeue: " + q);

		System.out.println("Size: " + q.size());
		System.out.println("Peek: " + q.peek());
	}

	private int size() {
		return this.size;
	}

	private int peek(){
		if(isEmpty()) throw new IllegalStateException("Cannot peek because Queue is empty!");

		return this.arr[front];
	}

	private void enqueue(int i){
		if(size + 1 > this.arr.length) resize();
		this.arr[size] = i;

		if(front < 0) front = 0;
		size++;
		rear++;
	}

	private int dequeue(){
		if(isEmpty()) throw new IllegalStateException("Cannot dequeue because Queue is empty!");
		front++;
		size--;
		return this.arr[front - 1];
	}

	private void resize(){
		int[] aux = new int[this.arr.length * 2];
		System.arraycopy(this.arr, 0, aux, 0, this.arr.length);
		this.arr = aux;
	}

	@Override
	public String toString() {
		String aux = "[ ";
		for(int i = front; i < rear; i++){
			if(i == rear - 1) {
				aux += this.arr[i];
				break;
			}
			aux += this.arr[i] + ", ";
		}
		aux += " ]";

		return aux;
	}
}

