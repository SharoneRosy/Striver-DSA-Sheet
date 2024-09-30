class Logger {
    private HashMap<String, Integer>map;
    private int timeout=10;
    public Logger() {
        map=new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message) && map.get(message)>timestamp){
            return false;
        }
        map.put(message,timestamp+timeout);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */