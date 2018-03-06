package classes;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    public Graph graph = new Graph();
    @Test
    void NumberOfChildren() {
        ArrayList<String> list = new ArrayList<>();
        list.add("K");
        list.add("F");
        graph.graph(8);
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
        graph.changeRibPrice("E","C",null);
        graph.removeVertex("B");
        graph.changeName("D","K");
        assertEquals(list,graph.getChildren("E"));
    }
    @Test
    void NumberOfParents() {
        ArrayList<String> list = new ArrayList<>();
        list.add("B");
        graph.graph(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addRib("A","E",6);
        graph.addRib("C","E", 10);
        graph.addRib("A","D",2);
        graph.addRib("F","E",8);
        graph.addRib("B","E",2);
        graph.changeRibPrice("A","E",null);
        graph.removeVertex("C");
        graph.changeName("F","U");
        graph.removeVertex("U");
        assertEquals(list,graph.getParents("E"));
    }
}