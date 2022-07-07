import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
    What this file does is it runs my main method and it grabs
    what it needs from the file and assigns my data to nodes so it 
    is easy to orginize and call. This file also handles printing.
    I used a rescource to help me understand to take in an args 
    and read the file acordingly  
    5/22/21
    https://www.w3schools.com/java/java_user_input.asp
*/

public class TakeoffQueue{

    public static void main(String [] args) {
        //calling and making a heap
        HeapMax heap = new HeapMax();
        //my node list being created
        ArrayList<flightNode> list = new ArrayList<flightNode>();

        try{
            //pulls the file and puts it in scanner
            File readFile = new File(args[0]);
            Scanner flights = new Scanner(readFile);
               
            //case 1 
            if(Integer.parseInt(args[1]) == 1){
                //if statement to check that the file has a next line
                if(flights.hasNext()){
                    while(flights.hasNext()){
                        flightNode node = new flightNode();
                        //This is just me assigning each node 
                        //to where it needs to go depending 
                        //where it is on in the file
                        node.Flightorder = flights.next();
                        node.departure = flights.next();
                        node.destination = flights.next();
                        node.time = flights.next();
                        node.passengers = Integer.parseInt(flights.next());
                        list.add(node);        
                    }
                    //this is just a basic for loop that prints out what i need
                    for(int i = 0; i < list.size(); i++){
                        System.out.println(list.get(i).Flightorder);
                    }
                }
            }
            //case 2
            else if(Integer.parseInt(args[1]) == 2){
                //if statement to check that the file has a next line
                if(flights.hasNext()){
                    while(flights.hasNext() == true){
                        flightNode node = new flightNode();
                        //This is just me assigning each node 
                        //to where it needs to go depending 
                        //where it is on in the file
                        node.Flightorder = flights.next();
                        node.departure = flights.next();
                        node.destination = flights.next();
                        node.time = flights.next();
                        node.passengers = Integer.parseInt(flights.next());
                        heap.insert(node);
                    }
                }
                //while loop 
                for(int i = 0; heap.Heap.size() > i;){
                    flightNode temp = heap.removeMax();
                    System.out.println(temp.Flightorder + " " + temp.passengers);
                }
            }
            //case 3    
            else if(Integer.parseInt(args[1]) == 3){
                //if statement to check that the file has a next line
                if(flights.hasNext()){
                    while(flights.hasNext()){
                        flightNode node = new flightNode();
                        //This is just me assigning each node 
                        //to where it needs to go depending 
                        //where it is on in the file
                        node.Flightorder = flights.next();
                        node.departure = flights.next();
                        node.destination = flights.next();
                        node.time = flights.next();
                        node.passengers = Integer.parseInt(flights.next());
                        heap.insert(node);
                    }
                    //basic for loop that prints out what i need
                    for(int i = 0; heap.Heap.size() > i;){
                        flightNode temp = heap.removeMax();
                        System.out.println(temp.Flightorder + " departed at " + temp.time);
                    }

                }
            }
        }
        //catch
        catch(FileNotFoundException ex){
            System.out.println("Error on file");
        }
    }

}