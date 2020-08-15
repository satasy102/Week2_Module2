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
        System.out.println("\nNhap lua chon cua ban");
        String nhap = sc.nextLine();
        while (true) {
            switch (nhap) {
                case "C" -> taoMoiGhiChu();
                case "U" -> chinhSuaGhiChu();
                case "D" -> xoaGhiChu();
                case "L" -> xemDanhSachGhiChu();
                case "F" -> hienThiGhiChuCanTim();
                default -> System.out.println("Ban da nhap sai Menu. Hay nhao lai.");
            }
            menu();
            System.out.println("\nNhap lua chon cua ban");
            nhap = sc.nextLine();
        }
    }

    public static void sort() {
        Collections.sort(mangGhiChu);
        Collections.reverse(mangGhiChu);
    }

    public static void hienThiBaGhiChuGanNhat() {
        System.out.println(" ");
        int size = mangGhiChu.size();
        if (size ==0) {
            System.out.println("Hien tai chua co ghi chu nao");
        } else if (size <= 3) {
            byte stt=0;
            for (GhiChu ghiChu : mangGhiChu) {
                stt++;
                System.out.printf("   %d %s\n",stt,ghiChu.getTieuDe());
                System.out.printf("      %s\n",ghiChu.getNoiDung());
            }
        }else {
            byte stt=0;
            for (byte i=0; i<3;i++) {
                stt++;
                System.out.printf("   %d %s\n",stt,mangGhiChu.get(i).getTieuDe());
                System.out.printf("      %s\n",mangGhiChu.get(i).getNoiDung());
            }
        }
    }


    public static void menu() {
        System.out.println("MENU");
        System.out.println("Tao Ghi Chu bam C");
        System.out.println("Sua Ghi Chu bam U");
        System.out.println("Xoa Ghi Chu bam D");
        System.out.println("Xem Danh Sach bam L");
        System.out.println("Xem Ghi Chu bam F");
        sort();

        hienThiBaGhiChuGanNhat();

    }

    public static Date thoiGian() {
        return new java.util.Date();
    }

    public static byte soTaskCanLam() {
        System.out.println("Nhap so task can lam:");
        byte task = 0;
        task = kiemTraSo(task);
        while (task > 20) {
            System.out.println("Vuot qua so task quy dinh.Nhap lai: ");
            task = sc.nextByte();
        }
        return task;
    }

    public static String[] taskCongViec() {
        byte task = soTaskCanLam();
        String[] congViec = new String[task];
        for (byte i = 0; i < task; i++) {
            int stt = i + 1;
            System.out.println("Nhap cong viec task thu " + stt + ":");
            congViec[i] = sc.nextLine();
        }

        return congViec;
    }

    public static void phanDay() {
        System.out.println(DAU_GACH_PHAN_DAY);
    }

    public static void taoMoiGhiChu() {
        System.out.println("TAO MOI GHI CHU");
        if (GhiChu.soGhiChu >= 128) {
            System.out.println("Da vuot qua gioi han cho phep de tao Ghi Chu moi.");
        } else {
            GhiChu ghiChu = new GhiChu();
            ghiChu.setThoiGianTao(thoiGian());
            System.out.println("Nhap Tieu De:");
            ghiChu.setTieuDe(sc.nextLine());
            System.out.println("Nhap Noi Dung:");
            ghiChu.setNoiDung(sc.nextLine());
            ghiChu.setDanhSachViec(taskCongViec());
            System.out.println("Ban da nhap ghi chu thanh cong");
            ghiChu.setThoiGianChinhSuaLanCuoi(thoiGian());
            mangGhiChu.add(ghiChu);
        }
        phanDay();
    }

    public static void chinhSuaGhiChu() {
        System.out.println("CHINH SUA GHI CHU");
        System.out.println("Tim ghi chu can sua:");
        if (timTieuDe()) suaTrongMotGhiChu();
        else System.out.println("Khong tim thay Ghi chu");
        phanDay();
    }

    public static boolean timTieuDe() {
        System.out.println("Nhap tieu de Ghi Chu can tim:");
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
        hienThiGhiChuCanTim();
        System.out.println("Ban muon sua phan nao? (Tieu de, Noi dung, Task, hoac K (Khong))");
        String canSua = sc.nextLine();
        canSua = canSua.toLowerCase();
        if (!canSua.equals("k")) {
            if (canSua.equals(TIEU_DE)) suaTieuDe();
            if (canSua.equals(NOI_DUNG)) suaNoiDung();
            if (canSua.equals(TASK)) suaTask();
            tiepTucChinhSua();
        } else System.out.println("Khong chinh sua gi");
    }

    public static void suaTieuDe() {
        System.out.println("Tieu de Moi:");
        mangGhiChu.get(index).setTieuDe(sc.nextLine());
        mangGhiChu.get(index).setThoiGianChinhSuaLanCuoi(thoiGian());
        System.out.println("Sua tieu de thanh cong");
    }

    public static void suaNoiDung() {
        System.out.println("Noi dung Moi:");
        mangGhiChu.get(index).setNoiDung(sc.nextLine());
        mangGhiChu.get(index).setThoiGianChinhSuaLanCuoi(thoiGian());
        System.out.println("Sua Noi dung thanh cong");
    }

    public static void suaTask() {
        mangGhiChu.get(index).hienThiDanhSachViec();
        System.out.println("Nhap so thu tu task can sua");
        byte stt = 0;
        stt = kiemTraSTTTask(stt);
        int indexTask = stt - 1;
        System.out.println("Nhap noi dung can sua.");
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
            System.out.println("Sai so thu tu. Nhap lai: ");
            stt = kiemTraSo(stt);
        }

        return stt;
    }

    public static void tiepTucSuaTask() {
        System.out.println("Sua Task thanh cong");
        String traLoi = cauHoiCoKhong();

        if (traLoi.equals(CO)) {
            suaTask();
        } else System.out.println("Chinh sua Task hoan tat.");
    }

    public static String cauHoiCoKhong() {
        System.out.println("Ban muon sua tiep khong? Co(C)/Khong(K)");
        String traLoi = sc.nextLine();
        traLoi = kiemTraCauTraLoi(traLoi);

        return traLoi;
    }

    public static void tiepTucChinhSua() {
        String canSua = cauHoiCoKhong();
        if (canSua.equals(CO)) {
            suaTrongMotGhiChu();
        } else System.out.println("Chinh sua hoan tat.");
    }

    public static void xoaGhiChu() {
        System.out.println("XOA GHI CHU");
        if (timTieuDe()) {
            System.out.println("Ghi chu can xoa la:");
            String tieuDe = mangGhiChu.get(index).getTieuDe();
            String noiDung = mangGhiChu.get(index).getNoiDung();

            System.out.println(tieuDe);
            System.out.printf("%-5s%s\n", " ", noiDung);
            System.out.println("Ban co muon xoa khong? Co(C)/Khong(K)");
            String traloi = sc.nextLine();
            traloi = kiemTraCauTraLoi(traloi);
            if (traloi.equals(CO)) {
                mangGhiChu.remove(index);
                System.out.println("Da xoa thanh cong");
            } else System.out.println("Huy xoa");
        }
    }

    public static String kiemTraCauTraLoi(String traloi) {
        traloi = traloi.toLowerCase();
        while (!traloi.equals(CO) && !traloi.equals(KHONG)) {
            System.out.println("Nhap du lieu sai. Nhap lai.");
            traloi = sc.nextLine();
            traloi = traloi.toLowerCase();
        }

        return traloi;
    }

    public static void xemDanhSachGhiChu() {
        System.out.println("DANH SACH GHI CHU");
        sort();
        byte stt = 0;
        for (GhiChu ghiChu : mangGhiChu) {
            stt++;
            System.out.println(stt + " ");
            ghiChu.hienThiGhiChu();
            System.out.println(DAU_GACH_CHIA_TASK);
        }

    }

    public static void hienThiGhiChuCanTim() {
        if (timTieuDe()) {
            mangGhiChu.get(index).hienThiGhiChu();
        } else System.out.println("Khong tim thay");
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
                System.out.println("Khong phai dang so. Nhap lai:");
            }
        }

        return num;
    }

}
