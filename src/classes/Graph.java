package classes;

import java.util.ArrayList;
import java.util.List;

public class Graph {
        public ArrayList<String> vertexList = new ArrayList<>();          /** А такой вариант не пойдет?*/
        public Integer[][] matrix;

        public void graph(int Vertices) {
            matrix = new Integer[Vertices][Vertices];
            for (int i = 0; i < Vertices; i++)
                for (int j = 0; j < Vertices; j++)
                    matrix[i][j] = null;
        }

        public void addVertex(String name) {
            if (!vertexList.contains(name))
                vertexList.add(name);

        }

        public void changeName(String name1, String name2) {
            int a = vertexList.indexOf(name1);
            if (!vertexList.contains(name2))
                 vertexList.set(a, name2);
        }

        public void addRib(String vertex1, String vertex2, Integer ribPrice) {
            matrix[vertexList.indexOf(vertex1)][vertexList.indexOf(vertex2)] = ribPrice;
        }

        public void changeRibPrice(String vertex1, String vertex2, Integer ribPrice) {
            if (matrix[vertexList.indexOf(vertex1)][vertexList.indexOf(vertex2)] != null)
                matrix[vertexList.indexOf(vertex1)][vertexList.indexOf(vertex2)] = ribPrice;
        }

        public void removeVertex(String name) {
            int a = vertexList.indexOf(name);
            for (int i = 0;i < vertexList.size();i++) {
                for (int j = 0;j < vertexList.size();j++) {
                    if (i < a && j >= a)
                        matrix[i][j] = matrix[i][j + 1];

                    if (i >= a && j >= a)
                        matrix[i][j] = matrix[i + 1][j + 1];

                    if (i >= a && j < a)
                        matrix[i][j] = matrix[i + 1][j];

                    if (i == vertexList.size() - 1 || j == vertexList.size() - 1)
                        matrix[i][j] = null;
                }
            }
            vertexList.remove(name);
        }

        public List<String> getChildren(String name) {
            List<String> list = new ArrayList();
            for (int i = 0; i < vertexList.size(); i++) {
                if (matrix[vertexList.indexOf(name)][i] != null)
                    list.add(vertexList.get(i));
            }
            return list;
        }
        public List<String> getParents(String name) {
            List<String> list = new ArrayList();
            for (int i = 0; i < vertexList.size(); i++) {
                if (matrix[i][vertexList.indexOf(name)] != null)
                    list.add(vertexList.get(i));
            }
            return list;
        }
    }
