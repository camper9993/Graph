package classes;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    private Graph graph = new Graph();
    @Test
    void getChildren() {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("F");
        list.add("K");
        list1.add("A");
        list1.add("C");
        list1.add("E");
        list1.add("F");
        list1.add("K");
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
        assertEquals(list1,graph.getAllVerices());
    }
    @Test
    void getParents() {
        ArrayList<String> list = new ArrayList<>();
        list.add("B");
        list.add("U");
        list.add("G");
        Integer price = 8;
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
        assertEquals(price,graph.getRibPrice("G","E"));
    }
}
