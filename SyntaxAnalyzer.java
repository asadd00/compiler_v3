/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syntax.analyzer;
    
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Muhammad
 */
public class SyntaxAnalyzer {
    static int i=0;
    static boolean syn;
    /**
     * @param args the command line arguments
     */
    static String[] syntaxarray = new String[100];
    
    public static void main(String[] args) {

        //String[] syntaxarray = new String[100];
        //String[] cp = new String[]{"public","expose","void","start","(",")","{","DT","ID","=","int_constant",";","}"};
        //String[] cp = new String[]{"public","expose","void","start","(",")","{","DT","ID",";","}"};
        //String[] cp = new String[]{"public","expose","void","start","(",")","{","check","(","ID","Relation_operator","ID",")","{","DT","ID","=","int_constant",";","}"};
        //String[] cp = new String[]{"public","expose","void","start","(",")","{","next","(","DT","ID","=","int_constant",";","ID","Relation_operator","ID",";","ID","INC/DEC_OPERATORS",")","{","DT","ID","=","int_constant",";","}","}"};
        
            userInt ui = new userInt();
            
            //ui.setVisible(true);
            
            int  s=0,t=0,a=0 ,b=0;
            
            String class_part="" ;
            String value_part="" ;
    
            int line_no = 1 ;
            boolean dot=true;
             boolean flt=true;
             boolean comit=true;
           String[] token = new String[100];
           
           String[] Valuepart = new String[100];
            
            
                Scanner scan = new Scanner(System.in);
                //String testString = ui.getCode();
                String testString = scan.nextLine();
                
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
                               ||array1[j]== '@'||array1[j]== '\"'){ 
                           
                           
                       s =j;
                     
                        char[] token1 = Arrays.copyOfRange(array1, i, s);
                              
                         String tokens1 = String.valueOf(token1);
                         
                             token[t] = tokens1;
                               t=t+1;
                           i=s+1;
                       }
                       
