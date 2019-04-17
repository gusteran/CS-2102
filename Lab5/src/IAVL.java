
interface IAVL extends IBST{
	void balance();
}

class DataAVL extends DataBST implements IAVL {

	DataAVL(String data, IBST left, IBST right) {
		super(data, left, right);
		balance();
	}
	
	DataAVL(String data){
		super(data);
	}
	
	public void balance() {}
	
}
