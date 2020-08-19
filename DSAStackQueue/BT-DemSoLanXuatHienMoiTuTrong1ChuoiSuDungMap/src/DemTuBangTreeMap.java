import java.util.Scanner;
import java.util.TreeMap;

public class DemTuBangTreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap 1 chuoi gom nhieu tu:");
        String str = sc.nextLine();
        str = str.toLowerCase();
        str = chuanHoa(str);

        if (str.equals("")) {
            System.out.println("Khong co tu nao");
        } else {
            String[] mangChuoi = str.split("\\s");

            for (String s : mangChuoi) {
                if (map.containsKey(s)) {
                    int value = map.get(s);
                    value++;
                    map.put(s, value);
                } else {
                    map.put(s, 1);
                }
            }
            System.out.println(map);
        }
    }

    public static String chuanHoa(String str) {
        str = str.replaceAll("\\s+", " ");
        str = str.trim();
        return str;
    }
}
