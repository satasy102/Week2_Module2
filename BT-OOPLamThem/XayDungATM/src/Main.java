import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM("Nguyen Van A", 1200000);
        System.out.printf("Ngan hang ABC kinh chao Quy khach %s \n", atm.getTenTK());

        menu();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (input != "X") {
            switch (input) {
                case "A" -> kiemTraTaiKhoan(atm);
                case "D" -> napTien(atm);
                case "W" -> rutTien(atm);
                case "H" -> lichSuGiaoDich(atm);
                case "X" -> {
                    System.out.println("Cam on ban da su dung dich vu ATM");
                    System.exit(0);
                }
                default -> System.out.println("Thông báo sai dữ liệu. Moi nhap lai:");
            }
            menu();
            input = sc.nextLine();
        }
        System.out.println("Cảm ơn bạn đã sử dụng dịch vụ ATM");
    }

    public static void menu(){
        System.out.println("Menu:");
        System.out.println("1. Nhan phim A de kiem tra tai khoan");
        System.out.println("2. Nhan phim D de nap tien");
        System.out.println("3. Nhan phim W de rut tien");
        System.out.println("4. Nhan phim H de xem lich su 3 lan rut tien");
        System.out.println("5. Nhan phim X de thoat");
    }

    public static void kiemTraTaiKhoan(ATM atm) {
        System.out.println("So du tai khoan khach hang la: " + atm.getSoDuTK());
        System.out.println("Bam nut theo menu de tiep tuc giao dich");
        System.out.println("===========================================");
    }

    public static void napTien(ATM atm) {
        System.out.println("Vui long nhap so tien:");
        long tienNap = 0;
        tienNap = checkNumber(tienNap);
        atm.napTien(tienNap);

        System.out.printf("Giao dich thanh cong. Ban vua nap %d thanh cong.\n", tienNap);
        System.out.printf("So du tai khoan là: %d Vnd\n", atm.getSoDuTK());
        System.out.println("Bam nut theo menu de tiep tuc giao dich");
        System.out.println("===========================================");
    }

    public static void rutTien(ATM atm) {
        System.out.println("Vui long nhap so tien:");
        long tienRut = 0;
        tienRut = checkNumber(tienRut);
        while (tienRut>atm.getSoDuTK()){
            System.out.println("Giao dich khong thanh cong.");
            System.out.printf("So du tai khoan khach hang la: %d Vnd.\n",atm.getSoDuTK());
            System.out.println("Ban khong the rut so tien hon so du tai khoan. Nhap lai:");
            System.out.println("Vui long nhap so tien:");
            tienRut = checkNumber(tienRut);
        }
        atm.rutTien(tienRut);
        System.out.printf("Giao dich thanh cong. Ban vua rut %d thanh cong.\n", tienRut);
        System.out.printf("So du tai khoan là: %d Vnd\n", atm.getSoDuTK());
        System.out.println("Bam nut theo menu de tiep tuc giao dich");
        System.out.println("===========================================");
    }

    public static void lichSuGiaoDich(ATM atm) {
        int stt = 1;
        System.out.println("Lich su giao dich");
        for (int i = atm.getLichSuGD().length - 1; i >= 0; i--) {
            if (atm.getLichSuGD()[i] != null && stt <= 3) {
                System.out.printf("%-5d%S\n", stt, atm.getLichSuGD()[i]);
                stt++;
            }
        }
        System.out.println("Bam nut theo menu de tiep tuc giao dich");
        System.out.println("===========================================");

    }

    public static long checkNumber(long num) {
        Scanner sc = new Scanner(System.in);
        String str = null;
        while (true) {
            try {
                str = sc.nextLine();
                num = Long.parseLong(str);
                break;
            } catch (Exception ex) {
                System.out.println("Khong phai so. Moi nhap lai:");
            }
        }
        return num;
    }
}
