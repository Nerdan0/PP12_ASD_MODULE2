//Решетник Денис ПП12 Модуль2 Завдання 1 Варіант4.+
#include <iostream>
using namespace std;
struct Node{
    int data;
    Node* right;
    Node* left;
};

Node* create(int data){
    Node* temp = new Node();
    temp->data = data;
    temp->right=temp->left=NULL;
    return temp;
}

void insert(Node* &root, int data) {
    if (root == NULL) {
        root = create(data);
    } else if (root->data > data)
        insert(root->left, data);
    else
        insert(root->right, data);

}

void display(Node * root){//sorted
    if(root!=NULL){
        display(root->left);
        cout<<root->data<<" ";
        display(root->right);
    }
}

Node *lca(Node* root, int n1, int n2)
{
    if (root == NULL) return NULL;

    if (root->data > n1 && root->data > n2)
        return lca(root->left, n1, n2);

    if (root->data < n1 && root->data < n2)
        return lca(root->right, n1, n2);

    return root;
}

int main() {
    Node* temp =new Node();
    Node* root = NULL;
    int n, num, n1, n2, n3;
    cout<<"Enter n:";
    cin>>n;
    for(int i = 0; i < n; i++)
        cin>>num,insert(root,num);
    display(root);
    cout<<"enter n1 and n2";
    cin>>n1>>n2;
    n3=lca(root,n1,n2)->data;
    cout<<n3;
    return 0;
}
