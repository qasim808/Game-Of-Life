package bin.Interfaces.StorageInterface;


public interface StorageInterface {
	public String viewStates();

    public void LoadState(String GridID);

    public void saveState(String GridID,int RowNo,int ColNo,Boolean bit);

	public void deleteState(String GridID);
}
