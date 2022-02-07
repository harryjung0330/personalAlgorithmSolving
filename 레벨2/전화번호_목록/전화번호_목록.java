import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    public boolean solution(String[] phone_book) {

        HashSet<String> [] arrOfHashSet = new HashSet[21];

        for(String phone: phone_book)
        {
            if(arrOfHashSet[phone.length()] == null)
            {
                arrOfHashSet[phone.length()] = new HashSet<String>();
            }

            arrOfHashSet[phone.length()].add(phone);
        }


        for(String phone: phone_book)
        {
            for(int index = 1; index < phone.length(); index++)
            {
                HashSet<String> temp = arrOfHashSet[index];
                if( temp != null) {
                    if (temp.contains(phone.substring(0, index)))
                    {

                        return false;
                    }
                }
            }
        }


        return true;
    }

}
