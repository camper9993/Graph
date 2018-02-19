package classes;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    public Graph graph = new Graph();
    @Test
    void NumberOfChildren() {
        ArrayList<String> list = new ArrayList<>();
        list.add("D");
        list.add("F");
        graph.AddVertex("A");
        graph.AddVertex("B");
        graph.AddVertex("C");
        graph.AddVertex("D");
        graph.AddVertex("E");
        graph.AddVertex("F");
        graph.AddRib("E","B",6);
        graph.AddRib("E","C",3);
        graph.AddRib("E","D",2);
        graph.AddRib("C","A",1);
        graph.AddRib("E","F",2);
        graph.ChangeRibPrice("E","C",0);
        graph.RemoveVertex("B");
        assertEquals(list,graph.NumberOfChildren("E"));
    }
    @Test
    void NumberOfParents() {
        ArrayList<String> list = new ArrayList<>();
        list.add("F");
        graph.AddVertex("A");
        graph.AddVertex("B");
        graph.AddVertex("C");
        graph.AddVertex("D");
        graph.AddVertex("E");
        graph.AddVertex("F");
        graph.AddRib("A","E",6);
        graph.AddRib("C","E", 10);
        graph.AddRib("A","D",2);
        graph.AddRib("F","E",8);
        graph.ChangeRibPrice("A","E",0);
        graph.RemoveVertex("C");
        assertEquals(list,graph.NumberOfParents("E"));
    }
}