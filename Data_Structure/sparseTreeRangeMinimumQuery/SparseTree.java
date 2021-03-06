package sparseTreeRangeMinimumQuery;

public class SparseTree {
	private int[][] sparse;
	private int n;
	private int[] input;
	
	public SparseTree(int[] input){
		this.input = input;
		this.n=input.length;
		this.sparse = preProcess(input, this.n);
	}
	
	private int[][] preProcess(int[] input, int n){
		int[][] sparse = new int[n][log2(n)+1];
		for(int i=0; i<input.length; i++)
			sparse[i][0]=i;
		
		for(int j=1; 1 << j <= n; j++){
			for(int i=0; i+ (1<<j)-1 < n; i++){
				if(input[sparse[i][j-1]] < input[sparse[i +(1<<(j-1))][j-1]]){
					sparse[i][j]=sparse[i][j-1];
				}else{
					sparse[i][j] = sparse[i + (1 << (j - 1))][j - 1];
				}
			}
		}
		return sparse;
	}
	
	public int rangeMinimumQuery(int low, int high) {
        int l = high - low + 1;
        int k = log2(l);
        if (input[sparse[low][k]] <= input[sparse[low + l - (1<<k)][k]]) {
            return input[sparse[low][k]];
        } else {
            return input[sparse[high - (1<<k) + 1][k]];
        }
    }
	
	private static int log2(int n){
		if(n<=0) throw new IllegalArgumentException();
		return 31-Integer.numberOfLeadingZeros(n);
	}
	
	public static void main(String[] Args){
		int[] input = {2, 5, 3, 6, 4, 1, -1, 3, 4, 2};
		SparseTree sparseTableRangeMinimumQuery = new SparseTree(input);
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                System.out.print(sparseTableRangeMinimumQuery.rangeMinimumQuery(i, j) + " ");
            }
            System.out.println();
        }
	}
}
