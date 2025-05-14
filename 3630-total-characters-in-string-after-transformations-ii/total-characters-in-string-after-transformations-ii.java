class Solution {
    final int M = 1_000_000_007;
	
	private int[][] matrixMultiplication(int A[][], int B[][])
	{
		int res[][] = new int[26][26];
		
		for(int i=0;i<26;i++)
		{
			for(int j=0;j<26;j++)
			{
				for(int k=0;k<26;k++)
				{
					res[i][j] = (int)((res[i][j]+(1L*A[i][k]*B[k][j])%M)%M);
				}
			}
		}
		
		return res;
	}
	
	private int[][] matrixExponentiation(int transformationMatrix[][], int t)
	{
		int res[][] = new int[26][26];
		
		for(int i=0;i<26;i++)
		{
			res[i][i]=1;
		}
		
		while(t>0)
		{
			if((t&1)==1)
			{
				res = matrixMultiplication(transformationMatrix, res);
			}
			
			transformationMatrix = matrixMultiplication(transformationMatrix, transformationMatrix);
			
			t>>=1;
		}
		
		return res;
	}
	
	public int lengthAfterTransformations(String s, int t, List<Integer> nums) 
    {
		int freq[] = new int[26];
		
		for(char c: s.toCharArray())
		{
			freq[c-'a']++;
		}
		
		int transformationMatrix[][] = new int[26][26];
		
		for(int i=0;i<26;i++)
		{
			for(int j=i+1;j<=i+nums.get(i);j++)
			{
				transformationMatrix[j%26][i]++;
			}
		}
		
		int res[][] = matrixExponentiation(transformationMatrix, t);
		
		int finalRes[] = new int[26];
		
		for(int i=0;i<26;i++)
		{
			for(int j=0;j<26;j++)
			{
				finalRes[i] = (int)((finalRes[i]+(1l*res[i][j]*freq[j])%M)%M);
			}
		}
		
		int stringSize = 0;
		
		for(int i=0;i<26;i++)
		{
			stringSize = (stringSize+finalRes[i])%M;
		}
        
		return stringSize;
    }
}