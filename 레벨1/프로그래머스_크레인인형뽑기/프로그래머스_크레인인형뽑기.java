import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int solution(int[][] board, int[] moves) {
int answer = 0;
        ArrayList<Integer> basket = new ArrayList<Integer>();

        HashMap<Integer, Integer> moveMap = new HashMap<Integer, Integer>();

        int pop = 0;
        //해쉬맵을 써서 인형을 뽑을때 어디있는지 바로 찾을수 있게 해쉬맵을 먼저 만든다.
      
        for(int i = 0; i < board.length; i++)
        {
            moveMap.put(i, board.length);
        }

        for(int i = board.length - 1 ; i >= 0; i--)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if( board[i][j] != 0)
                    moveMap.put(j, i);
            }
        }
     

        for(int move: moves)
        {
            move = move - 1;
          
            if(moveMap.get(move) < board.length)                                        //그 칸에 남아있을시
            {
                int last = -1;

                if(basket.size() != 0 )
                {
                    last = basket.get(basket.size() - 1);
                }

                int moveNum = board[moveMap.get(move)][move];   

                if(moveNum == last)
                {
                    basket.remove(basket.size() - 1);
                    pop += 2;                                                               //2개씩 사라지므로 
                }
                else
                {
                    basket.add(moveNum);
                }


                moveMap.put(move, moveMap.get(move) + 1);                                   //그 줄에 인형하나를 줄인다.
            }
        }
      
        return pop;
    }
}
