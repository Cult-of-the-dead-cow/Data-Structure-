class MergeSort
{
    void mergeSort(int a[], int start, int end)
    {
        if(start<end)
        {
            int mid =(start + end )/2;
            mergeSort(a,start,mid);
            mergeSort(a, mid+1, end);
            merge(a, start, mid, end);
        }
    }
    void merge(int a[] , int start , int mid ,int end)
    {
        //left side of array 
        int l[] = new int [mid - start+1 ];
        //right side of array
        int r[] = new int[end -mid];

        int p,q; p=q=0;
        // entering th elements of a[i] in the left and right side of p and q 
        for(int i= start ; i<=end ; i++)
        {
            if(i <= mid)
            {
                l[p++]= a[i];
            }
            else
            {
                r[q++]=a[i] ;  
            }
        }
        p=q=0; int i=start;
        while  (p<l.length && q <r.length)
        {
            // comparing the elements of left and right array and the sorting them 
            if(l[p]<r[q])
            {
                a[i++] = l[p++];
            } 
            else
            {
                a[i++] = r[q++];   
            }
        }
        // loop for the remaining element in the left and right side and puting them in the merge sorted array
        
        while(p<l.length)
        {
            a[i++] = l[p++];
        }
        while (q<r.length)
        {
            a[i++] = r[q++];
        }

    }
}
class mergeSortDemo
{
    public static void main(String args[])
    {
        int a[] = {10,19,12,9,5,1};
        MergeSort obj = new MergeSort();
        obj.mergeSort(a,0,a.length-1);
        for(int i=0; i<a.length;i++)
        {
            System.out.println(a[i]);
        }
    }
}