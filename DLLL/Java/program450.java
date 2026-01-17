 //////////////////////////////////////////////////////////////
//
//Description :doubly linear linked list in java
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

class DoublyLL
{
    private node first;
    private int iCount;

    public DoublyLL()  
    {
        System.out.println("Object of DoublyLL is created");
        this.first = null;
        this.iCount = 0;
    }
    public void InsertFirst(int no)
    {
        node newn = new node(no);

        if(first == null)
        {
            first = newn;
        }
        else
        {
            newn.next = first;
            first.prev = newn;
            first = newn;
        }
        iCount++;
    }
    public void InsertLast(int no)
    {
        node newn = new node(no);
        node temp = null;

        if(first == null)
        {
            first = newn;
        }
        else
        {
            temp = first;
            while(temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = newn;
            newn.prev = temp;  //$

        }
        iCount++;
    }
    public void InsertAtPos(int no,int pos)
    {
        node newn = null;
        node temp = null;

        int iCnt = 0;

        if((pos < 1) || (pos > iCount + 1))
        {
            System.out.println("Invalid Position");
            return;
        }
        if(pos == 1)
        {
            InsertFirst(no);
        }
        else if(pos == iCount + 1)
        {
            InsertLast(no);
        }
        else
        {
            newn = new node(no);

            temp = first;

            for(iCnt = 1;iCnt <pos-1  ; iCnt++)
            {
                temp = temp.next;
            }

            newn.next = temp.next;
            temp.next.prev = newn;
            temp.next = newn;
            newn.prev = temp;
            iCount++;
        }
    }
    public void DeleteFirst()
    {
        node temp = null;

        if(first == null)
        {
            return;
        }
        else if(first.next == null)
        {
            first = null;
        }
        else
        {
            temp = first;
            first = first.next;
            first.prev = null;   //$
            iCount--;
        }
    }
    public void DeleteLast()
    {
        node temp = null;
        if(first == null)
        {
            return;
        }
        else if(first.next == null)
        {
            first = null;
        }
        else
        {
            temp = first;

            while(temp.next.next != null)
            {
                temp = temp.next;
            }
            temp.next = null;
            iCount--;
        }
    }
    public void DeleteAtPos(int pos)
    {
        node temp = null;
        node target = null;
        int iCnt = 0;

        if((pos<1)||(pos > iCount))
        {
            System.out.println("Invalid Position\n");
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

            for(iCnt = 1 ; iCnt < pos-1 ;iCnt++)
            {
                temp = temp.next;
            }
            target = temp.next;

            temp.next = target.next;
            temp.next.prev = temp;
            iCount--;
        }
    }
    public void Display()
    {
        node temp = null;

        temp = first;

        System.out.print("NULL <=> ");
        while(temp != null)
        {
            System.out.print( "|" +temp.data  +"| <=> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public int Count()
    {
        return this.iCount;
    }

}
class program450
{
    public static void main(String A[])
    {
        int iRet = 0;

        DoublyLL obj = null;
        obj = new DoublyLL();

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