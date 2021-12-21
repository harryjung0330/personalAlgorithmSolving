import java.lang.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int L = 10;
        int R = 12;
        boolean isLeftHanded = false;
        
        if(hand.equals("left"))
        {
            isLeftHanded = true;
        }
        
        for(int cur : numbers)
        {
            if(cur == 0)                                            //0을 편의상 11로 매핑, special case 다룰때 용의하다.
                cur = 11;
            
            if(cur % 3 == 0)
            {
                answer += "R";
                R = cur;
            }
            
            if(cur % 3 == 1)
            {
                answer += "L";
                L = cur;
            }
            
            if(cur % 3 == 2)                                              //special case  2 -> 0, 5 -> 1, 8 -> 2, 11 -> 3 으로 매핑해서 푼다.  
            {
                int Rcount = 1;
                int Lcount = 1;
                int target = cur / 3;                                     //현재 cur은 어디에 있는가
                int Rstart = (R - 1)/ 3;                                  //오른 손가락을 가운데에 놨을때 어디에서 시작하는가 
                int Lstart = L / 3;                                       //왼손가락을 가운데에 놨을때 어디에서 시작하는가
                
                if( R % 3 == 2)                                            //오른손가락이 이미 가운데 라인( 2, 5, 8, 11)중 하나에 올려져 있다면 Rcount를 줄인다.
                    Rcount = 0;
                
                if( L % 3 == 2)                                             //왼손가락이 이미 가운데 라인( 2, 5, 8, 11)중 하나에 올려져 있다면 Lcount를 줄인다.
                    Lcount = 0;
                
                Rcount = Rcount + Math.abs(Rstart - target);              //오른손가락과 현제 눌러야되는 번호의 거리
                Lcount = Lcount + Math.abs(Lstart - target);              //왼손가락과 현제 눌러야되는 번호의 거리
                
                if( Rcount > Lcount)
                {
                    answer += "L";
                    L = cur;
                }
                else if( Lcount > Rcount)
                {
                    answer += "R";
                    R = cur;
                }
                else
                {
                    if(isLeftHanded)
                    {
                        answer += "L";
                        L = cur;
                    }
                    else
                    {
                        answer += "R";
                        R = cur;
                    }
                }
                
            }
        }
        return answer;
    }
}
