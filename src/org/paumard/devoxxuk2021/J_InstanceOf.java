package org.paumard.devoxxuk2021;

import org.paumard.devoxxuk2021.model.Circle;
import org.paumard.devoxxuk2021.model.Rectangle;
import org.paumard.devoxxuk2021.model.Shape;
import org.paumard.devoxxuk2021.model.Square;

public class J_InstanceOf {

    public static void main(String[] args) {

    }

    public int surface(Shape shape) {

        int surface = switch (shape) {
            case null -> -1;
            case Rectangle rectangle ->
                    rectangle.height() * rectangle.width();
            case Square square && square.edge() == 0 -> 0;
            case Square square ->
                    square.edge() * square.edge();
            case Circle circle ->
                    circle.radius()* circle.radius();
        };
        return surface;

//        if (shape instanceof Square square) {
//            return square.edge()*square.edge();
//        } else if (shape instanceof Rectangle rectangle) {
//            return rectangle.height()*rectangle.width();
//        } else if (shape instanceof Circle circle) {
//            return circle.radius()* circle.radius();
//        }
//
//        return 0;
    }
}
