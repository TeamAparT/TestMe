package JavaDsign;

public abstract class Vehicles implements UseVehicles
{
	private int statu = 1;//Ĭ��Ϊ1���ý�ͨ�����ѱ�ռ��
	private int speed = 0;//��ͨ�����ٶ�ֵ��Ĭ��Ϊ0
	private int cardID = 0;//Ĭ��Ϊ0�����ڹ�����˾��
	private String vType = new String();//��ͨ��������
	
	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}

	public int getCardID() {
		return cardID;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

	public String getvType() {
		return vType;
	}

	public void setvType(String vType) {
		this.vType = vType;
	}

	public Vehicles() {}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
