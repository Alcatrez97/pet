package com.test;

import javax.swing.*;
import javax.xml.xpath.XPath;


class HamiltonianCycle {
    int V = 5;
    public static void main(String args[])
    {
        HamiltonianCycle hamiltonian =
                new HamiltonianCycle();
        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4)    */
        int graph1[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };

        // Print the solution
        hamiltonian.hamCycle(graph1);

        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)       (4)    */
        int graph2[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };

        // Print the solution
       if( hamiltonian.hamCycle(graph2) ==1) System.out.println("No Cycle found");;
    }
    boolean hamcycleUtil(int[][] graph, int[] path, int pos){
        if(pos==V){
            if(graph[path[V-1]][0]==1){
                return true;
            }
        }

        for(int i = 1; i < V; i ++){
            if(isSafe(path, pos, graph, i)){
                path[pos] = i;

                if(hamcycleUtil(graph, path, pos + 1)) return true ;
                path[pos] =-1;
            }
        }
        return false;
    }

    int hamCycle(int graph[][]){
       int[] path = new int[V];

        for (int i = 0; i < V; i++) {
            path[i] =-1;
        }

        path[0] = 0;
        if(hamcycleUtil(graph, path, 1)){
            print(path);
            return 0;
        }
        return 1;


    }
    boolean isSafe(int[] path, int pos, int[][] graph, int i){
        if(graph[path[pos -1]][i]==0) return  false ;

        for (int x:
             path) {
            if(x == i) return false;
        }
        return true;

    }
    static void print(int[] arr){
        for (int x :
                arr) {
            System.out.print(x+"->");
        }
        System.out.print(0);
        System.out.println("");
    }
}

