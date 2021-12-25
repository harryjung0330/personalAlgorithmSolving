class Solution {
    public String solution(String new_id) {
        String case1Str = new_id.toLowerCase();

        String case2Str = "";
        for(int i = 0 ; i < case1Str.length(); i++)
        {
            char tempChar = case1Str.charAt(i);
            if( tempChar != '_' && tempChar != '-' && tempChar != '.' &&
                    !(tempChar >= '0' && tempChar <= '9')  && !(tempChar >= 'a' && tempChar <= 'z'))
                continue;

            case2Str += tempChar;

        }

        System.out.println("case2str: " + case2Str);

        String case3Str = "";

        char cur;

        for(int i = 1; i < case2Str.length(); i++)
        {
            char prev = case2Str.charAt(i - 1);
            cur = case2Str.charAt(i);

            if(prev == cur && prev == '.')
                continue;

            case3Str += prev;

        }

        System.out.println("case3str: " + case3Str);

        cur = case2Str.charAt(case2Str.length() - 1);

        if( cur != '.')
            case3Str += cur;

        String case4Str;

        if(case3Str.length() > 0 && case3Str.charAt(0) == '.')
            case4Str = case3Str.substring(1);
        else
            case4Str = case3Str;

        System.out.println("case4str: " + case4Str);

        String case5Str = case4Str;

        if(case4Str.length() == 0)
            case5Str ="a";

        System.out.println("case5str: " + case5Str);

        String case6Str = case5Str;

        if(case5Str.length() > 15)
        {
            String temp = case5Str.substring(0, 15);
            if(temp.charAt(14) == '.')
                temp = temp.substring(0, 14);
            case6Str = temp;
        }

        System.out.println("case6str: " + case6Str);

        String case7Str = case6Str;

        while(case7Str.length() < 3)
        {
            case7Str = case7Str + case7Str.charAt(case7Str.length() - 1);
        }

        System.out.println("case7str: " + case7Str);

        return case7Str;

        
    }
}
