package JavaDsign;

public class CarDriver extends Drivers//����˾��
{	
	public CarDriver() {}
	public CarDriver( int cardID, String name ) 
	{ 
		super.setCardID( cardID ); 
		super.setCardStatu( 0 );
		super.setName( name );
		super.setSpeed( 2 );
	}
}