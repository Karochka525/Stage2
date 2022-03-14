package stage2.practice.one;

import java.util.*;


public class Parser {
  public static boolean validate(String string ){
      HashMap<String,Integer> openBrackets=new HashMap<String, Integer>(){{
          put("{",0);
          put("[",1);
          put("(",2);
      }};
      HashMap<String,Integer> closeBrackets=new HashMap<String, Integer>(){{
          put("}",0);
          put("]",1);
          put(")",2);
      }};
      String[] str=string.split(",");
      Deque<String> stack=new ArrayDeque<>();
      for(String inline: str){
          for (int i = 0; i <inline.length() ; i++) {
              char character=inline.charAt(i);
              String symbol=Character.toString(character);
              if(openBrackets.containsKey(symbol)){
                  stack.push(symbol);
              }
              else if(closeBrackets.containsKey(symbol)){
                  if(!stack.isEmpty()){
                      Integer ordinalNumber=closeBrackets.get(symbol);
                      String firstElement=stack.pop();
                      Integer ordinaryLast=openBrackets.get(firstElement);
                      boolean isPairBrackets=ordinaryLast.equals(ordinalNumber);

                      if(isPairBrackets) break;;
                  }
                  return false;
              }
          }
      }
      return stack.isEmpty();
  }

}
