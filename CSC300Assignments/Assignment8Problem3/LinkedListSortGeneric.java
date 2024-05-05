import java.util.*;

public class LinkedListSortGeneric<T extends Comparable<T>>
{
    public void insertionSort(LinkedList<T> list)
    {
        if (list == null || list.isEmpty())
            return;

        LinkedList<T> sortedList = new LinkedList<>();
        sortedList.add(list.removeFirst()); // Move the first element to the sorted list

        while (!list.isEmpty())
        {
            T current = list.removeFirst();

            ListIterator<T> sortedIterator = sortedList.listIterator();

            while (sortedIterator.hasNext())
            {
                if (current.compareTo(sortedIterator.next()) <= 0)
                		{
                    sortedIterator.previous();
                    sortedIterator.add(current);
                    break;
                }
            }
            if (!sortedIterator.hasNext())
                sortedIterator.add(current);
        }

        // Replace the original list with the sorted list
        list.addAll(sortedList);
    }
}
