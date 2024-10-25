class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res=new ArrayList<>();
        Arrays.sort(folder);
        res.add(folder[0]);
        for(int i=1;i<folder.length;i++){
            String lastfolder=res.get(res.size()-1);
            lastfolder+='/';

            if (!folder[i].startsWith(lastfolder)) {
                res.add(folder[i]);
            }
        }
        return res;
    }
}