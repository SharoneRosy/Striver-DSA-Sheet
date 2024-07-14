class Solution {
    public String countOfAtoms(String formula) {
        int len = formula.length();
        Stack<Map<String,Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        for(int i=0;i<len;){
            char ch = formula.charAt(i);
            if(ch == '('){
                stack.push(new HashMap<>());
                i++;
            }else if(ch == ')'){
                int start = ++i;
                while(i<len && Character.isDigit(formula.charAt(i)))
                    i++;
                int val = i > start ? Integer.parseInt(formula.substring(start,i)) : 1;
                Map<String,Integer> map = stack.pop();
                for(String element : map.keySet()){
                    int count = map.get(element) * val;
                    stack.peek().put(element,stack.peek().getOrDefault(element,0)+count);
                }
            }else{
                int start = i++;
                while(i < len && Character.isLowerCase(formula.charAt(i)))
                    i++;
                String element = formula.substring(start,i);
                start = i;
                while (i < len && Character.isDigit(formula.charAt(i))) 
                    i++;
                int count = i > start ? Integer.parseInt(formula.substring(start, i)) : 1;
                stack.peek().put(element,stack.peek().getOrDefault(element,0)+count);
            }
        }
        Map<String,Integer> map = stack.pop();
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        StringBuilder res = new StringBuilder();;
        for(String element : list){
            res.append(element);
            int val = map.get(element);
            if(val > 1) 
                res.append(val + "");
        }
        return res.toString();
    }
}