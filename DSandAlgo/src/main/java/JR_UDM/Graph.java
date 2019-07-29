package JR_UDM;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    private int vertices; //no of vertices
    private LinkedList<Integer> adjancencyList[]; //Adjacency List

    Graph(int vertices){
        this.vertices = vertices;
        adjancencyList = new LinkedList[vertices];
        for(int i=0; i < vertices; i++){
            adjancencyList[i] = new LinkedList();
        }
    }

    //Add edges
    public void addEdges(int fromVertex, int toVertex){
        adjancencyList[fromVertex].add(toVertex);
    }


    //Breadth First Search from given source s
    public void BreadthFirstSearch(int initialVertex){

        //mark all the vertices as not visited (boolean default value is false)
        boolean visited[] = new boolean[vertices];

        //Create a Queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        //Mark the current node as visited
        visited[initialVertex] = true;

        //add initial vertex to queue
        queue.add(initialVertex);

        while (queue.size() != 0){

            int vertex = queue.poll();
            System.out.println("De-Queue : " + vertex);

            //Get all the adjacent vertices of the de-queued vertex
            //If adjacent vertex has not been visited, marked as visited
            //Visited and En-queue it

            Iterator<Integer> itr = adjancencyList[vertex].listIterator();
            while (itr.hasNext()){
                int nextVertex = itr.next();

                //check if it is not visited, if yes then add to queue and make it visited
                if(!visited[nextVertex]){
                    visited[nextVertex] = true;

                    System.out.println("En-Queue : "+nextVertex);
                    queue.add(nextVertex);
                }
            }
        }

    }


    public void DepthFirstSearch (int initialVertex){

        //create new stack and add initial vertex
        Stack<Integer> stack = new Stack<>();
        stack.add(initialVertex);

        //create visited vertex list and mark initial vertex to visited
        boolean[] visited = new boolean[vertices];
        visited[initialVertex] = true;

        //run the loop while stack is Empty
        while(stack.isEmpty()){

            //pop out the initial vertex
            int popVertex = stack.pop();

            System.out.println("De-Stack : "+popVertex);

            //Find the connected vertices
            Iterator itr = adjancencyList[popVertex].listIterator();
             while (itr.hasNext()){
                int neighbourVertex = (Integer) itr.next();

                if(!visited[neighbourVertex]){
                    //mark neighbour vertex to visited
                    visited[neighbourVertex] = true;
                    //add back stack again
                    stack.add(neighbourVertex);
                    System.out.println("Stacking : "+neighbourVertex);
                }
            }
        }

    }


}
