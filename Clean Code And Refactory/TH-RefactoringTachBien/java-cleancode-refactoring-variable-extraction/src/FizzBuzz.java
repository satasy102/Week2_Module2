public class FizzBuzz {
    public static String fizzBuzz(int number){
        int isBuzz  = number % 5;
        int isFizz  = number % 3;
        if(isFizz  == 0 && isBuzz  == 0)
            return "FizzBuzz";

        if(isFizz  == 0)
            return "Fizz";

        if(isBuzz  == 0)
            return "Buzz";

        return number + "";
    }
}
