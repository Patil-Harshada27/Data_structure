// Doubly Circular
#include<iostream>
using namespace std;

#pragma pack(1)

template<class T>
class DoublyCLLnode
{
    public:
        T data;
        DoublyCLLnode<T> *next;
        DoublyCLLnode<T> *prev;
};
template<class T>
class DoublyCLL
{
    private:
    DoublyCLLnode<T> *first;
    DoublyCLLnode<T> *last;
    int iCount;

public:    
DoublyCLL();

    void InsertFirst(T);
    void InsertLast(T);
    void InsertAtPos(T, int);

    void DeleteFirst();
    void DeleteLast();
    void DeleteAtPos(int);

    void Display();
    int Count();
};

template<class T>
DoublyCLL<T>::DoublyCLL()
{
    cout<<"Object of DOUBLYCLL gets created.\n";
    first = NULL;
    last = NULL;
    iCount = 0;
}

template<class T>
void DoublyCLL<T>::InsertFirst(T no)
{
DoublyCLLnode<T>*newn = new DoublyCLLnode<T>;

newn->data = no;
newn->next = NULL;
newn->prev = NULL;

if(first == NULL && last == NULL)
{
    first = newn;
    last = newn;
    first->next = first;
    first->prev = first;
}
else
{
    newn->next = first;
    first->prev = newn;
    first = newn;
    
   last->next = first;
   first->prev = last;


}
iCount++;
}

template<class T>
void DoublyCLL<T>::InsertLast(T no)
{
DoublyCLLnode<T>* newn = new DoublyCLLnode<T>;

newn->data = no;
newn->next = NULL;
newn->prev = NULL;

if(first == NULL && last == NULL) // LL is empty
{
    first = newn;
    last = newn;
}
else    // LL contains one or more
{
    last->next = newn;
    newn->prev = last;
    last = newn;
}

last->next = first;
first->prev = last;

iCount++;
}

template<class T>
void DoublyCLL<T>:: InsertAtPos(T no, int pos)
{
DoublyCLLnode<T>* temp = NULL;
DoublyCLLnode<T>* newn = NULL;
int iCnt = 0;


if(pos < 1 || pos > iCount+1)
{
    cout<<"Invalid position\n";
    return;
}

if(pos == 1)
{
    InsertFirst(no);
}
else if(pos == iCount+1)
{
    InsertLast(no);
}
else
{
    newn = new DoublyCLLnode<T>;
    
    newn->data = no;
    newn->next = NULL;
    newn->prev = NULL;

    temp = first;

    for(iCnt = 1; iCnt < pos-1; iCnt++)
    {
        temp = temp->next;
    }

    newn->next = temp->next;
    newn->next->prev = newn;

    temp->next = newn;
    newn->prev = temp;

    iCount++;
}
}

template<class T>
void DoublyCLL<T>:: DeleteFirst()
{
if(first == NULL && last == NULL) // LL is empty
{
    return;
}
else if(first == last)    // LL contains 1 node
{
    delete(first);
    first = NULL;
    last = NULL;
}
else
{
    DoublyCLLnode<T>* temp = first;
    first = first ->next;
    delete(first->prev);

    last->next = first;
    first->prev = last;
}
iCount--;
}

template<class T>
void DoublyCLL<T>::DeleteLast()
{
if(first == NULL && last == NULL) // LL is empty
{
    return;
}
else if(first == last)    // LL contains 1 node
{
    delete(first);
    first = NULL;
    last = NULL;
}
else
{
    last = (last)->prev;
    delete(last->next);
    
    (last)->next = first;
    (first)->prev = last;
}    
iCount--;
}

template<class T>
void DoublyCLL<T>::DeleteAtPos(int pos)
{
DoublyCLLnode<T>* temp = NULL;
int iCnt = 0;

if(pos < 1 || pos > iCount)
{
    cout<<"Invalid position\n";
    return;
}

if(pos == 1)
{
    DeleteFirst();
}
else if(pos == iCount)
{
    DeleteLast();
}
else
{
    temp = first;

    for(iCnt = 1; iCnt < pos-1; iCnt++)
    {
        temp = temp->next;
    }

    temp->next = temp->next->next;
    delete(temp->next->prev);
    temp->next->prev = temp;
    iCount--;
}
}

template<class T>
void DoublyCLL<T>::Display()
{
    if(first == NULL)
    {
        cout<<"Linked List is empty\n";
        return;
    }

    DoublyCLLnode<T>* temp = first;

    cout<<" <=> ";

    do
    {
        cout<<"| "<<temp->data<<" | <=> ";
        temp = temp->next;
    }
    while(temp != first);

    cout<<"\n";
}


template<class T>
int DoublyCLL<T>:: Count()
{
    return iCount;
}

int main()
{
    DoublyCLL<int> obj;
    int iRet = 0;

    obj.InsertFirst(51);
    obj.InsertFirst(21);
    obj.InsertFirst(11);

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of nodes are : "<<iRet<<"\n";

    obj.InsertLast(101);
    obj.InsertLast(111);
    obj.InsertLast(121);
    obj.Display();
    iRet = obj.Count();
    cout<<"Number of nodes are : "<<iRet<<"\n";
    
    obj.DeleteFirst();
    obj.Display();
    iRet = obj.Count();
    cout<<"Number of nodes are : "<<iRet<<"\n";

    obj.DeleteLast();
    obj.Display();
    iRet = obj.Count();
    cout<<"Number of nodes are : "<<iRet<<"\n";

    obj.InsertAtPos(21,3);
    obj.Display();
    iRet = obj.Count();
    cout<<"Number of nodes are : "<<iRet<<"\n";

    obj.DeleteAtPos(3);
    obj.Display();
    iRet = obj.Count();
    cout<<"Number of nodes are : "<<iRet<<"\n";

    return 0;
}