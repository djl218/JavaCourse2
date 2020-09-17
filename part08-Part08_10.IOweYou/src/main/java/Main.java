public class Main {

    public static void main(String[] args) {
        IOU dansIOU = new IOU();
        dansIOU.setSum("Arthur", 51.5);
        dansIOU.setSum("Michael", 30);
        
        System.out.println(dansIOU.howMuchDoIOweTo("Arthur"));
        System.out.println(dansIOU.howMuchDoIOweTo("Michael"));
    }
}
