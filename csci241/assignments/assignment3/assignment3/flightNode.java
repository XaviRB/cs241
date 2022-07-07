//This file makes the flight node and it will return Flightorder, time, departerure, destination 
//Made this node class so i can point at any node at anytime, also usefull to hold each type of information
//Got help from CS tutor hours helping me make the node class and understand what each node is suposed to take in
public class flightNode {
    //Flightorder
    String Flightorder;
    public String getFlightorder() { 
        return Flightorder; 
    }
    //Passengers
    int passengers;
    public Integer getpassenger() { 
        return passengers; 
    }
    //Time 
    String time;
    public String getTime(){
        return time;
    }
    //Departure
    String departure;
    public String getDeparture(){
        return departure;
    }
    //Destation
    String destination;
    public String getDestination(){
        return destination;
    }
}
