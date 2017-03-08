public class FastSelect {
    
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------

    public static int partition( int arr[], int left, int right, int pvt ) {
	int v = arr[c];

	swap( pvt, right, arr);
	int s = left;

	for( int i = left; i < right; i++ ) {
	    if ( arr[i] <= v) {
		swap( i, s, arr );
		s++;}
	}
	swap(s,b,arr);

	return s;
    }//end partition

    public static int fastSelect( int arr[], int y ) {
	int a = 0;
	int b = arr.length - 1;
	while ( partition( arr, a, b, y ) != y ) {
	    if ( partition( arr, a, b, y ) > y ) {
		int[] arr2 = new int[ arr.length - 1 ];
		for ( int i = 0; i < arr.length - 1; i++ ) {
		    arr2[i] = arr[i];
		}
		fastSelect( arr2, y - 1 );
	    }
	    else if ( partition( arr, a, b, y ) < y ) {
		int[] arr3 = new int[ arr.length - 1 ];
		for ( int i = 1; i < arr.length; i++ ) {
		    arr3[i - 1] = arr[i];
		}
		fastSelect( arr3, y + 1 );
	    }
	}
	return arr[y];
    }

    public static void main ( String[] args ) {

	int[] a1 = {8,21,17,69,343};
	int[] a2 = {1,28,33,4982,37};
	int[] a3 = {5,4,17,9000,6};
	int[] a4 = {3,0,16,599,1024};

	fastSelect( a1, 3 );
	fastSelect( a2, 3 );
	fastSelect( a3, 3 );
	fastSelect( a4, 3 );

    }
}
