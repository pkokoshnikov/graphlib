package com.pkokoshnikov.graph.vertex;

/**
 * User: pako1113
 * Date: 22.05.15
 */
public class NumberVertex implements Vertex{
    int number;

    public NumberVertex(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "NumberVertex{" +
                "number=" + number +
                '}';
    }
}
