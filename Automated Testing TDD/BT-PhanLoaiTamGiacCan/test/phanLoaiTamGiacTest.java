import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class phanLoaiTamGiacTest {
    @Test
    void tamGiac222() {
        int a=2;
        int b=2;
        int c=2;
        String expected="Tam giac deu";
        String result=phanLoaiTamGiac.loaiTamGiac(a,b,c);
        assertEquals(expected,result);
    }

    @Test
    void tamGiac223() {
        int a=2;
        int b=2;
        int c=3;
        String expected="Tam giac can";
        String result=phanLoaiTamGiac.loaiTamGiac(a,b,c);
        assertEquals(expected,result);
    }

    @Test
    void tamGiac232() {
        int a=2;
        int b=3;
        int c=2;
        String expected="Tam giac can";
        String result=phanLoaiTamGiac.loaiTamGiac(a,b,c);
        assertEquals(expected,result);
    }

    @Test
    void tamGiac322() {
        int a=3;
        int b=2;
        int c=2;
        String expected="Tam giac can";
        String result=phanLoaiTamGiac.loaiTamGiac(a,b,c);
        assertEquals(expected,result);
    }

    @Test
    void tamGiac345() {
        int a=3;
        int b=4;
        int c=5;
        String expected="Tam giac thuong";
        String result=phanLoaiTamGiac.loaiTamGiac(a,b,c);
        assertEquals(expected,result);
    }

    @Test
    void tamGiac823() {
        int a=8;
        int b=2;
        int c=3;
        String expected="Khong phai tam giac";
        String result=phanLoaiTamGiac.loaiTamGiac(a,b,c);
        assertEquals(expected,result);
    }

    @Test
    void tamGiacNagative121() {
        int a=-1;
        int b=2;
        int c=1;
        String expected="Khong phai tam giac";
        String result=phanLoaiTamGiac.loaiTamGiac(a,b,c);
        assertEquals(expected,result);
    }

    @Test
    void tamGiac011() {
        int a=0;
        int b=1;
        int c=1;
        String expected="Khong phai tam giac";
        String result=phanLoaiTamGiac.loaiTamGiac(a,b,c);
        assertEquals(expected,result);
    }
}