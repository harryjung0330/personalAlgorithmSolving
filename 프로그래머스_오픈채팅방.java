import java.util.ArrayList;
import java.util.HashMap;

public class Prac3
{
    public static final String ENTER = "Enter";
    public static final String CHANGE = "Change";
    public static final String Leave = "Leave";
    
    //Msg라는 container클래스 생성 -> msgNum이 0이면 들어왔습니다, 1이면 나갔습니다.
    //id는 사용자 id
    public static class Msg
    {
        public int msgNum;
        public String id;

        public Msg(int msgNum, String id)
        {
            this.msgNum = msgNum;
            this.id = id;
        }
    }

    public static void main(String[] args)
    {
        solution( new String []{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }

  
    public static String[] solution(String[] record)
    {
        
        String[] answer;
        ArrayList<Msg> arrayMsg = new ArrayList<Msg>();                                 //msg리스트
        HashMap<String, String> idDict = new HashMap<String, String>();                 //해당 id랑 사용자 이름을 매핑하는 HashMap

        for(String stringToParse: record)
        {
            String temp[] = stringToParse.split(" ");                                   //메세지를 space를 기준으로 split -> 첫단어를 통해서 메세지 타입을 알수있다 두번째 단어는 id
            if (temp[0].equals(ENTER))                                                  //Enter 메세지면 이름이 바뀔수도 있으니 HashMap을 수정, 그리고 arrayMsg에 추가
            {

                arrayMsg.add(new Msg(0, temp[1]));
                if (idDict.containsKey(temp[1]))
                {
                    idDict.replace(temp[1], temp[2]);
                }
                else
                {
                    idDict.put(temp[1], temp[2]);
                }

            }
            else if (temp[0].equals(CHANGE))                                           //Change면 id가 바뀐다는 뜻이니 HashMap을 수정한다 하지만 answer에 리턴할 필요가 없다 따라서
            {                                                                          //arrayMsg에 저장할필요가 없다
                idDict.replace(temp[1], temp[2]);
            }
            else                                                                       //나갔다는 메세지는 이름이 변경될수 없으니 arrayMsg에만 저장
            {
                arrayMsg.add(new Msg(1, temp[1]));
            }
        }                                                                              //for loop후에 변경된 이름이 다 반영이 되니까 이제 answer 메세지를 만들수 있다.

        answer = new String[arrayMsg.size()];

        int index = 0;

        for(Msg msg: arrayMsg)                                                          //이름을 idDict를 통해서 가져온다
        {
            if(msg.msgNum == 0)                                                         //여기서 퍼포맨스를 더 향상시키기위해 StringBuilder사용하는것을 추천 
            {
                answer[index] = idDict.get(msg.id) + "님이 들어왔습니다.";                
            }
            else
            {
                answer[index] = idDict.get(msg.id) + "님이 나갔습니다.";
            }

            index++;
        }

        return answer;
    }
}
