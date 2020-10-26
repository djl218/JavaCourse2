public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {
        MagicSquare square = new MagicSquare(size);
        int num = 1;
        int row = 0;
        int column = size / 2;
        int old_row;
        int old_col;
        
        while (num <= size * size) {
            square.placeValue(column, row, num);
            num++;
            old_row = row;
            old_col = column;
            row -= 1;
            column += 1;
            
            if (row == -1) {
                row = size - 1;
            }
            if (column == size) {
                column = 0;
            }
            if (square.readValue(column, row) != 0) {
                row = old_row + 1;
                column = old_col;
                if (row == -1) {
                    row = size - 1;
                }
            }
        }
        
        return square;
    }
}
