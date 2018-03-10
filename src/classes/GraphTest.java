package classes;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    public Graph graph = new Graph();
    @Test
    void NumberOfChildren() {
        ArrayList<String> list = new ArrayList<>();
        list.add("F");
        list.add("K");
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addRib("E","B",6);
        graph.addRib("E","C",3);
        graph.addRib("E","D",2);
        graph.addRib("C","A",1);
        graph.addRib("E","F",2);
        graph.deleteRib("E","C");
        graph.removeVertex("B");
        graph.changeName("D","K");
        assertEquals(list,graph.getChildren("E"));
    }
    @Test
    void NumberOfParents() {
        ArrayList<String> list = new ArrayList<>();
        list.add("B");
        list.add("U");
        list.add("G");
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addRib("A","E",6);
        graph.addRib("C","E", 10);
        graph.addRib("A","D",2);
        graph.addRib("F","E",8);
        graph.addRib("B","E",2);
        graph.addRib("G","E",2);
        graph.changeRibPrice("G","E",8);
        graph.deleteRib("A","E");
        graph.removeVertex("C");
        graph.changeName("F","U");
        assertEquals(list,graph.getParents("E"));
    }
}