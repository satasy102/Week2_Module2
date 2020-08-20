import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void findFizzBuzz3() {
        int number=3;
        String expected="Fizz";

        String result=FizzBuzz.findFizzBuzz(number);
        assertEquals(expected,result);
    }

    @Test
    void findFizzBuzz5() {
        int number=5;
        String expected="Buzz";

        String result=FizzBuzz.findFizzBuzz(number);
        assertEquals(expected,result);
    }

    @Test
    void hangChuc1(){
        String str="1";
        String expected="Mot";

        String result=LevelUpFizzBuzz.hangChuc(str);
        assertEquals(expected,result);
    }

    @Test
    void hangChuc2(){
        String str="2";
        String expected="Hai";

        String result=LevelUpFizzBuzz.hangChuc(str);
        assertEquals(expected,result);
    }

    @Test
    void hangChuc3(){
        String str="3";
        String expected="Fizz";

        String result=LevelUpFizzBuzz.hangChuc(str);
        assertEquals(expected,result);
    }

    @Test
    void hangChuc4(){
        String str="4";
        String expected="Bon";

        String result=LevelUpFizzBuzz.hangChuc(str);
        assertEquals(expected,result);
    }

    @Test
    void hangChuc5(){
        String str="5";
        String expected="Buzz";

        String result=LevelUpFizzBuzz.hangChuc(str);
        assertEquals(expected,result);
    }

    @Test
    void hangChuc6(){
        String str="6";
        String expected="Sau";

        String result=LevelUpFizzBuzz.hangChuc(str);
        assertEquals(expected,result);
    }

    @Test
    void hangChuc7(){
        String str="7";
        String expected="Bay";

        String result=LevelUpFizzBuzz.hangChuc(str);
        assertEquals(expected,result);
    }

    @Test
    void hangChuc8(){
        String str="8";
        String expected="Tam";

        String result=LevelUpFizzBuzz.hangChuc(str);
        assertEquals(expected,result);
    }

    @Test
    void hangChuc9(){
        String str="9";
        String expected="Chin";

        String result=LevelUpFizzBuzz.hangChuc(str);
        assertEquals(expected,result);
    }

    @Test
    void hangChuc0(){
        String str="0";
        String expected="";

        String result=LevelUpFizzBuzz.hangChuc(str);
        assertEquals(expected,result);
    }

    @Test
    void hangdonvi0(){
        String str="0";
        String expected="khong";

        String result=LevelUpFizzBuzz.hangDonVi(str);
        assertEquals(expected,result);
    }

    @Test
    void hangDonVi1(){
        String str="1";
        String expected="mot";

        String result=LevelUpFizzBuzz.hangDonVi(str);
        assertEquals(expected,result);
    }

    @Test
    void hangDonVi2(){
        String str="2";
        String expected="hai";

        String result=LevelUpFizzBuzz.hangDonVi(str);
        assertEquals(expected,result);
    }

    @Test
    void hangDonVi3(){
        String str="3";
        String expected="Fizz";

        String result=LevelUpFizzBuzz.hangDonVi(str);
        assertEquals(expected,result);
    }

    @Test
    void hangDonVi4(){
        String str="4";
        String expected="bon";

        String result=LevelUpFizzBuzz.hangDonVi(str);
        assertEquals(expected,result);
    }

    @Test
    void hangDonVi5(){
        String str="5";
        String expected="Buzz";

        String result=LevelUpFizzBuzz.hangDonVi(str);
        assertEquals(expected,result);
    }

    @Test
    void hangDonVi6(){
        String str="6";
        String expected="sau";

        String result=LevelUpFizzBuzz.hangDonVi(str);
        assertEquals(expected,result);
    }

    @Test
    void hangDonVi7(){
        String str="7";
        String expected="bay";

        String result=LevelUpFizzBuzz.hangDonVi(str);
        assertEquals(expected,result);
    }

    @Test
    void hangDonVi8(){
        String str="8";
        String expected="tam";

        String result=LevelUpFizzBuzz.hangDonVi(str);
        assertEquals(expected,result);
    }

    @Test
    void hangDonVi9(){
        String str="9";
        String expected="chin";

        String result=LevelUpFizzBuzz.hangDonVi(str);
        assertEquals(expected,result);
    }


}
