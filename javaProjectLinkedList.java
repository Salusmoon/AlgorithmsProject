import java.io.*;
import java.util.Scanner;
import java.util.*;

class javaProjectLinkedList{

    public static LinkedList<String> FileRead(String file_name) {
    LinkedList<String> my_linkList = new LinkedList<String>(); 
    try{
      // Open the file that is the first 
      // command line parameter
            FileInputStream fstream = new FileInputStream(file_name);
      // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
      //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
      // Print the content on the console
            my_linkList.add(strLine);
            }
      //Close the input stream
        in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        return my_linkList;
    }
    public static void main(String args[]){
   // Scanner input1 = new Scanner(System.in);  // Create a Scanner first input file
    //System.out.println("Enter your first file");

    String file_name = args[0];

    LinkedList<String> my_linkList1 = new LinkedList<String>(); // Create a LinkedList first input file
    my_linkList1 =FileRead(file_name);   
    //System.out.println(my_linkList1);

    file_name = args[1];

    LinkedList<String> my_linkList2 = new LinkedList<String>(); // Create a LinkedList first input file
    my_linkList2 =FileRead(file_name);  
    //System.out.println(my_linkList2);
    
    
    long start = System.nanoTime(); 
    
    LinkedList<String> my_linkList3 = new LinkedList<String>();
    for(int i = 0 ; i < my_linkList1.size() ; i++ ){          //comparison my_linkList1 and my_linkList2
        if(my_linkList2.contains(my_linkList1.get(i))  ){
            my_linkList3.add(my_linkList1.get(i));
        }
    }

    long end = System.nanoTime(); 
    System.out.println("Number of same element :" + my_linkList3.size()); 
    System.out.println("Same elements :"+my_linkList3);
    //System.out.println(start);
    //System.out.println(end);
    System.out.println("Time of algorithms :" + (end - start)+ "ns");  
    }
}