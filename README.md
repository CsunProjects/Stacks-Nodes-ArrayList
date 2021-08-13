# Stacks-Nodes-ArrayList
Create a Stack/Get vertex from stack and mark visted paths. remove. add unvisted paths to stack



_____________________________________________________________________________________________________________
High Planes Airline Company (HP Air)

Given a flight map for HP Air as a graph consisting of vertices and edges between the vertices, write a program to indicate whether a sequence of HPAir flights exists from the origin city to the destination city.

HP Air Flight map




Algorithm:

Create a stack (aStack)
Clear marks on all cities
aStack.push(originalCity)
Mark the originalCity as visited
While ( have not found a path to destCity) {
  if ( no flight exist from city on top of stack to unvisited cities)
     temp = aStack.pop()
  else {
     select an unvisited dest. city c for a flight from the city on the top of the stack
      aStack.push(c)
      mark c as visited
    }
 }


Classes needed for the project:

public class Vertex {
	private String city;
	private boolean visited;
	
	public Vertex() {
		
	}
	
	public Vertex(String city) {
		this.city=city;
		visited=false;
	}
	
	public Vertex(String city, boolean v) {
		this.city=city;
		visited=v;
	}
	
	public void setCity(String city) {
		this.city=city;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setVisited(boolean visited) {
		this.visited=visited;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public String toString() {
		return city;
	}
	
	public boolean equals(Object v) {
		return this.city.equals(((Vertex)v).city);
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
				String[] tokens = line.split(" ");
				Node city = new Node(new Vertex(tokens[0]));
				for(int i=1;i<tokens.length;++i) {
					city.addPath(new Vertex(tokens[i]));
				}
				list.add(city);
			}
		}
	}
	
	public boolean findFlight(String start,String end) {
		Stack<Vertex> stack = new Stack<>();
		Vertex startCity = new Vertex(start,true);
		Vertex endCity = new  Vertex(end,false);
		stack.push(startCity);
		ArrayList<Vertex> path; 

		while(!stack.isEmpty()) {
			
			String city = stack.peek().getCity();
			if(city.equals(end)) {
				while(!stack.isEmpty())
					route.addFirst(stack.pop());
				System.out.println(route.toString());
				
				return true;

                // Left as exercise : find the flight route, if it exists
               //  get a vertex from stack and mark visited  (v)
               //  get the path of vertex v
               // if path.size() is zero then remove from stack
               // else
               // get a vertex from the path that is not int the stack (unvisited), remove it from 
               // path and add to stack 
               // otherwise remove from stack
   

					
	    } // end while
	
	public String toString() {
		String result="";
		for(int i=0;i<list.size();++i) {
			result += list.get(i).toString()+"\n";
		}
		return result;
	}

}

