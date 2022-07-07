//This is my Node file i used guidence from the turtoing center and the 
//i relyed heavely on the professors sildes
//i also got extra recources from the link provided
//https://java2blog.com/dijkstra-java/
//june 8th ,2021


*/
//    For some reason it wont let me add a commit to this file so i added the summary here of what would be in the commit. This is also going to be0 //an updated file so im not sure why it didnt let me commit, always have problems with the ssh and pushing.
//    For this file it is my node File that carrys the names and carrys the weight. there are other mehtods that help me get a specific thing that ////i  need in my algorithim.
*/

import java.util.ArrayList;
import java.util.List;
//What this file is it is my node maker and holds many differnet methods that i need to traverse the graph
public class Node implements Comparable<Node> {
    private String name;
    private List<Edge> adjacenciesList;
    private boolean visited;
    private Node predecessor;
    private Integer distance = Integer.MAX_VALUE;
    //takes the string of the node
    public Node(String name){
        this.name = name;
        this.adjacenciesList = new ArrayList<>();        
    }
    //takes in the neighbour and adds it to List
    public void addNeighbour(Edge edge) {
        this.adjacenciesList.add(edge);
    }
    //gets name
    public String getName() {
        return name;
    }
    //sets the name
    public void setName(String name) {
        this.name = name;
    }
    //returns the list
    public List<Edge> getAdjacenciesList() {
        return adjacenciesList;
    }
    //sets the list
    public void setAdjacenciesList(List<Edge> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }
    //boolean
    public boolean isVisited() {
        return visited;
    }
    //sets the boolean
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    //gets the node before 
    public Node getPredecessor() {
        return predecessor;
    }
    //sets the node
    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }
    //gets the distance
    public Integer getDistance() {
        return distance;
    }
    //sets the distance
    public void setDistance(Integer distance) {
        this.distance = distance;
    }
    //rests the string name
    @Override
    public String toString() {
        return this.name;
    }
    //comparing    
    @Override
    public int compareTo(Node otherVertex) {
        return Integer.compare(this.distance, otherVertex.getDistance());
    }
}

