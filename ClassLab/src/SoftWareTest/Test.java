package SoftWareTest;

import java.util.ArrayList;

public class Test
{
	private Object a;
    private Object b;
    private Object c;
    private Integer r;

    public Test() {}

	public Test( Object a, Object b, Object c, Integer r ) 
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.r = r;
    }

	public Object getA() {
		return a;
	}

	public void setA(Object a) {
		this.a = a;
	}

	public Object getB() {
		return b;
	}

	public void setB(Object b) {
		this.b = b;
	}

	public Object getC() {
		return c;
	}

	public void setC(Object c) {
		this.c = c;
	}

	public Integer getR() {
		return r;
	}

	public void setR(Integer r) {
		this.r = r;
	}
	
	public static void testTriangle() 
    {
        //边界值测试
        Test t1 = new Test( 1, 1, 200, 0 );
        Test t2 = new Test( 1, 2, 199, 0 );
        Test t3 = new Test( 1, 100, 100, 2 );
        Test t4 = new Test( 1, 199, 2, 0 );
        Test t5 = new Test( 1, 200, 1, 0 );
        Test t6 = new Test( 2, 1, 200, 0 );
        Test t7 = new Test( 2, 2, 199, 0 );
        Test t8 = new Test( 2, 100, 100, 2 );
        Test t9 = new Test( 2, 199, 2, 0 );
        Test t10 = new Test( 2, 200, 1, 0 );
        Test t11 = new Test( 100, 1, 200,  0 );
        Test t12 = new Test( 100, 2, 199, 0 );
        Test t13 = new Test( 100, 100, 100, 3 );
        Test t14 = new Test( 100, 199, 2, 0 );
        Test t15 = new Test( 100, 200, 1, 0 );
        Test t16 = new Test( 199, 1, 200, 0 );
        Test t17 = new Test( 199, 2, 199, 2 );
        Test t18 = new Test( 199, 100, 100, 2 );
        Test t19 = new Test( 199, 199, 2, 2 );
        Test t20 = new Test( 199, 200, 1, 0);
        Test t21 = new Test( 200, 1, 200, 2 );
        Test t22 = new Test( 200, 2, 199, 1 );
        Test t23 = new Test( 200, 100, 100, 0 );
        Test t24 = new Test( 200, 199, 2, 1 );
        Test t25 = new Test( 200, 200, 1, 2 );
        
        //无效等价类
        Test t26 = new Test( 100.1, 100, 100, -1 );
        Test t27 = new Test( 100, 100.1, 100, -1 );
        Test t28 = new Test( 100, 100, 100.1, -1 );
        Test t29 = new Test( 100.1, 100.1, 100, -1 );
        Test t30 = new Test( 100.1, 100, 100.1, -1 );
        Test t31 = new Test( 100, 100.1, 100.1, -1 );
        Test t32 = new Test( 100.1, 100.1, 100.1, -1 );
        Test t33 = new Test( 'a', 100, 100, -1 );
        Test t34 = new Test( 100, 'a', 100, -1 );
        Test t35 = new Test( 100, 100, 'a', -1 );
        Test t36 = new Test( 'a',  'a',  100, -1 );
        Test t37 = new Test( 'a',  100,  'a', -1 );
        Test t38 = new Test( 100,  'a',  'a', -1 );
        Test t39 = new Test( 'a',  'a',  'a', -1 );
        Test t40 = new Test( 100, 100, 200, 0 );
        Test t41 = new Test( 100, 200, 100, 0 );
        Test t42 = new Test( 200, 100, 100, 0 );
        Test t43 = new Test( 5, 5, 11, 0 );
        Test t44 = new Test( 5, 11, 5, 0 );
        Test t45 = new Test( 11, 5, 5, 0 );
        Test t46 = new Test( null, 100, 100, -1 );
        Test t47 = new Test( 100, null, 100, -1 );
        Test t48 = new Test( 100, 100, null, -1 );
        Test t49 = new Test( null, null, 100, -1 );
        Test t50 = new Test( null, 100, null, -1 );
        Test t51 = new Test( 100, null, null, -1 );
        Test t52 = new Test( null, null, null, -1 );
        Test t53 = new Test( -100, 100, 100, -1 );
        Test t54 = new Test( 100, -100, 100, -1 );
        Test t55 = new Test( 100, 100, -100, -1 );
        Test t56 = new Test( -100, -100, 100, -1 );
        Test t57 = new Test( -100, 100, -100, -1 );
        Test t58 = new Test( 100, -100, -100, -1 );
        Test t59 = new Test( -100, -100, -100, -1 );
        
        //有效等价类
        Test t60 = new Test( 100, 100, 100, 3 );
        
        ArrayList <Test> test_list = new ArrayList<>();
        test_list.add(t1);
        test_list.add(t2);
        test_list.add(t3);
        test_list.add(t4);
        test_list.add(t5);
        test_list.add(t6);
        test_list.add(t7);
        test_list.add(t8);
        test_list.add(t9);
        test_list.add(t10);
        test_list.add(t11);
        test_list.add(t12);
        test_list.add(t13);
        test_list.add(t14);
        test_list.add(t15);
        test_list.add(t16);
        test_list.add(t17);
        test_list.add(t18);
        test_list.add(t19);
        test_list.add(t20);
        test_list.add(t21);
        test_list.add(t22);
        test_list.add(t23);
        test_list.add(t24);
        test_list.add(t25);
        test_list.add(t26);
        test_list.add(t27);
        test_list.add(t28);
        test_list.add(t29);
        test_list.add(t30);
        test_list.add(t31);
        test_list.add(t32);
        test_list.add(t33);
        test_list.add(t34);
        test_list.add(t35);
        test_list.add(t36);
        test_list.add(t37);
        test_list.add(t38);
        test_list.add(t39);
        test_list.add(t40);
        test_list.add(t41);
        test_list.add(t42);
        test_list.add(t43);
        test_list.add(t44);
        test_list.add(t45);
        test_list.add(t46);
        test_list.add(t47);
        test_list.add(t48);
        test_list.add(t49);
        test_list.add(t50);
        test_list.add(t51);
        test_list.add(t52);
        test_list.add(t53);
        test_list.add(t54);
        test_list.add(t55);
        test_list.add(t56);
        test_list.add(t57);
        test_list.add(t58);
        test_list.add(t59);
        test_list.add(t60);

        Test1 t = new Test1();

        for ( int i = 0; i < test_list.size(); i++ ) 
        {
        	System.out.printf( "T%d     ", i+1 );
            if ( test_list.get( i ).getR() == t.Triangle( test_list.get(i).getA(),
                                                          test_list.get(i).getB(),
                                                          test_list.get(i).getC() ) ) 
                continue;
            else 
            {
                System.out.println( "" );
            }
        }
    }
}
