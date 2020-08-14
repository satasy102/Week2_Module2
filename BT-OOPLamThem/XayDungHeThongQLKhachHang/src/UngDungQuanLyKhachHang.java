import java.util.ArrayList;
import java.util.Scanner;

public class UngDungQuanLyKhachHang {

    public static final String DAU_CHIA_DONG = "==========================================";
    public static final String NHAP_THONG_TIN_KHACH_HANG = "Bam 1 de nhap thong tin khach hang";
    public static final String TIM_KIEM_KHACH_HANG = "Bam 2 de tim kiem khach hang";
    public static final String IN_THONG_KHACH_HANG = "Bam 3 de in thong khach hang";
    public static final String IN_TOAN_BO_DANH_SACH_KHACH_HANG = "Bam 4 de in toan bo danh sach khach hang";
    public static final String TANG_SO_DON_HANG_CHO_KHACH = "Bam 5 de tang so don hang cho khach";
    public static final String THOAT = "Bam 0 de thoat";
    private static final ArrayList<KhachHang> mangKhachHang = new ArrayList<>();
    private static final Scanner sc=new Scanner(System.in);
    public static final String KHONG_TON_TAI_KH = "Khong ton tai KH";
    private static int index;

    public static void main(String[] args) {
        System.out.println("Chao mung ban den voi he thong quan ly khach hang");
        menu();

        int input = 0;
        input = (int) kiemTraSo(input);

        while (true) {
            switch (input) {
                case 1 -> nhapThongTinKH();
                case 2 -> timKiemKhachHang();
                case 3 -> inThongTinKhachHang();
                case 4 -> hienThiDanhSachKhachHang();
                case 5 -> tangSoDonHangChoKhach();
                case 0 -> {
                    System.out.println("He thong Quan ly khach hang vua shutdown.");
                    System.exit(0);
                }
                default -> System.out.println("Nhap sai du lieu. Moi nhap lai:");
            }
            System.out.println("Nhap lua chon:");
            input = (int) kiemTraSo(input);
        }
    }

    public static void menu() {
        System.out.println(NHAP_THONG_TIN_KHACH_HANG);
        System.out.println(TIM_KIEM_KHACH_HANG);
        System.out.println(IN_THONG_KHACH_HANG);
        System.out.println(IN_TOAN_BO_DANH_SACH_KHACH_HANG);
        System.out.println(TANG_SO_DON_HANG_CHO_KHACH);
        System.out.println(THOAT);
    }

    public static void nhapThongTinKH() {

        System.out.println("Nhap ten KH:");
        String tenKH = sc.nextLine();
        tenKH = chuanHoa(tenKH);
        tenKH = kiemTraChuoi(tenKH);

        System.out.println("Nhap dia chi KH:");
        String diaChi = sc.nextLine();

        System.out.println("Nhap So Dien Thoai KH:");
        String soDienThoai = sc.nextLine();

        System.out.println("Nhap Email KH:");
        String email = sc.nextLine();

        System.out.println("Nhap gioi tinh KH:");
        String gender = sc.nextLine();
        gender = kiemTraChuoi(gender);
        boolean gioiTinh = chuyenGioiTinhSangBoolean(gender);

        KhachHang khachHang= new KhachHang(tenKH, diaChi, soDienThoai, email, gioiTinh);

        if(kiemTraSDTVaEmailTrungNhau(soDienThoai,email)){

            mangKhachHang.get(index).setTenKH(tenKH);
            mangKhachHang.get(index).setDiaChi(diaChi);
            mangKhachHang.get(index).setGioiTinh(gioiTinh);
            System.out.println("Khach hang nay da ton tai. He thong da cap nhat thong tin.");

        } else {
            mangKhachHang.add(khachHang);
            System.out.printf("Ban vua them khach hang %s thanh cong.", tenKH);
        }
    }

    public static boolean kiemTraSDTVaEmailTrungNhau(String soDienThoai, String email){
        int size = mangKhachHang.size();

        for (int i = 0; i< size; i++) {

            String soDienThoaiCu = mangKhachHang.get(i).getSoDienThoai();
            String eMailCu = mangKhachHang.get(i).getEmail();

            if(soDienThoaiCu.equals(soDienThoai) && eMailCu.equals(email)){
                index=i;
                return true;
            }
        } return false;
    }

    public static void thongTinKhachHang(int index) {
        String thongTin = mangKhachHang.get(index).toString();
        int soDonHangDaMua = mangKhachHang.get(index).getSoDonHangDaMua();
        System.out.printf("%s, Gioi tinh: %s, So don hang da mua: %d\n",
                thongTin, gioiTinh(index), soDonHangDaMua);
    }

    public static boolean timKiemSDT(){
        System.out.println("Nhap sdt khach hang:");
        String sdtNhap = sc.nextLine();

        int size = mangKhachHang.size();
        for (int i = 0; i < size; i++) {
            String soDienThoai = mangKhachHang.get(i).getSoDienThoai();

            if (soDienThoai.equals(sdtNhap)) {
                index = i;
                return true;
            }
        } return false;
    }

    public static void timKiemKhachHang() {
        if (timKiemSDT()) {
            thongTinKhachHang(index);
        } else System.out.println(KHONG_TON_TAI_KH);
        phanDay();
    }

    public static void inThongTinKhachHang() {
        System.out.println("Thong tin");
        timKiemKhachHang();
    }

    public static void hienThiDanhSachKhachHang() {
        int size = mangKhachHang.size();
        
        for (int i = 0; i < size; i++) {
            int soThuTu = i + 1;
            System.out.print(soThuTu + ". ");
            thongTinKhachHang(i);
            System.out.println();
        }
        System.out.printf("Tong co %d Khach hang trong he thong\n", size);
        phanDay();
    }

    public static void tangSoDonHangChoKhach() {
       if (timKiemSDT()) {
            System.out.println("Thong tin sau khi tang 1 don hang");

           int soDonHangDaMua = mangKhachHang.get(index).getSoDonHangDaMua();
           mangKhachHang.get(index).setSoDonHangDaMua(soDonHangDaMua + 1);

           thongTinKhachHang(index);
        } else System.out.println(KHONG_TON_TAI_KH);
        phanDay();
    }

    public static String gioiTinh(int index) {
        boolean gioiTinh = mangKhachHang.get(index).getGioiTinh();
        if (gioiTinh) return "Nam";
        else return "Nu";
    }

    public static boolean chuyenGioiTinhSangBoolean(String gender) {
        Scanner sc = new Scanner(System.in);
        gender = gender.toLowerCase();
        while (!gender.equals("nam") && !gender.equals("nu")) {
            System.out.println("Gioi tinh la Nam hoac Nu. Nhap lai:");
            gender = sc.nextLine();
        }

        return gender.equals("nam");
    }

    public static void phanDay() {
        System.out.println("Chon menu de thuc hien tiep");
        System.out.println(DAU_CHIA_DONG);
    }

    public static long kiemTraSo(long num) {
        Scanner sc = new Scanner(System.in);
        String str;
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

    public static String kiemTraChuoi(String input) {
        Scanner sc = new Scanner(System.in);
        input = input.trim();
        while (input.equals("")) {
            System.out.println("Khong duoc bo trong. Nhap lai:");
            input = sc.nextLine();
            input = chuanHoa(input);
        }
        return input;
    }

    public static String chuanHoa(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        return str;
    }
}
