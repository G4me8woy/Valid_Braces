import java.util.ArrayList;
import java.util.List;

public class Solution_1 {

  public static boolean isValid(String braces) {

    // * possible characters => {}()[]

    // note: - First of all, if the number of given braces is odd, return false. cos
    // then there'll be no way they could pair up
    // if odd
    if (braces.length() % 2 != 0)
      // return false
      return false;

    // if not (if even)
    // > Logic: all closing brace should match the most recent recorded opening brace
    // * a stack record of opened braces is needed

    //     - creating a char sample array to contain all given braces
    char[] sample = braces.toCharArray();

    //     - creating a stack array to track open braces
    //         - I used an array list to easily facilitate removing brace entries 
    List<Character> stack = new ArrayList<>();

    // * tracking opened and closed braces
    //     - for all braces in the sample array list
    for (int i = 0, stackIndex = -1; i < braces.length(); i++) {

      //     - if an open brace is detected
      if (sample[i] == '{' || sample[i] == '(' || sample[i] == '[') {
        //     - record it to the stack
        stackIndex++;
        stack.add(sample[i]);
        //     - if the stack entries exceed half the given brace size
        if (stack.size() > braces.length() / 2)
        //     - return false because that would mean there are more open braces than close braces and no means to match it up
          return false;
      }

      // - once a close brace is recorded;
      else {
        // * check if it matches the recent entry of open braces to the stack

        //     - if it matches the type of the recent entry to the stack
        if (stack.get(stackIndex) == '(' && sample[i] == ')' || stack.get(stackIndex) == '{' && sample[i] == '}'
            || stack.get(stackIndex) == '[' && sample[i] == ']'){
          //     - remove the entry from the stack
          stack.remove(stackIndex);
          stackIndex--;
        }

        //     - if it doesn't match or stack is empty (else)
        else
        // Return false;
          return false;
      }
    } // end of looping through braces in the sample 

    // > if at the end of the given braces set;
    // * there are still elements on the stack 
    if (stack.size() > 0)
    //     - return false, because that would mean there are more open braces than closed
      return false;
    // * if there arent, 
    else
    //     - return true because that would mean they were all matched up... awesome :wink:
    return true;
  }

  public static void main(String[] args) {

    // "(){}[]" => True
    // "([{}])" => True
    // "(}" => False
    // "[(])" => False
    // "[({})](]" => False

    System.out.println(isValid("(){}[]"));
    ;

  }

}