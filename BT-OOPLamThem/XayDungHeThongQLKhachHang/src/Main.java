import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<KhachHang> arrKhachHang = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Chao mung ban den voi he thong quan ly khach hang");
        menu();

        int input = 0;
        input= (int) checkNumber(input);

        while (true) {
            switch (input) {
                case 1:
                    nhapThongTinKhachHang(arrKhachHang);
                    break;
                case 2:
                    timKiemKhachHang(arrKhachHang);
                    break;
                case 3:
                    inThongTinKhachHang(arrKhachHang);
                    break;
                case 4:
                    hienThiDanhSachKhachHang(arrKhachHang);
                    break;
                case 5:
                    tangSoDonHangChoKhach(arrKhachHang);
                    break;
                case 0:
                    System.out.println("He thong Quan ly khach hang vua shutdown.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhap sai du lieu. Moi nhap lai:");
            }
            menu();
            input= (int) checkNumber(input);
        }
    }

    public static void menu() {
        System.out.println("Bam 1 de nhap khach hang");
        System.out.println("Bam 2 de tim kiem khach hang");
        System.out.println("Bam 3 de in thong khach hang");
        System.out.println("Bam 4 de in toan bo danh sach khach hang");
        System.out.println("Bam 5 de tang so don hang cho khach");
        System.out.println("Bam 0 de thoat");
    }

    public static void nhapThongTinKhachHang(ArrayList<KhachHang> arrKhachHang) {
        KhachHang khachHang = new KhachHang();

        khachHang.nhapThongTinKH();

        boolean check = false;
        int index = 0;
        for (int i = 0; i < arrKhachHang.size(); i++) {
            if (arrKhachHang.get(i).getSoDienThoai()==khachHang.getSoDienThoai() &&
                    arrKhachHang.get(i).getEmail().equals(khachHang.getEmail())) {
                check = true;
                index = i;
                break;
            }
        }
        if (check) {
            arrKhachHang.get(index).setTenKH(khachHang.getTenKH());
            arrKhachHang.get(index).setDiaChi(khachHang.getDiaChi());
            arrKhachHang.get(index).setGioiTinh(khachHang.getGioiTinh());
            System.out.println("Khach hang da ton tai, He thong vua update thong tin");
        } else {
            arrKhachHang.add(khachHang);
            System.out.printf("Ban vua them moi khach hang %s thanh cong \n", khachHang.getTenKH());
        }
        System.out.println("Chon menu de thuc hien tiep");
        System.out.println("==========================================");

    }

    public static void timKiemKhachHang(ArrayList<KhachHang> arrKhachHang) {
        Scanner sc = new Scanner(System.in);
        int index = 0;
        boolean check = false;


        System.out.println("Nhap sdt khach hang:");
        long sdt = 0;
        sdt=checkNumber(sdt);
        System.out.println("He thong dang tim kiem");
        System.out.println("Ket qua:");

        for (int i = 0; i < arrKhachHang.size(); i++) {
            if (arrKhachHang.get(i).getSoDienThoai()==sdt) {
                check = true;
                index=i;
                break;
            }
        }

        if(check){
            System.out.printf("Khach hang %s, Dia chi: %s, Email: %s, SDT: %s, Gioi tinh: %s, So don hang da mua: %d;\n",
                    arrKhachHang.get(index).getTenKH(), arrKhachHang.get(index).getDiaChi(),
                    arrKhachHang.get(index).getEmail(), arrKhachHang.get(index).getSoDienThoai(),
                    arrKhachHang.get(index).getGioiTinh(),arrKhachHang.get(index).getSoDonHangDaMua());
        } else System.out.println("Khong ton tai KH");
        System.out.println("Chon menu de thuc hien tiep");
        System.out.println("==========================================");

    }

    public static void inThongTinKhachHang(ArrayList<KhachHang> arrKhachHang) {
        Scanner sc = new Scanner(System.in);
        int index = 0;
        boolean check = false;

        System.out.println("Nhap sdt khach hang:");
        long sdt = 0;
        sdt=checkNumber(sdt);
        System.out.println("Thong tin");

        for (int i = 0; i < arrKhachHang.size(); i++) {
            if (arrKhachHang.get(i).getSoDienThoai()==sdt) {
                check = true;
                index=i;
                break;
            }
        }

        if(check){
            System.out.printf("Khach hang %s, Dia chi: %s, Email: %s, SDT: %s, Gioi tinh: %s, So don hang da mua: %d;\n",
                    arrKhachHang.get(index).getTenKH(), arrKhachHang.get(index).getDiaChi(),
                    arrKhachHang.get(index).getEmail(), arrKhachHang.get(index).getSoDienThoai(),
                    arrKhachHang.get(index).getGioiTinh(),arrKhachHang.get(index).getSoDonHangDaMua());
        } else System.out.println("Khong ton tai KH");
        System.out.println("Chon menu de thuc hien tiep");
        System.out.println("==========================================");

    }

    public static void hienThiDanhSachKhachHang(ArrayList<KhachHang> arrKhachHang) {
        for (int i = 0; i < arrKhachHang.size(); i++) {
            System.out.print( (i+1)+". ");
            arrKhachHang.get(i).hienThiThongTinKH();
            System.out.println("==========================================");
        }
        System.out.printf("Tong co %d Khach hang trong he thong\n", arrKhachHang.size());
        System.out.println("Chon menu de thuc hien tiep");
        System.out.println("==========================================");
    }

    public static void tangSoDonHangChoKhach(ArrayList<KhachHang> arrKhachHang){
        Scanner sc = new Scanner(System.in);
        int index = 0;
        boolean check = false;

        System.out.println("Nhap sdt khach hang:");
        long sdt = 0;
        sdt=checkNumber(sdt);
        System.out.println("Thong tin sau khi tang 1 don hang");

        for (int i = 0; i < arrKhachHang.size(); i++) {
            if (arrKhachHang.get(i).getSoDienThoai()==sdt) {
                check = true;
                index=i;
                break;
            }
        }

        if(check){
            arrKhachHang.get(index).setSoDonHangDaMua(arrKhachHang.get(index).getSoDonHangDaMua()+1);
            System.out.printf("Khach hang %s, Dia chi: %s, Email: %s, SDT: %s, Gioi tinh: %s, So don hang da mua: %d;\n",
                    arrKhachHang.get(index).getTenKH(), arrKhachHang.get(index).getDiaChi(),
                    arrKhachHang.get(index).getEmail(), arrKhachHang.get(index).getSoDienThoai(),
                    arrKhachHang.get(index).getGioiTinh(),arrKhachHang.get(index).getSoDonHangDaMua());
        } else System.out.println("Khong ton tai KH");
        System.out.println("Chon menu de thuc hien tiep");
        System.out.println("==========================================");
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
