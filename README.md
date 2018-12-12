# Bounded-Queue

CS 5V81 - Implementation of Data structures and Algorithms  
Fall 2018  
Short Project 2: Lists, Stacks, Queues  

Authors - Team SG2 15
- Prateek Sarna (pxs180012)
- Nirbhay Sibal (nxs180002)

Task  
- Implement a bounded-sized queue BoundedQueue<T>, using arrays with the following operations:
   To avoid "generic array cannot be created" error, declare the array to be Object[] and
   typecast where needed to avoid type warnings.  
   BoundedQueue(int size): Constructor for queue of given size  
   boolean offer(T x):	add a new element x at the rear of the queue  
			returns false if the element was not added because the queue is full  
   T poll():		remove and return the element at the front of the queue  
			return null if the queue is empty  
   T peek():		return front element, without removing it (null if queue is empty)  
   int size():		return the number of elements in the queue  
   boolean isEmpty():	check if the queue is empty  
   void clear():	clear the queue (size=0)  
   void toArray(T[] a):	fill user supplied array with the elements of the queue, in queue order  
  
Files Included
- BoundedQueue.java

Navigation Inside the Program  
- Size can be passed as a parameter when you run the program to specify size of the queue. If size is not provided, the default value would be 10. Once you run the program, enter  
'1' into the console to add elements in the queue (Offer),  
'2' to remove an element from the queue (Poll),  
'3' to display the element at front of the queue (Peek),  
'4' to display size of the queue,  
'5' to check if the queue is empty,  
'6' to clear the queue, and  
'7' to fill user supplied array with the elements of the queue, in queue order
