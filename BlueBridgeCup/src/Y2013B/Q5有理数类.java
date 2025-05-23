package Y2013B;

/**
 * @author Hyper
 * @date 2022/03/15
 */
public class Q5有理数类 {
    public static void main(String[] args) {
        Rational a = new Rational(1, 3);
        Rational b = new Rational(1, 6);
        Rational c = a.add(b);
        System.out.println(a + "+" + b + "=" + c);
    }

    private static class Rational {
        private long ra;
        private long rb;

        //辗转相除法求最大公约数gcd
        private long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        public Rational(long a, long b) {
            ra = a;
            rb = b;
            long k = gcd(ra, rb);
            if (k > 1) { //需要约分
                ra /= k;
                rb /= k;
            }
        }

        // 加法
        public Rational add(Rational x) {
            return new Rational(ra * x.rb + x.ra * rb, rb * x.rb);  //填空位置
        }

        // 乘法
        public Rational mul(Rational x) {
            return new Rational(ra * x.ra, rb * x.rb);
        }

        public String toString() {
            if (rb == 1) return "" + ra;
            return ra + "/" + rb;
        }
    }
}
