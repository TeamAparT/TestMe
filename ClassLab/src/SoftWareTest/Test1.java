package SoftWareTest;

public class Test1 
{
    public static void main(String[] args) 
    {
        Test.testTriangle();
    }

    //返回值改为整数值代码比较合适
    //-2:超出边界
    //-1：输入不合法
    //0：构不成三角形
    //1：一般三角形
    //2：等腰三角形
    //3：等边三角形
    Integer Triangle( Object one, Object two, Object three ) 
    {
        if ( one==null || two==null || three==null ) 
        {
        	System.out.println( "无效输入" );
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
            	System.out.println( "超出边界" );
                return -2;
            }

            if ( a+b <=c || a+c <=b || b+c <=a) 
            {
            	System.out.println( "不构成三角形" );
                return 0;
            }

            if ( a == b || a == c || b == c )
            {
                if( a == b && b == c )
                {	
                    r = 3;
                    System.out.println( "等边三角形" );
                }
                else
                {
                	r = 2;
                	System.out.println( "等腰三角形" );
                }
            }
            else 
            {
                r = 1;
                System.out.println( "一般三角形" );
            }
            return r;
        } 
        catch ( Exception e )
        {
        	System.out.println( "无效输入" );
            return -1;
        }
    }
}

    