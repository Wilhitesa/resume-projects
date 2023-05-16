#include <fstream>
//#include <iostream>
using namespace std;

int main() {
    ifstream inStream;
    ofstream outStream;
    //input the file to be converted here:
    inStream.open("/Users/samuelwilhite/Downloads/mantest.txt");
    //input the output file name here:
    outStream.open("/Users/samuelwilhite/Downloads/outfile.txt");

    outStream << "<PRE>" << std::endl;
    char next;
    //reads the file character by character
    inStream.get(next);
    while(!inStream.eof()) {
        //if the next character is either < or >, change accordingly
        if(next == '<') {
            outStream << "&lt;";
        } else if(next == '>') {
            outStream << "&gt;";
        //else, output the character
        } else {
            outStream << next;
        }
        inStream.get(next);
    }
    outStream << std::endl << "</PRE>";
    //close the files
    inStream.close();
    outStream.close();
}
