package by.IvanHWtms.Service;

public class MathService {

    public static String mathOperation(String aS, String bS, String mathOperation) {

        int a = 0;
        int b = 0;

        try {
             a = Integer.parseInt(aS);
             b = Integer.parseInt(bS);
        }catch (Exception e){
            return "This is not integer";
        }

        if (mathOperation.equals("sum")) {
            return String.valueOf(a+b);
        }else if(mathOperation.equals("min")){
            return String.valueOf(a-b);
        }else if(mathOperation.equals("mul")){
            return String.valueOf(a*b);
        }else if(mathOperation.equals("div")){
            return String.valueOf(a/b);
        }
        return "something wrong";
    }

}
