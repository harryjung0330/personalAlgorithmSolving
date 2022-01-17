function solution(progresses, speeds)
{
    var answer = [];
    
    var answerElement = 0;
    var cur = -1; 
    for(var index = 0; index < progresses.length; index++)
    {
        var remaining = Math.ceil((100 - progresses[index]) / speeds[index]);

        if(cur >= remaining)
        {
            answerElement++;
        }
        else
        {
            if(answerElement !== 0 )
            {
                answer.push(answerElement);
            }
            answerElement = 1;
            cur = remaining;
        }

    }

    answer.push(answerElement);

    return answer;
}
