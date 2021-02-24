package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {

    int size = 100;
    float cellSize;
    boolean[][] board = new boolean[size][size];
    boolean[][] next = new boolean[size][size];

    public int countNeighbours(int row, int col)
    {
        int count = 0;
        
        for(int r = row -1 ; r <= row + 1; r ++)
        {
            for(int c = col -1 ; c <= col + 1; c ++)
            {
                if (! (r == row && c == col))
                {
                    if (getCell(board, r, c))
                    {
                        count ++;
                    }
                }
            }
        }

        // OR Use 8 if statements
        /*
        if (getCell(board, row-1, col-1))
        {
            count ++;
        }
        if (getCell(board, row-1, col))
        {
            count ++;
        }
        if (getCell(board, row-1, col+1))
        {
            count ++;
        }
        if (getCell(board, row, col-1))
        {
            count ++;
        }
        if (getCell(board, row, col+1))
        {
            count ++;
        }
        if (getCell(board, row+1, col-1))
        {
            count ++;
        }
        if (getCell(board, row+1, col))
        {
            count ++;
        }
        if (getCell(board, row+1, col+1))
        {
            count ++;
        }
        */
        
        return count;
    }

    public void setCell(boolean[][] board, int row, int col, boolean b)
    {
        if (row >= 0 && row < size -1 && col >= 0 && col < size -1)
        {
            next[row][col] = b;
        }
    }

    public boolean getCell(boolean[][] board, int row, int col)
    {
        if (row >= 0 && row < size -1 && col >= 0 && col < size -1)
        {
            return board[row][col];
        }
        else
        {
            return false;
        }        
    }

    float offset = 0;
    public void drawBoard(boolean[][] board)
    {
        // Use a nested loop
        // Use map to calculate x and y
        // Rect draw the cell
        // Use the cell size variable
        // Use some colours!
        float cGap = 255 / (float)size;
        offset += (mouseX / 100);
        colorMode(HSB);
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                // float ran = random(3.0f, (float)cellSize * 2);
                float x = map(col, 0, size, 0, width);
                float y = map(row, 0, size, 0, height);
                if (board[row][col])
                {
                    float c = ((cGap * (row + col)) + offset) % 255;
                    fill(c, 255 , 255);
                    rect(x, y, cellSize, cellSize);
                }
            }
        }

    }

    private void printBoard(boolean[][] board)
    {
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                print(board[row][col] ? 1 : 0);
            }
            println();
        }        
    }

    public void randomize()
    {
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                float dice = random(0.0f, 1.0f);
                /*
                if (dice < 0.5)
                {
                    board[row][col] = true;
                }
                else
                {
                    board[row][col] = false;
                }
                */
                board[row][col] = (dice < 0.5f) ? true : false;
            }
        }
    }

    public void settings()
    {
        size(500, 500);
    }
    
    int mode = 0;
    boolean paused = false;
    public void keyPressed() {
        if (keyCode == ' ')
        {
        }
        
        if (keyCode == '1')
        {
            randomize();
        }
        if (keyCode == '2')
        {
            clearBoard(board);
        }
        if (keyCode == '3')
        {
        }
            
    }
    
 

    void clearBoard(boolean[][] board) {
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                board[row][col] = false;
            }
        }   
    }

    public void setup() {
        colorMode(RGB);
        randomize();
        
        /*
        board[0][1] = true;
        board[1][2] = true;
        board[3][2] = true;
        */
        println(countNeighbours(0, 2));

        cellSize = width / (size);
        
        //printBoard(board);        
    }

    private void updateBoard()
    {
        float cGap = 255 / (float) size;
        colorMode(HSB);
        // Put code here to apply the rules!!
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size ; col++) {
                if(getCell(board, row, col)) {
                    if(countNeighbours(row, col) == 2 || countNeighbours(row, col) == 3) {
                        // next[row][col] = true;
                        setCell(next, row, col, true);
                    } else {
                        // next[row][col] = false;
                        setCell(next, row, col, false);

                    }
                } else {
                    if(countNeighbours(row, col) == 3) {
                        // next[row][col] = true;
                        setCell(next, row, col, true);

                    } else {
                        // next[row][col] = false;
                        setCell(next, row, col, false);

                    }
                }
            }
        }

        
        // Swap board and next
        boolean[][] temp = board;
        board = next;
        next = temp;
    }

    public void mouseDragged()
    {
        // This method gets called automatically when the mouse is dragged across the screen
        int col = (int) (map(pmouseX, 0, width, 0, size-1)) % size;
        int row = (int) (map(pmouseY, 0, height, 0, size-1)) % size;        

        board[row][col] = true;

        col = (int) (map(mouseX, 0, width, 0, size-1)) % size;
        row = (int) (map(mouseY, 0, height, 0, size-1)) % size;

        println("col-> " + col);
        println("row->" + row);


        board[row][col] = true;


         
        // for (int col = 0 ; col < size ; col ++)
        // {
        //     float x = map(size / 2, 0, size, 0, width);
        //     int x1 = (int)x;
        //     float y = map(pos, 0, size, 0, height);
        //     fill(50, 255 , 255);
        //     board[x1][col] = true;
        //     rect(x, y, cellSize, cellSize);
        // }
   

    }

    public void draw() {
        frameRate(10);
        background(0);
        drawBoard(board);
        updateBoard();
    }
}
