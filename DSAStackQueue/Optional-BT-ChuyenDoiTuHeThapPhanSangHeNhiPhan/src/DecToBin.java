import java.util.Scanner;
import java.util.Stack;

public class DecToBin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Stack<Byte> nhiPhan=new Stack<>();

        System.out.println("Nhap 1 so thap phan bat ky:");
        long soThapPhan=sc.nextLong();

        byte soDu;
        long soBiChia = soThapPhan;

        while (soBiChia!=0){
            soDu= (byte) (soBiChia%2);
            nhiPhan.push(soDu);
            soBiChia=soBiChia/2;
        }

        System.out.print("So nhi phan tuong ung la:");
        while(!nhiPhan.empty()){
            System.out.print(nhiPhan.pop());
        }
    }
}
