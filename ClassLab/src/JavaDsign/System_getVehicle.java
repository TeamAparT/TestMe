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
		if ( cardStatu == 1 )//���cardStatuΪ0����ǰ˾���޷�����
			return false;
		
		return true;//�����ģ�鷢����ѯ��Ϣ
	}
}
