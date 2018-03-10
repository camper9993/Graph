package classes;

import java.util.*;

class Graph {
    private Map<String, Map<String, Integer>> matrixList = new HashMap<>();

    void addVertex(String name) {
        matrixList.put(name, new HashMap<>());
    }

    void changeName(String name1, String name2) {
        matrixList.put(name2, matrixList.get(name1));
        matrixList.remove(name1);
        for (String key : matrixList.keySet()) {
            if (matrixList.get(key) != null && matrixList.get(key).containsKey(name1)) {
                matrixList.get(key).put(name2, matrixList.get(key).get(name1));
                matrixList.get(key).remove(name1);
            }

        }
    }

    void addRib(String name1, String name2, Integer ribPrice) {
        matrixList.get(name1).put(name2, ribPrice);
    }

    void changeRibPrice(String name1, String name2, Integer ribPrice) {
        matrixList.get(name1).put(name2, ribPrice);
    }

    void deleteRib(String name1, String name2) {
        matrixList.get(name1).remove(name2);
    }

    void removeVertex(String name) {
        matrixList.remove(name);
        for (String key : matrixList.keySet()) {
            if (matrixList.get(key) != null && matrixList.get(key).containsKey(name))
                matrixList.get(key).remove(name);
        }
    }

    List<String> getParents(String name) {
        ArrayList<String> list = new ArrayList<>();
        for (String key : matrixList.keySet()) {
            if (matrixList.get(key) != null && matrixList.get(key).containsKey(name))
                list.add(key);
        }
        return list;
    }

    List<String> getChildren(String name) {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(matrixList.get(name).keySet());
        return list;
    }
}

