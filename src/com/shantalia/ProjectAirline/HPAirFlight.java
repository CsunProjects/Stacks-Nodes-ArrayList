package com.shantalia.ProjectAirline;

import java.io.*;
import java.util.*;
public class HPAirFlight {
   private ArrayList<Node> list;
   private LinkedList<Vertex> route = new LinkedList<>();
	
	
   public HPAirFlight() {
      list=new ArrayList<>();
   }
	
   public void loadFlightMap(String fileName) throws IOException {
      File infile = new File(fileName);
      try(Scanner in = new Scanner(infile);)
      {
         while(in.hasNextLine()) {
            String line = in.nextLine();
            String[] tokens = line.split(" "); // splits file characters being read
            Node city = new Node(new Vertex(tokens[0])); // assigns first token read as city
            for(int i=1;i<tokens.length;++i) { //
               city.addPath(new Vertex(tokens[i])); //takes cities path
            }
            list.add(city);
         }
      }
   }
	
   public boolean findFlight(String start,String end) {
      Stack<Vertex> stack = new Stack<>(); //The stack
      Vertex startCity = new Vertex(start,true); //the vertex start point
      Vertex endCity = new Vertex(end,false); //the vertex endpoint
      stack.push(startCity);//pushes the point of the city that was started at into the bottom of stack
      ArrayList<Vertex> path; //list of vertex that the current city can travel to
      
      while(!stack.isEmpty()) {
      	
         String city = stack.peek().getCity();
         if(city.equals(end)) {
            while(!stack.isEmpty())
               route.addFirst(stack.pop());
            System.out.println(route.toString());
         	
            return true;
         }

         //🍉 -Code Starts here:  Left as exercise. Your code goes here
         else {
            // Left as exercise : find the flight route, if it exists
            //  get a vertex from stack and mark visited  (v)
            Vertex CurrentCityPoint = stack.peek(); //👀  city, at top is set to currentCity
            CurrentCityPoint.setVisited(true);// ✈ set to true indicating its visited
            //  get the path of vertex v
            path = new ArrayList<Vertex>(); // 🦜 setting the path to the vertex inside the arraylist
            path = list.get(list.indexOf(new Node(CurrentCityPoint))).getPath(); //🌴  setting path to getting index of node of current city and path

            // if path.size() is zero then remove from stack
            if(path.size()==0){
               stack.pop(); // pops off top of stack (based on path visited since  zero means true
            }
            else {  // else
              // get a vertex from the path that is not int the stack (unvisited), remove it from
               // path and add to stack
               // otherwise remove from stack
               Vertex PathToCity; //varible  vertex created
               for(int j =0; j<path.size();j++) { // for loop takes in size of path,
                  PathToCity=path.get(j); //sets citypath vertex as path
                  if(!PathToCity.isVisited()) { // if vertex is not visited, if false, we want to consider the city for the path,
                     stack.push(PathToCity); // 📌 putting city vertex that was not visited in stack
                     path.remove(PathToCity); // 🚫  removing from path ?
                     break;

                  }
                  else {
                     stack.pop(); //🍿 removes city from path because it has already been visited?
                  }
               }
            }

         }
      }  		
      return false;
   }
	
   public String toString() {
      String result="";
      for(int i=0;i<list.size();++i) {
         result += list.get(i).toString()+"\n";
      }
      return result;
   }

}

class Node{
   private Vertex city;
   private ArrayList<Vertex> path;
   public Node() {
      path = new ArrayList<>();
   }
	
   public Node(Vertex city) {
      this.city = city;
      path = new ArrayList<>();
   }
	
   public void setCity(Vertex city) {
      this.city = city;
   }
	
   public Vertex getCity() {
      return city;
   }
	
   public ArrayList<Vertex> getPath(){
      return path;
   }
	
   public void addPath(Vertex v) {
      path.add(v);
   }
	
   public String toString() {
      return city +"-->"+path;
   }
	
   public boolean equals(Object e) {
      Vertex v = ((Node)e).getCity();
      return this.city.equals(v);
   }
}
