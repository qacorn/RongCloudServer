package com.qacorn.rongcloud.utility;

import java.util.*;

/**
 * @author Feng_zhulin
 * @since 2018/8/26
 */
public class ListUtility {

    public static boolean isEmpty(List<?> lists) {
        return null == lists || lists.size() == 0;
    }

    public static <T, K, V> Map<K, V> buildMap(List<T> list, ValuePicker<T, K> keyPicker, ValuePicker<T, V> valuePicker) {
        Map<K, V> map = new HashMap<>();
        for (T t : list) {
            K key = keyPicker.pickValue(t);
            map.put(key, valuePicker.pickValue(t));
        }
        return map;
    }

    public static <V> Map<Long, V> buildMap(List<V> valueList, KeyPicker<V> keyPicker) {
        Map<Long, V> map = new HashMap<>();
        for (V v : valueList) {
            map.put(keyPicker.pickKey(v), v);
        }
        return map;
    }

    public static <T> List<Long> buildIdList(List<T> tList, KeyPicker<T> keyPicker) {
        Set<Long> idList = new LinkedHashSet<>(tList.size());
        for (T t : tList) {
            Long key = keyPicker.pickKey(t);
            if(key != null) {
                idList.add(key);
            }
        }
        return new ArrayList<Long>(idList);
    }

    public static <S, T>  List<T> buildList(List<S> sList, ValuePicker<S, T> valuePicker) {
        List<T> tList = new ArrayList<T>(sList.size());
        for (S s : sList) {
            tList.add(valuePicker.pickValue(s));
        }
        return tList;
    }

    public static <T, E> T orFirst(List<E> list, ValuePicker<E, T> valuePicker) {
        if (isEmpty(list)) {
            return null;
        } else {
            return valuePicker.pickValue(list.get(0));
        }
    }
}
