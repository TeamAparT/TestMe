package JavaDsign;

public class Plane extends Vehicles
{
	public Plane( )
	{
		super.setvType( "�ɻ�" );
		super.setStatu( 0 );
		super.setSpeed( 3 );
	}
	
	public String useVehicle()
	{
		return "���ڿ��ɻ�";
	}
}