                      if(array1[j]=='\"'){                      //string
                        int str=j+1;
                            for(;str<array1.length;str++){
                                if( array1[str]!='\"') 
                              {
                                 
                               j=j+1;
                               s=j;
                              }
                                else if(array1[str]=='\"')
                                {
                                     str=array1.length;
                                 char[] token1 = Arrays.copyOfRange(array1, i, s+1);
                              
                                String tokens1 = String.valueOf(token1);
                                String invertedcomas = "\"";
                               
                                tokens1=invertedcomas+ tokens1 +invertedcomas;
                                 token[t] = tokens1;
                                  t=t+1;
                                   token[t] = " ";
                                  t=t+1;
                                    i=s+2;
                                   j=j+1;
                                }
                            }
                        
                  }
                  else    if(array1[j]=='\''){                      //char
                         s=j;
                          char[] token1 = Arrays.copyOfRange(array1, i, s+3);
                                 String tokens1 = String.valueOf(token1); 
                                 token[t] = tokens1;
                                  t=t+1;
                                  i=s+3;
                                  j=j+2;
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
                                if(array2.matches("[0-9]")&&array1[j]=='.'&& array.matches("[0-9]")) 
                        {
                             
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
                             
                               dot=false;
                        }
                          else     if(array2.matches("[0-9]")&&array1[j]=='.'&& array.matches("[0-9]")) 
                        {
                             
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
                        
                         if(token[k].equals("string")||token[k].equals("int")||token[k].equals("char")||token[k].equals("float") ){ ///Data types
                                class_part = "DT";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");
                                syntaxarray[a] = class_part;
                                Valuepart[a]=value_part;
                               a++;
                                }
                         else if (token[k].matches("check")){  //IF_CONDITIONAL 
                            
                             class_part="check";
                             System.out.println("( IF_CONDITION,"+token[k]+","+line_no+" )");
                              syntaxarray[a] = class_part;
                              Valuepart[a]= token[k];
                               a++;
                            }
                         else if (token[k].matches("until")){  //While_CONDITIONAL 
                            
                             class_part="until";
                             System.out.println("( until ,"+token[k]+","+line_no+" )");
                              syntaxarray[a] = class_part;
                              Valuepart[a]=token[k];
                               a++;
                            }
                         else if (token[k].matches("next")){  //for_CONDITIONAL 
                            
                             class_part="for_CONDITIONAL";
                             System.out.println("( for_CONDITIONAL,"+token[k]+","+line_no+" )");
                              syntaxarray[a] = class_part;
                              Valuepart[a]=token[k];
                               a++;
                            }
                         else if (token[k].matches("then")){  //else_CONDITIONAL 
                            class_part="then";
                             System.out.println("( then,"+token[k]+","+line_no+" )");
                              syntaxarray[a] = class_part;
                              Valuepart[a]=token[k];
                               a++;
                            }
                         else if (token[k].matches("exec")){  //do_CONDITIONAL 
                             class_part = "exec";
                             System.out.println("( exec,"+token[k]+","+line_no+" )");
                              syntaxarray[a] = class_part;
                              Valuepart[a]=token[k];
                               a++;
                            }
                         else if (token[k].matches("terminate")||token[k].matches("case")||token[k].matches("start")   //   Keywords
                                 ||token[k].matches("void")||token[k].matches("expose")||token[k].matches("secure")
                                 ||token[k].matches("method")||token[k].matches("do")||token[k].matches("grab")
                                 ||token[k].matches("goBack")||token[k].matches("static")||token[k].matches("fixed")
                                 ||token[k].matches("class")||token[k].matches("stick")||token[k].matches("import")
                                 ||token[k].matches("yes")||token[k].matches("no")){   
                             class_part = token[k];
                             value_part = token[k];
                             System.out.println("( "+value_part+" , "+token[k]+" , "+line_no+" )");
                              syntaxarray[a] = class_part;
                              Valuepart[a]=token[k];
                               a++;
                            }
                           
                         else if(token[k].equals(",")||token[k].equals(":")||token[k].equals("{")||token[k].equals("}")      ///Punctuators
                                 ||token[k].equals("[")||token[k].equals("]")||token[k].equals("(")||token[k].equals(")")||token[k].equals(";")){ 
                               class_part = token[k];
                               value_part = token[k];
                               System.out.println( "( "+value_part+" , "+value_part+" , "+line_no+" )");
                               syntaxarray[a] = class_part;
                               Valuepart[a]=token[k];
                               a++;
                                }
                         else if(token[k].equals("<")||token[k].equals(">")){       /// single Relation operator
                               
                              class_part = "Relation_operator";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");
                               syntaxarray[a] = class_part;
                               Valuepart[a]=token[k];
                               a++;
                                }
                         else if(token[k].equals("++")||token[k].equals("--")){       /// inc/dec operator
                               
                              class_part = "INC/DEC_OPERATORS";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");
                               syntaxarray[a] = class_part;
                               Valuepart[a]=token[k];
                               a++;
                               
                                }
                         else if(token[k].equals("+")||token[k].equals("-")){       /// ADD/SUB_ARITHMETIC_OPERATORS
                               
                              class_part = "ADD/SUB_Operators";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");
                               syntaxarray[a] = class_part;
                               Valuepart[a]=token[k];
                               a++;
                                }
                         else if(token[k].equals("*")||token[k].equals("/")){       /// MUL/DIV _ARITHMETIC_OPERATORS
                               
                              class_part = "MUL/DIV _OPERATORS";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");
                               syntaxarray[a] = class_part;
                               Valuepart[a]=token[k];
                               a++;
                                }
                         else if(token[k].equals("+=")||token[k].equals("-=")||token[k].equals("*=")  /// SPEC_ASSIGNMENT_OPERATORS
                                 ||token[k].equals("/=")){       
                               
                              class_part = "SPEC_ASSIGNMENT_OPERATORS";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");
                               syntaxarray[a] = class_part;
                               Valuepart[a]=token[k];
                               a++;
                                }
                          else if(token[k].equals("&&")||token[k].equals("||")){       //   LOGICAL_OPERATORS
                               
                              class_part = "AND/OR_OPERATOR";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");syntaxarray[a] = class_part;
                               syntaxarray[a] = class_part;
                               Valuepart[a]=token[k];
                               a++;
                               
                                }
                          else if(token[k].equals("!")||token[k].equals("=")||token[k].equals("%")||token[k].equals(".")){       /// single same name operator
                               
                              class_part = token[k];
                               value_part = token[k];
                               System.out.println( "( "+class_part+" , "+value_part+" , "+line_no+" )");
                               syntaxarray[a] = class_part;
                               Valuepart[a]=token[k];
                               a++;
                                }
                         
                          else if(token[k].equals("<=")||token[k].equals(">=")||token[k].equals("==")
                                  ||token[k].equals("!=")){        //Double relation operator
                               
                              class_part = "Relation_operator";
                               value_part = token[k];
                               System.out.println( "("+class_part+","+value_part+","+line_no+")");
                               syntaxarray[a] = class_part;
                               Valuepart[a]=token[k];
                               a++;
                                }
                          
                            
                         
                          else   if (token[k].matches("[A-z]+")||token[k].matches("[[A-z]*[0-9]*]+[_]+[[A-z]*[0-9]*]+") //ID
                                  ||token[k].matches("[_]+[[A-z]+[0-9]*]+")){ 
                             String[] ID_token;
                           class_part="ID";
                             System.out.println("("+class_part+","+token[k]+","+line_no+" )");
                             syntaxarray[a] = class_part;
                             Valuepart[a]=token[k];
                               a++;
                            
                            }
                          else   if (token[k].matches("[[0-9]*[A-z]*]+[A-z]+[[0-9]*[A-z]*]+")){  //Invalid ID
                             String[] ID_token;
                           
                             System.out.println("( Invalid_ID,"+token[k]+","+line_no+" )");
                            
                            }
                         
                         
                         else   if (token[k].matches("[0-9]+[.][A-z]+")||token[k].matches("[A-z]+[.][A-z]+")
                                 ||token[k].matches("[A-z]+[.][0-9]*[A-z]+[0-9]*")){  // float constant seperator
                             String[] ID_token;
                            ID_token = token[k].split("[.]");
                             System.out.println("( ID,"+ID_token[0]+","+line_no+" )");
                             syntaxarray[a] = "ID";
                             Valuepart[a]=ID_token[0];
                               a++;
                             System.out.println("( . , . ,0 )");
                             syntaxarray[a] = ".";
                             Valuepart[a]=".";
                               a++;
                             System.out.println("( ID,"+ID_token[1]+","+line_no+" )");
                             syntaxarray[a] = "ID";
                             Valuepart[a]=ID_token[1];
                               a++;
                             
                            }
                        
                                 else   if (token[k].matches("[A-z]+[.][0-9]+")){  // float constant seperator
                             String[] ID_token;
                            ID_token = token[k].split("[.]");
                             System.out.println("( ID,"+ID_token[0]+","+line_no+" )");
                             syntaxarray[a] = "ID";
                             Valuepart[a]=ID_token[0];
                               a++;
                             System.out.println("( . , . ,"+line_no+" )");
                             syntaxarray[a] = ".";
                             Valuepart[a]=".";
                               a++;
                             System.out.println("( int_constant,"+ID_token[1]+","+line_no+" )");
                             syntaxarray[a] = "int_constant" ;
                             Valuepart[a]=ID_token[1];
                               a++;
                            }
                         else   if (token[k].matches("[0-9]+[.][0-9]+")){  // float constant 
                            
                           
                             System.out.println("( float_constant,"+token[k]+","+line_no+" )");
                             syntaxarray[a] = "float_constant";
                             Valuepart[a]=token[k];
                               a++;
                             
                            }
                         else   if (token[k].matches("[A-z]*[0-9]+[.][0-9]+[[A-z]+[0-9]*]+")){  //Invalid float constant 
                            
                           
                             System.out.println("( Invalid_Float_constant,"+token[k]+","+line_no+" )");
                             syntaxarray[a] = class_part;
                             Valuepart[a]=token[k];
                               a++;
                            }
                         
                            
                         else   if (token[k].matches("\\\"[[A-z]*[0-9]*[A-z]*[0-9]*]*\\\"")){ //String constant
          
                            String[] ID_token = token[k].split("[\\\"]");
                            class_part = "string_constant";
                           value_part = token[k];
                            System.out.println( "( \" , \" ,"+line_no+")");
                            syntaxarray[a] = "\"";
                            Valuepart[a]="\"";
                               a++;
                           System.out.println( "("+class_part+","+ID_token[1]+","+line_no+")");
                           syntaxarray[a] = class_part;
                           Valuepart[a]=ID_token[1];
                               a++;
                          System.out.println( "( \" , \" ,"+line_no+")");
                          syntaxarray[a] = "\"";
                          Valuepart[a]="\"";
                               a++;
                         }
                            
                         else if (token[k].matches("[0-9]+")){          ////int constant
                        String[] ID_token = token[k].split("[=]");
                         class_part = "int_constant";
                        value_part = token[k];
                         System.out.println( "("+class_part+","+ID_token[0]+","+line_no+")");
                         syntaxarray[a] = class_part;
                         Valuepart[a]=ID_token[0];
                               a++;
                          
                                }
                            else if (token[k].matches("['][A-z][']")){          ////char constant
                        String[] ID_token = token[k].split("[']");
                         class_part = "char_constant";
                        value_part = token[k];
                        System.out.println( "( ' , ' ,"+line_no+")");
                        syntaxarray[a] = "'";
                        Valuepart[a]="'";
                               a++;
                         System.out.println( "("+class_part+","+ID_token[1]+","+line_no+")");
                         syntaxarray[a] = class_part;
                         Valuepart[a]=ID_token[1];
                               a++;
                          System.out.println( "( ' , ' ,"+line_no+")");
                          syntaxarray[a] = "'";
                          Valuepart[a]="'";
                               a++;
                                }
                             else if (token[k].matches("['][[A-z]+[0-9]+]+")){
                              String[] ID_token = token[k].split("[']");
                             System.out.println( "( Invalid Char_constant ,"+ID_token[1]+","+line_no+")");
                             }
                    }
                   
                    
                     
		}catch(NullPointerException e){}
                    
