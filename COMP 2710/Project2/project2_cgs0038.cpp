/* Carlton Schmieder
	cgs0038
	project2_cgs0038.cpp
	Compiled with command: g++ project2_cgs0038.cpp
	This project that creates a shooting game with random
	generated numbers everytime to determine the amount each
	person wins. 
	I visited cpluscplus.com to help with my do while statements.
	I went over the slides to help with my pointers. 
	*/
#include <iostream>
#include <stdlib.h>
#include <assert.h>
#include <ctime>
using namespace std; 

//Prototypes 
bool at_least_two_alive(bool A_alive, bool B_alive, bool C_alive);
void Aaron_shoots1(bool& B_alive, bool& C_alive);
void Bob_shoots(bool& A_alive, bool& C_alive);
void Charlie_shoots(bool& A_alive, bool& B_alive);
void Aaron_shoots2(bool& B_alive, bool& C_alive);

//Method to pause the program till enter is pressed 
void Press_any_key();

//Test Prototypes
void test_at_least_two_alive();
void test_Aaron_shoots();
void test_Bob_shoots();
void test_Charlie_shoots();
void test_Aaron_shoots2();

//Constant Variabled 
const int totalRuns = 10000; 
const double aaron_hit_prob = 1.0 / 3.0; 
const double bob_hit_prob = 1.0 / 2.0; 
const double charlie_hit_prob = 1.0;

//Main method to run the simulations
int main() {
	//Variables
	bool aaron_alive = true;
	bool bob_alive = true;
	bool charlie_alive = true; 

	int aaron_wins1 = 0;
	int aaron_wins2 = 0;
	int bob_wins = 0; 
	int charlie_wins = 0;

	double aaron_success = 0.0;
	double bob_success = 0.0;
	double charlie_success = 0.0;

	//Start
	cout << "*** Welcome to Carlton's Duel Simulator ***\n"; 
	srand(time(0));

	  test_at_least_two_alive(); 
	  Press_any_key(); 

	  test_Aaron_shoots();
	  Press_any_key(); 

	  test_Bob_shoots(); 
	  Press_any_key();

	  test_Charlie_shoots();
	  Press_any_key(); 

	  test_Aaron_shoots2(); 
	  Press_any_key();
	

	//Start strategy 1 and runs 10000 times 
	cout << "Ready to test strategy 1  (run 10000 times): " << endl;
	Press_any_key();

	for (int i = 0; i < totalRuns; i++) {
		aaron_alive = true;
		bob_alive = true; 
		charlie_alive = true;

		do {
			if (aaron_alive) {
				Aaron_shoots1(bob_alive, charlie_alive);
			}
			if (bob_alive) {
				Bob_shoots(aaron_alive, charlie_alive);
			}
			if (charlie_alive) {
				Charlie_shoots(aaron_alive, bob_alive);
			}
		} 
		while (at_least_two_alive(aaron_alive, bob_alive, charlie_alive));

		if (aaron_alive == true) {
			aaron_wins1++; 
		}
		if (bob_alive == true) {
			bob_wins++; 
		}
		if (charlie_alive == true) {
			charlie_wins++;
		}
	}
	
	//Prints out the results from strategy one
	cout << "Aaron won " << aaron_wins1 << "/10000 duels or " << static_cast<double>(aaron_wins1) /
		totalRuns * 100 << "%\n";
	cout << "Bob won " << bob_wins << "/10000 duels or " << static_cast<double>(bob_wins) /
		totalRuns * 100 << "%\n";
	cout << "Charlie won " << charlie_wins << "/10000 duels or " << static_cast<double>(charlie_wins) /
		totalRuns * 100 << "%\n"
		<< endl; 

	//Starts Strategy 2 and runs 10000 times
	cout << "Ready to test strategy 2 (run 10000 times):\n";
	Press_any_key();

	bob_wins = 0;
	charlie_wins = 0;

	for (int i = 0; i < totalRuns; i++) {
		aaron_alive = true;
		bob_alive = true;
		charlie_alive = true;

		do {
			if (aaron_alive) {
				Aaron_shoots2(bob_alive, charlie_alive);
			}
			if (bob_alive) {
				Bob_shoots(aaron_alive, charlie_alive);
			}
			if (charlie_alive) {
				Charlie_shoots(aaron_alive, bob_alive);
			}
		} while (at_least_two_alive(aaron_alive, bob_alive, charlie_alive));

		if (aaron_alive == true) {
			aaron_wins2++;
		}
		if (bob_alive == true) {
			bob_wins++;
		}
		if (charlie_alive == true) {
			charlie_wins++;
		}
	}

	//Prints out the results from strategy 2
	cout << "Aaron won " << aaron_wins2 << "/10000 duels or " << static_cast<double>(aaron_wins2) /
		totalRuns * 100 << "%\n";
	cout << "Bob won " << bob_wins << "/10000 duels or " << static_cast<double>(bob_wins) /
		totalRuns * 100 << "%\n";
	cout << "Charlie won " << charlie_wins << "/10000 duels or " << static_cast<double>(charlie_wins) /
		totalRuns * 100 << "%\n"
		<< endl;

	//Strategy Comparison
	if (aaron_wins2 >= aaron_wins1) {
		cout << "Strategy 2 is better than strategy 1.\n";
	}

	else {
		cout << "Strategy 1 is better than strategy 2.\n";
	}


	return 0; 
}

