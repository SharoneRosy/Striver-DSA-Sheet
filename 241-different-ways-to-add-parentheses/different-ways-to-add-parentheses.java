class Solution {
    List<Integer> solve(String s)
    {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*')
            {
                List<Integer> left = new ArrayList<>();
                left = solve(s.substring(0,i));
                List<Integer> right = new ArrayList<>();
                right = solve(s.substring(i+1));

                for(int x: left)
                {
                    for(int y: right)
                    {
                        if(ch=='+')
                        result.add(x+y);
                        else if(ch=='-')
                        result.add(x-y);
                        else
                        result.add(x*y);
                    }
                }
            }
        }
        if(result.size()==0)
        result.add(Integer.valueOf(s));
        return result;
    }


    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }
}