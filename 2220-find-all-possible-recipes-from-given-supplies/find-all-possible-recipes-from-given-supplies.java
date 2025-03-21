class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        
        for(int i=0; i<ingredients.size(); i++) {
            for(int j=0; j<ingredients.get(i).size(); j++) {
                adj.putIfAbsent(ingredients.get(i).get(j), new ArrayList<>());
                adj.get(ingredients.get(i).get(j)).add(recipes[i]);
                indegree.put(recipes[i], indegree.getOrDefault(recipes[i], 0)+1);
            }
        }
        
        Queue<String> q = new LinkedList();
        
        for(String s: supplies) {
            q.add(s);
        }
        
        List<String> res = new ArrayList<>();
    
        
        while(!q.isEmpty()) {
            String supply = q.poll();
            
            if(!adj.containsKey(supply)) {
                continue;
            }
            
            for(String recp: adj.get(supply)) {
                int ind = indegree.get(recp) - 1;
                indegree.put(recp, ind);
        
                if(ind == 0) {
                    q.add(recp);
                    res.add(recp);
                }
            }
        }
        
        return res;
    }
}