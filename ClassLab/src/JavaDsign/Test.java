package JavaDsign;

/*
 * 主程序，包含界面。
 * 从下拉菜单中选中司机后点击租借按钮即可获取到一辆交通工具
 * 点击使用便会打印该司机使用的交通工具
 * 点击归还便会将该司机占用的交通工具释放
 * 每一种交通工具具有不同的speed，船为1，车为2，飞机为3
 * 共有三种司机，船只驾驶员，汽车驾驶员，飞机驾驶员
 * 程序默认设置了三位司机Jason，Jams，Jack分别对应上述三种交通工具的司机
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Test 
{
	private JFrame frame;
	private JTextField 显示;
	private Drivers Driver = null;
	Vehicles Vehicle = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		List<Drivers> drivers = new ArrayList<Drivers>();//初始化一个司机表
		CarDriver carDriver = new CarDriver( 1001, "Jams" );//初始化一位汽车司机
		PlaneDriver planeDriver = new PlaneDriver( 1002, "Jack" );//初始化一位飞机驾驶员
		ShipDriver shipDriver = new ShipDriver( 1003, "Jason" );//处时化一位船只驾驶员
		
		Plane plane = new Plane();
		Car car = new Car();
		Ship ship = new Ship();
		
		System_manageVehicles.addVehicle( plane );
		System_manageVehicles.addVehicle( car );
		System_manageVehicles.addVehicle( ship );
		
		drivers.add( carDriver );
		drivers.add( planeDriver );
		drivers.add( shipDriver );
		
		int i = 0; int num = 0;
		for ( @SuppressWarnings("unused") Drivers driver : drivers )//统计列表中的司机数
			num++;
		String[] driverMes = new String[num+1];
		for ( Drivers driver : drivers )//获取司机名字并放入列表中
		{
			driverMes[ i ] = driver.getName();
			i++;
			if ( i == num )
				break;
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 591, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		显示 = new JTextField();
		显示.setHorizontalAlignment(SwingConstants.LEFT);
		显示.setFont(new Font("宋体", Font.BOLD, 23));
		显示.setBackground(Color.DARK_GRAY);
		显示.setForeground(Color.BLACK);
		显示.setEnabled(false);
		显示.setBounds(21, 62, 523, 216);
		frame.getContentPane().add(显示);
		显示.setColumns(10);
		
		JComboBox<Object> 司机 = new JComboBox<Object>();
		司机.setModel(new DefaultComboBoxModel<Object>(driverMes));
		司机.setBounds(102, 14, 120, 27);
		frame.getContentPane().add(司机);
		
		JComboBox<Object> 交通工具 = new JComboBox<Object>();
		交通工具.setMaximumRowCount(100);
		交通工具.setModel(new DefaultComboBoxModel<Object>(new String[] {"\u8239", "\u6C7D\u8F66", "\u98DE\u673A"}));
		交通工具.setBounds(217, 365, 114, 27);
		frame.getContentPane().add(交通工具);
		
		JComboBox 速度 = new JComboBox();
		速度.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		速度.setBounds(357, 14, 52, 27);
		frame.getContentPane().add(速度);
		
		JLabel 增加载具 = new JLabel("\u589E\u52A0\u8F7D\u5177\uFF1A");
		增加载具.setFont(new Font("宋体", Font.PLAIN, 18));
		增加载具.setBounds(138, 366, 120, 29);
		frame.getContentPane().add(增加载具);
		
		JLabel 司机项 = new JLabel("\u9009\u62E9\u53F8\u673A\uFF1A");
		司机项.setFont(new Font("宋体", Font.PLAIN, 18));
		司机项.setBounds(21, 12, 108, 29);
		frame.getContentPane().add(司机项);
		
		JButton 使用交通工具 = new JButton("\u4F7F\u7528");
		使用交通工具.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try 
				{
					String name = 司机.getSelectedItem().toString();//获取下拉菜单中的司机名
					
					for ( Drivers driver : drivers )//遍历drivers找到名字相同的司机
					{
						if ( driver.getName() == name )//通过司机的名字确定申请者
						{
							Driver = driver;
							break;
						}
					}
					
					if ( Driver.getUseVehicle() == null )
						显示.setText( "当前司机未获取任何交通工具" );
					else
					    显示.setText( "当前司机" + Driver.useVehicle() );
				}catch( Exception e )
				{
					显示.setText( "所选项无效" );
				}
			}
		});
		
		JButton 借车 = new JButton("\u79DF\u501F");
		借车.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				String name = new String();
				try 
				{
				    name = 司机.getSelectedItem().toString();//获取下拉菜单中的司机名
				    for ( Drivers driver : drivers )//遍历drivers找到名字相同的司机
					{
						if ( driver.getName() == name )//通过司机的名字确定申请者
						{
							Driver = driver;
							break;
						}
					}
					
					boolean signal = System_getVehicle.vehicleSearch( Driver.getCardStatu() );
					if ( signal )
					{
						Vehicle = System_manageVehicles.searchVehicle( Driver.getCardStatu(), Driver.getCardID(), Driver.getSpeed() );
						Driver.setUseVehicle( Vehicle );
						if ( Driver.getUseVehicle() == null)
							显示.setText( "对于当前司机无可用的交通工具" );
						else
						{
							Driver.setCardStatu(1);
							显示.setText( "当前司机获取到了" + Vehicle.getvType() );
						}
					}
					else
						显示.setText( "当前司机无法获取新的交通工具" );
				}
				catch( Exception e )
				{
					显示.setText( "所选项无效" );
				}
			}
		});
		
		JLabel 速度项 = new JLabel("\u901F\u5EA6\u9879\uFF1A");
		速度项.setFont(new Font("宋体", Font.PLAIN, 18));
		速度项.setBounds(291, 12, 108, 29);
		frame.getContentPane().add(速度项);
		
		借车.setBounds(31, 303, 130, 37);
		frame.getContentPane().add(借车);
		使用交通工具.setBounds(226, 307, 130, 37);
		frame.getContentPane().add(使用交通工具);
		
		JButton 增加 = new JButton("\u589E\u52A0");
		增加.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = 交通工具.getSelectedItem().toString();
				if ( name == "飞机" )
				{
					Plane newPlane = new Plane();
					System_manageVehicles.addVehicle( newPlane );
				}
				else if ( name == "汽车" )
				{
					Car newCar = new Car();
					System_manageVehicles.addVehicle( newCar );
				}
				else if ( name == "船" )
				{
					Ship newShip = new Ship();
					System_manageVehicles.addVehicle( newShip );
				}
				
				显示.setText( "添加" + name + "成功！" );
			}
		});
		增加.setFont(new Font("宋体", Font.PLAIN, 14));
		增加.setBounds(340, 365, 82, 27);
		frame.getContentPane().add(增加);
		
		JButton 归还 = new JButton("\u5F52\u8FD8");
		归还.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				try
				{
					String name = 司机.getSelectedItem().toString();//获取下拉菜单中的司机名
					
					for ( Drivers driver : drivers )//遍历drivers找到名字相同的司机
					{
						if ( driver.getName() == name )//通过司机的名字确定申请者
						{
							Driver = driver;
							break;
						}
					}
					
					boolean statu = System_manageVehicles.returnVehicle( Driver.getCardStatu(), Driver.getCardID() );
					if ( statu )
					{
						Driver.setCardStatu( 0 );
						Driver.setUseVehicle( null );
						显示.setText( Driver.getName() + "已归还交通工具" );
					}
					else
						显示.setText( "当前司机未使用交通工具" );
				}catch( Exception e )
				{
					显示.setText( "所选项无效" );
				}
			}
		});
		归还.setBounds(414, 307, 114, 37);
		frame.getContentPane().add(归还);
		
		JButton 重设 = new JButton("\u91CD\u8BBE\u901F\u5EA6");
		重设.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try
				{
					String name = 司机.getSelectedItem().toString();//获取下拉菜单中的司机名
					int speed = Integer.valueOf( 速度.getSelectedItem().toString() ).intValue();
				
				    for ( Drivers driver : drivers )//遍历drivers找到名字相同的司机
				    {
					    if ( driver.getName() == name )//通过司机的名字确定申请者
					    {
						    Driver = driver;
						    break;
					    }
				    }
				    Driver.setSpeed( speed );
				    显示.setText( "已设置速度为" + speed );
				    
				}catch( Exception e )
				{
				    	显示.setText( "所选项无效" );
				}
			}
		});
		重设.setFont(new Font("宋体", Font.PLAIN, 18));
		重设.setBounds(420, 14, 114, 27);
		frame.getContentPane().add(重设);
	}
}