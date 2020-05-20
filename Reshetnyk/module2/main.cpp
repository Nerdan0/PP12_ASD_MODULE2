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

    int countSum(){
        NodeStack<T>* p = pTop;
        int total=0;
        while(p){
            total+=p->item;
            p = p->next;
        }
        return total;
    }

};


int main() {
    int size,size2,size3, item;
    StackList<int> SL,SL2,SL3;
    cout<<"Enter N1 N2 N3"<<endl;
    cin>>size>>size2>>size3;
    cout<<"Enter elements of N1"<<endl;
    for(int i =0; i<size;i++){
        cin>>item;
        SL.push(item);
    }
    cout<<"Enter elements of N2"<<endl;
    for(int i =0; i<size2;i++){
        cin>>item;
        SL2.push(item);
    }
    cout<<"Enter elements of N3"<<endl;
    for(int i =0; i<size3;i++){
        cin>>item;
        SL3.push(item);
    }
    int sum1=SL.countSum();
    int sum2= SL2.countSum();
    int sum3= SL3.countSum();
    while(!((sum1 == sum2) && (sum2 == sum3) && (sum1 == sum3))){
        if(sum1 >= sum2 && sum1 >= sum3){
            sum1 -=SL.pop();
        }else if(sum2 >= sum1 && sum2 >= sum3){
            sum2 -=SL2.pop();
        }else{
            sum3 -=SL3.pop();
        }
    }
    cout<<endl<<"max :"<<sum1;
    return 0;
}
