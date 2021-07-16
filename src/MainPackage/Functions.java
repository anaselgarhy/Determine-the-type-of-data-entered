package MainPackage;

public abstract class Functions {
    public static boolean checkNumber(String line){
        short dot =0;
        boolean minusNumber = line.startsWith("-");
        for(int i= (minusNumber)? 1 : 0; i<line.length(); i++){
            if(line.charAt(i) == '.')
                dot++;
            if(line.charAt(i) > 57 || (line.charAt(i) < 48 && line.charAt(i) != 46))
                if(!(String.valueOf(line.charAt(i)).equalsIgnoreCase("E") && dot == 1))
                    return false;
                else if(line.charAt(i+1) == '-')
                    i++;
        }
        // the input is valid number
        return true;
    }
    public static InputType checkNumberType(String line){
        for(int i=0; i<line.length(); i++)
            if(line.charAt(i)  == '.') // double or float
                if(Double.parseDouble(line) <= Float.MAX_VALUE
                        || Double.parseDouble(line) >= Float.MIN_VALUE) // float
                    return InputType.Float;
                else // double
                    return InputType.Double;
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
}
