package bank;

class Main {
  public static void main(String[] args) {
	BankingService B = new Examples().setUpGompei(); 
    BankingConsole C = new BankingConsole(B);
    C.loginScreen();
  }
}
