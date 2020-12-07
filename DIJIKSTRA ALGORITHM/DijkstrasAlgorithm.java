import java.util.Scanner;

class DijkstrasAlgorithm {

    private static final int NO_PARENT = -1;


    private static void dijkstra(int[][] ar,
                                 int src)
    {
        int nVertices = ar[0].length;

        int[] shortestDistances = new int[nVertices];

        boolean[] visited = new boolean[nVertices];


        for (int i = 0; i < nVertices;
             i++)
        {
            shortestDistances[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }


        shortestDistances[src] = 0;


        int[] parents = new int[nVertices];


        parents[src] = NO_PARENT;

        for (int i = 1; i < nVertices; i++)
        {


            int c = -1;
            int min = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                if (!visited[vertexIndex] &&
                        shortestDistances[vertexIndex] <
                                min)
                {
                    c = vertexIndex;
                    min = shortestDistances[vertexIndex];
                }
            }


            visited[c] = true;


            for (int j = 0;
                 j < nVertices;
                 j++)
            {
                int edgeDistance = ar[c][j];

                if (edgeDistance > 0
                        && ((min + edgeDistance) <
                        shortestDistances[j]))
                {
                    parents[j] = c;
                    shortestDistances[j] = min +
                            edgeDistance;
                }
            }
        }

        printSolution(src, shortestDistances, parents);
    }


    private static void printSolution(int startVertex,
                                      int[] distances,
                                      int[] parents)
    {
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0;
             vertexIndex < nVertices;
             vertexIndex++)
        {
            if (vertexIndex != startVertex)
            {
                System.out.print("\n" + startVertex + " -> ");
                System.out.print(vertexIndex + " \t\t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, parents);
            }
        }
    }


    private static void printPath(int currentVertex,
                                  int[] parents)
    {


        if (currentVertex == NO_PARENT)
        {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }


    public static void main(String[] args)
    {
        Scanner x=new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int n=x.nextInt();
        int[][] ar =new int[n][n];
        System.out.println("Enter adjacency matrix");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                ar[i][j]=x.nextInt();
            }

        }

        System.out.println("Enter start vertex");
        int k=x.nextInt();
        dijkstra(ar, k);
    }
}


