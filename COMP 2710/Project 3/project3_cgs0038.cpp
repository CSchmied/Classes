/* Carlton Schmieder
    cgs0038
    project3_cgs0038.cpp
    Compiled with command: g++ project3_cgs0038.cpp
    This project that creates a shooting game with random
    generated numbers everytime to determine the amount each
    person wins.
    I visited cpluscplus.com to help with ofstream and writing file part.
    */

#include <iostream>
#include <fstream>
#include <cstdlib>
#include <string>
#include <cassert>
using namespace std; 

const int MAX_SIZE = 100; 
int readFile(int inputArray[], ifstream& instream);
int sort(int inputArray1[], int inputArray1_size, int inputArray2[], int inputArray2_size, int outputArray[]);
void writefile(int outputArray[], int outputArray_size);

int main() {
    //Variables 
    ifstream instream; 
    ofstream outstream;

    int inputArray1[MAX_SIZE];
    int inputArray2[MAX_SIZE]; 
    int inputArray1_size; 
    int inputArray2_size;
    int outputArray[MAX_SIZE];
    int outputArray_size; 

    string input1; 
    string input2; 
    string output1; 

    cout << "*** Welcome to Carlton's sorting program ***" << endl; 
    
    //FIRST INPUT ARRAY SETUP
    cout << "Enter the first input file name: "; 
    cin >> input1; 

    instream.open((char*)input1.c_str()); 
    cout << ""; 
    if (instream.fail()) {
        cout << "Input file opening failed." << endl;
        exit(1);
    }
    inputArray1_size = readFile(inputArray1, instream);
    instream.close(); 

    cout << "The list of " << inputArray1_size << " numbers in the file " << input1 << " is:" << endl; 
    for (int i = 0; i < inputArray1_size; i++) {
        cout << inputArray1[i] << endl; 
    }
    cout << "\n"; 

    //SECOND INPUT ARRAY SETUP
    cout << "Enter the second input file name: ";
    cin >> input2; 

    instream.open((char*)input2.c_str());
    cout << "";

    inputArray2_size = readFile(inputArray2, instream);
    if (inputArray2_size < 0) {
        cout << "Input file opening failed." << endl;
        exit(1); 
    }
    instream.close();
    cout << "The list of " << inputArray2_size << " numbers in the file " << input2 << " is: " << endl; 
    for (int i = 0; i < inputArray2_size; i++) {
        cout << inputArray2[i] << endl; 
    }
    cout << "\n"; 

    //OUTPUT ARRAY SETUP
    outputArray_size = sort(inputArray1, inputArray1_size, inputArray2, inputArray2_size, outputArray);

    cout << "The sorted list of " << outputArray_size << " numbers is: ";
    for(int k = 0; k < outputArray_size; k++) {
        cout << outputArray[k];
        cout << " ";
    }

    writefile(outputArray, outputArray_size);
    cout << endl;
    
    return 0; 
}

//Readfile method 
int readFile(int inputArray[], ifstream& instream) {
    if (instream.fail()) {
        exit(1);
    }
    int index = 0; 

    instream >> inputArray[index];

    while (!instream.eof()) {
        index++; 
        instream >> inputArray[index]; 
    }
    return index; 
}

//Sort Method
int sort(int inputArray1[], int inputArray1_size, int inputArray2[], int inputArray2_size, int outputArray[]) {
    int input1 = 0;
    int input2 = 0;
    int output1 = 0; 

    while (input1 < inputArray1_size && input2 < inputArray2_size) {
        if (inputArray1[input1] < inputArray2[input2]) {
            outputArray[output1] = inputArray1[input1];
            input1++;
            output1++;
        }
        else if (inputArray1[input1] > inputArray2[input2]) {
            outputArray[output1] = inputArray2[input2]; 
            input2++; 
            output1++; 
        }
        else {
            outputArray[output1] = inputArray1[input1];
            input1++;
            output1++;
            outputArray[output1] = inputArray2[input2];
            input2++;
            output1++;
        }
    }
    if (input1 == inputArray1_size) {
        while(input2 < inputArray2_size) {
            outputArray[output1] = inputArray2[input2];
            input2++;
            output1++; 
        }
    }
    else {
        while (input1 < inputArray1_size) {
            outputArray[output1] = inputArray1[input1];
            input1++;
            output1++; 
        }
    }
    return output1;
}

//Write file method 
void writefile(int outputArray[], int outputArray_size) {
    string output; 
    ofstream outstream; 
    cout << "\n"; 
    cout << "Enter output file name: ";
    cin >> output; 

    outstream.open((char*)output.c_str());

    for (int i = 0; i < outputArray_size; i++) {
        outstream << outputArray[i] << " ";
    }
    cout << "*** Please check the new file - " << output << " ***" << endl;
    cout << "*** Goodbye. ***" << endl;
    outstream.close(); 
 }

