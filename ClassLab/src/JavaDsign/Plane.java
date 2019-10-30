package JavaDsign;

public class Plane extends Vehicles
{
	public Plane( )
	{
		super.setvType( "飞机" );
		super.setStatu( 0 );
		super.setSpeed( 3 );
	}
	
	public String useVehicle()
	{
		return "正在开飞机";
	}
}
