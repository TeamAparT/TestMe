package JavaDsign;

public class PlaneDriver extends Drivers
{
	public PlaneDriver() {}
	public PlaneDriver( int cardID, String name ) 
	{ 
		super.setCardID( cardID ); 
		super.setCardStatu( 0 );
		super.setName( name );
		super.setSpeed( 3 );
	}
}
