package org.paumard.devoxxuk2021.legacy;

import java.io.ObjectStreamException;
import java.io.Serial;
import java.io.Serializable;

public record RangeProxy(int begin, int end) implements Serializable {

    public RangeProxy {
        RangeLegacy.Validator.validate(begin, end);
    }

    @Serial
    private Object readResolve() throws ObjectStreamException {
        System.out.println("I am creating the real object");
        return new RangeLegacy(begin, end);
    }
}
