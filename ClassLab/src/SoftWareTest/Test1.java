package SoftWareTest;

public class Test1 
{
    public static void main(String[] args) 
    {
        Test.testTriangle();
    }

    //����ֵ��Ϊ����ֵ����ȽϺ���
    //-2:�����߽�
    //-1�����벻�Ϸ�
    //0��������������
    //1��һ��������
    //2������������
    //3���ȱ�������
    Integer Triangle( Object one, Object two, Object three ) 
    {
        if ( one==null || two==null || three==null ) 
        {
        	System.out.println( "��Ч����" );
            return -1;
        }

        Integer r;
        
        try 
        {
            int a = (Integer)one;
            int b = (Integer)two;
            int c = (Integer)three;

            if ( a<=0 || b<=0 || c<=0 || a>200 || b>200 || c>200 ) 
            {
            	System.out.println( "�����߽�" );
                return -2;
            }

            if ( a+b <=c || a+c <=b || b+c <=a) 
            {
            	System.out.println( "������������" );
                return 0;
            }

            if ( a == b || a == c || b == c )
            {
                if( a == b && b == c )
                {	
                    r = 3;
                    System.out.println( "�ȱ�������" );
                }
                else
                {
                	r = 2;
                	System.out.println( "����������" );
                }
            }
            else 
            {
                r = 1;
                System.out.println( "һ��������" );
            }
            return r;
        } 
        catch ( Exception e )
        {
        	System.out.println( "��Ч����" );
            return -1;
        }
    }
}

    