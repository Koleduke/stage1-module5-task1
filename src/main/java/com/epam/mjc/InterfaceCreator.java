package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {

        return x -> {
            for (String s : x) {
                return Character.isUpperCase(s.charAt(0)) && !Character.isDigit(s.charAt(0));
            }
            return false;
        };

    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        List<Integer> list = new ArrayList<>();

        return x -> {
            System.out.println(x);
            list.addAll(x);
            for (Integer integer : list) {
                if (integer % 2 == 0) {
                    x.add(integer);
                }
            }

        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();
            for (String s : values) {
                if (Character.isUpperCase(s.charAt(0)) && s.charAt(s.length() - 1) == '.' && s.split(" ").length > 3) {
                    list.add(s);
                }
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String s : x) {
                map.put(s, s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> list = new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            return list;
        };
    }
}