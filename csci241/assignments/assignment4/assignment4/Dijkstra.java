//This is my Dijkstra file i used guidence from the turtoing center 
//i relyed heavely on the professors sildes
//i also got extra recources from the link provided
//https://java2blog.com/dijkstra-java/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    public void Calculate(Node sourceNode){
 
        sourceNode.setDistance(0);
        PriorityQueue<Node> Masterlist = new PriorityQueue<>();
        Masterlist.add(sourceNode);
        sourceNode.setVisited(true);
        //while loop that checks it using prority queue 
        while( !Masterlist.isEmpty() ){
            // Getting the minimum distance vertex from priority queue
            Node actualVertex = Masterlist.poll();
            //checks from edge to adjacitcylist
            for(Edge edge : actualVertex.getAdjacenciesList()){
                //checks to the node
                Node v = edge.getTargetNode();
                if(!v.isVisited())
                {   
                    //create a new integer
                    Integer newDistance = actualVertex.getDistance() + edge.getWeight();
                    //if statement that checks if new dist is less
                    if( newDistance < v.getDistance() ){
                        Masterlist.remove(v);
                        v.setDistance(newDistance);
                        v.setPredecessor(actualVertex);
                        Masterlist.add(v);
                    }
                }
            }
            //checks if it is visted
            actualVertex.setVisited(true);
        }
    }
    //get shortest path 
    public List<Node> getShortestPathTo(Node targetNode){
        List<Node> path = new ArrayList<>();
        //for loop that checks the target
        for(Node vertex = targetNode; vertex != null; vertex = vertex.getPredecessor()){
            path.add(vertex);
        }
        // returns path and collection
        Collections.reverse(path);
        return path;
    }
}
