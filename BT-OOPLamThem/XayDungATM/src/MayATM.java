import java.util.Scanner;

public class MayATM {
    public static void main(String[] args) {
        TaiKhoan taiKhoan = new TaiKhoan("Nguyen Van A", 1200000);
        System.out.printf("Ngan hang ABC kinh chao Quy khach %s \n", taiKhoan.getTenTK());

        menu();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (input != "X") {
            switch (input) {
                case "A" -> taiKhoan.kiemTraTaiKhoan();
                case "D" -> taiKhoan.napTien();
                case "W" -> rutTien(taiKhoan);
                case "H" -> taiKhoan.lichSuGiaoDich();
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

    public static void menu() {
        System.out.println("Menu:");
        System.out.println("1. Nhan phim A de kiem tra tai khoan");
        System.out.println("2. Nhan phim D de nap tien");
        System.out.println("3. Nhan phim W de rut tien");
        System.out.println("4. Nhan phim H de xem lich su 3 lan rut tien");
        System.out.println("5. Nhan phim X de thoat");
    }

    public static void rutTien(TaiKhoan taiKhoan){
        System.out.println("Nhap tien rut");
        long tienRut = 0;
        tienRut = taiKhoan.checkNumber(tienRut);
        if (taiKhoan.rutTien(tienRut)) {
            System.out.println("Rut thanh cong " + tienRut + " VND");
            taiKhoan.kiemTraTaiKhoan();
        } else {
            System.out.println("Rut khong thanh cong. So tien ban nhap vuot qua so du tai khoan");
            taiKhoan.kiemTraTaiKhoan();
        }
    }
}
