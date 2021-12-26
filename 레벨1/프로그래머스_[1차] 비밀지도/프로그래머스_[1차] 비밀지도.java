class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        //turn into binary string
        String [] str1 = new String[n];
        String [] str2 = new String[n];
        
      
        //숫자를 바이너리로 변환
        for(int i = 0; i < arr1.length ; i++)
        {
            int cur = arr1[i];
            String temp = "";

            for(int j = n - 1 ; j > -1 ; j-- )
            {
                int curDeno = (int) Math.pow(2, j);

                if(cur / curDeno == 1)
                {
                    cur = cur - curDeno;
                    temp += "1";
                }
                else
                {
                    temp += "0";
                }

            }
            System.out.println(" i => " + temp);

            str1[i] = temp;
        }
        
      
        //숫자를 바이너리로 변환
        for(int i = 0; i < arr2.length ; i++)
        {
            int cur = arr2[i];
            String temp = "";

            for(int j = n - 1 ; j > -1 ; j-- )
            {
                int curDeno = (int) Math.pow(2, j);

                if(cur / curDeno == 1)
                {
                    cur = cur - curDeno;
                    temp += "1";
                }
                else
                {
                    temp += "0";
                }

            }

            str2[i] = temp;
            System.out.println(" i => " + temp);
        }
        
      
        //숫자를 OR한것과 비슷
        for(int i = 0; i < str1.length; i++)
        {
            String curStr1 = str1[i];
            String curStr2 = str2[i];
            String tempStr = "";

            for(int j = 0; j < curStr1.length(); j++)
            {
                if(curStr1.charAt(j) == '0' && (curStr1.charAt(j) == curStr2.charAt(j)))
                {
                    tempStr += " ";
                }
                else
                {
                    tempStr += "#";
                }
            }

            System.out.println("tempStr => " + tempStr);

            answer[i] = tempStr;

        }


        return answer;
    }
}
