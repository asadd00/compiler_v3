/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syntax.analyzer;
    
/**
 *
 * @author Muhammad
 */
public class SyntaxAnalyzer {
    static int i=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String[] cp = new String[]{"public","expose","void","start","(",")","{","DT","ID","=","int_constant",";","}"};
        //String[] cp = new String[]{"public","expose","void","start","(",")","{","DT","ID",";","}"};
        String[] cp = new String[]{"public","expose","void","start","(",")","{","check","(","ID","Relation_operator","ID",")","{","DT","ID","=","int_constant",";","}"};
        //String[] cp = new String[]{"public","expose","void","start","(",")","{","next","(","DT","ID","=","int_constant",";","ID","Relation_operator","ID",";","ID","INC/DEC_OPERATORS",")","{","DT","ID","=","int_constant",";","}","}"};
        boolean b = start(cp);
        System.out.println(b);
        
    }
    
    public static boolean start(String[] c){
        if(c[i].equals("public")){
            i++;if(c[i].equals("expose")){
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
        if(Dec(c)||While_CONDITIONAL(c)||DoWhile(c)||for_CONDITIONAL(c)||if_st(c)||Assign_exp(c)){
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
        return false;
    }
    public static boolean Dec(String[] c){
        if(c[i].equals("DT")){
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
    public static boolean init(String[] c){
        if(c[i].equals("=")){
            i++;if(init1(c)){
                return true;
            }//--------------------------------------------------------------------------------null
             
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
    public static boolean dec_init(String[] c){
        
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
        
        return false;
    }
    public static boolean DoWhile(String[] c){
        if(c[i].equals("do")){
            i++;if(c[i].equals("{")){
                i++;if(m_st(c)){
                    if(c[i].equals("}")){
                        i++;if(c[i].equals("until")){
                            i++;if(c[i].equals("(")){
                                i++;if(cond(c)){
                                    if(c[i].equals(")")){
                                        i++;return true;
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
        if(c[i].equals("next")){
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
        if(cond(c)){return true;}//-----------------------------------------------------null
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
            }//----------------------------------------------------------------------null
        }
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
        return false;
    }
    public static boolean Static(String[] c){
        if(c[i].equals("static")){i++;return true;}
        //----------------------------------------------------------------------------null
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
        return false;
    }
    public static boolean alist(String[] c){
        if(c[i].equals(",")){
            i++;if(arg_list(c)){
                return true;
            }
        }
        //--------------------------------------------------------------------------------null
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
        if(c[i].equals("return")){
            i++;if(ret_value(c)){
                return true;
            }
        }
        //--------------------------------------------------------------------------------null
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
        return false;
    }
    public static boolean param_list(String[] c){
        if(c[i].equals(",")){
            i++;if(param_list1(c)){
                return true;
            }
        }
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
        return false;
    }
}
