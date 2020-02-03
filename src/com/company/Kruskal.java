//  The time complexity for kruskal is O(E * V) endges times verticies  because it takes going through all the edges and for each edge we try to insert we must check if it creates a cycle the check is constant for each edge but the updating of the sets which each edge belongs to needed in order to see if there is a cycle is checking every Vertex and seeing what set its part of and updating it. (its possible to do the set joining faster with having each node have a pointer to the node whose set its paet of.  it should start as pointing to itself and as edges are added one vertex will point to another  vertex.  nodes already pointing to another vertex which points to another and so on will be updated to point at the head node.  this is done while traversing to see which set its part of.


// prim is order n^2 by starting from a vertex and putting it in a set of vertexes already traversed.  go through all the edges in order from smallest up and find the first one which has one vertex already traversed. once you find one remove it from edge set and start agian from the smallest.  repeat until you have all the vetices covered.




package com.company;

import java.util.*;

public class Kruskal {

    public static class Edge implements Comparable<Edge> {
        String a;
        String b;
        int length;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge)) return false;
            Edge edge = (Edge) o;
            return length == edge.length;
        }

        public Edge(String a, String b, int l) {
            this.a = a;
            this.b = b;
            this.length = l;
        }

        @Override
        public int compareTo(Edge o) {

            return this.length - o.length;
        }
    }

    public class Vertex {
        String name;
        String set;
        boolean visted = false;

        public Vertex(String name) {
            this.name = name;
            this.set = name;

        }
    }


    public Kruskal(ArrayList<Edge> edges) {
        Edges = edges;
    }

    ArrayList<Edge> Edges;
    HashMap<String, Vertex> Vertices = new HashMap<>();
    ArrayList<Edge> mst = new ArrayList<>();
    int vertexCount;
    int edgeCount;

    public ArrayList<Edge> kruskal() {
        Collections.sort(Edges);
        for (int i = 0; i < Edges.size(); i++) {
            Edge e = Edges.get(i);

            if (!Vertices.containsKey(e.a)) {
                Vertices.put(e.a, new Vertex(e.a));
                vertexCount++;
            }
            if (!Vertices.containsKey(e.b)) {
                Vertices.put(e.b, new Vertex(e.b));
                vertexCount++;
            }

            if (!cycle(e)) {
                mst.add(e);
                edgeCount++;
                //Vertices.get(e.b).set = Vertices.get(e.a).set;

                Iterator<Map.Entry<String, Vertex>> itr = Vertices.entrySet().iterator();

                String a_set = Vertices.get(e.a).set;
                String b_set = Vertices.get(e.b).set;
                while (itr.hasNext()) {
                    Map.Entry<String, Vertex> entry = itr.next();
                    if(entry.getValue().set.equals(b_set)){
                        entry.getValue().set = a_set;
                    }
                }
            }
        }
        if(edgeCount== vertexCount-1){
            System.out.println("it is a mst");
        }else {
            System.out.println("it is not an mst");
        }
        return mst;
    }




    private boolean cycle(Edge e) {
        System.out.println(Vertices.get(e.a).name + "    "+  Vertices.get(e.a).set+"    " +Vertices.get(e.b).name + "    "+Vertices.get(e.b).set);
        if(Vertices.get(e.a).set.equals(Vertices.get(e.b).set)){
            System.out.println("is cycle");
            return true;
        }
        System.out.println("not cycle");
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge("a", "b", 10));
        edges.add(new Edge("a", "c", 2));
        edges.add(new Edge("d", "c", 5));
        edges.add(new Edge("b", "d", 3));


        Kruskal k = new Kruskal(edges);
        ArrayList<Edge> mst = k.kruskal();
        for (int i = 0; i < mst.size(); i++) {
            System.out.println(mst.get(i).length);
        }

    }
}
