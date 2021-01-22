/*  * Carlton Schmieder
	* cgs0038
	* project4_cgs0038.cpp 
	* Compiled with command: g++ project4_cgs0038.cpp 
	* This project creates a simple trivia quiz game that starts off with 
	* three questions and the user can add more questions and answers. The program
	* will keep count of the total points.
	* I looked over notes and slides and cplusplus.com to figure out storing data with nodes  
	*/

#include <iostream> 
#include <string>
#include <assert.h>
using namespace std; 

//CREATING TRIVIANODE
struct TriviaNode {
	string question;
	string answer;
	int points;
	TriviaNode* pointer = NULL; 
};

typedef TriviaNode* ptr_node;

//initialize
void initialize(ptr_node& ques) {
	ptr_node current = new TriviaNode; 

	current->question = "How long was the shortest war on record? (Hint: how many minutes):";
	current->answer = "38";
	current->points = 100;
	current->pointer = new TriviaNode; 
	ptr_node temp = current; 
	current = current->pointer;

	current->question = "what was Bank of America's original name? (Hint: Bank of Italy or Bank of Germany)?";
	current->answer = "Bank of Italy";
	current->points = 50;
	current->pointer = new TriviaNode; 
	current = current->pointer;

	current->question = "what is the best-selling video game of all time? (Hint: Call of Duty or Wii Sports)?";
	current->answer = "Wii Sports";
	current->points = 20; 

	current = temp; 
	ques = current; 
}

//ASK THE PLAYER TO CREATE THEIR OWN QUESTION
void addQuestions(ptr_node& ques) {
	ptr_node newNode = new TriviaNode;
	int points;
	int startNode = 0;
	int endNode = 0; 

	ptr_node temp = ques;
	if (ques != NULL) {
		startNode++;
	}
	while (ques->pointer != NULL) {
		ques = ques->pointer;
		startNode++;
	}

	cout << "Enter a new question: ";
	getline(cin, newNode->question);
	cin.clear();

	cout << "Enter an answer: ";
	getline(cin, newNode->answer);
	cin.clear();

	cout << "Enter award points: ";
	cin >> points; 
	newNode->points = points;
	cin.clear();
	ques->pointer = newNode;

	while (ques != NULL) {
		ques = ques->pointer; 
		endNode++; 
	}
	ques = temp;
}

//USEDD FOR UNIT TESTING 
int askPlayerQuestions(ptr_node ques, int num) {
	ptr_node current = ques;
	string input; 
	int tpoints = 0;
	int numOfQuestions = 0; 

	while (current != NULL) {
		current = current->pointer;
		numOfQuestions++; 
	}

	current = ques; 
	if (current == NULL) {
		return 0; 
	}
	if (num < 1) {
		cout << "Warning - the number of trivia to be asked must be equal to or be larger than 1.";
		return 1;
	}
	else if (numOfQuestions < num) {
		cout << "Warning - There is only " << numOfQuestions << " trivia in the list.";
		return 1; 
	}
	else {
		for (int i = 0; i < num;  i++) {
			cout << "Question: " << current->question << endl; 
			cout << "Answer: ";
			getline(cin, input); 
			cin.clear();
			if (input.compare(current->answer) == 0) {
				cout << "Your answer is correct. You recieve " << current->points << " points.";
				tpoints += current->points;
				cout << "\nYour total points: " << tpoints << endl;
				current = current->pointer; 
			}
			else {
				cout << "Your answer is wrong. The correct answer is " << current->answer;
				cout << "\nYour total points: " << tpoints << endl;
				current = current->pointer;
			}
		}
		return 0; 
	}
}

//TEST DRIVER
void testDriver() {
	cout << "*** This is a debugging version ***\n";
	ptr_node list = new TriviaNode;
	initialize(list);
	//Unit Test Case 1
	cout << "Unit Case Test 1: Ask no question. The program should give a warning message." << endl;
	int case1 = askPlayerQuestions(list, 0);
	assert(case1 == 1); 
	cout << "\nCase 1 passed\n\n";

	//Unit Test Case 2.1
	cout << "Unit Test Case 2.1: Ask 1 question in the linked list. The tester enters a incorrect answer." << endl;
	int case2_1 = askPlayerQuestions(list, 1);
	assert(case2_1 == 0); 
	cout << "\nCase 2.1 passed\n\n";

	//Unit Test Case 2.2
	cout << "Unit Test Case 2.2: Ask 1 question in the linked list. The tester enters a correct answer." << endl;
	int case2_2 = askPlayerQuestions(list, 1);
	assert(case2_2 == 0);
	cout << "\nCase 2.2 passed\n\n";

	//Unit Test Case 3
	cout << "Unit Test 3: Ask all the questions of the last trivia in the linked list." << endl;
	int case3 = askPlayerQuestions(list, 3);
	assert(case3 == 0); 
	cout << "Case 3 passed\n\n"; 

	//Unit Test Case 4
	cout << "Unit Test 4: Ask 5 questions in the linked list." << endl;
	int case4 = askPlayerQuestions(list, 5); 
	assert(case4 == 1); 
	cout << "\n\nCase 4 passed\n\n"; 
	cout << "*** End of the Debugging Version ***\n\n";

}

//#define UNIT_TESTING
#define trivia_quiz

int main() {
#ifdef UNIT_TESTING
	testDriver(); 
#endif

#ifdef trivia_quiz
	ptr_node list = new TriviaNode; 
	initialize(list);
	cout << "*** Welcome to Carlton's Trivia Quiz Game ***\n";
	int questions = 3; 
	while (cin.good()) {
		addQuestions(list);
		questions++;
		string moveOn; 
		cout << "Continue? (Yes/No): ";
		cin >> moveOn; 
		cin.clear(); 
		cin.ignore(10000, '\n');
		if (moveOn.compare("No") == 0) {
			break; 
		}
	}
	askPlayerQuestions(list, questions);
	cout << "\n*** Thank you for playing the trivia quiz game. Goodbye! ***\n\n";
#endif

}
