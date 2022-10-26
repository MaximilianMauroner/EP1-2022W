import java.math.BigDecimal;
import java.math.RoundingMode;

public class HelloWorld {
    public static void main(String[] args) {
        calculateBefore(new BigDecimal("1581"), new BigDecimal("16"));
    }

    public static void calculateBefore(BigDecimal number, BigDecimal type) {
        if (number.floatValue() >= 0) {
            BigDecimal temp = number.divide(type, RoundingMode.DOWN);
            if(temp.compareTo(type) > 0){

            }
            number = number.subtract(temp.multiply(type));
            System.out.println(number);
//            calculateBefore(number, type);
        }
    }
}
