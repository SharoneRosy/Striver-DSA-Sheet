class Node {
    Node a[]=new Node[26];
    boolean flag=false;

    boolean isPresent(char ch){
        return a[ch-'a']!=null;
    }

    void create(char ch,Node node){
        a[ch-'a']=node;
    }
    Node get(char ch){
        return a[ch-'a'];
    }

    void endSet(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
}
class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node node =root;
        for(char ch:word.toCharArray()){
            if(!node.isPresent(ch)){
                node.create(ch,new Node());
            }
            node=node.get(ch);
        }
        node.endSet();
    }
    
    public boolean search(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.isPresent(ch)){
                return false;
            }
            node=node.get(ch);
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node=root;
        for(char ch:prefix.toCharArray()){
            if(!node.isPresent(ch)){
                return false;
            }
            node=node.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */