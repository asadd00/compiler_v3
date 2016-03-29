/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crunchify;
 
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Crunchify.com
 */
 
public class CompilerConstructor {
 
	public static void main(String[] args) {
            int  s=0,t=0,a=0 ,b=0;
            char c;
            String class_part="" ;
            String value_part="" ;
    
            int line_no = 1 ;
            boolean dot=true;
             boolean flt=true;
             boolean comit=true;
           String[] token = new String[100];
            String[] ftoken = new String[2];
            
                Scanner scan = new Scanner(System.in);String testString = scan.nextLine();
                
                String arraybreak = " ?";
                
                testString=testString+arraybreak;
                
		char[] array1 = testString.toCharArray();
                
                      System.out.println("your string: "+testString);
                    try{
                      for(int i=0;i<array1.length;i++){
                        for(int j=0;j<array1.length;j++){
                       if(array1[j]== ' '||array1[j]== ';'||array1[j]== '\\'||array1[j]== ','||array1[j]== ':'    //sepaerators
                               ||array1[j]== '{'||array1[j]== '}'||array1[j]== '['
                               ||array1[j]== ']'||array1[j]== '('||array1[j]== ')'||array1[j]== '='||array1[j]== '<'
                               ||array1[j]== '>'||array1[j]== '+'||array1[j]== '-'||array1[j]== '!'||array1[j]== '='
                               ||array1[j]== '%'||array1[j]== '*'||array1[j]== '/'||array1[j]== '&'||array1[j]== '|'
                               ||array1[j]== '@'){ 
                           
                           
                       s =j;
                     
                        char[] token1 = Arrays.copyOfRange(array1, i, s);
                              
                         String tokens1 = String.valueOf(token1);
                         
                             token[t] = tokens1;
                               t=t+1;
                           i=s+1;
                       }
                       
                  else     if(array1[j]=='='){                      // = and == conditions
                        if(array1[j]=='='&&array1[j+1]=='=') 
                        {
                            
                             token[t] = "==";
                               t=t+1;
                               i=i+1;
                               j=j+1;
                               
                        }else{
                        token[t] = "=";
                               t=t+1;
                            
                        }
                       }
                       if(array1[j]=='+'){                      // + and ++ conditions
                        if(array1[j]=='+'&&array1[j+1]=='+') 
                        {
                            
                             token[t] = "++";
                               t=t+1;
                               i=i+1;
                               j=j+1;
                               
                        }
                        else if(array1[j]=='+'&&array1[j+1]=='=') 
                        {
                            
                             token[t] = "+=";
                               t=t+1;
                               i=i+1;
                               j=j+1;
                               
                        }
                        else{
                        token[t] = "+";
                               t=t+1;
                            
                        }
                       }
                       if(array1[j]=='-'){                      // - and -- conditions
                        if(array1[j]=='-'&&array1[j+1]=='-') 
                        {
                            
                             token[t] = "--";
                               t=t+1;
                               i=i+1;
                               j=j+1;
                               
                        }
                      else   if(array1[j]=='-'&&array1[j+1]=='=') 
                        {
                            
                             token[t] = "-=";
                               t=t+1;
                               i=i+1;
                               j=j+1;
                               
                        }
                        else{
                        token[t] = "-";
                               t=t+1;
                            
                        }
                       }
                       if(array1[j]=='*'){                      // * and *= conditions
                        if(array1[j]=='*'&&array1[j+1]=='=') 
                        {
                            
                             token[t] = "*=";
                               t=t+1;
                               i=i+1;
                               j=j+1;
                               
                        }else{
                        token[t] = "*";
                               t=t+1;
                            
                        }
                       }
                       if(array1[j]=='/'){                      //    / and /= conditions
                        if(array1[j]=='/'&&array1[j+1]=='=') 
                        {
                            
                             token[t] = "/=";
                               t=t+1;
                               i=i+1;
                               j=j+1;
                               
                        }else{
                        token[t] = "/";
                               t=t+1;
                            
                        }
                       }
                       if(array1[j]=='&'&&array1[j+1]=='&')  //// LOGICAL_OPERATORS
                        {
                            
                             token[t] = "&&";
                               t=t+1;
                               i=i+1;
                               j=j+1;
                               
                        }
                       if(array1[j]=='|'&&array1[j+1]=='|')  //// LOGICAL_OPERATORS
                        {
                            
                             token[t] = "||";
                               t=t+1;
                               i=i+1;
                               j=j+1;
                               
                        }
                       if(array1[j]=='<'){                      // <= relation 
                        if(array1[j]=='<'&&array1[j+1]=='=') 
                        {
                            
                             token[t] = "<=";
                               t=t+1;
                               i=i+1;
                               j=j+1;
                               
                        }else{
                        token[t] = "<";
                               t=t+1;
                            
                        }
                       }
                                              
                       if(array1[j]=='!'){                      // != ! relation 
                        if(array1[j]=='!'&&array1[j+1]=='=') 
                        {
                            
                             token[t] = "!=";
                               t=t+1;
                               i=i+1;
                               j=j+1;
                               
                        }else{
                        token[t] = "!";
                               t=t+1;
                            
                        }
                       }
                       
                       if(array1[j]=='>'){                      // >= relation 
                        if(array1[j]=='>'&&array1[j+1]=='=') 
                        {
                            
                             token[t] = ">=";
                               t=t+1;
                               i=i+1;
                               j=j+1;
                               
                        }else{
                        token[t] = ">";
                               t=t+1;
                            
                        }
                       }
                        if(array1[j]=='%')  // %
                        {
                            
                             token[t] = "%";
                               t=t+1;
                              
                               
                        }
                       
                    
                        
                       if(array1[j]=='.'){   // float constant
                               
                           if(dot==false)
                           {
                              String array = String.valueOf(array1[j+1]);
                               String array2 = String.valueOf(array1[j-1]);
                                if(array2.matches("[0-9]")&&array1[j]=='.'&& array.matches("[0-9]")&& flt==false) 
                        {
                              flt=true;
                             dot=false;
                        }
                                else{   
                                    s =j; 
                                char[] token1 = Arrays.copyOfRange(array1, i, s);

                                 String tokens1 = String.valueOf(token1);
                                 i=s+1;
                                     token[t] = tokens1;
                                       t=t+1;
                                       token[t] = ".";
                                       t=t+1;
                                  dot=true;
                                   flt=false;
                                }
                               
                           } 
                           else if(dot==true)
                           { 
                               
                               String array = String.valueOf(array1[j+1]);
                               String array2 = String.valueOf(array1[j-1]);
                               if((array2.matches("[A-z]")&& array1[j]=='.'&& array.matches("[A-z]"))||
                                ( array2.matches("[0-9]")&& array1[j]=='.'&& array.matches("[A-z]"))
                                 || (array2.matches("[A-z]")&& array1[j]=='.'&& array.matches("[0-9]"))
                                 || (array2.matches("[A-z]")&& array1[j]=='.')) 
                        {
                             s =j; 
                               
                        char[] token1 = Arrays.copyOfRange(array1, i, s);
                              
                         String tokens1 = String.valueOf(token1);
                         i=s+1;
                             token[t] = tokens1;
                               t=t+1;
                               
                               token[t] = ".";
                               t=t+1;
                               token[t] = " ";
                               t=t+1;
                               flt=false;
                               dot=false;
                        }
                          else     if(array2.matches("[0-9]")&&array1[j]=='.'&& array.matches("[0-9]")) 
                        {
                             flt=true;
                             dot=false;
                        }
                          else    
                        {
                           System.out.println("dot is here");
                             token[t] = ".";
                               t=t+1;
                                token[t] = " ";
                               t=t+1;
                                flt=false;
                             dot=false;
                        }
                             
                               }
                           
                           
                       }
                       
                    else    if(array1[j]== ','||array1[j]== ':'||array1[j]== '{'
                                ||array1[j]== '}'||array1[j]== '['||array1[j]== ']'||array1[j]== '('||array1[j]== ')'||array1[j]== ';') //punctuators
                        {
                            String tokens1 = String.valueOf(array1[j]);
                          
                             token[t] = tokens1;
                               t=t+1;
                               
                        }
                    else if(array1[j]== '@' ){    
                        
                                String array = String.valueOf(array1[j+1]);
                             
                                if(array1[j]=='@'&& array!="@")             // multi comments
                                {
                            int cmt=j+1;
                            for(;cmt<array1.length;cmt++){
                                if(array1[cmt]!='@'){
                                    i=i+1;
                                   j=j+1;
                                }
                                else if(array1[cmt]=='@'){

                               cmt=array1.length;
                               i=i+1;
                               j=j+1;
                                }

                                 }
                                }
                                
                             else   if(array1[j]=='@'&& array=="@" )       // single comments
                                {
                                 
                                    int cmt=j+1;
                                    for(;cmt<array1.length;cmt++){
                                    if(array1[cmt]!='?'){
                                        i=i+1;
                                       j=j+1;
                                    }
                                    else if(array1[cmt]=='?'){

                                   cmt=array1.length;
                                   i=i+1;
                                   j=j+1;
                                    }

                                     }
                                }
                      }
                      }   
                    }
                    
                    System.out.println("\n"); /// print token
                    for(int k=0;k<array1.length;k++){
                      //  System.out.println("Your token: " +token[k]);
                        
                         if(token[k].equals("String")||token[k].equals("int")||token[k].equals("char")||token[k].equals("float") ){ ///Data types
                                class_part = "Data Type";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");
                                }
                         else if (token[k].matches("if")){  //IF_CONDITIONAL 
                            
                             System.out.println("( IF_CONDITION,"+token[k]+","+line_no+" )");
                            }
                         else if (token[k].matches("else")){  //IF_CONDITIONAL 
                            
                             System.out.println("( ELSE_CONDITION,"+token[k]+","+line_no+" )");
                            }
                         else if (token[k].matches("for")){  //for_CONDITIONAL 
                            
                             System.out.println("( for_CONDITIONAL,"+token[k]+","+line_no+" )");
                            }
                         else if (token[k].matches("while")){  //while_CONDITIONAL 
                            
                             System.out.println("( while_CONDITIONAL,"+token[k]+","+line_no+" )");
                            }
                         else if (token[k].matches("do")){  //do_CONDITIONAL 
                            
                             System.out.println("( DO_CONDITIONAL,"+token[k]+","+line_no+" )");
                            }
                         else if (token[k].matches("Terminate")||token[k].matches("Case")||token[k].matches("Start")   //   Keywords
                                 ||token[k].matches("Void")||token[k].matches("Expose")||token[k].matches("Secure")
                                 ||token[k].matches("Method")||token[k].matches("Do")||token[k].matches("Grab")
                                 ||token[k].matches("Goback")||token[k].matches("Static")||token[k].matches("Fixed")
                                 ||token[k].matches("Class")||token[k].matches("Stick")||token[k].matches("Import")
                                 ||token[k].matches("Yes")||token[k].matches("No")){   
                            
                             value_part = token[k];
                             System.out.println("( "+value_part+" , "+token[k]+" , "+line_no+" )");
                            }
                         else if(token[k].equals(",")||token[k].equals(":")||token[k].equals("{")||token[k].equals("}")      ///Punctuators
                                 ||token[k].equals("[")||token[k].equals("]")||token[k].equals("(")||token[k].equals(")")||token[k].equals(";")){ 
                               
                               value_part = token[k];
                               System.out.println( "( "+value_part+" , "+value_part+" , "+line_no+" )");
                                }
                         else if(token[k].equals("<")||token[k].equals(">")){       /// single Relation operator
                               
                              class_part = "Relation_operator";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");
                                }
                         else if(token[k].equals("++")||token[k].equals("--")){       /// inc/dec operator
                               
                              class_part = "INC/DEC_OPERATORS";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");
                                }
                         else if(token[k].equals("+")||token[k].equals("-")){       /// ADD/SUB_ARITHMETIC_OPERATORS
                               
                              class_part = "ADD/SUB_ARITHMETIC_OPERATORS";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");
                                }
                         else if(token[k].equals("*")||token[k].equals("/")){       /// MUL/DIV _ARITHMETIC_OPERATORS
                               
                              class_part = "MUL/DIV _ARITHMETIC_OPERATORS";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");
                                }
                         else if(token[k].equals("+=")||token[k].equals("-=")||token[k].equals("*=")  /// SPEC_ASSIGNMENT_OPERATORS
                                 ||token[k].equals("/=")){       
                               
                              class_part = "SPEC_ASSIGNMENT_OPERATORS";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");
                                }
                          else if(token[k].equals("&&")||token[k].equals("||")){       //   LOGICAL_OPERATORS
                               
                              class_part = "AND/OR_OPERATOR";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");
                                }
                          else if(token[k].equals("!")||token[k].equals("=")||token[k].equals("%")||token[k].equals(".")){       /// single same name operator
                               
                              class_part = token[k];
                               value_part = token[k];
                               System.out.println( "( "+class_part+" , "+value_part+" , "+line_no+" )");
                                }
                         
                          else if(token[k].equals("<=")||token[k].equals(">=")||token[k].equals("==")
                                  ||token[k].equals("!=")){        //Double relation operator
                               
                              class_part = "Relation_operator";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");
                                }
                          
                            
                         
                          else   if (token[k].matches("[A-z]+")||token[k].matches("[[A-z]*[0-9]*]+[_]+[[A-z]*[0-9]*]+") //ID
                                  ||token[k].matches("[_]+[[A-z]+[0-9]*]+")){ 
                             String[] ID_token;
                           
                             System.out.println("( ID,"+token[k]+","+line_no+" )");
                            
                            }
                          else   if (token[k].matches("[A-z]*[0-9]*[A-z]+[0-9]+")){  //Invalid ID
                             String[] ID_token;
                           
                             System.out.println("( Invalid_ID,"+token[k]+","+line_no+" )");
                            
                            }
                         
                         
                         else   if (token[k].matches("[0-9]+[.][A-z]+")||token[k].matches("[A-z]+[.][A-z]+")
                                 ||token[k].matches("[A-z]+[.][0-9]*[A-z]+[0-9]*")){  // float constant seperator
                             String[] ID_token;
                            ID_token = token[k].split("[.]");
                             System.out.println("( ID,"+ID_token[0]+","+line_no+" )");
                             System.out.println("( . , . ,0 )");
                             System.out.println("( ID,"+ID_token[1]+","+line_no+" )");
                            }
                        
                                 else   if (token[k].matches("[A-z]+[.][0-9]+")){  // float constant seperator
                             String[] ID_token;
                            ID_token = token[k].split("[.]");
                             System.out.println("( ID,"+ID_token[0]+","+line_no+" )");
                             System.out.println("( . , . ,"+line_no+" )");
                             System.out.println("( Int_constant,"+ID_token[1]+","+line_no+" )");
                            }
                         else   if (token[k].matches("[0-9]+[.][0-9]+")){  // float constant 
                            
                           
                             System.out.println("( Float_constant,"+token[k]+","+line_no+" )");
                            }
                         else   if (token[k].matches("[A-z]*[0-9]+[.][0-9]+[[A-z]+[0-9]*]+")){  //Invalid float constant 
                            
                           
                             System.out.println("( Invalid_Float_constant,"+token[k]+","+line_no+" )");
                            }
                         
                            
                         else   if (token[k].matches("\\\"[[A-z]*[0-9]*[A-z]*[0-9]*]*\\\"")){ //String constant
          
                            String[] ID_token = token[k].split("[\\\"]");
                            class_part = "String_constant";
                           value_part = token[k];
                            System.out.println( "( \" , \" ,"+line_no+")");
                           System.out.println( "("+class_part+","+ID_token[1]+","+line_no+")");
                          System.out.println( "( \" , \" ,"+line_no+")");
                         }
                            
                         else if (token[k].matches("[0-9]+")){          ////int constant
                        String[] ID_token = token[k].split("[=]");
                         class_part = "Int_constant";
                        value_part = token[k];
                         System.out.println( "("+class_part+","+ID_token[0]+","+line_no+")");
                          
                                }
                            else if (token[k].matches("['][A-z][']")){          ////char constant
                        String[] ID_token = token[k].split("[']");
                         class_part = "Char_constant";
                        value_part = token[k];
                        System.out.println( "( ' , ' ,"+line_no+")");
                         System.out.println( "("+class_part+","+ID_token[1]+","+line_no+")");
                          System.out.println( "( ' , ' ,"+line_no+")");
                                }
                          
                        
                        
                    }
		}catch(NullPointerException e){}
               
                  
}

}

