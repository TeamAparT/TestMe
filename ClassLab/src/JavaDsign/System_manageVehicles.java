package JavaDsign;

import java.util.ArrayList;
import java.util.List;

/*
 * 交通工具管理类
 * 该类中可以向交通工具列表中添加新的交通工具
 * 可以搜寻空闲的交通工具并返回给司机
 * 可以实现交通工具的退回
 */
public class System_manageVehicles 
{	
	static List<Vehicles> vehicleList = new ArrayList<Vehicles>();//创建一个列表以存储交通工具
	
	public static void addVehicle( Vehicles vehicle )//向列表中添加新的交通工具
	{
		vehicleList.add(vehicle);
	}
	
	public static Vehicles searchVehicle( int cardStatu, int cardID, int speed )//寻找空闲交通工具并返回给司机
	{
		Vehicles Vehicle = null;
		if ( cardStatu == 0 )
		{
			for( Vehicles vehicle : vehicleList )
			{
				if ( vehicle.getStatu() == 0 && vehicle.getSpeed() == speed )
				{
					Vehicle = vehicle;
					vehicle.setCardID(cardID);//关联司机卡号
					vehicle.setStatu( 1 );//将状态码置为占用态
					break;
				}
			}
		}
		return Vehicle;//如果没有则返回null
	}
	
	public static boolean returnVehicle( int cardStatu, int cardID )
	{
		if ( cardStatu == 1 )
		{
			for ( Vehicles vehicle : vehicleList )
			{
				if ( vehicle.getCardID() == cardID )
				{
					vehicle.setStatu(0);//重置交通工具的状态
					vehicle.setCardID(0);
					return true;
				}
			}
		}
		return false;
	}
}
