package Y2021B;

public class B {
    public static void main(String[] args) {
        int[] cards = new int[10];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = 2021;
        }

        int ans = 0;
        boolean flag = false;
        for (int i = 1; i <= 10000 && !flag; i++) {
            String num = String.valueOf(i);
            for (char c : num.toCharArray()) {
                int idx = Integer.parseInt(String.valueOf(c));
                cards[idx]--;
                if (cards[idx] < 0) {
                    flag = true;
                    ans = i - 1;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
