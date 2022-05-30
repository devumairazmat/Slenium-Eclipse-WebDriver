package net.codejava;
import java.util.Vector;
import java.util.Scanner;

class city{
 public int f_n; //straightLineDistfromGoal;
 public int g_n; //straightLineDistfromSource;
 public int total;
 public String cityName;
 Node n;

 city(String Name,int stDG, int stDS, Node nn){
 f_n = stDG;
 g_n = stDS;
 total = f_n + g_n;
 cityName = Name;
 n = nn;
 }
}
class Node{ 

 public String nodeName;
 public Vector<city> nextNodes; 
 Node Start;

 
 Node(String Name, Vector<city>  nns){
 nodeName = Name;
 nextNodes = nns; 
 }

Node(String Name){nodeName = Name;}
  
 public void Initialization(){
  Node Arad = new Node("Arad");
  Node Sibiu = new Node("Sibiu");
  Node RimicuVilcea = new Node("RimicuVilcea");
  Node Pitesti = new Node("Pitesti");
  Node Zerind = new Node("Zerind");
  Node Timisoara = new Node("Timisoara");
  Node Craiova = new Node("Craiova");
  Node Bucharest = new Node("Bucharest");
  Node Oradea = new Node("Oradea");
  Node Fagaras= new Node("Fagaras");
 

  Vector<city> vec1 = new Vector<city>();
  vec1.add(new city("Sibiu",253,140,Sibiu));
  vec1.add(new city("Zerind",374,75,Zerind)); 
  vec1.add(new city("Timisoara",329,118,Timisoara));
  Arad.nodeName = "Arad";
  Arad.nextNodes = vec1;

  Vector<city> vec2 = new Vector<city>();
  vec2.add(new city("Arad",366,280,Arad));
  vec2.add(new city("Fagaras",176,239,Fagaras));
  vec2.add(new city("RimicuVilcea",193,220,RimicuVilcea));
  vec2.add(new city("Oradea",380,291,Oradea));
  Sibiu.nodeName = "Sibiu";
  Sibiu.nextNodes = vec2;

  Vector<city> vec3 = new Vector<city>();
  vec3.add(new city("Pitesti",100,317,Pitesti));
  vec3.add(new city("Craiova",160,366,Craiova));
  vec3.add(new city("Sibiu",253,300,Sibiu));
  RimicuVilcea.nodeName = "Rimicu_Vilcea";
  RimicuVilcea.nextNodes = vec3;


  Vector<city> vec4 = new Vector<city>();
  vec4.add(new city("RimicuVilcea",193,414,RimicuVilcea));
  vec4.add(new city("Craiova",160,455,Craiova));
  vec4.add(new city("Bucharest",0,418,Bucharest));
  Pitesti.nodeName  = "Pitesti";
  Pitesti.nextNodes = vec4;
//
//  try (Scanner scan = new Scanner(System.in)) {
//	System.out.print("Enter Your Starting City :");
//	  String startCity = scan.nextLine();
//	  System.out.print(startCity);
//	  Start = new Node(startCity);
//}
     Start = Arad;
    System.out.println("Initialized");

  }
public void Search(){
  String dest = "ab";
  int min = 0;
  Node curr = Start;
  System.out.println(curr.nodeName);


  while (dest != "Bucharest"){
   min = curr.nextNodes.elementAt(0).total; 
   Node psudoCurr = curr.nextNodes.elementAt(0).n;
     for(int i = 1; i < curr.nextNodes.size(); i++){
         if (min > curr.nextNodes.elementAt(i).total){
            min = curr.nextNodes.elementAt(i).total;
            psudoCurr = curr.nextNodes.elementAt(i).n;
          }
      }
     curr = psudoCurr;
     dest = curr.nodeName; 
     System.out.println(dest);
   }
  }

}
public class HelloWorld {
	

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		Node n = new Node("dummy");
		 n.Initialization();
		 n.Search();
	}

}
