package JavaDsign;

abstract class Drivers
{
	private String name;
	private int cardID = 0;//��ʻ֤���������Ĭ��δ����Ϊ0�����м�ʻ֤������һ���������
	private int cardStatu = 1;//��cardStatuΪ1ʱ��ʾcard�޷�ʹ�û�����ռ��
	private int speed;
	private UseVehicles UseVehicle;
	
	public Drivers() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCardID() {
		return cardID;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
	}
	
	public int getCardStatu() {
		return cardStatu;
	}

	public void setCardStatu(int cardStatu) {
		this.cardStatu = cardStatu;
	}
	
	public UseVehicles getUseVehicle() {
		return UseVehicle;
	}

	public void setUseVehicle(UseVehicles useVehicle) {
		this.UseVehicle = useVehicle;
	}
	
	public String useVehicle()
	{
		return UseVehicle.useVehicle();
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
