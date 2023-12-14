#include <iostream>
using namespace std;

class Person{
    public:
    string greet(){
        return "I'm a person";
    }
};

class Student : Person{
    public:
    string greet(){
        return "I'm a Student";
    }
};

void process (Person p )


int main(){
    Person p1; //no polymorphism

    /* C++ polymorphism requires refrence or pointers */
    Person* p2 = new Student(); //polymorphism

    process(p1);
    process(p2);

    cout<<p1.greet()<<endl;
    cout<<p2.greet()<<endl;

}