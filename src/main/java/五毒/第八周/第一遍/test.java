package 五毒.第八周.第一遍;

public class test {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(2,2);
        System.out.println(cache.get(2));
    }
}
