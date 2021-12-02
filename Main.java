	import java.io.*;
	import java.util.*;

	public class Main {
	   
	  public static String lexmen = "";
	  public  static HashMap<String, Integer> symbol_ID = new HashMap<>();
    public static int token; 
	   
	  public static void main(String args[]) throws IOException {

	  specialsymbol_ID();
 
      String str;

        BufferedReader br = new BufferedReader(new FileReader("text.txt"));

        while ((str = br.readLine()) != null)
        {
            

            for(int i = 0; i < str.length(); i++){


                ident(str.charAt(i), false);
              
            }
            
        }
        ident(' ', true);
        

        System.out.println("Next token is: -1 , Next Lexmen is  EOF");

	    }

	    
	   static void specialsymbol_ID(){

	        symbol_ID.put("letter",0);
	        symbol_ID.put("ident",3);
	        symbol_ID.put("+",2);
	        symbol_ID.put("-",10);
	        symbol_ID.put("/",11);
	        symbol_ID.put("*",12);
	        symbol_ID.put("(",13);
	        symbol_ID.put(")",14);
	        symbol_ID.put("=",55);
	        symbol_ID.put(".", 8);
          symbol_ID.put("{", 23);
          symbol_ID.put("}", 24);
          symbol_ID.put(";", 25); // required symbol
	        symbol_ID.put("for", 30);
	        symbol_ID.put("if", 31);
          symbol_ID.put("else",32);
          symbol_ID.put("while",33);
          symbol_ID.put("do",34);
          symbol_ID.put("int",35);
          symbol_ID.put("float",36);
          symbol_ID.put("switch",37);
          symbol_ID.put("foreach", 40); //for each
          symbol_ID.put("void", 41);
          symbol_ID.put("assignment", 42);
          symbol_ID.put("main", 43);
          symbol_ID.put("return", 44);
          symbol_ID.put("public", 45);
          symbol_ID.put("static", 46);
          symbol_ID.put(":", 47);
          symbol_ID.put("[", 48);
          symbol_ID.put("]", 49);

	    }

	    static void ident(char a, boolean finalC){
	        boolean lookup = symbol_ID.containsKey(a+"");
	        if(a == ' '){
	            lookup = true;
	        }
	        if(lookup == false){
	            lexmen += a+"";
	        }else{
	          int tokenID = floatliteral(lexmen) == false ? 0 : 15;
            tokenID = intliteral(lexmen) == false ? 0 : 8;
            
            if(tokenID == 0 && symbol_ID.containsKey(lexmen)){//string
                tokenID = symbol_ID.get(lexmen);
            }
         
      
            if(lexmen.length() > 1){
                System.out.println("Next token is: " + tokenID + ", Next Lexmen is " + lexmen);

                if(lexmen.equals("void")){
                  System.out.println("Enter Void \n");
                }
                if(lexmen.equals("main")){
                  System.out.println("Enter Main \n");
                }
                if(lexmen.equals("return")){
                  System.out.println("Enter Return \n");
                }
                if(lexmen.equals("==")){
                  System.out.println("Enter aAsignment \n");
                }
                if(lexmen.equals("public")){
                  System.out.println("Enter method \n");
                }
                if(lexmen.equals("static")){
                  System.out.println("Enter static method \n");
                }
            }  
           
        
                

            if(symbol_ID.get(a+"") != null)
                System.out.println("Next token is: " +  symbol_ID.get(a+"") + ", Next Lexmen is " + a);
        
              lexmen = "";
        // syntax rules I decided to use a switch statement because a is a char vaue
              switch(a){
                case '(':
                System.out.println("Enter Expression \n ");
                break; 
                case ')':
                System.out.println("Exit Expression \n");
                break; 
                case '{':
                System.out.println("Enter Block  \n");
                break;
                case '}':
                System.out.println("Exit Block \n");
                break;

              }

        }
        
  }
      
   

	    static boolean floatliteral(String str){
	        for(int i = 0; i < str.length(); i++){
	            if(str.charAt(i)=='.'){
	                return true;
	            }
	        }
	        return false;

	    }

	    static boolean intliteral(String str){
	        for(int i = 0; i < str.length(); i++){
	            if(Character.isLetter(str.charAt(i))){
	                return false;
	            }
	        }
	        return true;
	    }
	}