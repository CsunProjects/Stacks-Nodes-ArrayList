package com.shantalia.ProjectAirline;

import java.io.*;
public class TestFlight {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		HPAirFlight hp = new HPAirFlight(); // Extends object
		hp.loadFlightMap("flights.txt"); //file name is flights.txt, this loads the vertexes
		System.out.println(hp); // prints hp(the object vertex points)
		if(hp.findFlight("T", "X"))
			System.out.println("Path found"); //
		else
			System.out.println("No path found");
		 //file name is flights.txt, this loads the vertexes
		hp =new HPAirFlight();
		hp.loadFlightMap("flights.txt");
		System.out.println(hp); // prints hp(the object vertex points)
		if(hp.findFlight("T", "R"))
			System.out.println("Path found"); //
		else
			System.out.println("No path found");


		

	}

}
