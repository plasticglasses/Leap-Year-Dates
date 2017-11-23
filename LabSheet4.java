import java.util.Scanner;

public class LabSheet4 {

		public static void main(String[] args) {
			
			Scanner integerIn = new Scanner(System.in); 
			String monthString="default";
			int day;
			String middle="default";
			boolean again = true;
			
			
				//do{
					again=true;
					System.out.println("Enter a day");
					day = integerIn.nextInt();
					System.out.println("Enter a month");
					int month = integerIn.nextInt();
					System.out.println("Enter a year");
					int year = integerIn.nextInt();				
					
					//leap years are evenly divisible by 4(2012, 2016), except if it is evenly divided by 100, then its not(2100, 2200).  Except if it can be divided by 400 (2000, 2400), then it is.
					//is the input year a leap year?
					boolean leap = true;
					int remainder=(year % 4);
					if (remainder == 0){
						remainder = year % 100;
						if (remainder == 0) {
							leap=false;
							remainder = year % 400;
							if (remainder == 0){
								leap = true;
								//System.out.println("this year IS A leap year");
							}else{
								leap=false;
								//System.out.println("this year IS NOT A  leap year");
							}
						}else{
							leap=true;
							//System.out.println("this year IS A  leap year");
						}
					}else{
						leap=false;
						//System.out.println("this year IS NOT A  leap year");
					}
					//leap year truth value established
					
					
					//For Gregorian date, add 0 for 1900, 6 for 2000, 4 for 1700, 2 for 1800
					int firstDigit = Integer.parseInt((""+year).substring(0, 1));
					int firstTwoDigits = Integer.parseInt((""+year).substring(0, 2));
					int GregorianDigit = 0;
					if (firstDigit == 2){
						GregorianDigit = 4;
					}
					if (firstTwoDigits == 19){
						GregorianDigit = 0;
					}
					if (firstTwoDigits == 17){
						GregorianDigit = 4;
					}
					if (firstTwoDigits == 18){
						GregorianDigit = 2;
					}
					//For a Julian date, add 1 for 1700's, and 1 for every additional century you go back.
					
					int monthKeyValue = 0;
					// is the day a valid date
					if ((day<0) || (day>32) || (month<0) || (month>13)){
						System.out.println("Invalid date");
						again=false;
						}else{
							switch(month){
								case 1: 
									monthString = "January";
									System.out.println("valid date"); //day can be 31
									if (leap==true){
										monthKeyValue = 143;	
									}else{
										monthKeyValue = 144;
									}
									break;
								case 2: 
									int NumInFeb = 29;
									
									if (leap=true){
										NumInFeb=30;
									}
									monthString = "February";
									if (day<NumInFeb){
										//System.out.println("Valid Date");
									}else{
										System.out.println("Invalid Date");
										again=false;
									}
									if (leap==true){
										monthKeyValue = 143;	
									}else{
										monthKeyValue = 144;
									}
									break;
								case 3:
									monthString = "March";
									//System.out.println("valid date");
									monthKeyValue = 144;
									break;
								case 4: 
									monthString = "April";
									if (day<30){
										//System.out.println("Valid Date");
									}else{
										System.out.println("Invalid Date");
										again=false;
									}
									monthKeyValue = 025;
									break;
								case 5: 
									monthString = "May";
									//System.out.println("valid date"); //day can be 31
									monthKeyValue = 025;
									break;
								case 6: 
									monthString = "June";
									if (day<30){
										//System.out.println("Valid Date");
									}else{
										System.out.println("Invalid Date");
										again=false;
									}
									monthKeyValue = 025;
									break;
								case 7: 
									monthString = "July";
									System.out.println("valid date"); //day can be 31
									monthKeyValue = 036;
									break;
								case 8: 
									monthString = "August";
									//System.out.println("valid date"); //day can be 31
									monthKeyValue = 036;
									break;
								case 9: 
									monthString = "September";
									if (day<30){
										//System.out.println("Valid Date");
									}else{
										System.out.println("Invalid Date");
										again=false;
									}
									monthKeyValue = 036;
									break;
								case 10: 
									monthString = "October";
									//System.out.println("valid date"); //day can be 31
									monthKeyValue = 146;
									break;
								case 11: 
									monthString = "November";
									if (day<30){
										//System.out.println("Valid Date");
									}else{
										System.out.println("Invalid Date");
										again=false;
									}
									monthKeyValue = 146;
									break;
								case 12: 
									monthString = "December";
									//System.out.println("valid date"); //day can be 31
									monthKeyValue = 146;
									break;
								
								default:  
									//System.out.println("Valid Date");
									break;	
							}
						}
					if (again != false){
						//calculating the day
						int yearLastTwoDigits = (year%100);
						double integerValue = (yearLastTwoDigits/4);  //need to discard the fraction
						int integerValues = (int)integerValue;	//change from double to int to achieve the above.
						int nameOfDay = ((integerValues + day + monthKeyValue + GregorianDigit + yearLastTwoDigits)%7);
						String dayName = ("default");
						if (nameOfDay == 1){
							//System.out.print("sunday ");
							dayName = ("sunday");
						}
						if (nameOfDay==2){
							//System.out.print("monday ");
							dayName = ("monday");
						}
						if (nameOfDay==3){
							//System.out.print("tuesday ");
							dayName = ("tuesday");
						}
						if (nameOfDay==4){
							//System.out.print("wednesday ");
							dayName = ("wednesday");
						}
						if (nameOfDay==5){
							//System.out.print("thursday ");
							dayName = ("thursday");
						}
						if (nameOfDay==6){
							//System.out.print("friday ");
							dayName = ("friday");
						}
						if (nameOfDay==7){
							//System.out.print("saturday ");
							dayName = ("saturday");
						}
					}
					//System.out.println(nameOfDay);  test for serious challenge
					//prefixes
						if ((day==1) || (day==2) || (day==3) || (day==21) || (day==22) || (day==23) || (day==31)) {
							
							if ((day==1) || (day==31) || (day==21)){
								middle=("st");
							}
							if ((day==2) || (day==22)){
								middle="nd";
							}
							if ((day==3) || (day==23)){
								middle="rd";
							}		
						}else{
							middle="th";
						}
						
						if (again!=false){
							System.out.println(day + middle + " " + monthString + " " + year);
						}
						
				//}while(again=false);
		}	
}
