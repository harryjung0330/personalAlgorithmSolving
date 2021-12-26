class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int [] intToAdd = new int [3];

        int indForAdd = 0;

        for(int i = 0; i < dartResult.length(); i++)
        {

            char cur = dartResult.charAt(i);

            if(cur == '1' && i != dartResult.length() - 1 && dartResult.charAt(i + 1) == '0' )
            {
                i++;
                intToAdd[indForAdd] = 10;
                indForAdd++;
            }
            else if(cur >= '0' && cur <= '9')
            {
                intToAdd[indForAdd] = Character.getNumericValue(cur);
                indForAdd++;
            }
            else if(cur == 'S')
            {
                intToAdd[indForAdd - 1 ] = intToAdd[indForAdd - 1];
            }
            else if( cur == 'D')
            {
                intToAdd[indForAdd - 1] = (int) Math.pow(intToAdd[indForAdd - 1] , 2);
            }
            else if( cur == 'T')
            {
                intToAdd[indForAdd - 1 ] = (int) Math.pow(intToAdd[indForAdd - 1] , 3);
            }
            else if( cur == '*')
            {
                intToAdd[indForAdd - 1] = intToAdd[indForAdd - 1] * 2;
                if( indForAdd != 1 )
                {
                    intToAdd[indForAdd - 2] = intToAdd[indForAdd - 2] * 2;
                }
            }
            else if( cur == '#')
            {
                intToAdd[indForAdd - 1 ] = intToAdd[indForAdd - 1] * -1;
            }
        }

        for(int numbs: intToAdd)
        {
            System.out.println("numbs: " + numbs);
            answer += numbs;
        }

        System.out.println("answer: " + answer);
        return answer;
    }
    
}
