public class LevelUpFizzBuzz {
    public static String printfFizzBuzz(int number) {
        if (number >= 100) return "Khong ho tro";
        else {
            int hangChuc = number / 10;
            int hangDonVi = number % 10;

            String chuoiHangDonVi = String.valueOf(hangDonVi);
            String chuoiHangChuc = String.valueOf(hangChuc);

            chuoiHangDonVi = hangDonVi(chuoiHangDonVi);
            chuoiHangChuc = hangChuc(chuoiHangChuc);

            String result=chuoiHangChuc+" "+chuoiHangDonVi;
            result=result.trim();
            return result;
        }
    }

    public static String hangChuc(String chuoiHangChuc) {
        switch (chuoiHangChuc) {
            case "1" -> chuoiHangChuc = chuoiHangChuc.replace("1", "Mot");
            case "2" -> chuoiHangChuc = chuoiHangChuc.replace("2", "Hai");
            case "3" -> chuoiHangChuc = chuoiHangChuc.replace("3", "Fizz");
            case "4" -> chuoiHangChuc = chuoiHangChuc.replace("4", "Bon");
            case "5" -> chuoiHangChuc = chuoiHangChuc.replace("5", "Buzz");
            case "6" -> chuoiHangChuc = chuoiHangChuc.replace("6", "Sau");
            case "7" -> chuoiHangChuc = chuoiHangChuc.replace("7", "Bay");
            case "8" -> chuoiHangChuc = chuoiHangChuc.replace("8", "Tam");
            case "9" -> chuoiHangChuc = chuoiHangChuc.replace("9", "Chin");
            case "0" -> chuoiHangChuc = chuoiHangChuc.replace("0", "");
        }
        return chuoiHangChuc;
    }

    public static String hangDonVi(String chuoiHangDonVi) {
        switch (chuoiHangDonVi) {
            case "1" -> chuoiHangDonVi = chuoiHangDonVi.replace("1", "mot");
            case "2" -> chuoiHangDonVi = chuoiHangDonVi.replace("2", "hai");
            case "3" -> chuoiHangDonVi = chuoiHangDonVi.replace("3", "Fizz");
            case "4" -> chuoiHangDonVi = chuoiHangDonVi.replace("4", "bon");
            case "5" -> chuoiHangDonVi = chuoiHangDonVi.replace("5", "Buzz");
            case "6" -> chuoiHangDonVi = chuoiHangDonVi.replace("6", "sau");
            case "7" -> chuoiHangDonVi = chuoiHangDonVi.replace("7", "bay");
            case "8" -> chuoiHangDonVi = chuoiHangDonVi.replace("8", "tam");
            case "9" -> chuoiHangDonVi = chuoiHangDonVi.replace("9", "chin");
            case "0" -> chuoiHangDonVi = chuoiHangDonVi.replace("0", "khong");
        }
        return chuoiHangDonVi;
    }


}
