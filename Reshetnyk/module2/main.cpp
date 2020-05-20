//Решетник Денис ПП12 - Варіант4. Модуль 2, задача 2. Я не знав як правильно забивати елементи в стек, тому перший елемент введений користувачем іде на низ
#include <iostream>
using namespace std;

template <typename T>
struct NodeStack
{
    T item;
    NodeStack<T>* next;
};

template <typename T>
class StackList
{
public:
    NodeStack<T>* pTop = nullptr;

    void push(T item)
    {
        NodeStack<T>* p;
        p = new NodeStack<T>;
        p->item = item;
        p->next = pTop;
        pTop = p;
    }

    int pop(){
        int temp = pTop->item;
        pTop=pTop->next;
        return temp;
    }

    void print(){
        NodeStack<T>* p = pTop;
        while(p){
            cout<<p->item<<" ";
            p = p->next;
        }
    }

};


int main() {
    int size,size2,size3, item;
    int total1=0,total2=0,total3=0;
    StackList<int> SL,SL2,SL3;
    cout<<"Enter N1 N2 N3"<<endl;
    cin>>size>>size2>>size3;
    cout<<"Enter elements of N1"<<endl;
    for(int i =0; i<size;i++){
        cin>>item;
        SL.push(item);
        total1+=item;
    }
    cout<<"Enter elements of N2"<<endl;
    for(int i =0; i<size2;i++){
        cin>>item;
        SL2.push(item);
        total2+=item;
    }
    cout<<"Enter elements of N3"<<endl;
    for(int i =0; i<size3;i++){
        cin>>item;
        SL3.push(item);
        total3+=item;
    }
    while(!((total1==total2)&&(total2==total3)&&(total1==total3))){
        if(total1>=total2 && total1>=total3){
            total1 -=SL2.pop();
        }else if(total2 >=total1 && total2>=total3){
            total2 -=SL2.pop();
        }else{
            total3 -=SL3.pop();
        }
    }
    cout<<endl<<"max :"<<total1;
    return 0;
}
