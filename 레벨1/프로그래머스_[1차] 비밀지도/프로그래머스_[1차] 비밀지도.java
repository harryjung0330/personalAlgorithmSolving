class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) 
    {
        String[] answer = new String[n];

        //turn into binary string

        int [] newInts = new int[n];
        
        //두 int를 bitwise operation (or)을 취해서 푼다.
        for(int i = 0; i < arr1.length; i++)
        {
            int newInt = arr1[i] | arr2[i];
            newInts[i] = newInt;
        }
        
        //decimal을 binary로 바꾼다.
        for(int i = 0; i < newInts.length ; i++)
        {
            int cur = newInts[i];
            String temp = "";

            for(int j = n - 1 ; j > -1 ; j-- )
            {
                int curDeno = (int) Math.pow(2, j);

                if(cur / curDeno == 1)
                {
                    cur = cur - curDeno;
                    temp += "#";
                }
                else
                {
                    temp += " ";
                }

            }
            System.out.println(" answer => " + temp);

            answer[i] = temp;
        }

        return answer;
    }
}
