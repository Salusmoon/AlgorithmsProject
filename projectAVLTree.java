import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.math.*;


class projectAVLTree{

    public static AVLTree FileRead(String file_name) {
        AVLTree avlTree = new AVLTree() ; 
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
                avlTree.root = avlTree.insert(avlTree.root, Integer.parseInt(strLine));
                }
          //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        return avlTree;
    }

    public static void main(String args[]){
        // Scanner input1 = new Scanner(System.in);  // Create a Scanner first input file
        //System.out.println("Enter your first file");
    
        String file_name = args[0];
    
        AVLTree avlTree1 = new AVLTree(); // Create a AVLTree first input file
        avlTree1 =FileRead(file_name);   
        //avlTree1.preOrder(avlTree1.root);
        System.out.println("\n");
    
        file_name = args[1];
    
        AVLTree avlTree2 = new AVLTree(); // Create a AVLTree second input file
        avlTree2 =FileRead(file_name);   
        //avlTree2.preOrder(avlTree2.root);
    
        ArrayList<Integer> containsBoth = new ArrayList<>();

        long start = System.nanoTime(); 
        containsBoth.addAll(avlTree1.compareAvl(avlTree2,avlTree1.root));
        long end = System.nanoTime(); 

        System.out.println("Number of same element :" + containsBoth.size()); 
        System.out.println("Same elements :");
        for(Integer item : containsBoth){
            System.out.print(Integer.toString(item)+" ");
        }
        System.out.println("\n");
        System.out.println("Time of algorithms :" + (end - start)+ "ns");  
        
        
    }   
    
}

