import java.util.HashMap;
import java.util.Scanner;

public class UngDungQuanLyKhachHang {

    public static final String DAU_CHIA_DONG = "==========================================";
    public static final String NHAP_THONG_TIN_KHACH_HANG = "Bam 1 de nhap thong tin khach hang";
    public static final String TIM_KIEM_KHACH_HANG = "Bam 2 de tim kiem khach hang";
    public static final String IN_THONG_KHACH_HANG = "Bam 3 de in thong khach hang";
    public static final String IN_TOAN_BO_DANH_SACH_KHACH_HANG = "Bam 4 de in toan bo danh sach khach hang";
    public static final String TANG_SO_DON_HANG_CHO_KHACH = "Bam 5 de tang so don hang cho khach";
    public static final String THOAT = "Bam 0 de thoat";
    public static final String KHONG_TON_TAI_KH = "Khong ton tai KH";
    private static final HashMap<Long, KhachHang> mangKhachHang = new HashMap<>();
    private static final Scanner sc = new Scanner(System.in);
    public static long id = 0;
    private static long max = 0;
    private static long maxTen = 0;
    private static long maxDiaChi = 0;
    private static long maxSDT = 0;
    private static long maxEmail = 0;
    private static long soDauGachDuoi = 8 + 7 + 2 + 1 + 6 * 3 + maxTen + maxDiaChi + maxEmail + maxSDT + 9 + 11;
    private static long index = 0;


