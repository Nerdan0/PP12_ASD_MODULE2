#include <iostream>
#include <stack> 
#include <locale>
#include <queue>// подключаем библиотеки для 
// использования стеков и очередей
using namespace std;

int main() 
{
	int oper, num;	
	oper = 0;
	int f=0;
	int max = 0;
	int b = 0;
	int max1[100];
	int count = 0;
	setlocale(LC_ALL, "");
	stack <int> steck1;  // создаем стек
	stack <int> steck2;
	while (oper != 4)
	{
		cout << "Виберiть необхiдну операцiю \n 1. Додати число у стек \n 2. Видалити число зi стека \n 3. Вивести найбiльше число зi стека \n 4. Вивести результат" << endl;
		cin >> oper;
		if (oper == 1)
		{ 
			cin >> num;
			steck1.push(num);
			steck2.push(num);
			b++;
		}
		if (oper == 2)
		{
			steck1.pop();
			steck2.pop();
			b--;
		}
		if (oper == 3)
		{
			int a[100];
			for (int i = 0; i < b; i++)
			{
				a[i] = steck2.top();
				steck2.pop();
			}
			for (int i = 0; i < b; i++)
			{
				if (a[i] > max)
				{
					max = a[i];
				}
			}
			f = f+b;
			max1[count] = max;
			b = 0;
			count++;
			cout << "Maximum number is " << max << endl;
			
		}
		
	}
	if (oper == 4)
	{ 
		cout << "Виведемо стек на екран \n ";
		queue<int>que;
		for (int i = 0; i < f; i++) {
			que.push(steck1.top());
			cout << que.front() << " ";
			steck1.pop();
			que.pop();
		}
		cout << "\n Усi найбiльшi значення стеку \n";
		for (int i = 0; i < count; i++)
		{
			cout << max1[i] << endl;
		}
	}
	system("pause");
	return 0;
}