package org.paumard.devoxxuk2021.legacy;

import java.io.ObjectStreamException;
import java.io.Serial;
import java.io.Serializable;

public class RangeLegacy implements Serializable {

    public static class Validator {

        public static void validate(int begin, int end) {
            if (begin > end) {
                throw new IllegalArgumentException("Begin should be smaller than range");
            }
        }
    }

    private final int begin;
    private final int end;

    public RangeLegacy(int begin, int end) {
        Validator.validate(begin, end);
        this.begin = begin;
        this.end = end;
    }

    @Serial
    private Object writeReplace() throws ObjectStreamException {
        System.out.println("I am serializing a record proxy");
        return new RangeProxy(begin, end);
    }


    @Override
    public String toString() {
        return "RangeLegacy{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}
