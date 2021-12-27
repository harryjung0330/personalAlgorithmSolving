import java.util.ArrayList;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();

            int [] cur = commands[i];
            for(int j = cur[0] - 1; j <= cur[1] - 1; j++)
            {
              temp.add(array[j]);
            }

            quickSort(temp, 0 , temp.size() - 1);


            answer[i] = temp.get(cur[2] - 1);
        }

        for(int ans:answer)
        {
            System.out.println(ans);
        }

        return answer;
    }
    
    static void quickSort(ArrayList<Integer> arr, int startInd, int endInd)
    {
        if(endInd - startInd <= 10)
        {
            selectionSort(arr, startInd, endInd);
            return;
        }

        int mid = (startInd + endInd) / 2;


        if(arr.get(startInd) > arr.get(mid))
        {
            swap(arr, startInd, mid);
        }

        if(arr.get(mid) > arr.get(endInd))
        {
            swap(arr, mid, endInd);
            if(arr.get(startInd) > arr.get(mid))
            {
                swap(arr, startInd, mid);
            }
        }

        swap(arr, mid, endInd - 1 );

        int standardVal = arr.get(endInd - 1);
        int left = startInd + 1;
        int right = endInd - 2;

        while(left < right)
        {
            while(arr.get(left) < standardVal)
            {
                left++;
            }

            while(arr.get(right) > standardVal)
            {
                right--;
            }

            if(left < right)
            {
                swap(arr, left, right);
            }
        }

        swap(arr, left, endInd - 1);

        quickSort(arr, startInd, left - 1);
        quickSort(arr, left + 1, endInd);
    }

    static void selectionSort(ArrayList<Integer> arr, int startInd, int endInd)
    {
        for(int i = startInd + 1; i <= endInd; i++)
        {
            for(int j = i; j > startInd; j--)
            {
                if(arr.get(j) < arr.get(j - 1))
                {
                    swap(arr, j, j - 1);
                }
                else
                {
                    break;
                }
            }

        }
    }
    static void swap(ArrayList<Integer> arr, int ind1, int ind2)
    {
        int temp = arr.get(ind1);
        arr.set(ind1, arr.get(ind2));
        arr.set(ind2, temp);
    }
}
