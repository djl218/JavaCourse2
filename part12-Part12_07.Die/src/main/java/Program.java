public class Program {

    public static void main(String[] args) {
        Die die = new Die(6);

        int i = 0;
        while (i < 10) {
            System.out.println(die.throwDie());
            i++;
        }
    }
}
