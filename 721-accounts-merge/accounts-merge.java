import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        // Initialize Union-Find
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> emailToIndex = new HashMap<>();

        // Step 1: Map emails to account indices and union emails within the same account
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    ds.unionBySize(i, emailToIndex.get(email));
                }
            }
        }

        // Step 2: Group emails by their root parent
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {
            String email = entry.getKey();
            int parentIndex = ds.findParent(entry.getValue());

            indexToEmails
                .computeIfAbsent(parentIndex, x -> new ArrayList<>())
                .add(email);
        }

        // Step 3: Prepare the final result
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : indexToEmails.entrySet()) {
            int index = entry.getKey();
            List<String> emails = entry.getValue();

            Collections.sort(emails);
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(accounts.get(index).get(0)); // Add the account name
            mergedAccount.addAll(emails); // Add the sorted emails
            result.add(mergedAccount);
        }

        return result;
    }
}

class DisjointSet {
    private int[] parent;
    private int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent[node]); // Path compression
        }
        return parent[node];
    }

    public void unionBySize(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);

        if (rootU != rootV) {
            if (size[rootU] < size[rootV]) {
                parent[rootU] = rootV;
                size[rootV] += size[rootU];
            } else {
                parent[rootV] = rootU;
                size[rootU] += size[rootV];
            }
        }
    }
}