             /*  
                     System.out.println("your class parts: ");
                 System.out.println("\n");
                     for(int sn=0;sn<=a;sn++)
                    {
                       System.out.print("\n"+syntaxarray[sn]);
                       
                    
                    }  
                     
               */      
             
        
    /*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
    
    
    
        syn = start(syntaxarray);
        System.out.println(syn);
        
    }
    public void setSyntax(String[] s){
        syntaxarray = s;
    }
    public String[] getSyntax(){
        return syntaxarray;
    }
    public void setResult(Boolean b){
        syn = b;
    }
    public Boolean getResult(){
        return syn;
    }
    
    
    public static boolean start(String[] c){
        if(c[i].equals("expose")){
            i++;if(c[i].equals("static")){
                i++;if(c[i].equals("void")){
                    i++;if(c[i].equals("start")){
                        i++;if(c[i].equals("(")){
                            i++;if(c[i].equals(")")){
                                i++;if(c[i].equals("{")){
                                    i++;if(body(c)){
                                        if(c[i].equals("}")){
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
  
    public static boolean s_st(String[] c){
        if(c[i].equals(";")){i++;return true;}
        if(Dec(c)||init_only(c)||While_CONDITIONAL(c)||DoWhile(c)||for_CONDITIONAL(c)||if_st(c)||func_call_st(c)||Assign_exp(c)){
            return true;
        }
        return false;
    }
    public static boolean m_st(String[] c){
        if(c[i].equals("{")){
            i++;if(s_st(c)){
                   if(c[i].equals("}")){
                       return true;
                   }
            }
        }//-----------------------------------------------------------------------------------null
        if(c[i].equals("}")&&c[i-1].equals(";")){
            return true;
        }
        return false;
    }
    public static boolean Dec(String[] c){
        if(c[i].equals("DT")){
            i++;if(c[i].equals("ID")){
                
                i++;if(init(c)){
                    if(list2(c)){
                        return true;
                    }
                }
            }
            
            
        }
        return false;
    }
    
    public static boolean init(String[] c){
        if(c[i].equals("=")){
            i++;if(init1(c)){
                return true;
            }
             
        }//--------------------------------------------------------------------------------null
        if(c[i].equals(",")||c[i].equals(";")){
            return true;
        }
        return false;
    }
    public static boolean init1(String[] c){
        if(c[i].equals("ID")){
            i++;if(init(c)){
                return true;
            }
        }
        if(Const(c)){
            
              return true;
            
        }
        if(exp(c)){return true;}
        
        return false;
    }
    
    public static boolean id_const(String[] c){
        if(c[i].equals("ID")){i++;return true;}
        if(Const(c)){return true;}
        return false;
    }
    public static boolean list(String[] c){
        if(c[i].equals(";")){i++;return true;}
        if(c[i].equals(",")){
            i++;if(c[i].equals("ID")){
                i++;if(init(c)){
                    if(list(c)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean Const(String[] c){
        if(c[i].equals("int_constant")||c[i].equals("float_constant")||c[i].equals("char_constant")||c[i].equals("string_constant")){
            i++;return true;
        }
        return false;
    }
    public static boolean init_only(String[] c){
        if(c[i].equals(",")){
            i++;if(value(c)){
                return true;
            }
        }
        return false;
    }
    public static boolean value(String[] c){
        if(c[i].equals("=")){
            i++;if(value1(c)){
                return true;
            }
        }
        return false;
    }
    public static boolean value1(String[] c){
        if(id_const(c)){
            if(c[i].equals(";")){
                i++;return true;
            }
        }
        if(list1(c)){
            return true;
        }
        return false;
    }
    public static boolean list1(String[] c){
        if(init_only(c)){return true;}
        return false;
    }
    public static boolean list2(String[] c){
        if(c[i].equals(",")){
            i++;if(c[i].equals("ID")){
                i++;if(init(c)){
                    if(list2(c)){
                        return true;
                    }
                }
            }
        }
        if(c[i].equals(";")){i++;return true;}
        
        return false;
    }
    public static boolean While_CONDITIONAL(String[] c){
        if(c[i].equals("until")){
            i++;if(c[i].equals("(")){
                i++;if(cond(c)){
                    if(c[i].equals(")")){
                        i++;if(body(c)){
                            return false;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    public static boolean cond(String[] c){
        if(id_const(c)){
            if(c[i].equals("Relation_operator")){
                i++;if(id_const(c)){
                    return true;
                }
            }
        }
        if(id_const(c)){return true;}
        
        return false;
    }
    public static boolean body(String[] c){
        if(s_st(c)){return true;}
        if(m_st(c)){return true;}
        if(c[i].equals("}")){i++;return true;}
        return false;
    }
    public static boolean DoWhile(String[] c){
        if(c[i].equals("exec")){
            i++;if(c[i].equals("{")){
                i++;if(m_st(c)){
                    if(c[i].equals("}")){
                        i++;if(c[i].equals("until")){
                            i++;if(c[i].equals("(")){
                                i++;if(cond(c)){
                                       if(c[i].equals(")")){
                                           i++;if(c[i].equals(";")){
                                               i++;return true;
                                           }
                                       }
                                       
                                    }
                                     
                            }
                        }
                    }
                    
                }
            }
        }
        return false;
    }
    public static boolean for_CONDITIONAL(String[] c){
        if(c[i].equals("for_CONDITIONAL")){
            i++;if(c[i].equals("(")){
                i++;if(x(c)){
                    if(y(c)){
                        if(c[i].equals(";")){
                            i++;if(z(c)){
                                if(c[i].equals(")")){
                                    i++;if(body(c)){
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public static boolean x(String[] c){
        if(Dec(c)){return true;}
        if(Assign_exp(c)){return true;}
        if(c[i].equals(";")){
            i++;return true;
        }//---------------------------------------------------------------------------null
        return false;
    }
    public static boolean y(String[] c){
        if(cond(c)){return true;}
          //--------------------------------------------------------------------------null
        if(c[i].equals(";")){return true;}
        
        return false;
    }
    public static boolean z(String[] c){
        if(c[i].equals("ID")){
            i++;if(inc_dec(c)){
                return true;
            }
        }
        if(inc_dec(c)){
            if(c[i].equals("ID")){
                i++;
                return true;
            }
        }
        if(Assign_exp(c)){
            return true;
        }
        //-----------------------------------------------------------------------------null
        if(c[i].equals(")")){return true;}
        
        return false;
    }
    public static boolean inc_dec(String[] c){
        if(c[i].equals("INC/DEC_OPERATORS")){
            i++;
            return true;
        }
        return false;
    }
    public static boolean Assign_exp(String[] c){
        if(c[i].equals("ID")){
            i++;if(operations(c)){
                    return true;
            }
        }
        if(inc_dec(c)){
            if(c[i].equals("ID")){
                i++;if(c[i].equals(";")){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean operations(String[] c){
        if(Assign_exp(c)){
            if(exp(c)){
                return true;
            }
        } 
        if(inc_dec(c)){return true;}
        return false;
    }
    public static boolean exp(String[] c){
        if(t(c)){
            if(exp1(c)){
                return true;
            }
        }
        return false;
    }
    public static boolean exp1(String[] c){
        if(c[i].equals("ADD/SUB_Operators")){
            i++;if(t(c)){
                if(exp1(c)){
                    return true;
                }
            }
        }
        //----------------------------------------------------------------------------null
        if(c[i].equals(")")||c[i].equals(";")){return true;}
        
        return false;
    }
    public static boolean t(String[] c){
        if(f(c)){
            if(t1(c)){
                return true;
            }
        }
        return false;
    }
    public static boolean f(String[] c){
        if(Const(c)){return true;}
        if(c[i].equals("ID")){
            i++;if(i(c)){
                return true;
            }
        }
        return false;
    }
    public static boolean i(String[] c){
        if(inc_dec(c)){return true;}
        //---------------------------------------------------------------------------------null
        if(c[i].equals("MUL/DIV_OPERATORS")||c[i].equals(")")){return true;}
        return false;
    }
    public static boolean t1(String[] c){
        if(c[i].equals("MUL/DIV_OPERATORS")){
            i++;if(f(c)){
                if(t1(c)){
                    return true;
                }
            }
        }
        //------------------------------------------------------------------------------null
        if(c[i].equals("ADD/SUB_Operators")||c[i].equals(")")){return true;}
        return false;
    }
    public static boolean if_st(String[] c){
        if(c[i].equals("check")){
            i++;if(c[i].equals("(")){
                i++;if(cond(c)){
                    if(c[i].equals(")")){
                        i++;if(body(c)){
                            if(else_st(c)){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean else_st(String[] c){
        if(c[i].equals("then")){
            i++;if(body(c)){
                return true;
            }
        }//-----------------------------------------------------------------------------null
        if(body(c)){return true;}
        return false;
    }
    public static boolean function(String[] c){
        if(access_modifier(c)){
            if(Static(c)){
                if(ret_type(c)){
                    if(c[i].equals("ID")){
                        i++;if(c[i].equals("(")){
                            i++;if(arg_list(c)){
                                if(c[i].equals(")")){
                                    i++;if(c[i].equals("{")){
                                        i++;if(in_func(c)){
                                            if(c[i].equals("}")){
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public static boolean access_modifier(String[] c){
        if(c[i].equals("expose")){i++;return true;}
        if(c[i].equals("secure")){i++;return true;}
        //----------------------------------------------------------------------------null
        if(c[i].equals("void")||c[i].equals("static")||c[i].equals("DT")){i++;return true;}
        return false;
    }
    public static boolean Static(String[] c){
        if(c[i].equals("static")){i++;return true;}
        //----------------------------------------------------------------------------null
        if(c[i].equals("void")||c[i].equals("DT")){i++;return true;}
        return false;
    }
    public static boolean ret_type(String[] c){
        if(c[i].equals("void")){i++;return true;}
        if(c[i].equals("DT")){i++;return true;}
        return false;
    }
    public static boolean arg_list(String[] c){
        if(c[i].equals("DT")){
            i++;if(c[i].equals("ID")){
                i++;if(alist(c)){
                    return true;
                }
            }
        }
        //-------------------------------------------------------------------------------null
        if(c[i].equals(")")){i++;return true;}
        return false;
    }
    public static boolean alist(String[] c){
        if(c[i].equals(",")){
            i++;if(arg_list(c)){
                return true;
            }
        }
        //--------------------------------------------------------------------------------null
        if(c[i].equals(")")){i++;return true;}
        return false;
    }
    public static boolean in_func(String[] c){
        if(body(c)){
            if(in_func1(c)){
                return true;
            }
        }
        return false;
    }
    public static boolean in_func1(String[] c){
        if(c[i].equals("goBack")){
            i++;if(ret_value(c)){
                return true;
            }
        }
        //--------------------------------------------------------------------------------null
        if(c[i].equals("}")){i++;return true;}
        return false;
    }
    public static boolean ret_value(String[] c){
        if(c[i].equals("ID")){i++;return true;}
        if(Const(c)){return true;}
        if(Assign_exp(c)){return true;}
        
        return false;
    }
    public static boolean func_call_st(String[] c){
        if(func_call(c)){
            return true;
        }
        return false;
    }
    public static boolean func_call(String[] c){
        if(c[i].equals("ID")){
            i++;if(c[i].equals("(")){
                i++;if(parameters(c)){
                    if(c[i].equals(")")){
                        i++;if(c[i].equals(";")){
                           i++;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static boolean parameters(String[] c){
        
         
        if(c[i].equals("ID")){
            i++;if(param_list(c)){
                return true;
            }
        }
        if(Const(c)){
            if(param_list(c)){
                return true;
            }
        }
        //------------------------------------------------------------------------------null
        if(c[i].equals(")")){return true;}
        
        return false;
    }
    public static boolean param_list(String[] c){
        
        
        if(c[i].equals(",")){
            i++;if(param_list1(c)){
                return true;
            }
        }
        if(c[i].equals(")")){return true;}
        return false;
    }
    public static boolean param_list1(String[] c){
        
          
        if(c[i].equals("ID")){
            i++;if(param_list(c)){
                return true;
            }
        }
        if(Const(c)){
            if(param_list(c)){
                return true;
            }
        }
        //-------------------------------------------------------------------------------------null
        if(c[i].equals(")")){i++;return true;}
        return false;
    }
    public static boolean Class(String[] c){
        if(access_modifier(c)){
            if(c[i].equals("class")){
                i++;if(c[i].equals("ID")){
                    i++;if(attrib(c)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean attrib(String[] c){
        if(Dec(c)){
            if(attrib(c)){
                return true;
            }
        }
        if(construct(c)){
            return true;
        }
        return false;
    }
    public static boolean construct(String[] c){
        if(access_modifier(c)){
            if(c[i].equals("ID")){
                i++;if(c[i].equals("(")){
                    i++;if(arg_list(c)){
                        if(c[i].equals(")")){
                            i++;if(c[i].equals("{")){
                                i++;if(Dec(c)){
                                    if(c[i].equals("}")){
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    
    
    //*********************************************************************************************************************
    
    static String[] name=new String[50];
    static String[] type=new String[50];
    static String[] scope=new String[50];
    static int j,ind=0;
    
    public void insert(String N,String T,String S)
        {
            
            name[ind] = N;
            type[ind] = T;
            scope[ind] = S;
            ind++;
            
        }
    
    public static String lookup(String N,String S){
        for(j=0;j<name.length;j++){
            if(!N.equals(name[i])){                
                    return N;
            }
            if(N.equals(name[i])){
                if(!S.equals(scope[i])){
                    return N;
                }
            }
            
        }
        return null;
    } 
}
