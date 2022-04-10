package Y2022B;

public class B {
    public static void main(String[] args) {
        int ans = 0;
        for (int i = 2022; i <= 2022222022; i++) {
            if (checked(i)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean checked(int i) {
        String string = String.valueOf(i);
        int p1 = 0;
        int p2 = string.length() - 1;
        while (p1 <= p2) {
            if (string.charAt(p1) != string.charAt(p2)) {
                return false;
            }
            if (p1 != 0 && p2 != string.length() - 1) {
                if (string.charAt(p1 - 1) > string.charAt(p1) || string.charAt(p2) < string.charAt(p2 + 1)) {
                    return false;
                }
            }
            p1++;
            p2--;
        }
        return true;
    }
}
