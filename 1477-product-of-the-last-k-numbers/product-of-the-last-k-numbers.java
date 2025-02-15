class ProductOfNumbers {
    ArrayList<Integer> al = new ArrayList<>();
    int size = 0;

    public ProductOfNumbers() {
        al.add(1);
        size = 0;
    }

    public void add(int num) {
        if (num == 0) {
            al = new ArrayList<Integer>();
            al.add(1);
            size = 0;
        } else {
            al.add(al.get(size) * num);
            size++;
        }
    }

    public int getProduct(int k) {
        if (k > size)
            return 0;
        return (al.get(size) / al.get(size - k));
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */