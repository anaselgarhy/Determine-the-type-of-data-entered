package MainPackage;

import java.util.Scanner;

public class Main extends Functions{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] lineInput = new String[(args.length == 0)? 1 : args.length];
        InputType type;
        if(args.length == 0){
            // Read input from user
            System.out.print("> ");
            lineInput[0] = input.nextLine();
        } else
            lineInput = args;
        // Check
        for (String s : lineInput) {
            if (checkNumber(s))
                // check number type
                type = checkNumberType(s);
            else {
                // Check character
                if (s.length() == 1)
                    type = InputType.Character;
                    // check boolean
                else if (checkBoolean(s))
                    type = InputType.Boolean;
                else // the input line is a string
                    type = InputType.String;
            }
            // Print result
            System.out.println(s + " type: " + type.name());
        }
    }

}
