class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int [] dom = null;
        Stack<Integer> ans = new Stack();
        for(int i = 0;i < asteroids.length; i++){
            if(!ans.isEmpty() && asteroids[i] < 0){
                if(ans.peek() == Math.abs(asteroids[i])){
                    ans.pop();
                    continue;
                }
                while(!ans.isEmpty() && ans.peek() >0 && ans.peek()< Math.abs(asteroids[i])){
                    ans.pop();
                }
                if( !ans.isEmpty()&&ans.peek() > 0){
                    if(ans.peek() == Math.abs(asteroids[i])){
                        ans.pop();
                    }
                    
                }else{
                    ans.add(asteroids[i]);
                }
            }else{
                ans.add(asteroids[i]);
            }
        }
        dom = new int[ans.size()];
        for(int i =0;i<ans.size();i++){
            dom[i] = ans.get(i);
        }
        return dom;
    }
}