public class KhachHang {
    private String tenKH;
    private String diaChi;
    private long soDienThoai;
    private String email;
    private boolean gioiTinh;
    private int soDonHangDaMua;
    public long ID=0;

    public KhachHang() {}

    public KhachHang(String tenKH, String diaChi, long soDienThoai, String email, boolean gioiTinh) {
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.gioiTinh = gioiTinh;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getSoDonHangDaMua() {
        return soDonHangDaMua;
    }

    public void setSoDonHangDaMua(int soDonHangDaMua) {
        this.soDonHangDaMua = soDonHangDaMua;
    }
}
