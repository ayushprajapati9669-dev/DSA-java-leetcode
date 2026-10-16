import java.util.*;
class Solution {
    public String decodeString(String s) {
        String str=s;
        Stack<String> st=new Stack();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch==']'){
              // make the decoded string pop the elements untill [ not comes
              String decoded="";
              while(!st.peek().equals("[")){
                 decoded=st.pop()+decoded;
              }
              // remove the [
              st.pop();
              String numStr="";
              while(!st.isEmpty()&& st.peek().matches("\\d+")){
              numStr=  st.pop()+numStr;
              }
              int num=Integer.parseInt(numStr);
              String res="";
              for(int j=1;j<=num;j++){
                res+=decoded;
              }
              st.push(res);
            }else{
               st.push(String.valueOf(ch));
            }
        }
       String ans="";
       while(!st.isEmpty()){
        ans=st.pop()+ans;
       }
       return ans;
    }
}