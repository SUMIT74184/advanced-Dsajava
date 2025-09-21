package Recursion_;

public class Sudoku {

    private static boolean isSafe(int [][]b,int row,int col,int num){

        //check row
        for(int r=0;r<9;r++){
            if(b[r][col]==num){
                return false;
            }
        }

        //check column
        for(int c=0;c<9;c++){
            if(b[row][c]==num){
                return false;
            }
        }
        // checking the subgrid first
        int boxStartRow=(row/3)*3;
        int boxStartCol=(col/3)*3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
            if(b[boxStartRow+r][boxStartCol+c]==num){ //i found this part as difficult at beginning
                return false;
            }


            }
        }
        return true;
    }

    public static boolean solve(int [][]b){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(b[row][col]==0){
                    //try all the number present

                    for(int num=1;num<=9;num++){
                        if(isSafe(b,row,col,num)){
                            b[row][col]=num;

                            if(solve(b)) return true;
                            b[row][col]=0;
                        }
                    }
                    return false;  //no number works in this please leave it
                }
            }
        }
        return true;
    }

    public static void printBoard(int [][]b){
        int N= b.length;
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                System.out.print(b[r][c]+" ");
            }
            System.out.println();
        }
    }

//    r = row offset inside the box (0,1,2)
//    c = col offset inside the box (0,1,2)
//    Actual cell checked = (boxStartRow + r, boxStartCol + c)
//    For boxStartRow=3, boxStartCol=6, the loop checks:
//            (3+0, 6+0) = (3,6)
//            (3+0, 6+1) = (3,7)
//            (3+0, 6+2) = (3,8)
//            (3+1, 6+0) = (4,6)
//            (3+1, 6+1) = (4,7)
//            (3+1, 6+2) = (4,8)
//            (3+2, 6+0) = (5,6)
//            (3+2, 6+1) = (5,7) ← the cell we want to fill
//            (3+2, 6+2) = (5,8)

    public static void main(String[] args) {
        int[][] board = {
                {5,3,0, 0,7,0, 0,0,0},
                {6,0,0, 1,9,5, 0,0,0},
                {0,9,8, 0,0,0, 0,6,0},

                {8,0,0, 0,6,0, 0,0,3},
                {4,0,0, 8,0,3, 0,0,1},
                {7,0,0, 0,2,0, 0,0,6},

                {0,6,0, 0,0,0, 2,8,0},
                {0,0,0, 4,1,9, 0,0,5},
                {0,0,0, 0,8,0, 0,7,9}
        };

        if (solve(board)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }
    }
}
