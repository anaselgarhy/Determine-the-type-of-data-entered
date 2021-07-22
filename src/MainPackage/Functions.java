package MainPackage;

public abstract class Functions {
    private static boolean prospectFloatNumber, minusNumber;
    /**
     * This function checks if the line is a number or not,
     * and this function is supposed to work with decimal numbers and negative numbers without problems
     * @param line as string
     * @return true if the line is valid number false if line not a valid number
     */
    public static boolean checkNumber(String line){
        int dot = numOfRebate('.', line, false);
        int e = numOfRebate('E', line, true);
        if(dot > 1 || e > 1)
            return false;
        minusNumber = line.startsWith("-");
        prospectFloatNumber = (dot == 1 && e == 0) || (dot == 1 && e == 1); // check prospect float number
        char ch;
        for(int i= (minusNumber)? 1 : 0; i<line.length(); i++){ // loop on characters
            ch = line.charAt(i);
            if(ch > 57 || ch < 48) { // Verify that the letter is not within the numbers in the ASCII table
                if(prospectFloatNumber && ch == '.' && i + 1 < line.length())
                    i++;
                else if (prospectFloatNumber && String.valueOf(ch).equalsIgnoreCase("E")) { // check e if prospect tempCht number
                    if ((line.length() > i + 1) &&  line.charAt(i+1) == '-') {
                        i++;
                        minusNumber = true;
                    }
                } else
                    return false;
            }
        }
        // the input is valid number
        return true;
    }

    /**
     * You are supposed to call this function after verifying that the line entered by the user is a valid number
     * with the checkNumber function and if you do not want to use the checkNumber function
     * then make the {@code prospectFloatNumber} and {@code minusNumber} local variables I have the checkNumber function
     * because there is no longer a need to make them global, and do Simple loop that finds the dot for decimal numbers.
     * @param line as string
     * @return Number type as {@link MainPackage.InputType InputType}
     */
    public static InputType checkNumberType(String line){
            if(prospectFloatNumber) { // double or float
                float f = minusNumber? +Float.parseFloat(line) : -Float.parseFloat(line);
                if(f == 0.0f && Double.parseDouble(line) != 0.0) // check double
                    return InputType.Double;
                else // float
                return InputType.Float;
            }
        // integer or long or byte short
        if(Long.parseLong(line) > Integer.MAX_VALUE || Long.parseLong(line) < Integer.MIN_VALUE)
            return InputType.Long;
        else if(Integer.parseInt(line) > Short.MAX_VALUE || Integer.parseInt(line) < Short.MIN_VALUE)
            return InputType.Integer;
        else if(Short.parseShort(line) > Byte.MAX_VALUE || Short.parseShort(line) < Byte.MIN_VALUE)
            return InputType.Short;
        else // byte
            return InputType.Byte;
    }
    public static boolean checkBoolean(String line){
        return (line.equals("true") || line.equals("false"));
    }
    private static int numOfRebate(char ch, String line, boolean ignoreCase){
        int numOfRebate = 0;
        for(char c: (ignoreCase)? line.toUpperCase().toCharArray() : line.toCharArray())
            if(c == ch)
                numOfRebate++;
        return numOfRebate;
    }
}