//Method to determine if two are alive
bool at_least_two_alive(bool A_alive, bool B_alive, bool C_alive) {
	if (A_alive && B_alive) {
		return true;
	}
	if (A_alive && C_alive) {
		return true;
	}
	if (B_alive && C_alive) {
		return true;
	}

		return false;
}

//Test for at_least_two_alive
void test_at_least_two_alive() {
	cout << "Unit Testing 1: Function - at_least_two_alive()" << endl;

	//Two people alive
	cout << "\tCase 1: Aaron alive, Bob alive, Charlie alive\n";
	assert(true == at_least_two_alive(true, true, true));
	cout << "\tCase Passed ...\n";

	cout << "\tCase 2: Aaron dead, Bob alive, Charlie alive\n";
	assert(true == at_least_two_alive(false, true, true));
	cout << "\tCase passed ...\n";

	cout << "\tCase 3: Aaron alive, Bob dead, Charlie alive\n";
	assert(true == at_least_two_alive(true, false, true));
	cout << "\tCase passed ...\n";

	cout << "\tCase 4: Aaron alive, Bob alive, Charlie dead\n";
	assert(true == at_least_two_alive(true, true, false));
	cout << "\tCase passed ...\n";

	//One person alive 
	cout << "\tCase 5: Aaron dead, Bob dead, Charlie alive\n";
	assert(false == at_least_two_alive(false, false, true));
	cout << "\tCase passed ...\n";

	cout << "\tCase 6: Aaron dead, Bob alive, Charlie dead\n";
	assert(false == at_least_two_alive(false, true, false));
	cout << "\tCase passed ...\n";

	cout << "\tCase 7: Aaron alive, Bob dead, Charlie dead\n";
	assert(false == at_least_two_alive(true, false, false));
	cout << "\tCase passed ...\n";

	//All dead
	cout << "\tCase 8: Aaron dead, Bob dead, Charlie dead\n";
	assert(false == at_least_two_alive(false, false, false)); 
	cout << "\tCase passed ...\n";
}

//Method to determine aaron shoots using strategy 1
void Aaron_shoots1(bool& B_alive, bool& C_alive) {
	assert(B_alive || C_alive);
	int shot_result = rand() % 3; 

	if (shot_result == 1) {
		if (C_alive == true) {
			C_alive = false; 
		}

		else {
			B_alive = false; 
		}
	
	}

}

//Test for aaron_shoots1()
void test_Aaron_shoots() {
	bool bob_a = true;
	bool charlie_a = true;

	cout << "Unit Testing 2: Function - Aaron_shoots1(Bob_alive, Charlie_alive)\n";
	
	cout << "\tCase 1: Bob alive, Charlie alive\n"
		<< "\t\tAaron is shooting at Charlie\n";
	Aaron_shoots1(bob_a, charlie_a); 

	cout << "\tCase 2; Bob dead, Charlie alive\n"
		<< "\t\tAaron is shooting at Charlie\n";
	bob_a = false;
	charlie_a = true;
	Aaron_shoots1(bob_a, charlie_a);

	cout << "\tCase 3: Bob alive, Charlie dead\n"
		<< "\t\tAaron is shooting at Bob\n";
	bob_a = true;
	charlie_a = false;
	Aaron_shoots1(bob_a, charlie_a);

}

