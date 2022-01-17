function solution(answers) {
    function advance(aList, index)
    {
        var curIndex = index % aList.length;
        return aList[curIndex];
    }

    var answer = [];

    var first = [ 1, 2, 3, 4, 5];
    var second = [ 2, 1 ,2 ,3, 2, 4, 2, 5];
    var third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

    var firstGet = 0;
    var secondGet = 0;
    var thirdGet = 0;

    for( let index = 0; index < answers.length; index++)
    {
        if(answers[index] === advance(first, index))
        {
            firstGet = firstGet + 1;
        }

        if( answers[index] === advance(second, index))
        {
            secondGet = secondGet + 1;
        }

        if(answers[index] === advance(third, index))
        {
            thirdGet = thirdGet + 1;
        }
    }

    var max = 0;

    if(firstGet > max)
    {
        answer.push(1);
        max = firstGet;
    }
    else if( firstGet === max)
    {
        answer.push(1);
    }

    if(secondGet > max)
    {
        answer = [];
        answer.push(2);
        max = secondGet;
    }
    else if( secondGet === max)
    {
        answer.push(2);
    }

    if(thirdGet > max)
    {
        answer = [];
        answer.push(3);
        max = thirdGet;
    }
    else if( thirdGet === max)
    {
        answer.push(3);
    }


    return answer;
}
