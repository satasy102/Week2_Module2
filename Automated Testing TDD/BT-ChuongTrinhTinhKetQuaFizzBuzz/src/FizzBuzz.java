public class FizzBuzz {
    public static String findFizzBuzz(int number) {
        boolean chiaHetCho3va5 = number % 15 == 0;
        boolean chiaHetCho3 = number % 3 == 0;
        boolean chiaHetCho5 = number % 5 == 0;
        if (chiaHetCho3va5) return "FizzBuzz";
        else if (chiaHetCho3) return "Fizz";
        else if (chiaHetCho5) return "Buzz";
        else return String.valueOf(number);
    }


}
