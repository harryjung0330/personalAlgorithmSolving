import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Node> aQueue = new LinkedList<Node>();
        int priorOfLoc = priorities[location];

        PriorityQueue<Node> aPrio = new PriorityQueue<Node>();

        for(int ind = 0; ind < priorities.length; ind++)
        {
            Node temp = new Node(priorities[ind], ind);
            aPrio.add(temp);
            aQueue.add(temp);
        }

        int polled = 0;

        while(!(aQueue.isEmpty()))
        {
           if(aPrio.peek().prioirty == aQueue.peek().prioirty)
           {
               aPrio.poll();
               Node temp = aQueue.poll();
               polled++;

               if(temp.loc == location)
               {
                   return polled;
               }
           }
           else
           {
               aQueue.add(aQueue.poll());
           }
        }

        return polled;
    }

    
}

class Node implements Comparable<Node>
{
    int prioirty;
    int loc;

    public Node(int prio, int loc)
    {
        prioirty = prio;
        this.loc = loc;
    }

    public int compareTo(Node o)
    {
        return o.prioirty - prioirty;
    }

}
