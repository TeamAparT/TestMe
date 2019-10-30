package JavaDsign;

abstract class Drivers
{
	private String name;
	private int cardID = 0;//驾驶证持有情况，默认未持有为0，持有驾驶证将赋予一串随机数字
	private int cardStatu = 1;//当cardStatu为1时表示card无法使用或正被占用
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
