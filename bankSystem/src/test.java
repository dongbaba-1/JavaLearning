import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Account currentAccount = new Account();
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        int temp;
        while(flag){
            atm.showInitPage();
            temp = sc.nextInt();
            switch (temp){
                case 1:
                    if(ATM.listOfAccounts.size() == 0){ // 系统中还没有账户
                        System.out.println("当前系统中无账户，请先去开户!");
                        continue;
                    }
                    currentAccount = atm.login();
                    while(true){
                        if(currentAccount == null){
                            break;
                        }
                        atm.showOperateList();
                        int choice = sc.nextInt();
                        switch (choice){
                            case 1:
                                atm.showAccountINfo(currentAccount);
                                break;
                            case 2:
                                atm.save(currentAccount);
                                break;
                            case 3:
                                atm.withDraw(currentAccount);
                                break;
                            case 4:
                                atm.transfer(currentAccount);
                                break;
                            case 5:
                                atm.updatePwd(currentAccount);
                                break;
                            case 6:
                                if(atm.logout()){
                                    currentAccount = null;
                                }
                                break;
                            case  7:
                                if(atm.deleteAccount(currentAccount))
                                    currentAccount = null;
                                break;
                        }
                    }
                    break;
                case 2:
                    atm.createAccount();
                    break;
                default:
                    System.out.println("请输入正确的数字！");
            }
            //flag = false;
        }
    }

}
