class QuickSort
{
    void quickSort(int a[] , int s , int e)
    {
        if(s<e)
        {
            int p = partition(a,s,e);
            // elements from start to element +1 
            quickSort(a, s, p-1);
            //elements from end to element -1 
            quickSort(a, p+1, e);
            return ;
        }
    }
    int partition(int a[], int s, int e)
    {
        int k= s;
        for(int i=s ; i<e ; i++)
        {
            if(a[i] < a[e])
            {
                int t= a[i];
                a[i] = a[k];
                a[k]= t;
                k++;
            }

        }
        int temp=0;
         temp = a[k];
        a[k] = a[e];
        a[e]=temp;
        return k;
    }
}
class QuickSortDemo
{
    public static void main(String args[])
    {
        QuickSort s1 = new QuickSort();
        int a[] = {10,5,6,8,7};
        s1.partition(a,0,a.length-1);
        for(int i=0; i<a.length;i++)
        {
            System.out.println(a[i]);
        }
        
    }
}
