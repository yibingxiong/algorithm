package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

	Queue<Integer> queue;
	public RecentCounter() {
		queue = new LinkedList<Integer>();
	}

	public int ping(int t) {
		queue.add(t);
        while (queue.peek() < t - 3000) {
        	 queue.poll();
        }    
        return queue.size();
	}
}

public class Code933_RecentCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
