import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
         String answer = "";

        HashMap<String, Integer> aMap = new HashMap<String, Integer>();
        
        for(String part: participant)                             //participant를 Map에 저장.
        {
            if(aMap.containsKey(part))
            {
                aMap.put(part, aMap.get(part) + 1);
            }
            else
            {
                aMap.put(part, 1);
            }
        }

        for(String compl : completion)                          //완주한 선수를 Map에서 뺀다. 동일인물이 있을수도 있다.
        {
            aMap.put(compl, aMap.get(compl) - 1);
            if(aMap.get(compl) == 0)                            //0이면 더이상 없다는 뜻이니까 지움.
            {
                aMap.remove(compl);
            }

        }

        for(String left: aMap.keySet())
        {
            answer = left;
        }

        System.out.println(answer);

        return answer;
    }
}
