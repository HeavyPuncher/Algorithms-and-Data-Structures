public class StackQueue {
    private static Stack s;
    private static Queue q;
    public static void main(String[] args) {
	prepare();
	System.out.print(q.dequeue());
	System.out.print(s.pop());//this number should be 3
	System.out.print(s.pop());//"5"
	System.out.print(q.dequeue());
	s.pop();//irrelevant
	q.dequeue();//irrelevant
	System.out.print(s.pop());//should be 0
	System.out.print(q.dequeue());
	System.out.print(s.pop());//should be 5
	System.out.println(q.dequeue());
	s.pop();//irrelevant
	q.dequeue();//irrelevant
    }
    private static void prepare() {
    	s = new Stack();
		q = new Queue();

q.enqueue(3);
s.push(0);
s.push(0);
q.enqueue(1);
s.push(5);
q.enqueue(0);
 s.push(0);
 q.enqueue(5);
s.push(5);
q.enqueue(8);
s.push(3);
q.enqueue(0);
    }
}

//33515508