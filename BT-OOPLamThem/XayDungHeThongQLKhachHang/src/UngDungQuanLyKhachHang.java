import java.util.ArrayList;
import java.util.Scanner;

public class UngDungQuanLyKhachHang {

    public static void main(String[] args) {

        ArrayList<KhachHang> mangKhachHang = new ArrayList<>();

        System.out.println("Chao mung ban den voi he thong quan ly khach hang");
        menu();

        int input = 0;
        input= (int) kiemTraSo(input);

        while (true) {
            switch (input) {
                case 1 -> capnhapThongTinKhachHang(mangKhachHang);
                case 2 -> timKiemKhachHang(mangKhachHang);
                case 3 -> inThongTinKhachHang(mangKhachHang);
                case 4 -> hienThiDanhSachKhachHang(mangKhachHang);
                case 5 -> tangSoDonHangChoKhach(mangKhachHang);
                case 0 -> {
                    System.out.println("He thong Quan ly khach hang vua shutdown.");
                    System.exit(0);
                }
                default -> System.out.println("Nhap sai du lieu. Moi nhap lai:");
            }
            System.out.println("Nhap lua chon:");
            input= (int) kiemTraSo(input);
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

    public static KhachHang nhapThongTinKH() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ten KH:");
        String tenKH = sc.nextLine();
        tenKH = chuanHoa(tenKH);
        tenKH = kiemTraChuoi(tenKH);
        System.out.println("Nhap dia chi KH:");
        String diaChi = sc.nextLine();
        diaChi = chuanHoa(diaChi);
        System.out.println("Nhap So Dien Thoai KH:");
        long soDienThoai = 0;
        soDienThoai = kiemTraSo(soDienThoai);
        System.out.println("Nhap Email KH:");
        String email = sc.nextLine();
        email = email.trim();
        System.out.println("Nhap gioi tinh KH:");
        String gender = sc.nextLine();
        gender= kiemTraChuoi(gender);
        boolean gioiTinh = chuyenGioiTinhSangBoolean(gender);

        return new KhachHang(tenKH,diaChi,soDienThoai,email,gioiTinh);
    }

    public static void capnhapThongTinKhachHang(ArrayList<KhachHang> mangKhachHang) {
        KhachHang khachHang=nhapThongTinKH();

        boolean check = false;
        int index = 0;
        for (int i = 0; i < mangKhachHang.size(); i++) {
            if (mangKhachHang.get(i).getSoDienThoai()==khachHang.getSoDienThoai() &&
                    mangKhachHang.get(i).getEmail().equals(khachHang.getEmail())) {
                check = true;
                index = i;
                break;
            }
        }
        if (check) {
            mangKhachHang.get(index).setTenKH(khachHang.getTenKH());
            mangKhachHang.get(index).setDiaChi(khachHang.getDiaChi());
            mangKhachHang.get(index).setGioiTinh(khachHang.getGioiTinh());
            System.out.println("Khach hang da ton tai, He thong vua update thong tin");
        } else {
            mangKhachHang.add(khachHang);
            System.out.printf("Ban vua them moi khach hang %s thanh cong \n", khachHang.getTenKH());
        }
        System.out.println("Chon menu de thuc hien tiep");
        System.out.println("==========================================");

    }

    public  static void thongTinKhachHang(ArrayList<KhachHang> mangKhachHang,int index){
        System.out.printf("Khach hang %s, Dia chi: %s, Email: %s, SDT: %s, Gioi tinh: %s, So don hang da mua: %d\n",
                mangKhachHang.get(index).getTenKH(), mangKhachHang.get(index).getDiaChi(),
                mangKhachHang.get(index).getEmail(), mangKhachHang.get(index).getSoDienThoai(),
                gioiTinh(mangKhachHang,index),mangKhachHang.get(index).getSoDonHangDaMua());
    }

    public static void timKiemKhachHang(ArrayList<KhachHang> mangKhachHang) {
        System.out.println("He thong dang tim kiem");
        int index = 0;
        boolean check = false;

        System.out.println("Nhap sdt khach hang:");
        long sdt = 0;
        sdt= kiemTraSo(sdt);

        for (int i = 0; i < mangKhachHang.size(); i++) {
            if (mangKhachHang.get(i).getSoDienThoai()==sdt) {
                check = true;
                index=i;
                break;
            }
        }

        if(check){
            thongTinKhachHang(mangKhachHang,index);
        } else System.out.println("Khong ton tai KH");
        System.out.println("Chon menu de thuc hien tiep");
        System.out.println("==========================================");

    }

    public static void inThongTinKhachHang(ArrayList<KhachHang> mangKhachHang) {
        System.out.println("Thong tin");

        int index = 0;
        boolean check = false;

        System.out.println("Nhap sdt khach hang:");
        long sdt = 0;
        sdt= kiemTraSo(sdt);

        for (int i = 0; i < mangKhachHang.size(); i++) {
            if (mangKhachHang.get(i).getSoDienThoai()==sdt) {
                check = true;
                index=i;
                break;
            }
        }

        if(check){
            thongTinKhachHang(mangKhachHang,index);
        } else System.out.println("Khong ton tai KH");
        System.out.println("Chon menu de thuc hien tiep");
        System.out.println("==========================================");

    }

    public static void hienThiDanhSachKhachHang(ArrayList<KhachHang> mangKhachHang) {
        for (int i = 0; i < mangKhachHang.size(); i++) {
            System.out.print( (i+1)+". ");
            thongTinKhachHang(mangKhachHang,i);
            System.out.println("==================");
        }
        System.out.printf("Tong co %d Khach hang trong he thong\n", mangKhachHang.size());
        System.out.println("Chon menu de thuc hien tiep");
        System.out.println("==========================================");
    }

    public static void tangSoDonHangChoKhach(ArrayList<KhachHang> mangKhachHang){
        int index = 0;
        boolean check = false;

        System.out.println("Nhap sdt khach hang:");
        long sdt = 0;
        sdt= kiemTraSo(sdt);

        for (int i = 0; i < mangKhachHang.size(); i++) {
            if (mangKhachHang.get(i).getSoDienThoai()==sdt) {
                check = true;
                index=i;
                break;
            }
        }

        if(check){
            System.out.println("Thong tin sau khi tang 1 don hang");
            mangKhachHang.get(index).setSoDonHangDaMua(mangKhachHang.get(index).getSoDonHangDaMua()+1);
            thongTinKhachHang(mangKhachHang,index);
        } else System.out.println("Khong ton tai KH");
        System.out.println("Chon menu de thuc hien tiep");
        System.out.println("==========================================");
    }

    public static String gioiTinh(ArrayList<KhachHang> mangKhachHang, int index){
        if(mangKhachHang.get(index).getGioiTinh()) return "Nam";
        else return "Nu";
    }

    public static boolean chuyenGioiTinhSangBoolean(String gender){
        Scanner sc = new Scanner(System.in);
        gender = gender.toLowerCase();
        while (!gender.equals("nam") && !gender.equals("nu")) {
            System.out.println("Gioi tinh la Nam hoac Nu. Nhap lai:");
            gender = sc.nextLine();
        }

        return gender.equals("nam");
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
        input=input.trim();
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
