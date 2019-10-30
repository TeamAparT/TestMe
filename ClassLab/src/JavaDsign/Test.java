package JavaDsign;

/*
 * �����򣬰������档
 * �������˵���ѡ��˾��������谴ť���ɻ�ȡ��һ����ͨ����
 * ���ʹ�ñ���ӡ��˾��ʹ�õĽ�ͨ����
 * ����黹��Ὣ��˾��ռ�õĽ�ͨ�����ͷ�
 * ÿһ�ֽ�ͨ���߾��в�ͬ��speed����Ϊ1����Ϊ2���ɻ�Ϊ3
 * ��������˾������ֻ��ʻԱ��������ʻԱ���ɻ���ʻԱ
 * ����Ĭ����������λ˾��Jason��Jams��Jack�ֱ��Ӧ�������ֽ�ͨ���ߵ�˾��
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
	private JTextField ��ʾ;
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
		List<Drivers> drivers = new ArrayList<Drivers>();//��ʼ��һ��˾����
		CarDriver carDriver = new CarDriver( 1001, "Jams" );//��ʼ��һλ����˾��
		PlaneDriver planeDriver = new PlaneDriver( 1002, "Jack" );//��ʼ��һλ�ɻ���ʻԱ
		ShipDriver shipDriver = new ShipDriver( 1003, "Jason" );//��ʱ��һλ��ֻ��ʻԱ
		
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
		for ( @SuppressWarnings("unused") Drivers driver : drivers )//ͳ���б��е�˾����
			num++;
		String[] driverMes = new String[num+1];
		for ( Drivers driver : drivers )//��ȡ˾�����ֲ������б���
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
		
		��ʾ = new JTextField();
		��ʾ.setHorizontalAlignment(SwingConstants.LEFT);
		��ʾ.setFont(new Font("����", Font.BOLD, 23));
		��ʾ.setBackground(Color.DARK_GRAY);
		��ʾ.setForeground(Color.BLACK);
		��ʾ.setEnabled(false);
		��ʾ.setBounds(21, 62, 523, 216);
		frame.getContentPane().add(��ʾ);
		��ʾ.setColumns(10);
		
		JComboBox<Object> ˾�� = new JComboBox<Object>();
		˾��.setModel(new DefaultComboBoxModel<Object>(driverMes));
		˾��.setBounds(102, 14, 120, 27);
		frame.getContentPane().add(˾��);
		
		JComboBox<Object> ��ͨ���� = new JComboBox<Object>();
		��ͨ����.setMaximumRowCount(100);
		��ͨ����.setModel(new DefaultComboBoxModel<Object>(new String[] {"\u8239", "\u6C7D\u8F66", "\u98DE\u673A"}));
		��ͨ����.setBounds(217, 365, 114, 27);
		frame.getContentPane().add(��ͨ����);
		
		JComboBox �ٶ� = new JComboBox();
		�ٶ�.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		�ٶ�.setBounds(357, 14, 52, 27);
		frame.getContentPane().add(�ٶ�);
		
		JLabel �����ؾ� = new JLabel("\u589E\u52A0\u8F7D\u5177\uFF1A");
		�����ؾ�.setFont(new Font("����", Font.PLAIN, 18));
		�����ؾ�.setBounds(138, 366, 120, 29);
		frame.getContentPane().add(�����ؾ�);
		
		JLabel ˾���� = new JLabel("\u9009\u62E9\u53F8\u673A\uFF1A");
		˾����.setFont(new Font("����", Font.PLAIN, 18));
		˾����.setBounds(21, 12, 108, 29);
		frame.getContentPane().add(˾����);
		
		JButton ʹ�ý�ͨ���� = new JButton("\u4F7F\u7528");
		ʹ�ý�ͨ����.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try 
				{
					String name = ˾��.getSelectedItem().toString();//��ȡ�����˵��е�˾����
					
					for ( Drivers driver : drivers )//����drivers�ҵ�������ͬ��˾��
					{
						if ( driver.getName() == name )//ͨ��˾��������ȷ��������
						{
							Driver = driver;
							break;
						}
					}
					
					if ( Driver.getUseVehicle() == null )
						��ʾ.setText( "��ǰ˾��δ��ȡ�κν�ͨ����" );
					else
					    ��ʾ.setText( "��ǰ˾��" + Driver.useVehicle() );
				}catch( Exception e )
				{
					��ʾ.setText( "��ѡ����Ч" );
				}
			}
		});
		
		JButton �賵 = new JButton("\u79DF\u501F");
		�賵.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				String name = new String();
				try 
				{
				    name = ˾��.getSelectedItem().toString();//��ȡ�����˵��е�˾����
				    for ( Drivers driver : drivers )//����drivers�ҵ�������ͬ��˾��
					{
						if ( driver.getName() == name )//ͨ��˾��������ȷ��������
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
							��ʾ.setText( "���ڵ�ǰ˾���޿��õĽ�ͨ����" );
						else
						{
							Driver.setCardStatu(1);
							��ʾ.setText( "��ǰ˾����ȡ����" + Vehicle.getvType() );
						}
					}
					else
						��ʾ.setText( "��ǰ˾���޷���ȡ�µĽ�ͨ����" );
				}
				catch( Exception e )
				{
					��ʾ.setText( "��ѡ����Ч" );
				}
			}
		});
		
		JLabel �ٶ��� = new JLabel("\u901F\u5EA6\u9879\uFF1A");
		�ٶ���.setFont(new Font("����", Font.PLAIN, 18));
		�ٶ���.setBounds(291, 12, 108, 29);
		frame.getContentPane().add(�ٶ���);
		
		�賵.setBounds(31, 303, 130, 37);
		frame.getContentPane().add(�賵);
		ʹ�ý�ͨ����.setBounds(226, 307, 130, 37);
		frame.getContentPane().add(ʹ�ý�ͨ����);
		
		JButton ���� = new JButton("\u589E\u52A0");
		����.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = ��ͨ����.getSelectedItem().toString();
				if ( name == "�ɻ�" )
				{
					Plane newPlane = new Plane();
					System_manageVehicles.addVehicle( newPlane );
				}
				else if ( name == "����" )
				{
					Car newCar = new Car();
					System_manageVehicles.addVehicle( newCar );
				}
				else if ( name == "��" )
				{
					Ship newShip = new Ship();
					System_manageVehicles.addVehicle( newShip );
				}
				
				��ʾ.setText( "���" + name + "�ɹ���" );
			}
		});
		����.setFont(new Font("����", Font.PLAIN, 14));
		����.setBounds(340, 365, 82, 27);
		frame.getContentPane().add(����);
		
		JButton �黹 = new JButton("\u5F52\u8FD8");
		�黹.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				try
				{
					String name = ˾��.getSelectedItem().toString();//��ȡ�����˵��е�˾����
					
					for ( Drivers driver : drivers )//����drivers�ҵ�������ͬ��˾��
					{
						if ( driver.getName() == name )//ͨ��˾��������ȷ��������
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
						��ʾ.setText( Driver.getName() + "�ѹ黹��ͨ����" );
					}
					else
						��ʾ.setText( "��ǰ˾��δʹ�ý�ͨ����" );
				}catch( Exception e )
				{
					��ʾ.setText( "��ѡ����Ч" );
				}
			}
		});
		�黹.setBounds(414, 307, 114, 37);
		frame.getContentPane().add(�黹);
		
		JButton ���� = new JButton("\u91CD\u8BBE\u901F\u5EA6");
		����.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try
				{
					String name = ˾��.getSelectedItem().toString();//��ȡ�����˵��е�˾����
					int speed = Integer.valueOf( �ٶ�.getSelectedItem().toString() ).intValue();
				
				    for ( Drivers driver : drivers )//����drivers�ҵ�������ͬ��˾��
				    {
					    if ( driver.getName() == name )//ͨ��˾��������ȷ��������
					    {
						    Driver = driver;
						    break;
					    }
				    }
				    Driver.setSpeed( speed );
				    ��ʾ.setText( "�������ٶ�Ϊ" + speed );
				    
				}catch( Exception e )
				{
				    	��ʾ.setText( "��ѡ����Ч" );
				}
			}
		});
		����.setFont(new Font("����", Font.PLAIN, 18));
		����.setBounds(420, 14, 114, 27);
		frame.getContentPane().add(����);
	}
}