import java.util.*;

public class KiemTraChuoiPalindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Nhap 1 chuoi de kiem tra Palindrome:");
        String str=sc.nextLine();

        char[] chuoiKyTu = str.toCharArray();

        Stack<Character> characterStack = addToStack(chuoiKyTu);

        Queue<Character> characterQueue = addToQueue(chuoiKyTu);

        checkPalindrome(chuoiKyTu, characterStack, characterQueue);
    }

    private static void checkPalindrome(char[] chuoiKyTu, Stack<Character> characterStack, Queue<Character> characterQueue) {
        boolean check=false;
        for(int i = 0; i< chuoiKyTu.length; i++) {
            check = characterStack.pop().equals(characterQueue.remove());
        }

        if(check) System.out.println("La 1 chuoi Palindrome");
        else System.out.println("Khong phai la chuoi Palindrome");
    }

    private static Queue<Character> addToQueue(char[] chuoiKyTu) {
        Queue<Character> characterQueue=new LinkedList<>();
        for(char ch: chuoiKyTu){
            characterQueue.add(ch);
        }
        return characterQueue;
    }

    private static Stack<Character> addToStack(char[] chuoiKyTu) {
        Stack<Character> characterStack=new Stack<>();

        for(char ch: chuoiKyTu){
            characterStack.push(ch);
        }
        return characterStack;
    }
}
