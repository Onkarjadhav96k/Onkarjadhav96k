import java.util.Scanner;
class User
{
	static String userName;
	static int pwd;
	static String emailId;
	static long phoneNo;

}
class Icici
{
	static int accountNo;
	static String ifsc;
	static String accountType;
	static String branch;
	static double balance;


	static Scanner sc=new Scanner(System.in);
	 public static void  icici2(){
		accountNo=850168;
		ifsc="icici8767";
		accountType="SAVING";
		branch="BARSHI";
		balance=7000;


	 }
    static double withdramAmt;
	 static double depositAmt;
	 public static void createUserAccount(){
		 System.out.println("Enter Your Name:");
		 User.userName=sc.nextLine();
		 System.out.println("Enter Password:");
		 User.pwd=sc.nextInt();
		 System.out.println("Enter Your EmailId:");
		 User.emailId=sc.next();
		 System.out.println("Enter Your Phone Number:");
		 User.phoneNo=sc.nextLong();
		 icici2();//Account Details By Bank..
		  System.out.println("Successfully Created Account"+User.userName+accountNo);


		
	 }
	 public static void withDrawMoney(){
		  System.out.println("Enter Your Password:");
		  double pwd=sc.nextInt();
		  if(pwd==User.pwd){
			  System.out.println("Enter the money to be withdrawn:");
			  withdramAmt=sc.nextDouble();
			  //Logics to withdrawn
			  balance=balance- withdramAmt;
			  System.out.println("Successfully withdrawn Money"+withdramAmt+"Rupees");

		  }
		  else{
			System.out.println("Invalid Password");
		  }
		
	 }
	 public static void DepositMoney(){
		 System.out.println("Enter Your Password:");
		  double pwd=sc.nextInt();
		  if(pwd==User.pwd){
			  System.out.println("Enter the money to be Deposit :");
			  depositAmt=sc.nextDouble();
			  //Logics to withdrawn
			  balance=balance+depositAmt;
			  System.out.println("Successfully Deposited Money"+depositAmt+"Rupees");

		  }
		  else{
			System.out.println("Invalid Password");
		  }
		
	 }
	public static void checkBalance(){
		System.out.println("Enter your password:");
		int pwd=sc.nextInt();
		if(pwd==User.pwd){
			System.out.println("Balance:"+balance);
		}else{
			System.out.println("Invalid Password:");
		}
		
	 }
	 public static void getUserDetails(){
		System.out.println("UserName:"+User.userName);
		System.out.println("EmailId:"+User.emailId);
		System.out.println("Phone Number:"+User.phoneNo);
		System.out.println("Account Number:"+accountNo);
		System.out.println("IFSC CODE:"+ifsc);
		System.out.println("Account Type:"+accountType);
		System.out.println("Branch:"+branch);

	}
	 public static void changePassword(){
		System.out.println("Enter Your Old Password:");
		int oldPwd=sc.nextInt();
		if(oldPwd==User.pwd){
			System.out.println("Enter Your New Password:");
			User.pwd=sc.nextInt();
			System.out.println("Your Password Changed Successfully");
		}else{
			System.out.println("Password Missmatch");
		}

		
	 }
}
class IciciDriver 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		boolean exit=true;
		while(exit){
		System.out.println("1.Create Account");
		System.out.println("2.Change Pin");
		System.out.println("3.Withdraw Money");
		System.out.println("4.Deposit Money");
		System.out.println("5.Check Balance");
		System.out.println("6.Account Details");
		System.out.println("7.Exit");
		
		int opt=sc.nextInt();
		switch(opt){
			case 1:{
				Icici.createUserAccount();
				
			}break;
			case 2:{
				Icici.changePassword();
			}break;
			case 3:{
				Icici.withDrawMoney();
			}break;
			case 4:{
					Icici.DepositMoney();
			}break;
			case 5:{
				Icici.checkBalance();
			}break;
			case 6:{
				Icici. getUserDetails();
			}break;
			case 7:{
				exit=false;
				System.out.println("Thank you for choosing ICICI BANKING");
			}break;
			default:{
				System.out.println("INVALID Options try again..........");
			}
			
		}
	}
}
}
