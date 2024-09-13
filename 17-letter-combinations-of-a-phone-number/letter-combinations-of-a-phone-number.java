class Solution {
    public void solve(String digits,StringBuilder sb,int id,List<String>res,String[] map){
        if(id>=digits.length()){
            res.add(sb.toString());
            return ;
        }
        String val=map[digits.charAt(id)-'0'];
        for(int i=0;i<val.length();i++){
            sb.append(val.charAt(i));
            solve(digits,sb,id+1,res,map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String>res=new ArrayList<>();
        if(digits.length()==0) return res;
        StringBuilder sb=new StringBuilder();
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(digits,sb,0,res,map);
        return res;
    }
}