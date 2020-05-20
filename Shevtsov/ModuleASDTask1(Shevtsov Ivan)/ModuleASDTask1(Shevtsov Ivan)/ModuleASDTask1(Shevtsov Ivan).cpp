// ModuleASDTask1(Shevtsov Ivan).cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include <iostream>
#include <stdlib.h>
using namespace std;

int getValue()
{
    while (true) 
    {

        int a;
        cin >> a;

        
        if (std::cin.fail()) 
        {
            cin.clear(); 
            cin.ignore(32767, '\n'); 
            cout << "Oops, that input is invalid.  Please try again.\n";
        }
        else
        {
            cin.ignore(32767, '\n');

            return a;
        }
    }
}
struct Node                         
{
    int x;                             
    Node* Next, * Prev;                 
};

class List                             
{
    Node* Head, * Tail;                
public:
    List() :Head(NULL), Tail(NULL) {};   
    ~List();                           
    void showList();                       
    void sortList();
    void addElement(int x);                   
};

List::~List()                          
{
    while (Head)                       
    {
        Tail = Head->Next;             
        delete Head;                   
        Head = Tail;                   
    }
}

void List::addElement(int x)
{
    Node* temp = new Node;               
    temp->Next = NULL;                   
    temp->x = x;                         

    if (Head != NULL)                    
    {
        temp->Prev = Tail;               
        Tail->Next = temp;               
        Tail = temp;                     
    }
    else 
    {
        temp->Prev = NULL;               
        Head = Tail = temp;              
    }
}

void List::showList()
{
    Node * temp = Head;                      
    while (temp != NULL)              
    {
        cout << temp->x << " ";       
        temp = temp->Next;            
    }
    cout << "\n";
}
void List::sortList() {
    Node* left = Head;                 
    Node* right = Head->Next;          

    Node* temp = new Node;            
    while (left->Next) {                 
        while (right) {              
            if ((left->x) < (right->x)) {        
                temp->x = left->x;              
                left->x = right->x;             
                right->x = temp->x;           
            }
            right = right->Next;                    
        }
        left = left->Next;                              
        right = left->Next;                            
    }
}
int main()
{
    int N, Add;
    cout << "Enter number of values :";
    N = getValue();
    cout << "Enter number of additional values :";
    Add = getValue();
    List lst; 
    for (int i = 0; i < N; i++) {
        cout << "Enter list element :";
        int temp = getValue();
        lst.addElement(temp); 
    }
    lst.showList(); 
    for (int i = 0; i < Add; i++) {
        cout << "Enter list element :";
        int temp = getValue();
        lst.addElement(temp); 
    }
    lst.showList();
    lst.sortList();
    lst.showList();
    system("PAUSE");
    return 0;
}