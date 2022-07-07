import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//What this file is my main file to my graph and it assigns the data do the nodes 
//has other methods that help get a specfic thing i need. Another node class
//i relyed heavely on the professors sildes
//I also got extra recources from the link provided and from the turtoing center
//https://java2blog.com/dijkstra-java/
//june 8th ,2021

public class FindUsers{

    public static void main(String [] args){
        //try block
        try {
            //reads file
            File readFile = new File(args[0]);
            Scanner FindUsers = new Scanner(readFile);
            
            ArrayList<String> name1 = new ArrayList<String>();
            ArrayList<String> name2 = new ArrayList<String>();
            ArrayList<Integer> weight = new ArrayList<Integer>();
            //fills in the names and weights
            while(FindUsers.hasNext()){
                //takes whats in the file and adds it to the 
                //differnet array lists 
                name1.add(FindUsers.next());
                name2.add(FindUsers.next());
                weight.add(Integer.parseInt(FindUsers.next()));
            }
            //case A) sourcePerson targetPerson
            if(name1.contains(args[1]) && name2.contains(args[2])){
                //counter 
                int i = 0;
                Node namesNode1 = new Node(name1.get(i));
                Node namesNode2 = new Node(name2.get(i));
                //while loop that assign
                //where the names and weight goes
                for(;i < weight.size(); i++){
                    //adds the neighbours 
                    namesNode1.addNeighbour(new Edge(namesNode1, namesNode2, weight.get(i)));
                    namesNode2.addNeighbour(new Edge(namesNode1, namesNode2, weight.get(i)));
                    
                }
                //puts it into the graph
                Dijkstra shortestDistance = new Dijkstra();
                shortestDistance.Calculate(namesNode1);
                System.out.println(args[1]+ "-> "+  args[2] + ":" + namesNode2.getDistance());
            }

            //case2
            if(name1.contains(args[1]) && args[2] == args[2]){
                

            } 

            //closes file
            FindUsers.close();
        }

        catch(FileNotFoundException ex){
            System.out.println("FILE NOT FOUND");
        }

    }    
}