//Method for bob shooting
void Bob_shoots(bool& A_alive, bool& C_alive) {
	assert(A_alive || C_alive);
	int shot_result = rand() % 2; 

	if (shot_result == 1) {
		if (C_alive == true) {
			C_alive = false;
		}

		else {
			A_alive = false;
		}
	}
	
}

//Test for bob_shoots
void test_Bob_shoots() {
	bool aaron_a = true;
	bool charlie_a = true;

	cout << "Unit Test 3: Function Bob_shoots(Aaron_alive, Charlie_alive)\n";

	cout << "\tCase 1: Aaron alive, Charlie alive\n";
	cout << "\t\tBob is shooting at Charlie\n";
	Bob_shoots(aaron_a, charlie_a);

	cout << "\tCase 2: Aaron dead, Charlie alive\n";
	cout << "\t\tBob is shooting at Charlie\n";
	aaron_a = false;
	charlie_a = true;
	Bob_shoots(aaron_a, charlie_a);

	cout << "\tCase 3: Aaron alive, Charlie dead\n";
	cout << "\t\tBob is shooting at Aaron\n";
	aaron_a = true;
	charlie_a = false; 
	Bob_shoots(aaron_a, charlie_a);

}

//Method for charlie shooting
void Charlie_shoots(bool& A_alive, bool& B_alive) {
	assert(A_alive || B_alive);
	int shot_result = 1; 

	if (shot_result <= charlie_hit_prob && B_alive == true) {
		B_alive = false;
	}

	else {
		A_alive = false; 
	}

}
//Test for Charlie Shoots
void test_Charlie_shoots() {
	bool aaron_a = true;
	bool bob_a = true; 

	cout << "Unit Testing 4: Function Charlie_shoots(Aaron_alive, Bob_alive)\n";

	cout << "\tCase 1: Aaron alive, Bob alive\n";
	cout << "\t\tCharlie is shooting at Bob\n";
	Charlie_shoots(aaron_a, bob_a);

	cout << "\tCase 2: Aaron dead, Bob alive\n";
	cout << "\t\tCharlie is shooting at Bob\n";
	aaron_a = false;
	bob_a = true;
	Charlie_shoots(aaron_a, bob_a);

	cout << "\tCase 3: Aaron alive, Bob dead\n";
	cout << "\t\tCharlie is shooting at Aaron\n";
	aaron_a = true; 
	bob_a = false;

}
//Strategy 2 for Aaron 
void Aaron_shoots2(bool& B_alive, bool& C_alive) {
	assert(B_alive || C_alive);
	int shot_result = rand() % 3; 

	if (shot_result == 1) {
		if (!(B_alive && C_alive)) {
			if (C_alive == true) {
				C_alive = false; 
			}

			else {
				B_alive = false;
			}
		}
 	}
}
//Test for aaron shoots2
void test_Aaron_shoots2() {
	bool bob_a = true;
	bool charlie_a = true; 

	cout << "Unit Testing 5: Functions Aaron_shoots2(Bob_alive, Charlie_alive)\n";

	cout << "\tCase 1: Bob alive, Charlie alive\n";
	cout << "\t\tAaron intentionally missed his first shot\n";
	cout << "\t\tBoth Bob and Charlie are alive.\n";
	Aaron_shoots2(bob_a, charlie_a);

	cout << "\tCase 2: Bob dead, Charlie alive\n";
	cout << "\t\tAaron is shooting at Charlie\n";
	bob_a = false;
	charlie_a = true; 
	Aaron_shoots2(bob_a, charlie_a);

	cout << "\tCase 3: Bob alive, Charlie dead\n";
	cout << "\t\tAaron is shooting at Bob\n";
	bob_a = true;
	charlie_a = false; 
	Aaron_shoots2(bob_a, charlie_a);

}

//Method for press_any_key 
void Press_any_key() {
	cout << "Press enter to continue..." << endl;
	cin.get();
}

