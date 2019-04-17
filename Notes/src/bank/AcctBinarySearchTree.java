package bank;

public class AcctBinarySearchTree implements IAcctDataStructure {

	private Account thisAcct;
	private AcctBinarySearchTree left;
	private AcctBinarySearchTree right;
	
	public Account findByNumber(int acctNum) {
	    if(thisAcct.checkNumber(acctNum)) 
	    	return thisAcct;
	    //else if acctNum is smaller, recurse down left subtree
	    //else recurse down right subtree
	    return null;
	}
}
