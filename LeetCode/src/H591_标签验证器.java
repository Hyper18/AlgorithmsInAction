/**
 * @author Hyper
 * @date 2022/05/02
 */
public class H591_标签验证器 {
    public boolean isValid(String code) {
        code = code.replaceAll("<!\\[CDATA\\[.*?\\]\\]>|t", "-");
        String temp = "";
        while (!temp.equals(code)) {
            temp = code;
            code = code.replaceFirst("<([A-Z]{1,9})>[^<]*</\\1>", "t");
        }
        return "t".equals(code);
    }
}
