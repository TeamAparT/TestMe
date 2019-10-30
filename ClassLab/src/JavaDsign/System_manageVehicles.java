package JavaDsign;

import java.util.ArrayList;
import java.util.List;

/*
 * ��ͨ���߹�����
 * �����п�����ͨ�����б�������µĽ�ͨ����
 * ������Ѱ���еĽ�ͨ���߲����ظ�˾��
 * ����ʵ�ֽ�ͨ���ߵ��˻�
 */
public class System_manageVehicles 
{	
	static List<Vehicles> vehicleList = new ArrayList<Vehicles>();//����һ���б��Դ洢��ͨ����
	
	public static void addVehicle( Vehicles vehicle )//���б�������µĽ�ͨ����
	{
		vehicleList.add(vehicle);
	}
	
	public static Vehicles searchVehicle( int cardStatu, int cardID, int speed )//Ѱ�ҿ��н�ͨ���߲����ظ�˾��
	{
		Vehicles Vehicle = null;
		if ( cardStatu == 0 )
		{
			for( Vehicles vehicle : vehicleList )
			{
				if ( vehicle.getStatu() == 0 && vehicle.getSpeed() == speed )
				{
					Vehicle = vehicle;
					vehicle.setCardID(cardID);//����˾������
					vehicle.setStatu( 1 );//��״̬����Ϊռ��̬
					break;
				}
			}
		}
		return Vehicle;//���û���򷵻�null
	}
	
	public static boolean returnVehicle( int cardStatu, int cardID )
	{
		if ( cardStatu == 1 )
		{
			for ( Vehicles vehicle : vehicleList )
			{
				if ( vehicle.getCardID() == cardID )
				{
					vehicle.setStatu(0);//���ý�ͨ���ߵ�״̬
					vehicle.setCardID(0);
					return true;
				}
			}
		}
		return false;
	}
}
