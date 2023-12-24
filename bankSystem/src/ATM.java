import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class ATM {

    public static ArrayList<Account> listOfAccounts = new ArrayList<>(); //存储已创建的账户
    private final Scanner sc = new Scanner(System.in);
    public void showInitPage(){
        System.out.println("=========欢迎进入银行操作系统=========");
        System.out.println("1、用户登录");
        System.out.println("2、用户开户");
        System.out.print("请选择功能：");
    }

    public void showOperateList(){
        System.out.println("请选择您要办理的业务：");
        System.out.println("1、查询账户");
        System.out.println("2、存款");
        System.out.println("3、取款");
        System.out.println("4、转账");
        System.out.println("5、修改密码");
        System.out.println("6、退出");
        System.out.println("7、注销账户");
    }
    public Account login(){
        int index = 0;
        System.out.println("请输入您的卡号：");
        int inputId = sc.nextInt();
        if(!isIdExisted(inputId)){
            System.out.println("该卡号不存在！请确认后重试！");
            return null;
        }
        else {
            while(true){
                index = getAccountIndexById(inputId);
                System.out.println("请输入您的密码：");
                String inputPwd = sc.next();
                String pwd = listOfAccounts.get(index).getPassword();
                if(pwd.equals(inputPwd)){
                    System.out.println("欢迎您，" + listOfAccounts.get(index).getName() + "您已进入系统 您的卡号是：" + listOfAccounts.get(index).getId());
                    break;

                }
                else {
                    System.out.println("密码错误，请确认后重试！");
                }
            }
        }
        return listOfAccounts.get(index);

    }

    public void createAccount(){
        String inputGender = null;
        String inputPwd = null;
        String confirmPwd;
        int quota = 0;
        System.out.println("请输入您的账户名：");
        String inputName = sc.next();
        boolean genderFlag = true;
        while (genderFlag){
            System.out.println("请输入您的性别（男/女）：");
            inputGender = sc.next();
            if(!isGenderCorrect(inputGender)){
                System.out.println("您的输入有误，请确认后重新输入！");
                continue;
            }
            genderFlag = false;
        }

        boolean pwdEqualFlag = true;
        while (pwdEqualFlag){
            System.out.println("请输入您的账户密码：");
            inputPwd = sc.next();
            System.out.println("请确认您的账户密码：");
            confirmPwd = sc.next();
            if(isPwdEqual(inputPwd, confirmPwd)){
                break;
            }
            System.out.println("您两次输入的密码不一致，请确认后重新输入！");
        }

        System.out.println("请输入您的每次取现额度：");
        quota = sc.nextInt();
        Account newAccount = new Account(generateId(),inputName,inputGender,inputPwd,quota);
        listOfAccounts.add(newAccount);
        System.out.println(inputName + "您已成功开户！您的卡号为：" + newAccount.getId() + "  请妥善保管您的银行卡！");

    }

    public void showAccountINfo(Account currentAccount){
        System.out.println("=======当前账户信息如下=======");
        System.out.println("卡号：\t"  + currentAccount.getId());
        System.out.println("户主：\t" + currentAccount.getName());
        System.out.println("余额：\t" + currentAccount.getBalance());
        System.out.println("限额：\t" + currentAccount.getQuota());

    }

    public void save(Account currentAccount){
        System.out.println("请输入您的存款金额");
        double saveNum = sc.nextInt();
        double temp = currentAccount.getBalance() + saveNum;
        currentAccount.setBalance(temp);
        System.out.println("存款成功！您当前的余额为：" + currentAccount.getBalance());
    }

    public void withDraw(Account currentAccount){
        while (true){
            System.out.println("请输入您的取款金额：");
            double withDrawNum = sc.nextDouble();
            if(withDrawNum > currentAccount.getQuota()){
                System.out.println("超出取现额度！您的取现额度为：" + currentAccount.getQuota());
            }
            else if(withDrawNum > currentAccount.getBalance()){
                System.out.println("余额不足，您的余额为：" + currentAccount.getBalance());
            }
            else {
                currentAccount.setBalance(currentAccount.getBalance() - withDrawNum);
                System.out.println("本次取款" + withDrawNum + "元！ 账户余额：" + currentAccount.getBalance());
                break;
            }

        }
    }

    public void transfer(Account transferOutAccount){
        Account transferInAccount;
        System.out.println("============用户转账操作===========");
        while (true){
            System.out.println("请您输入收款账户卡号：");
            int receiveId = sc.nextInt();
            if(!isIdExisted(receiveId)){
                System.out.println("您输入的账户不存在，请确认后重试！");
            }
            else if(receiveId == transferOutAccount.getId()){
                System.out.println("您无法给你自己的账户转账！");
            }
            else {
                transferInAccount = listOfAccounts.get(getAccountIndexById(receiveId));
                while(true){
                    System.out.println("请补充对方账户信息以确认转账");
                    String transferedName = transferName(transferInAccount.getName(),'*');
                    System.out.println(transferedName);
                    char temp = sc.next().charAt(0);
                    String supplementName = transferName(transferedName,temp);
                    //String tempHideName = transferedName;
                    while(true) {
                        if (!isNameEqual(supplementName, transferInAccount.getName())) {
                            System.out.println("信息输入有误，请确认后重试！");
                            System.out.println("请补充对方账户信息以确认转账");
                            System.out.println(transferedName);
                            temp = sc.next().charAt(0);
                            supplementName = transferName(transferedName, temp);
                        }
                        else
                            break;
                    }
                    while(true){
                        System.out.println("请输入转账金额：");
                        double transferMoneyNum = sc.nextDouble();
                        if(transferMoneyNum > transferOutAccount.getBalance()){
                            System.out.println("转账失败，失败原因：您的余额不足，您的余额为：" + transferOutAccount.getBalance());
                        }
                        else if(transferMoneyNum > transferOutAccount.getQuota()){
                            System.out.println("转账失败，失败原因：超过限额，您的限额为：" + transferOutAccount.getQuota());
                        }
                        else {
                            transferOutAccount.setBalance(transferOutAccount.getBalance() - transferMoneyNum);
                            transferInAccount.setBalance(transferInAccount.getBalance() + transferMoneyNum);
                            System.out.println("转账成功，您的当前账户信息如下：");
                            showAccountINfo(transferOutAccount);
                            break;
                        }
                    }
                    break;
                }
            }
            break;
        }
    }

    public boolean logout(){
        System.out.println("您确定要退出当前账户吗？Y：是 else：不是");
        char ch = sc.next().charAt(0);
        if(ch == 'Y'){
            System.out.println("您已成功退出当前账户，即将返回主页面！");
            return true;
        }
        else {
            System.out.println("取消退出操作！");
            return false;
        }

    }

    public void updatePwd(Account currentAccount){
        System.out.println("请输入您的原密码：");
        while(true){
            String oldPwd = sc.next();
            if(!isPwdEqual(oldPwd, currentAccount.getPassword())){
                System.out.println("原密码不正确，请重新输入：");
            }
            else {
                System.out.println("请输入您的新密码：");
                while(true){
                    String newPwd = sc.next();
                    if (isPwdEqual(newPwd, currentAccount.getPassword())){
                        System.out.println("新密码不得与旧密码一致，请重新输入：");
                    }
                    else {
                        System.out.println("您的密码已成功修改！");
                        currentAccount.setPassword(newPwd);
                        break;
                    }
                }
                break;
            }
        }
    }


    public boolean deleteAccount(Account account){
        System.out.println("您确认要注销您的账户吗？1、是 2、否");
        int chioce = sc.nextInt();
        if(chioce == 1){
            int index = getAccountIndexById(account.getId());
            listOfAccounts.remove(index);
            System.out.println("您的账户已注销成功！");
            return true;
        }
        else if(chioce == 2){
            System.out.println("您已取消注销操作！");
        }
        return false;
    }

    public boolean isIdExisted(int id){
        for(int i = 0;i<listOfAccounts.size();++i){
            if (listOfAccounts.get(i).getId() == id)
                return true;
        }
        return false;
    }

    public boolean isGenderCorrect(String inputGender){
        if(inputGender.equals("男") || inputGender.equals("女"))
            return true;

        return false;
    }

    public boolean isPwdEqual(String firstInput,String secInput){
        if(firstInput.equals(secInput))
            return true;
        return false;
    }

    public boolean isNameEqual(String firstName,String secName){
        if(firstName.equals(secName))
            return true;
        return false;
    }

    public boolean isNumOfAccountEnough(){
        if(listOfAccounts.size() < 2){
            System.out.println("当前系统中账户数不足2位，请先去开户！");
            return false;
        }
        return true;
    }

    public int generateId(){
        Random random = new Random();
        return random.nextInt(90000000) + 10000000;
    }

    public String transferName(String name,char ch){
        StringBuffer stringBuffer = new StringBuffer(name);
        if(ch == '*'){
            Random random = new Random();
            int randomIndex = random.nextInt(name.length());
            stringBuffer.setCharAt(randomIndex,'*');
        }
        else {
            int index = name.indexOf('*');
            stringBuffer.setCharAt(index,ch);
        }
        return stringBuffer.toString();

    }

    public Account getTransferInAccount(){
        //Account transferInAcount = new Account();
        int index;
        while(true){
            System.out.println("请您输入收款账户卡号：");
            int receiveId = sc.nextInt();
            if(!isIdExisted(receiveId)){
                System.out.println("您输入的账户不存在，请确认后重试！");
            }
            else {
                index = getAccountIndexById(receiveId);
                break;
            }
        }
        return listOfAccounts.get(index);
    }

    public int getAccountIndexById(int inputId){
        int index = 0;
        for (int i = 0;i<listOfAccounts.size();++i) {
            if (listOfAccounts.get(i).getId() == inputId)
                index = listOfAccounts.indexOf(listOfAccounts.get(i));
        }
        return index;
    }
}

