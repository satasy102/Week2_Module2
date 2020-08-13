public class ATM {
    private String tenTK;
    private long soDuTK;
    private String[] lichSuGD=new String[700000000];
    int i=0;

    public ATM(String tenTK, long soDuTK) {
        this.tenTK = tenTK;
        this.soDuTK = soDuTK;
    }

    public String getTenTK() {
        return tenTK;
    }

    public long getSoDuTK(){
        return soDuTK;
    }

    public String[] getLichSuGD() {
        return lichSuGD;
    }

    public void napTien(long soTienNap){
        this.soDuTK+=soTienNap;
        this.lichSuGD[i]="Nap tien: "+soTienNap;
        i=i+1;
    }

    public void rutTien(long soTienRut){
        this.soDuTK-=soTienRut;
        this.lichSuGD[i]="Rut tien: "+soTienRut;
        i=i+1;
    }
}
