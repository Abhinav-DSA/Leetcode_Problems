class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='(' || c=='{'|| c=='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                int val=stack.pop();
                if(c==')'&& val!='('|| c=='}'&& val!='{'|| c==']'&& val!='['){
                    return false;
                }
            }
        }
        
  return stack.isEmpty();
       }
          


       
    }
