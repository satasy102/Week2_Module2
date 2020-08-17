public class phanLoaiTamGiac {
    public static String loaiTamGiac(int a, int b, int c){
        String ketQua=null;
        if(a+b>c && a+c>b && c+b>a && a>0 && b>0 && c>0) {
            if (a == b && b == c) {
                ketQua = "Tam giac deu";
            } else if (a == b || a == c || b == c) {
                ketQua = "Tam giac can";
            } else ketQua = "Tam giac thuong";
        } else ketQua="Khong phai tam giac";
        return ketQua;
    }
}
