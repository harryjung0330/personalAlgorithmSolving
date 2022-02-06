import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    public boolean solution(String[] phone_book) {

        PriorityQueue<Node> aPrio = new PriorityQueue<Node>();

        for(String phone: phone_book)
        {
            aPrio.add(new Node(phone));
        }

        HashSet<String>[] arrOfHashSet = new HashSet[21];

        for(Node aNode: aPrio)
        {
            String phone = aNode.tempString;
            int length = phone.length();

            for(int ind = 1; ind < length; ind++)
            {
                HashSet<String> hashSet = arrOfHashSet[ind];

                if(hashSet != null) {
                    if (hashSet.contains(phone.substring(0, ind))) {
                        if(ind != length)
                        {
                            return false;
                        }
                        
                    }
                }

            }

            if(arrOfHashSet[length] == null)
            {
                arrOfHashSet[length] = new HashSet<String>();
            }

            arrOfHashSet[length].add(phone);
        }

        return true;
    }

}

class Node implements Comparable<Node>
{
    int size;
    String tempString;

    public Node(String aString)
    {
        tempString = aString;
        size = aString.length();
    }

    @Override
    public int compareTo(Node o) {
        return size - o.size;
    }
}
