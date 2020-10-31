public class Tsp {
    public static void main(String[] args)
    {

        // n is the number of nodes i.e. V
        int n = 4;

        int[][] graph = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};

        int graph2[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };
          /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)        (4)    */


        // Boolean array to check if a node
        // has been visited or not
        boolean[] v = new boolean[n];
        boolean[] v2 = new boolean[n+1];

        // Mark 0th node as visited
        v2[0]=true;
        v[0] = true;
        int ans = Integer.MAX_VALUE;

        // Find the minimum weight Hamiltonian Cycle
        ans = tsp(graph2, v2, 0, n+1, 1, 0, ans);
        Tsp t = new Tsp();


        // ans is the minimum weight Hamiltonian Cycle
        System.out.println(ans);
        System.out.println(t.ham(graph2, v2,0,1,5));
    }

    static int tsp(int[][] graph, boolean[] v, int pos , int n ,int count , int cost, int ans){

        if(count==n && graph[n-1][0]!=0){
            ans = Math.min(ans, cost+graph[pos][0]);
        }

        for(int i = 0; i < n; i++){
            if(v[i]==false && graph[pos][i] > 0 ){
                v[i] =true;
                ans = tsp(graph, v, i, n, count+1, cost+graph[pos][i], ans);
                v[i]=false;
            }
        }
        return  ans;

    }
   boolean ham(int[][] grap, boolean[] v, int pos, int count, int  n){
        if(count == n )
            if (grap[pos-1][0]==1)
                 return true;
                else return false ;

       for (int i = 1; i < n ; i++) {
           if(!v[i] && grap[pos][i]==1) {
               v[i] = true;
               if (ham(grap, v, i, count + 1, n)) return true;
               v[i] = false;
           }

       }
       return false;
    }
}
