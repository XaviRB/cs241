//What this file is my edges to my graph that gets the weight and 
//has other methods that help get a specfic thing i need. Another node class
//i relyed heavely on the professors sildes
//I also got extra recources from the link provided and from the turtoing center
//https://java2blog.com/dijkstra-java/
//june 8th ,2021
public class Edge {
    private Integer weight;
    private Node name1;
    private Node name2;
    //This just lays out what nodes and #'s I take in 
    //and assign from the file
    public Edge(Node name1, Node name2, Integer weight) {
        this.weight = weight;
        this.name1 = name1;
        this.name2 = name2;
    }
    //get weight
    public Integer getWeight() {
        return weight;
    }
    //sets the weight
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    //getStartNode
    public Node getStartNode() {
        return name1;
    }
    //setStartNode
    public void setStartNode(Node name1) {
        this.name1 = name1;
    }
    //getTargetNode
    public Node getTargetNode() {
        return name2;
    }
    //setTargetNode
    public void setTargetNode(Node name2) {
        this.name2 = name2;
    }
}
