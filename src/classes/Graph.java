package classes;

import java.util.ArrayList;

    public class Graph {
        public ArrayList<String> vertexList = new ArrayList<>();
        public final int Vertices = 100;
        public int[][] matrix;

        public Graph() {
            matrix = new int[Vertices][Vertices];
            for (int i = 0; i < Vertices; i++)
                for (int j = 0; j < Vertices; j++)
                    matrix[i][j] = 0;
        }

        public void AddVertex(String name) {
            vertexList.add(name);
        }

        public void AddRib(String vertex1, String vertex2, int ribPrice) {
            matrix[vertexList.indexOf(vertex1)][vertexList.indexOf(vertex2)] = ribPrice;
        }

        public void ChangeRibPrice(String vertex1, String vertex2, int ribPrice) {
            if (matrix[vertexList.indexOf(vertex1)][vertexList.indexOf(vertex2)] != 0)
                matrix[vertexList.indexOf(vertex1)][vertexList.indexOf(vertex2)] = ribPrice;
        }

        public void RemoveVertex(String name) {
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
                        matrix[i][j] = 0;
                }
            }
            vertexList.remove(name);
        }

        public ArrayList<String> NumberOfChildren(String name) {
            ArrayList<String> list = new ArrayList();
            for (int i = 0; i < Vertices; i++) {
                if (matrix[vertexList.indexOf(name)][i] != 0)
                    list.add(vertexList.get(i));
            }
            return list;
        }
        public ArrayList<String> NumberOfParents(String name) {
            ArrayList<String> list = new ArrayList();
            for (int i = 0; i < Vertices; i++) {
                if (matrix[i][vertexList.indexOf(name)] != 0)
                    list.add(vertexList.get(i));
            }
            return list;
        }
    }



/** if (a == vertexList.size() - 1)
 vertexList.remove(name);
 else {
 for (int i = 0; i < vertexList.size() - 1; i++) {
 for (int j = 0;j < vertexList.size() - (a + 1);j++) {
 if (a + j != i) {
 matrix[a + j][i] = matrix[a + j][i + 1];
 matrix[i][a + j] = matrix[i + 1][a + j];
 }
 else
 matrix[a + j][i] = 0;
 }
 }
 vertexList.remove(name);
 }
 for (int i = 0;i <= vertexList.size();i++) {
 matrix[vertexList.size()][i] = 0;
 matrix[i][vertexList.size()] = 0;
 }*/