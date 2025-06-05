class DisjointSet {
    int[] parent;

    DisjointSet() {
        parent = new int[26];
        for(int i=0; i<26; i++) {
            parent[i] = i;
        }
    }

    public int findUlPar(int idx) {
        if(parent[idx] == idx) {
            return idx;
        }
        return parent[idx] = findUlPar(parent[idx]);
    }

    public void unionByLex(char u, char v) {
        int pu = findUlPar(u - 'a'), pv = findUlPar(v - 'a');
        if(pu <= pv) {
            parent[pv] = pu; 
        } else {
            parent[pu] = pv;
        }
    }
}

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DisjointSet ds = new DisjointSet();
        int n = s1.length(), bn = baseStr.length();
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<n; i++) {
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            ds.unionByLex(ch1, ch2);
        }

        for(char ch: baseStr.toCharArray()) {
            ans.append((char)(ds.findUlPar(ch - 'a') + 'a'));
        }

        return ans.toString();
    }
}