package sample;

public class CUI extends UILayer{
    public CUI(int windowWidth, int windowHeight, int size){
        super(windowWidth, windowHeight, size);
    }
    @Override
    public void display(){
        char [][] grid = super.getCharGrid();
        System.out.print(" ");
        for (int i=1; i<super.getWindowHeight()/getSize(); i++){
            System.out.println(i + " ");
        }
        System.out.println();
        for (int i=0; i<super.getWindowWidth()/getSize(); i++){
            System.out.print(i + " ");
            for (int f = 0; f<super.getWindowHeight()/getSize(); f++){
                System.out.println(grid[i][f] + " ");
            }
        }
    }

}
