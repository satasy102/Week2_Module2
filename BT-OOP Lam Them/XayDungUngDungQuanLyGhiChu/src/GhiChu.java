import java.util.Date;

public class GhiChu implements Comparable<GhiChu>{
    private String tieuDe;
    private String noiDung;
    public String[] danhSachViec;
    private Date thoiGianTao;
    private Date thoiGianChinhSuaLanCuoi;
    public static short soGhiChu;

    public GhiChu() {soGhiChu++;}

    public GhiChu(String tieuDe, String noiDung, Date thoiGianTao) {
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.thoiGianTao = thoiGianTao;
        soGhiChu++;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String[] getDanhSachViec() {
        return danhSachViec;
    }

    public void setDanhSachViec(String[] danhSachViec) {
        this.danhSachViec = danhSachViec;
    }

    public void hienThiDanhSachViec() {
        byte stt = 0;
        for (String task : danhSachViec) {
            stt++;
            System.out.printf("    %d. Task thu %d: %s\n", stt, stt, task);
        }
    }

    public Date getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Date thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public Date getThoiGianChinhSuaLanCuoi() {
        return thoiGianChinhSuaLanCuoi;
    }

    public void setThoiGianChinhSuaLanCuoi(Date thoiGianChinhSuaLanCuoi) {
        this.thoiGianChinhSuaLanCuoi = thoiGianChinhSuaLanCuoi;
    }

    public void hienThiGhiChu(){
        System.out.println("Tieu de:"  + tieuDe);
        System.out.println("Noi dung: " + noiDung);
        System.out.println("Danh sach viec:" ); hienThiDanhSachViec();
        System.out.println("Thoi gian tao: " + thoiGianTao);
        System.out.println("Thoi gian chinh sua lan cuoi: "+ thoiGianChinhSuaLanCuoi);
    }

    @Override
    public int compareTo(GhiChu o) {
        if (getThoiGianChinhSuaLanCuoi() == null || o.getThoiGianChinhSuaLanCuoi() == null)
            return 0;
        return getThoiGianChinhSuaLanCuoi().compareTo(o.getThoiGianChinhSuaLanCuoi());
    }

}


