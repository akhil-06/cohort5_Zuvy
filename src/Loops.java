public class Loops {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 5; i++) {
            if (i == 2) {
                continue;
            }
            for (int j = 1; j <= 4; j++) {
                if (j == i) {
                    break;
                }
                if (j % 2 == 0) {
                    continue;
                }
                System.out.println("i = " + i + ", j = " + j);
            }
            System.out.println("Loop " + i);
        }
    }
}
