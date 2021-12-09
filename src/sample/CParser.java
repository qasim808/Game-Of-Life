package sample;

public class CParser implements IController{

    public CParser(){

    }
    @Override
    public char[][] BtnClick_handleStart(char[][] grid) {
        IController ic = new Controller();
        return ic.BtnClick_handleStart(grid);
    }

    @Override
    public char[][] BtnClick_handleNext(char[][] grid) {
        IController ic = new Controller();
        return ic.BtnClick_handleNext(grid);
    }
}
