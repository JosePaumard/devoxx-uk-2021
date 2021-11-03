package org.paumard.devoxxuk2021;

import java.util.Iterator;

public class E_PlayWithRange {

    public static void main(String[] args) {

        record Range(int begin, int end) implements Iterable<Integer> {

            Range {
                if (begin > end) {
                    throw new IllegalArgumentException("End should be greater than begin");
                }
            }

            Range() {
                this(0, 0);
            }

            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    private int index = Range.this.begin;
                    @Override
                    public boolean hasNext() {
                        return index < Range.this.end;
                    }

                    @Override
                    public Integer next() {
                        return index++;
                    }
                };
            }
        }

        var range = new Range(0, 5);
        for (int index: range) {
            System.out.println("index = " + index);
        }

        System.out.println("range = " + range);
    }
}