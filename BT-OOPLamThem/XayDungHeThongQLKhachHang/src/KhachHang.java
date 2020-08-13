import java.util.Scanner;

public class KhachHang {
    private String tenKH;
    private String diaChi;
    private long soDienThoai;
    private String email;
    private String gioiTinh;
    private int soDonHangDaMua;

    public KhachHang() {
    }

    public static String checkInput(String input) {
        Scanner sc = new Scanner(System.in);
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

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public long getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(long soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getSoDonHangDaMua() {
        return soDonHangDaMua;

    }

    public void setSoDonHangDaMua(int soDonHangDaMua) {
        this.soDonHangDaMua = soDonHangDaMua;
    }

    public void nhapThongTinKH() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ten KH:");
        tenKH = sc.nextLine();
        tenKH = chuanHoa(tenKH);
        tenKH = checkInput(tenKH);
        System.out.println("Nhap dia chi KH:");
        diaChi = sc.nextLine();
        diaChi = chuanHoa(diaChi);
        System.out.println("Nhap So Dien Thoai KH:");
        soDienThoai = 0;
        soDienThoai = checkNumber(soDienThoai);
        System.out.println("Nhap Email KH:");
        email = sc.nextLine();
        email = email.trim();
        System.out.println("Nhap gioi tinh KH:");
        gioiTinh = sc.nextLine();
    }

    public void hienThiThongTinKH() {
        System.out.println("Ho va ten:" + tenKH);
        System.out.println("Dia chi:" + diaChi);
        System.out.println("So dien thoai:" + soDienThoai);
        System.out.println("Email:" + email);
        System.out.println("Gioi tinh:" + gioiTinh);
    }

    public long checkNumber(long num) {
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
}
