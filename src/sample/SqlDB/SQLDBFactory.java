package sample.SqlDB;

public class SQLDBFactory implements IDBSQL {
    @Override
    public void saveGrid(String grid) {
        IDBSQL Isql = new SQLDBLayer();
        Isql.saveGrid(grid);
    }

    @Override
    public String getGrid() {
        IDBSQL Isql = new SQLDBLayer();
        Isql.getGrid();
        return "";
    }
}