    public static void main(String[] args) {
        println("Chao mung ban den voi he thong quan ly khach hang");
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
                    println("He thong Quan ly khach hang vua shutdown.");
                    System.exit(0);
                }
                default -> println("Nhap sai du lieu. Moi nhap lai:");
            }
            println("Nhap lua chon:");
            input = (int) kiemTraSo(input);
        }
    }

    public static void println(String msg) {
        System.out.println(msg);
    }

    public static void print(String msg) {
        System.out.print(msg);
    }

    public static void menu() {
        println(NHAP_THONG_TIN_KHACH_HANG);
        println(TIM_KIEM_KHACH_HANG);
        println(IN_THONG_KHACH_HANG);
        println(IN_TOAN_BO_DANH_SACH_KHACH_HANG);
        println(TANG_SO_DON_HANG_CHO_KHACH);
        println(THOAT);
    }

    public static void nhapThongTinKH() {

        println("Nhap ten KH:");
        String tenKH = sc.nextLine();
        tenKH = chuanHoa(tenKH);
        tenKH = kiemTraChuoi(tenKH);

        println("Nhap dia chi KH:");
        String diaChi = sc.nextLine();

        println("Nhap So Dien Thoai KH:");
        long soDienThoai = 0;
        soDienThoai = kiemTraSo(soDienThoai);

        println("Nhap Email KH:");
        String email = sc.nextLine();

        println("Nhap gioi tinh KH:");
        String gender = sc.nextLine();
        gender = kiemTraChuoi(gender);
        boolean gioiTinh = chuyenGioiTinhSangBoolean(gender);

        KhachHang khachHang = new KhachHang(tenKH, diaChi, soDienThoai, email, gioiTinh);

        if (kiemTraSDTVaEmailTrungNhau(soDienThoai, email)) {

            mangKhachHang.get(index).setTenKH(tenKH);
            mangKhachHang.get(index).setDiaChi(diaChi);
            mangKhachHang.get(index).setGioiTinh(gioiTinh);
            println("Khach hang nay da ton tai. He thong da cap nhat thong tin.");

        } else {
            id++;
            mangKhachHang.put(id, khachHang);
            mangKhachHang.get(id).ID = id;
            System.out.printf("Ban vua them khach hang %s thanh cong.", tenKH);

        }
    }

    public static boolean kiemTraSDTVaEmailTrungNhau(long soDienThoai, String email) {
        int size = mangKhachHang.size();

        for (long i = 1; i <= size; i++) {

            long soDienThoaiCu = mangKhachHang.get(i).getSoDienThoai();
            String eMailCu = mangKhachHang.get(i).getEmail();

            if (soDienThoaiCu == soDienThoai && eMailCu.equals(email)) {
                index = i;
                return true;
            }
        }
        return false;
    }

    public static void thongTinKhachHang(long index) {

        maxTen=maxTen();

        maxDiaChi=maxDiaChi();

        maxSDT=maxSDT();

        maxEmail=maxEmail();

        soDauGachDuoi = 8 + 7 + 2 + 1 + 6 * 3 + maxTen + maxDiaChi + maxEmail + maxSDT + 9 + 11;

        thongTinKHCanTim(index);

    }

    public static long maxSDT() {
        max = 0;
        max = soKyTuLonNhat("SDT");
        maxSDT = 0;
        int size = mangKhachHang.size();
        for (long i = 1; i <= size; i++) {
            long soDienThoai = mangKhachHang.get(i).getSoDienThoai();
            maxSDT = soKyTuLonNhat(String.valueOf(soDienThoai));
        }
        return maxSDT;
    }

    public static long maxTen() {
        max = 0;
        max = soKyTuLonNhat("Ten");
        maxTen = 0;
        int size = mangKhachHang.size();
        for (long i = 1; i <= size; i++) {
            String tenKH = mangKhachHang.get(i).getTenKH();
            maxTen = soKyTuLonNhat(tenKH);
        }
        return maxTen;
    }

    public static long maxEmail() {
        max = 0;
        max = soKyTuLonNhat("Email");
        maxEmail = 0;
        int size = mangKhachHang.size();
        for (long i = 1; i <= size; i++) {
            String email = mangKhachHang.get(i).getEmail();
            maxEmail = soKyTuLonNhat(email);
        }
        return maxEmail;
    }

    public static long maxDiaChi() {
        max = 0;
        max = soKyTuLonNhat("Dia Chi");
        maxDiaChi = 0;
        int size = mangKhachHang.size();
        for (long i = 1; i <= size; i++) {
            String diaChi = mangKhachHang.get(i).getDiaChi();
            maxDiaChi = soKyTuLonNhat(diaChi);
        }
        return maxDiaChi;
    }

    public static boolean timKiemId() {
        println("Nhap id khach hang:");
        long id = 0;
        id = kiemTraSo(id);
        if (mangKhachHang.containsKey(id)) {
            index = id;
            return true;
        } else return false;
    }

    public static void timKiemKhachHang() {
        if (timKiemId()) {
            bang1KhachHang();

        } else println(KHONG_TON_TAI_KH);
        phanDay();
    }

    public static void bang1KhachHang() {
        max = 0;
        max = soKyTuLonNhat("Ten");
        String tenKH = mangKhachHang.get(index).getTenKH();
        maxTen = soKyTuLonNhat(tenKH);

        max = 0;
        max = soKyTuLonNhat("Dia Chi");
        String diaChi = mangKhachHang.get(index).getDiaChi();
        maxDiaChi = soKyTuLonNhat(diaChi);

        max = 0;
        max = soKyTuLonNhat("SDT");
        long soDienThoai = mangKhachHang.get(index).getSoDienThoai();
        maxSDT = soKyTuLonNhat(String.valueOf(soDienThoai));

        max = 0;
        max = soKyTuLonNhat("Email");
        String email = mangKhachHang.get(index).getEmail();
        maxEmail = soKyTuLonNhat(email);

        soDauGachDuoi = 8 + 7 + 2 + 1 + 6 * 3 + maxTen + maxDiaChi + maxEmail + maxSDT + 9 + 11;
        phanTieuDeBang();

        thongTinKHCanTim();
    }

    public static void thongTinKHCanTim() {
        System.out.printf("\n%-2s%-3d%-2s%" + -(maxTen + 3) + "s%-2s%" +
                        -(maxDiaChi + 3) + "s%-2s%" + -(maxSDT + 3) + "d%-2s%" +
                        -(maxEmail + 3) + "s%-2s%-12s%-2s%-14s%s",
                "|", mangKhachHang.get(index).getID(),
                "|", mangKhachHang.get(index).getTenKH(),
                "|", mangKhachHang.get(index).getDiaChi(),
                "|", mangKhachHang.get(index).getSoDienThoai(),
                "|", mangKhachHang.get(index).getEmail(),
                "|", gioiTinh(index),
                "|", mangKhachHang.get(index).getSoDonHangDaMua(), "|\n");
    }

    public static void thongTinKHCanTim(long index) {
        System.out.printf("\n%-2s%-3d%-2s%" + -(maxTen + 3) + "s%-2s%" +
                        -(maxDiaChi + 3) + "s%-2s%" + -(maxSDT + 3) + "d%-2s%" +
                        -(maxEmail + 3) + "s%-2s%-12s%-2s%-14s%s",
                "|", mangKhachHang.get(index).getID(),
                "|", mangKhachHang.get(index).getTenKH(),
                "|", mangKhachHang.get(index).getDiaChi(),
                "|", mangKhachHang.get(index).getSoDienThoai(),
                "|", mangKhachHang.get(index).getEmail(),
                "|", gioiTinh(index),
                "|", mangKhachHang.get(index).getSoDonHangDaMua(), "|");
    }

    public static void inThongTinKhachHang() {
        println("Thong tin");
        timKiemKhachHang();
    }

    public static void hienThiDanhSachKhachHang() {
        int size = mangKhachHang.size();

        maxTen=maxTen();

        maxDiaChi=maxDiaChi();

        maxSDT=maxSDT();

        maxEmail=maxEmail();

        soDauGachDuoi = 8 + 7 + 2 + 1 + 6 * 3 + maxTen + maxDiaChi + maxEmail + maxSDT + 9 + 11;

        phanTieuDeBang();

        for (long i = 1; i <= size; i++) {
            thongTinKhachHang(i);
        }
        System.out.printf("\nTong co %d Khach hang trong he thong\n", size);
        phanDay();
    }

    public static void phanTieuDeBang() {
        for (int i = 1; i <= soDauGachDuoi; i++) print("-");

        System.out.printf("\n%-2s%-3s%-2s%" + -(maxTen + 3) +
                        "s%-2s%" + -(maxDiaChi + 3) +
                        "s%-2s%" + -(maxSDT + 3) + "s%-2s%" +
                        -(maxEmail + 3) +
                        "s%-2s%-12s%-2s%-14s%s",
                "|", "ID", "|", "Ten", "|", "Dia chi", "|", "SDT", "|", "Email", "|", "Gioi tinh", "|",
                "So don hang", "|\n");

        for (int i = 1; i <= soDauGachDuoi; i++) System.out.print("-");
    }

    public static void tangSoDonHangChoKhach() {
        if (timKiemId()) {
            println("Thong tin sau khi tang 1 don hang");

            int soDonHangDaMua = mangKhachHang.get(index).getSoDonHangDaMua();
            mangKhachHang.get(index).setSoDonHangDaMua(soDonHangDaMua + 1);

            bang1KhachHang();
        } else {
            println(KHONG_TON_TAI_KH);
            phanDay();
        }
    }

    public static String gioiTinh(long index) {
        boolean gioiTinh = mangKhachHang.get(index).getGioiTinh();
        if (gioiTinh) return "Nam";
        return "Nu";
    }

    public static boolean chuyenGioiTinhSangBoolean(String gender) {
        Scanner sc = new Scanner(System.in);
        gender = gender.toLowerCase();
        while (!gender.equals("nam") && !gender.equals("nu")) {
            println("Gioi tinh la Nam hoac Nu. Nhap lai:");
            gender = sc.nextLine();
        }

        return gender.equals("nam");
    }

    public static void phanDay() {
        println("\nChon menu de thuc hien tiep");
        println(DAU_CHIA_DONG);
    }

    public static long soKyTuLonNhat(String str) {
        char[] charArray = str.toCharArray();

        if (max < charArray.length)
            max = charArray.length;
        return max;
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
                println("Khong phai so. Moi nhap lai:");
            }
        }
        return num;
    }

    public static String kiemTraChuoi(String input) {
        Scanner sc = new Scanner(System.in);
        input = input.trim();
        while (input.equals("")) {
            println("Khong duoc bo trong. Nhap lai:");
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
