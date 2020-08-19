import java.util.Stack;

public class DaoNguocMangStack {
    public static void main(String[] args) {
        Stack<Integer> mangStackInt=new Stack<Integer>();
        mangSoNguyen(mangStackInt);

        Stack<String> mangStackStr=new Stack<String>();
        mangChuoi(mangStackStr);

    }

    private static void mangSoNguyen(Stack<Integer> mangStack) {
        int[] mangInt=new int[10];

        for(int i=0;i< mangInt.length;i++) mangInt[i]= (int) (Math.random() * 99+1);

        System.out.print("Mang so nguyen ban dau: ");
        for (int i:mangInt) System.out.print(i+" ");

        for (int j : mangInt) {
            mangStack.push(j);
        }

        for(int i=0;i< mangInt.length;i++){
            mangInt[i]= mangStack.pop();
        }

        System.out.print("\nMang so nguyen sau khi dao nguoc bang Stack: ");
        for (int i:mangInt) System.out.print(i+" ");
    }

    private static void mangChuoi(Stack<String> mangStack) {
        String[] mangStr= {"Cong","hoa","xa","hoi","chu","nghia","Viet","Nam"};

        System.out.print("\n\nMang chuoi ban dau: ");
        for (String i:mangStr) System.out.print(i+" ");

        for (String j : mangStr) {
            mangStack.push(j);
        }

        for(int i=0;i< mangStr.length;i++){
            mangStr[i]= mangStack.pop();
        }

        System.out.print("\nMang so nguyen sau khi dao nguoc bang Stack: ");
        for (String i:mangStr) System.out.print(i+" ");
    }
}
