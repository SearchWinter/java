package structure.map.hashmapdemo;

import java.util.HashMap;
import java.util.function.BiFunction;

/**
 * @ClassName HashMap
 * @Description TODO
 * @Author Li Anjun
 * @Date 2020/7/7  13:49
 **/
public class HashMapDemo {
    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        //默认初始容量16，降低hash碰撞的几率（两个输入串的hash函数的值一样）
        /**tableSizeFor()的主要功能是返回一个比给定整数大且最接近2的幂次方整数，如给定10，放回2的4次方16*/

        HashMap<Integer, String> hashMap = new HashMap<>(10,0.75f);

        //添加数据，K相同，value不相同时，新的会覆盖掉之前存在的数据
        hashMap.put(1,"tutorials");
        hashMap.put(2,"from");
        hashMap.put(3,"java2s.com");
        //key如果不存在就添加，存在就不操作
        hashMap.putIfAbsent(1,"web");
        hashMap.putIfAbsent(4,"world");
        System.out.println(hashMap);

        //compute(Key,BiFunction)
        /**计算指定键关联的映射值（没有映射值设置null），主要就是将BiFunction的结果赋予给key关联的映射值
         *
         * */
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one",10);
        System.out.println(map);
        map.compute("one",(key,val)->val+10);
        System.out.println(map);

        /*    System.out.println(hashMap);
        hashMap.put(3,"good");
        System.out.println(hashMap);*/

        //get(Object key)   得到指定Key的value
//        System.out.println(hashMap.get(3));

        //chear()      清空所有数据
//        hashMap.clear();
//        System.out.println(hashMap);
        //判断是否为空
//        System.out.println(hashMap.isEmpty());

        //clone()       将数据克隆到另一个map
/*        HashMap<Integer, String> hashMap1 = new HashMap<>();
        hashMap1=(HashMap<Integer, String>) hashMap.clone();
        System.out.println(hashMap1);*/

        //containsKey(Object key)   boolean   验证是否存在指定的key
//        System.out.println(hashMap.containsKey(4));

        //containsValue(Object value)       boolean      验证是否存在指定的value
//        System.out.println(hashMap.containsValue("fdfaf"));

        //entrySet()    Set<Map.Entry<K,V>>      返回<K,V> Set集合  [1=tutorials, 2=from, 3=java2s.com]
/*        Set<Map.Entry<Integer, String>> set = hashMap.entrySet();
        System.out.println(set);*/

        //keyset()      Set<K>       得到包含所有K值的集合     [1, 2, 3]
/*        Set<Integer> keySet = hashMap.keySet();
        System.out.println(keySet);*/

        //values()      Collection<V>        包含所有value的集合    [tutorials, from, java2s.com]
/*        Collection<String> values = hashMap.values();
        System.out.println(values);*/

        //remove()      移除指定K的值
        hashMap.remove(3);
        System.out.println(hashMap);

        System.out.println(hashMap.size());

    }
}
