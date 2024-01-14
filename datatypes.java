public class Solution {
    public static int dataTypes(String type) {
        // Write your code here
        String s=type.toUpperCase();
        switch(s){
            case "INTEGER":
                return 4;
            case "LONG":
                return 8;
            case "FLOAT":
                return 4;
            case "DOUBLE":
                return 8;
            case "CHARACTER":
                return 1;
            default:
                return -1;
            
        }
        
    }
}