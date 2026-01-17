 //////////////////////////////////////////////////////////////
//
//Description :doubly circlular linked list in java
//Author:Harshada anil patil 
// Date: 4/12/2025
//
//
////////////////////////////////////////////////////////////////
class node
{
    public int data;
    public node next;
    public node prev;

    public node(int no)
    {
        this.data = no;
        this.next = null;
        this.prev = null;
    }
}

class DoublyCLL
{
    private node first;
    private node last;
    private int iCount;

    public DoublyCLL()
    {
        System.out.println("Object of DoublyCLL is created");
        this.first = null;
        this.last = null;
        this.iCount = 0;
    }
    public void InsertFirst(int no)
    {
        node newn = new node(no);

        if(first == null && last == null)
        {
            first = newn;
            last = newn;
        }
        else
        {
            newn.next = first;
            first.prev = newn;
            first = newn;
            
            last.next = first;

        }
        iCount++;
    }
    public void InsertLast(int no)
    {
        node newn = new node(no);

        if(first == null && last == null) // LL is empty
        {
            first = newn;
            last = newn;
        }
        else    // LL contains one or more
        {
            last.next = newn;
            newn.prev = last;
            last = newn;
        }

        last.next = first;
        first.prev = last;

        iCount++;
    }
    public void InsertAtPos(int no,int pos)
    {
        node temp = null;
        node newn =  null;
        int iCnt = 0;


        if(pos < 1 || pos > iCount+1)
        {
            System.out.println("Invalid position");
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
            newn = new node(no);

            temp = first;

            for(iCnt = 1; iCnt < pos-1; iCnt++)
            {
                temp = temp.next;
            }

            newn.next = temp.next;
            newn.next.prev = newn;

            temp.next = newn;
            newn.prev = temp;

            iCount++;
        }
    }
    public void DeleteFirst()
    {
        if(first == null && last == null) // LL is empty
        {
            return;
        }
        else if(first == last)    // LL contains 1 node
        {
            first = null;
            last = null;
        }
        else
        {
            first = first.next;

            last.next = first;
            first.prev = last;
        }
        iCount--;
    }
    public void DeleteLast()
    {
        if(first == null && last == null) // LL is empty
        {
            return;
        }
        else if(first == last)    // LL contains 1 node
        {
            first = null;
            last = null;
        }
        else
        {
            last = last.prev;
            
            last.next = first;
            first.prev = last;
        }    
        iCount--;
    }
    public void DeleteAtPos(int pos)
    {
        node temp = null;
        int iCnt = 0;

        if(pos < 1 || pos > iCount)
        {
            System.out.println("Invalid position\n");
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
                temp = temp.next;
            }

            temp.next = temp.next.next;
            temp.next.prev = temp;
            iCount--;
        }  
    }
    public void Display()
    {
        if(first == null && last == null)
        {
            System.out.println("Linked List is empty");
            return;
        }

        node temp = first;

        System.out.print("<=> ");
        do
        {
            System.out.print("|" + temp.data + "| <=> ");
            temp = temp.next;
        } while(temp != first);

        System.out.println();

    }
    public int Count()
    {
        return this.iCount;
    }

}
class program449
{
    public static void main(String A[])
    {
        int iRet = 0;

        DoublyCLL obj = null;
        obj = new DoublyCLL();

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of Nodes are :"+iRet);

        obj.InsertLast(101);
        obj.InsertLast(111);
        obj.InsertLast(121);

        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of Nodes are :"+iRet);

        obj.DeleteFirst();
        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of Nodes are :"+iRet);

        obj.DeleteLast();
        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of Nodes are :"+iRet);

        obj.InsertAtPos(105,4);
        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of Nodes are :"+iRet);

        obj.DeleteAtPos(4);
        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of Nodes are :"+iRet);

        //IMP
        obj = null;
        System.gc();

    }
}