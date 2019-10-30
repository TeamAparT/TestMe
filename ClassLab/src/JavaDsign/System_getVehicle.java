package JavaDsign;

public class System_getVehicle 
{
	private int speed;
	private int cardID;
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getCard() {
		return cardID;
	}
	public void setCard(int cardID) {
		this.cardID = cardID;
	}
	
	public static boolean vehicleSearch( int cardStatu )
	{
		if ( cardStatu == 1 )//如果cardStatu为0，则当前司机无法申请
			return false;
		
		return true;//向管理模块发出查询信息
	}
}
