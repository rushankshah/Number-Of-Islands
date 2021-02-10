public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] islands = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
        System.out.println(numberOfIslands(islands));
    }

    static int numberOfIslands(int[][] islands) {
        int numberOfIslands = 0;
        int numberOfRows = islands.length;
        if (numberOfRows == 0)
            return numberOfIslands;
        int numberOfColumns = islands[0].length;
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (islands[i][j] == 1) {
                    markAsVisited(islands, i, j, numberOfRows, numberOfColumns);
                    numberOfIslands += 1;
                }
            }
        }
        return numberOfIslands;
    }

    static int[][] markAsVisited(int[][] islands, int row, int column, int numberOfRows, int numberOfColumns) {
        if (row < 0 || row >= numberOfRows || column < 0 || column >= numberOfColumns || islands[row][column] != 1)
            return islands;
        islands[row][column] = 2;

        islands = markAsVisited(islands, row + 1, column, numberOfRows, numberOfColumns);
        islands = markAsVisited(islands, row, column + 1, numberOfRows, numberOfColumns);
        islands = markAsVisited(islands, row - 1, column, numberOfRows, numberOfColumns);
        islands = markAsVisited(islands, row, column - 1, numberOfRows, numberOfColumns);

        return islands;
    }
}
