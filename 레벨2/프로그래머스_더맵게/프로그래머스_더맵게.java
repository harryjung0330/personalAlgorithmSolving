import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> scovilQueue = new PriorityQueue<Integer>();

        for(int scov : scoville)
        {
            scovilQueue.add(scov);
        }

        while((scovilQueue.size() >= 2) && scovilQueue.peek() < K )
        {
            
            answer++;
            scovilQueue.add(newScovil(scovilQueue.poll(), scovilQueue.poll()));
        }
        
        if(scovilQueue.peek() < K)
        {
            answer = -1;
        }
            

        return answer;
    }

    public int newScovil(int first, int second)
    {
        return first + second * 2;
    }

}
