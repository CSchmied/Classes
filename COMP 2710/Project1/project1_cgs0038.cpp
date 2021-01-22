/*	Carlton Schmieder
 * cgs0038
 *	project1_cgs0038.cpp 
 * Compiled with command: g++ project1_cgs0038.cpp 
 *  This project takes input by the user and calculates
	the amount of months and total interest it takes to pay
	back the loan. 
 *  I went over the loops in the slides for help. 
 *  I visited cpluscplus.com figure out the user input. 
*/
#include <iostream>
using namespace std;

int main() {
	// Starting Varaibles
	double loan = 0.0;
	double interest = 0.0;
	double monthlyPay = 0.0;

	// Currency Formatting
	cout.setf(ios::fixed);
	cout.setf(ios::showpoint);
	cout.precision(2);

	// User Input 
	cout << "Loan Amount: ";
	cin >> loan;

	// Warning message for when loan amount is not positive. 
	if (loan <= 0) {
		cout << "A positive loan must be entered." << endl;
		main();
		return 0;
	}
	cout << "Interest Rate (% per year): ";
	cin >> interest;

	// Warning message when interest is not positive. 
	if (interest <= 0) {
		cout << "A positive interest must be entered." << endl;
		main();
		return 0;
	}

	// Interest Calculations 
	double rate = interest / 12;
	double intrate = rate / 100;
	double startInterest = loan * intrate;
	cout << "Monthly Payments: ";
	cin >> monthlyPay;

	// If monthly payments is less than the interest. 
	if (monthlyPay <= startInterest) {
		cout << "Monthly payments must exceed monthly interest." << endl;
		main();
		return 0;
	}

	// Variables for calculations. 
	int months = 0;
	double amount = loan;
	double totalInterest = 0.0;
	double principal = 0.0;
	double remainingLoan;

	// Prints out the top part of the Amortization Table. 
	cout << "**********************************************************" << endl;
	cout << "\tAmortization Table" << endl;
	cout << "**********************************************************" << endl;
	cout << "Month\tBalance\t\tPayment\tRate\tInterest Principal" << endl;
	cout << months << "\t$" << loan << "\t" << "N/A\tN/A\tN/A\t N/A" << endl;

	// Loop to calculate data and prints the rest of the table. 
	while (amount > 0) {
		startInterest = amount * intrate;
		totalInterest += startInterest;
		remainingLoan = monthlyPay - startInterest;
		amount = amount - remainingLoan;
		months++; 

			if (amount < 0) {
				monthlyPay = amount += remainingLoan;
				remainingLoan = monthlyPay; 
				monthlyPay = monthlyPay + startInterest; 
				amount = 0.0; 
			}

			// Deals with spacing when the balance is greater than 1000.
			if (amount > 1000) { 
				cout << months << "\t$" << amount << "\t$" << monthlyPay << "\t"
					<< rate << "\t$" << startInterest << "\t $" << remainingLoan << endl;
			}

			// Deals with spacing when balance is less than 10000.
			else {
				cout << months << "\t$" << amount << "\t\t$" << monthlyPay << "\t"
					<< rate << "\t$" << startInterest << "\t $" << remainingLoan << endl;
			}
	}
	
	// Prints out how many months and total interest the program kept up. 
	if (monthlyPay > startInterest) {
		cout << "**********************************************************" << endl;
		cout << "" << endl; 
		cout << "It takes " << months << " months to pay off the loan." << endl;
		cout << "Total interest paid is: $" << totalInterest << endl;
	}

	return 0;
}