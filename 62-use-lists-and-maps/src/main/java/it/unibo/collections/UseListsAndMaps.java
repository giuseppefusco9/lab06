package it.unibo.collections;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final long OCEANIA_POPULATION = 38_304_000L;
    private static final long EUROPE_POPULATION = 742_452_000L;
    private static final long AMERICAS_POPULATION = 972_005_000L;
    private static final long AFRICA_POPULATION = 1_110_635_000L;
    private static final long ANTARTICA_POPULATION = 0L;
    private static final long ASIA_POPULATION = 4_298_723_000L;
    private static final int READ_TIMES = 1000;
    private static final int VALUES_TO_ADD = 100_000;
    private static final int MAX_VAL_ARRAYLIST = 2000;
    private static final int MIN_VAL_ARRAYLIST = 1000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> myArrayList = new ArrayList<>();

        for(int i = MIN_VAL_ARRAYLIST; i < MAX_VAL_ARRAYLIST; i++){
            myArrayList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> myLinkedList = new LinkedList<>(myArrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int firstEl = myArrayList.getFirst();
        myArrayList.set(0, myArrayList.getLast());
        myArrayList.set(myArrayList.size() - 1, firstEl);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(int element : myArrayList){
            System.out.print(element + " | ");
        }
        System.out.println(" ");
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();

        for(int i = 1; i <= VALUES_TO_ADD; i++){
            myArrayList.addFirst(i);
        }

        time = System.nanoTime() - time;
        System.out.println("Add " + VALUES_TO_ADD + " elements as first into myArrayList took " + time + "ns");

        time = System.nanoTime();
        for(int i = 1; i <= VALUES_TO_ADD; i++){
            myLinkedList.addFirst(i);
        }

        time = System.nanoTime() - time;
        System.out.println("Add " + VALUES_TO_ADD + " elements as first into myLinkedList took " + time + "ns");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

         time = System.nanoTime();

         for(int i = 0; i < READ_TIMES; i++){
            myArrayList.get(myArrayList.size() / 2);
         }

         time = System.nanoTime() - time;
         System.out.println("Reading " + READ_TIMES + " times the element in the middle from myArrayList took " + time + "ns");

         time = System.nanoTime();

         for(int i = 0; i < READ_TIMES; i++){
            myLinkedList.get(myLinkedList.size() / 2);
         }

         time = System.nanoTime() - time;
         System.out.println("Reading " + READ_TIMES + " times the element in the middle from myLinkedList took " + time + "ns");


        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

         Map<String, Long> myMap = new TreeMap<>();
         myMap.put("Africa", AFRICA_POPULATION);
         myMap.put("Americas", AMERICAS_POPULATION);
         myMap.put("Antartica", ANTARTICA_POPULATION);
         myMap.put("Asia", ASIA_POPULATION);
         myMap.put("Europe", EUROPE_POPULATION);
         myMap.put("Oceania", OCEANIA_POPULATION);
        /*
         * 8) Compute the population of the world
         */
        long worldPopulation = 0L;
        for(Long i : myMap.values()){
            worldPopulation += i;
        }

        System.out.println("World population: " + worldPopulation);
    }
}
