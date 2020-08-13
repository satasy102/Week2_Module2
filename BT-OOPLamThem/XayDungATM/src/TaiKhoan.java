import java.util.Scanner;

public class TaiKhoan {
    int i = 0;
    private String tenTK;
    private long soDuTK;
    private String[] lichSuGD = new String[700000000];

    public TaiKhoan(String tenTK, long soDuTK) {
        this.tenTK = tenTK;
        this.soDuTK = soDuTK;
    }

    public String getTenTK() {
        return tenTK;
    }

    public long getSoDuTK() {
        return soDuTK;
    }

    public String[] getLichSuGD() {
        return lichSuGD;
    }

    public long nhapTienNap() {
        System.out.println("Vui long nhap so tien can nap:");
        long tienNap = 0;
        tienNap = checkNumber(tienNap);
        return tienNap;
    }

    public void napTien() {
        long soTienNap = this.nhapTienNap();
        this.soDuTK += soTienNap;
        this.lichSuGD[i] = "Nap tien: " + soTienNap;
        i = i + 1;
        System.out.printf("Giao dich thanh cong. Ban vua nap %d thanh cong.\n", soTienNap);
        this.kiemTraTaiKhoan();
    }

    public boolean rutTien(long tienRut) {
        if (tienRut > this.getSoDuTK()) {
            return false;
        } else {
            this.soDuTK-=tienRut;
            this.lichSuGD[i] = "Rut tien: " + tienRut;
            i = i + 1;
            return true;
        }
    }

    public void kiemTraTaiKhoan() {
        System.out.println("So du tai khoan khach hang la: " + this.getSoDuTK());
        System.out.println("Bam nut theo menu de tiep tuc giao dich");
        System.out.println("===========================================");
    }

    public void lichSuGiaoDich() {
        int stt = 1;
        System.out.println("Lich su giao dich");
        for (int i = this.getLichSuGD().length - 1; i >= 0; i--) {
            if (this.getLichSuGD()[i] != null && stt <= 3) {
                System.out.printf("%-5d%S\n", stt, this.getLichSuGD()[i]);
                stt++;
            }
        }
        System.out.println("Bam nut theo menu de tiep tuc giao dich");
        System.out.println("===========================================");

    }

    public long checkNumber(long num) {
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

