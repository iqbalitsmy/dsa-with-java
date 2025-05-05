/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author AORUS
 */
public class GraphP {

    /*
            (5)
      0 -------- 1
                / \
            (1)/   \(3)
              /     \
             2 ----- 3
              \ (1)
            (2)\ 
                \ 
                 4
     */
    void call() {
        int V = 7;

        ArrayList<Edge>[] graph = new ArrayList[V]; //null -> empty arraylist

//        for (int i = 0; i < V; i++) {
//            graph[i] = new ArrayList<>();
//        }
////        0 -> vertix
//        graph[0].add(new Edge(0, 1, 5));
//
////        1 -> vertix
//        graph[1].add(new Edge(1, 0, 5));
//        graph[1].add(new Edge(1, 2, 1));
//        graph[1].add(new Edge(1, 3, 3));
//
////        2-> vertix
//        graph[2].add(new Edge(2, 1, 1));
//        graph[2].add(new Edge(2, 3, 1));
//        graph[2].add(new Edge(2, 4, 2));
//
////        3-> vertix
//        graph[3].add(new Edge(3, 1, 3));
//        graph[3].add(new Edge(3, 2, 1));
//
////        4-> vertix
//        graph[4].add(new Edge(4, 2, 2));
//        vertixNeigbors(graph, 2);
        createGraph(graph);
        bfs(graph);
        System.out.println("");
        dfs(graph);
        System.out.println("");
        System.out.println(hasPath(graph, 0, 5, new boolean[V]));
    }

    /*
            1 ---- 3
           /       | \
          0        |   5 -- 6
           \       |  /
            2 ---- 4

     */
    void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
//        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    class Edge {

        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

//    print neighbors
    void vertixNeigbors(ArrayList<Edge>[] graph, int vertix) {
        for (int i = 0; i < graph[vertix].size(); i++) {
            Edge e = graph[vertix].get(i);
            System.out.println(e.dest);
        }
    }

    //    Only connected graph
//    void bfs(ArrayList<Edge>[] graph) {     //TC O(V+E)
//        Queue<Integer> q = new LinkedList<>();
//        boolean visited[] = new boolean[graph.length];
//        q.add(0);   //source = 0
//
//        while (!q.isEmpty()) {
//            int curr = q.remove();
//
//            if (!visited[curr]) {
//                System.out.print(curr + " ");
//                visited[curr] = true;
//
//                for (int i = 0; i < graph[curr].size(); i++) {
//                    Edge e = graph[curr].get(i);
//                    q.add(e.dest);
//                }
//            }
//        }
//    }
//    Only connected graph
//    void dfs(ArrayList<Edge>[] graph, int curr, boolean visited[]) {    //TC O(V+E)
//        //visit 
//        System.out.print(curr + " ");
//        visited[curr] = true;
//
//        for (int i = 0; i < graph[curr].size(); i++) {  //check all neighbour
//            Edge e = graph[curr].get(i);
//            if (!visited[e.dest]) {
//                dfs(graph, e.dest, visited);
//            }
//        }
//    }

    /*
        Has Path?
        For given src & dest, tell if a path exists from src to dest 
     */
    boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean visited[]) {    //TC O(V+E)
        if (src == dest) {
            return true;
        }
        visited[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            if (!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) {
                return true;
            }
        }
        return false;
    }

//    -------- part 2 ---------
//    if graph is not connected
    void bfs(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfsUtil(graph, visited);
            }

        }
    }

    void bfsUtil(ArrayList<Edge>[] graph, boolean visited[]) {     //TC O(V+E)
        Queue<Integer> q = new LinkedList<>();

        q.add(0);   //source = 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!visited[curr]) {   //visited curr
                System.out.print(curr + " ");
                visited[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

//     if graph is not connected
    void dfs(ArrayList<Edge>[] graph) {    //TC O(V+E)

        boolean visited[] = new boolean[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            dfsUtil(graph, i, visited);
        }
    }

    void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean visited[]) {    //TC O(V+E)
        //visit 
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {  //check all neighbour
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfsUtil(graph, e.dest, visited);
            }
        }
    }
}
