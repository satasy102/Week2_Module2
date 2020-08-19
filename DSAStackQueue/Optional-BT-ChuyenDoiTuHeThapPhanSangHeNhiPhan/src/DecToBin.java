import java.util.Scanner;
import java.util.Stack;

public class DecToBin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Stack<Byte> nhiPhan=new Stack<Byte>();

        System.out.println("Nhap 1 so thap phan bat ky:");
        long soThapPhan=sc.nextLong();

        byte soDu;
        long soBiChia = soThapPhan;

        int count = 0;
        while (soBiChia!=0){
            count++;
            soDu= (byte) (soBiChia%2);
            nhiPhan.push(soDu);
            soBiChia=soBiChia/2;
        }

        System.out.print("So nhi phan tuong ung la:");
        for (byte i=0;i<count;i++){
            System.out.print(nhiPhan.pop());
        }
    }
}
