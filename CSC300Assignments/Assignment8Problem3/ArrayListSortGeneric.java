import java.util.*;

public class ArrayListSortGeneric<T extends Comparable<T>>
{
    public void insertionSort(ArrayList<T> x)
    {
        for (int i = 1; i < x.size(); i++)
            insert(x, i);
    }
    
    public void insert(ArrayList<T> x, int i)
    {
        T temp = x.get(i);
        int j = i - 1;
        while (j >= 0 && temp.compareTo(x.get(j)) < 0)
        {
            x.set(j + 1, x.get(j));
            j--;
        }
        x.set(j + 1, temp);
    }
}