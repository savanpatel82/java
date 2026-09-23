		import java.util.Scanner;

	class User
	{
		String username;
		String password;
		String email;
		String adhar;
		String pan;
		String mobileno;
		String gender;
		String address;
		String acctype;

		int age;
		double balance;

	}

	public class bank
	{		
			static Scanner obj=new Scanner(System.in);
			
			static User [] user = new User [100];

			static int count=0;
			static int currentUser = -1;

		public static void main(String [] s) {
			
			
			
			System.out.println("--BANK MANAGEMENT SYSTEM--");
			System.out.println("--------------------------");

			int choice;
			do{
				System.out.print("\n1.Register\n2.Login\n3.Exit");
				System.out.print("\nEnter Your Choice\n");
				choice=obj.nextInt();
				obj.nextLine();

				switch(choice)
				{
				case 1:

			        System.out.println("<=-Register Successful-=>");
					registeruser();				

					break;

				case 2:

			        System.out.println("<=-Login Successful-=>");
					login();

					break;

				case 3:

			        System.out.println("<=-Exit Successful-=>");
					exit();
					break;

				default :

	                System.out.println("Invalid Choice!");

	           	}
			}while(true);
		}


		public static void registeruser()
		{	
			if(count == 100)
				{
				    System.out.println("Maximum Number Of user Reached!");
				    return;
				}

			System.out.print("Enter Name:");
			String	name=obj.nextLine().trim();

		    for(int i = 0; i < count; i++)
				{
					if(user[i].username.equals(name))
					    {
					        System.out.println("Username Already Exists!");
					        return;
					    }
					}

					String pass;

					while(true)
					{

					System.out.print("Enter Password:");
					pass=obj.nextLine().trim();

					if (validatePass(pass))
					{
						System.out.println("Valid Password");
						break;
					}

					else
					{
						System.out.println("Invalid Password!");
    					System.out.print("Password must contain:");
    					System.out.print("- Minimum 8 characters");
    					System.out.print("- Uppercase and lowercase letters");
   						System.out.print("- At least one digit");
    					System.out.println("- At least one special character");
					}
					
					}

					System.out.print("Enter Your Gender(M/F):");
		    String	gen=obj.nextLine().trim();
					
					System.out.print("Enter Your Age:");
			int		ages=obj.nextInt();
					obj.nextLine();
					
					if(ages <= 0)
					{
					    System.out.println("Invalid Age!");
					    return;
					}
		
					String emails;

					while(true)
					{
					
					System.out.print("Enter Email:");
					emails=obj.nextLine().trim();

					if(validateEmail(emails))
					{
						System.out.println("Valid Email-address..");
						break;
					}

					else{
						 System.out.println("Invalid Email!");
					}

					}

					
					System.out.print("Enter Mobile No:");
					String	mn=obj.nextLine().trim();
					
					System.out.print("Enter Adhar Number:");
					String	adharno=obj.nextLine().trim();
					
					System.out.print("Enter PAN Number:");
					String	panno=obj.nextLine().trim();
				
					System.out.print("Enter Address:");
					String	addres=obj.nextLine().trim();

					String  typ;

					while(true)
					{
					System.out.println("Enter Account Type(Saving/Current)");
				    typ=obj.nextLine().trim();

					if(typ.equalsIgnoreCase("Saving") || typ.equalsIgnoreCase("Current"))
				    {
				        break;
				    }
				    else
				    {
				        System.out.println("Please Enter Correct Account Type!");
				    }

					}

					System.out.print("Enter Opening Balance (Minimum Rs.10000): ");
					Double	balances=obj.nextDouble();
					
					obj.nextLine();

					if(balances < 10000)
					{
					    System.out.println("Account cannot be created. Minimum opening balance is Rs.10000.");
						return;
					}

					user[count] = new User();

					user[count].username=name;
					user[count].password=pass;
					user[count].gender=gen;
					user[count].age=ages;
					user[count].email=emails;
					user[count].mobileno=mn;
					user[count].adhar=adharno;
					user[count].pan=panno;
					user[count].address=addres;
					user[count].acctype=typ;
					user[count].balance=balances;

					count++;		
					System.out.println("\nRegistration Successful!");
		}
        public static boolean validatePass(String pass)
        {
        	if(pass.length() < 8)
        		{
        			return false;
        		}


        	boolean upper = false;
			boolean lower = false;
			boolean num = false;
			boolean special = false;
			
			for(int i=0;i<pass.length();i++)
			{
				char ch= pass.charAt(i);

				if(Character.isUpperCase(ch))
				{
					upper= true;
				}
				else if(Character.isLowerCase(ch))
				{
					lower= true;
				}
				else if(Character.isDigit(ch))
				{
					num= true;
				}
				else
				{
					special= true;
				}
			}
			return upper && lower && num && special;

        }
        public static boolean validateEmail(String mail)
        {
        	boolean at=false;
        	for(int i=0;i<mail.length();i++)
        	{
        		char ch=mail.charAt(i);

        		if(ch=='@')
        		{
        			at = true;
					break;
        		}
        	}
        	return at;
        }
        public static void login()
        {
        	System.out.println("Enter Username:");
			String loginusername=obj.nextLine().trim();
			System.out.println("Enter Password:");
			String loginpassword=obj.nextLine().trim();

			for(int i=0;i<count;i++)
				{
					if(user[i].username.equals(loginusername) && user[i].password.equals(loginpassword))
					{
						currentUser=i;
						System.out.println("\nLogin Successful!\n");
						usermenu();
						return;
					}
				}
				
				System.out.println("Invalid Username or Password!");
       	}

       	public static void exit()
       	{
       		System.out.println("Exiting...");
			System.exit(0);
       	}

       	public static void usermenu()
       	{
       		while(true)
       		{
       			System.out.println("---USER-MENU-----");
				System.out.println("4.Deposit-Money");
				System.out.println("5.Withdraw-Money");
				System.out.println("6.Show-Balance");
				System.out.println("7.View Account Details");
				System.out.println("8.Log-Out");
				System.out.println("\nEnter-Choice:");
				int choice = obj.nextInt();
				obj.nextLine();

				switch(choice)
				{
				    case 4:
				   	deposit();
				   	break;

				    case 5:
				    withdraw();
					break;

					case 6:
					showbalance();
					break;

					case 7:
					viewaccountdetails();
					break;

				    case 8:
				    logout();
				    break;

				    default:
				    	System.out.println("tamari Choice khoti che!");
				    	break;
				}
       		}
       	}
       	public static void deposit()
       	{
       		double amount;

       		System.out.println("Enter Deposit Amount:");
			amount=obj.nextDouble();
			obj.nextLine();

			if(amount <= 0)
			{
				System.out.println("khoti amount che !");
				return;
			}
			user[currentUser].balance+=amount;
			System.out.println("Deposit Successful!"+"\n");
       	}
       	public static void withdraw()
       	{
       		double amount;

       		System.out.println("Enter withdraw Amount:");
       		amount=obj.nextDouble();
       		obj.nextLine();

       		if(amount <= 0)
       		{
       			System.out.println("khoti amount che !"+"\n");
       			return;
       		}
       		if(amount > user[currentUser].balance)
       		{
       			System.out.println("Insufficient Balance!"+"\n");
       		}
       		user[currentUser].balance-=amount;

       		System.out.println("Withdraw Successful!"+"\n");

       	}

       	public static void showbalance()
       	{
       		System.out.println("Balance: Rs." + user[currentUser].balance+"\n");
       	}

       	public static void viewaccountdetails()
       	{
       		System.out.println("\n=--- ACCOUNT DETAILS ---=");

       		System.out.println("Name   :"+user[currentUser].username);
       		System.out.println("Gender :"+user[currentUser].gender);
       		System.out.println("Age    :"+user[currentUser].age);
       		System.out.println("Email  :"+user[currentUser].email);
       		System.out.println("Mobil Number :"+user[currentUser].mobileno);
       		System.out.println("Pan Number :"+user[currentUser].pan);
       		System.out.println("Address :"+user[currentUser].address);
       		System.out.println("Account Type :"+user[currentUser].acctype);
       		System.out.println("Balance :"+user[currentUser].balance);
       	
       	}

       	public static void logout()
       	{
       		currentUser=-1;
       		System.out.println("Logout Successful"+"\n");
       	}
}
