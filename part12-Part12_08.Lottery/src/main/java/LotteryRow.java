import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {
    private ArrayList<Integer> numbers;

    public LotteryRow() {
        this.numbers = new ArrayList<>();
        randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return numbers;
    }

    public void randomizeNumbers() {
        numbers.clear();
        
        while (numbers.size() < 7) {
            Random random = new Random();
            int num = random.nextInt(40) + 1;
            
            if (!containsNumber(num)) {
                numbers.add(num);
            }
        }
    }

    public boolean containsNumber(int number) {
        if (numbers.contains(number)) {
            return true;
        }
        
        return false;
    }
}

