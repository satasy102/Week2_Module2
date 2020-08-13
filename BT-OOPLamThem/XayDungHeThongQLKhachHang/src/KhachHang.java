import java.util.Scanner;

public class KhachHang {
    private String tenKH;
    private String diaChi;
    private long soDienThoai;
    private String email;
    private boolean gioiTinh;
    private int soDonHangDaMua;

    public KhachHang() {
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
        if(gioiTinh) return "Nam";
        else return "Nu";
    }

    public void setGioiTinh(String gender) {
        gender = gender.toLowerCase();
        this.gioiTinh = gender.equals("nam");
    }

    public int getSoDonHangDaMua() {
        return soDonHangDaMua;

    }

    public void setSoDonHangDaMua(int soDonHangDaMua) {
        this.soDonHangDaMua = soDonHangDaMua;
    }

    public void nhapThongTinKH() {
        Scanner sc = new Scanner(System.in);
        String gender;

        System.out.println("Nhap ten KH:");
        tenKH = sc.nextLine();
        tenKH = chuanHoa(tenKH);
        tenKH = kiemTraChuoi(tenKH);
        System.out.println("Nhap dia chi KH:");
        diaChi = sc.nextLine();
        diaChi = chuanHoa(diaChi);
        System.out.println("Nhap So Dien Thoai KH:");
        soDienThoai = 0;
        soDienThoai = kiemTraSo(soDienThoai);
        System.out.println("Nhap Email KH:");
        email = sc.nextLine();
        email = email.trim();
        System.out.println("Nhap gioi tinh KH:");
        gender = sc.nextLine();
        gender= kiemTraChuoi(gender);
        gender = checkGioiTinh(gender);
        setGioiTinh(gender);

    }

    public String checkGioiTinh(String str) {
        Scanner sc = new Scanner(System.in);
        str = str.toLowerCase();
        while (!str.equals("nam") && !str.equals("nu")) {
            System.out.println("Gioi tinh la Nam hoac Nu. Nhap lai:");
            str = sc.nextLine();
        }
        return str;
    }

    public void hienThiThongTinKH() {
        System.out.println("Ho va ten:" + getTenKH());
        System.out.println("Dia chi:" + getDiaChi());
        System.out.println("So dien thoai:" + getSoDienThoai());
        System.out.println("Email:" + getEmail());
        System.out.println("Gioi tinh:" + getGioiTinh());
    }

    public long kiemTraSo(long num) {
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
