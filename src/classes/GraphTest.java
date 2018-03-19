package classes;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    private Graph graph = new Graph();
    @Test
    void getChildren() {
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
        graph.changeRibPrice("C","A",8);
        assertEquals(list,graph.getChildren("E"));
    }
    @Test
    void getParents() {
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
    @Test
    void showGraph() {
        List<String> list = new ArrayList<>();
        list.add("A -> D(price 2);");
        list.add("B -> E(price 2);G(price 7);");
        list.add("D -> No ways");
        list.add("E -> No ways");
        list.add("U -> E(price 8);");
        list.add("G -> E(price 8);");

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
        graph.addRib("B", "G",7);
        graph.changeRibPrice("G","E",8);
        graph.deleteRib("A","E");
        graph.removeVertex("C");
        graph.changeName("F","U");
        assertEquals(list,graph.showGraph());
    }
}
