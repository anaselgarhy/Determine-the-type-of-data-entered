package MainPackage;

public abstract class Functions {
    public static boolean checkNumber(String line){
        int dot = numOfRebate('.', line, false);
        int e = numOfRebate('E', line, true);
        if(dot > 1 || e > 1)
            return false;
        boolean minusNumber = line.startsWith("-");
        for(int i= (minusNumber)? 1 : 0; i<line.length(); i++){
            if(line.charAt(i) > 57 || (line.charAt(i) < 48) && dot == 1 && !(line.charAt(i) == '.') && line.length() > 1) {
                if (dot == 1 && e == 1 && String.valueOf(line.charAt(i)).equalsIgnoreCase("E")) {
                    if (line.charAt(i + 1) == '-')
                        i++;
                } else
                    return false;
            } else
                return false;
        }
        // the input is valid number
        return true;
    }
    public static InputType checkNumberType(String line){
        for(int i=0; i<line.length(); i++)
            if(line.charAt(i)  == '.') // double or float
                if(Float.parseFloat(line) > Float.MAX_VALUE
                        || Float.parseFloat(line) < Float.MIN_VALUE) // double
                    return InputType.Double;
                else // float
                    return InputType.Float;
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
