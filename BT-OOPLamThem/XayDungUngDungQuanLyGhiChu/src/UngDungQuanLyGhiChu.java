import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class UngDungQuanLyGhiChu {
    public static final String CO = "c";
    public static final String KHONG = "k";
    public static final String TIEU_DE = "tieu de";
    public static final String NOI_DUNG = "noi dung";
    public static final String TASK = "task";
    public static final String DAU_GACH_PHAN_DAY = "=========";
    public static final String DAU_GACH_CHIA_TASK = "-----------------------";
    private static final Scanner sc = new Scanner(System.in);
    public static ArrayList<GhiChu> mangGhiChu = new ArrayList<>();
    private static byte index;

    public static void main(String[] args) {
        menu();
        println("\nNhap lua chon cua ban");
        String nhap = sc.nextLine();
        nhap=nhap.toUpperCase();
        while (true) {
            switch (nhap) {
                case "C" -> taoMoiGhiChu();
                case "U" -> chinhSuaGhiChu();
                case "D" -> xoaGhiChu();
                case "L" -> xemDanhSachGhiChu();
                case "F" -> hienThiGhiChuCanTim();
                case "X" -> {
                    println("He thong dang shutdown");
                    System.exit(0);
                }
                default -> println("Ban da nhap sai Menu. Hay nhao lai.");
            }
            menu();
            println("\nNhap lua chon cua ban");
            nhap = sc.nextLine();
            nhap=nhap.toUpperCase();
        }
    }

    public static void sort() {
        Collections.sort(mangGhiChu);
        Collections.reverse(mangGhiChu);
    }

    public static void hienThiBaGhiChuGanNhat() {
        println(" ");
        int size = mangGhiChu.size();
        if (size ==0) {
            println("Hien tai chua co ghi chu nao");
        } else if (size <= 3) {
            byte stt=0;
            for (GhiChu ghiChu : mangGhiChu) {
                stt++;
                System.out.printf("   %d. %s\n",stt,ghiChu.getTieuDe());
                System.out.printf("      %s\n",ghiChu.getNoiDung());
            }
        }else {
            byte stt=0;
            for (byte i=0; i<3;i++) {
                stt++;
                System.out.printf("   %d. %s\n",stt,mangGhiChu.get(i).getTieuDe());
                System.out.printf("      %s\n",mangGhiChu.get(i).getNoiDung());
            }
        }
    }

    public static void println(String msg){
        System.out.println(msg);
    }

    public static void menu() {
        println("MENU");
        println("Tao Ghi Chu bam C");
        println("Sua Ghi Chu bam U");
        println("Xoa Ghi Chu bam D");
        println("Xem Danh Sach bam L");
        println("Xem Ghi Chu bam F");
        sort();

        hienThiBaGhiChuGanNhat();

    }

    public static Date thoiGian() {
        return new java.util.Date();
    }

    public static byte soTaskCanLam() {
        println("Nhap so task can lam:");
        byte soTask = 0;
        soTask = kiemTraSo(soTask);
        while (soTask > 20 || soTask<=0) {
            println("Sai so task quy dinh.Nhap lai: ");
            soTask = kiemTraSo(soTask);
        }
        return soTask;
    }

    public static String[] taskCongViec() {
        byte soTask = soTaskCanLam();
        String[] congViec = new String[soTask];
        for (byte i = 0; i < soTask; i++) {
            int stt = i + 1;
            println("Nhap cong viec Task thu " + stt + ":");
            congViec[i] = sc.nextLine();
        }

        return congViec;
    }

    public static void phanDay() {
        println(DAU_GACH_PHAN_DAY);
    }

    public static void taoMoiGhiChu() {
        println("TAO MOI GHI CHU");
        if (GhiChu.soGhiChu >= 128) {
            println("Da vuot qua gioi han cho phep de tao Ghi Chu moi.");
        } else {
            GhiChu ghiChu = new GhiChu();
            ghiChu.setThoiGianTao(thoiGian());
            println("Nhap Tieu De:");
            String tieuDe=sc.nextLine();
            tieuDe=kiemTraChuoi(tieuDe);
            tieuDe=kiemTraTieuDe(tieuDe);
            ghiChu.setTieuDe(tieuDe);
            println("Nhap Noi Dung:");
            ghiChu.setNoiDung(sc.nextLine());
            ghiChu.setDanhSachViec(taskCongViec());
            println("Ban da nhap ghi chu thanh cong");
            ghiChu.setThoiGianChinhSuaLanCuoi(thoiGian());
            mangGhiChu.add(ghiChu);
        }
        phanDay();
    }

    public static String kiemTraTieuDe(String tieuDe){
        for (GhiChu ghiChu : mangGhiChu) {
            String tieuDeGhiChu = ghiChu.getTieuDe();
            if (tieuDeGhiChu.equals(tieuDe)) {
                println("Da co Tieu de ten nay. Nhap lai ten khac.");
                tieuDe = sc.nextLine();
                tieuDe=kiemTraChuoi(tieuDe);
                kiemTraTieuDe(tieuDe);
                return tieuDe;
            }
        }
        return tieuDe;
    }
    public static void chinhSuaGhiChu() {
        println("CHINH SUA GHI CHU");
        println("Tim ghi chu can sua:");
        boolean timTieuDe=timTieuDe();
        if (timTieuDe) {
            suaTrongMotGhiChu();
        } else println("Khong tim thay Ghi chu");
        phanDay();
    }

    public static boolean timTieuDe() {
        println("Nhap tieu de Ghi Chu can tim:");
        String tieuDeCanTim = sc.nextLine();
        tieuDeCanTim = tieuDeCanTim.toLowerCase();

        int size = mangGhiChu.size();
        for (byte i = 0; i < size; i++) {
            String tieuDe = mangGhiChu.get(i).getTieuDe();
            tieuDe = tieuDe.toLowerCase();
            if (tieuDe.equals(tieuDeCanTim)) {
                index = i;

                return true;
            }
        }

        return false;
    }

    public static void suaTrongMotGhiChu() {
        mangGhiChu.get(index).hienThiGhiChu();//Hien thi ghi chu can sua
        println("Ban muon sua phan nao? (Tieu de, Noi dung, Task, hoac K (Khong))");
        String canSua = sc.nextLine();
        canSua = canSua.toLowerCase();
        if (!canSua.equals("k")) {
            if (canSua.equals(TIEU_DE)) suaTieuDe();
            if (canSua.equals(NOI_DUNG)) suaNoiDung();
            if (canSua.equals(TASK)) suaTask();
            tiepTucChinhSua();
        } else println("Khong chinh sua gi");
    }

    public static void suaTieuDe() {
        println("Tieu de Moi:");
        mangGhiChu.get(index).setTieuDe(sc.nextLine());
        mangGhiChu.get(index).setThoiGianChinhSuaLanCuoi(thoiGian());
        println("Sua tieu de thanh cong");
    }

    public static void suaNoiDung() {
        println("Noi dung Moi:");
        mangGhiChu.get(index).setNoiDung(sc.nextLine());
        mangGhiChu.get(index).setThoiGianChinhSuaLanCuoi(thoiGian());
        println("Sua Noi dung thanh cong");
    }

    public static void suaTask() {
        mangGhiChu.get(index).hienThiDanhSachViec();
        println("Nhap so thu tu task can sua");
        byte stt = 0;
        stt = kiemTraSTTTask(stt);
        int indexTask = stt - 1;
        println("Nhap noi dung can sua.");
        System.out.printf("Task thu %d:\n", stt);
        String ndTaskMoi = sc.nextLine();

        String noiDungTask = mangGhiChu.get(index).danhSachViec[indexTask];
        noiDungTask = ndTaskMoi;
        mangGhiChu.get(index).setThoiGianChinhSuaLanCuoi(thoiGian());
        tiepTucSuaTask();
    }

    public static byte kiemTraSTTTask(byte stt) {
        stt = kiemTraSo(stt);
        while (true) {
            int length = mangGhiChu.get(index).danhSachViec.length;

            if (!(stt > length || stt < 0)) break;
            println("Sai so thu tu. Nhap lai: ");
            stt = kiemTraSo(stt);
        }

        return stt;
    }

    public static void tiepTucSuaTask() {
        println("Sua Task thanh cong");
        String traLoi = cauHoiCoKhong();

        if (traLoi.equals(CO)) {
            suaTask();
        } else println("Chinh sua Task hoan tat.");
    }

    public static String cauHoiCoKhong() {
        println("Ban muon sua tiep khong? Co(C)/Khong(K)");
        String traLoi = sc.nextLine();
        traLoi = kiemTraCauTraLoi(traLoi);

        return traLoi;
    }

    public static void tiepTucChinhSua() {
        String canSua = cauHoiCoKhong();
        if (canSua.equals(CO)) {
            suaTrongMotGhiChu();
        } else println("Chinh sua hoan tat.");
    }

    public static void xoaGhiChu() {
        println("XOA GHI CHU");
        boolean timTieuDe = timTieuDe();
        if (timTieuDe) {
            println("Ghi chu can xoa la:");
            String tieuDe = mangGhiChu.get(index).getTieuDe();
            String noiDung = mangGhiChu.get(index).getNoiDung();

            println(tieuDe);
            System.out.printf("%-5s%s\n", " ", noiDung);
            println("Ban co muon xoa khong? Co(C)/Khong(K)");
            String traloi = sc.nextLine();
            traloi = kiemTraCauTraLoi(traloi);
            if (traloi.equals(CO)) {
                mangGhiChu.remove(index);
                println("Da xoa thanh cong");
            } else println("Huy xoa");
        }
    }

    public static String kiemTraCauTraLoi(String traloi) {
        traloi = traloi.toLowerCase();
        while (!traloi.equals(CO) && !traloi.equals(KHONG)) {
            println("Nhap du lieu sai. Nhap lai.");
            traloi = sc.nextLine();
            traloi = traloi.toLowerCase();
        }

        return traloi;
    }

    public static void xemDanhSachGhiChu() {
        println("DANH SACH GHI CHU");
        sort();
        if(mangGhiChu.size()!=0) {
            byte stt = 0;
            for (GhiChu ghiChu : mangGhiChu) {
                stt++;
                println(stt + ".");
                ghiChu.hienThiGhiChu();
                println(DAU_GACH_CHIA_TASK);
            }
        } else println("Chua co ghi chu nao");

    }

    public static void hienThiGhiChuCanTim() {
        if (timTieuDe()) {
            mangGhiChu.get(index).hienThiGhiChu();
        } else println("Khong tim thay");
        phanDay();
    }

    public static byte kiemTraSo(byte num) {
        String str;
        while (true) {
            try {
                str = sc.nextLine();
                num = Byte.parseByte(str);
                break;
            } catch (Exception ex) {
                println("Khong phai dang so. Nhap lai:");
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
