package jcpackage;

import javacard.framework.APDU;
import javacard.framework.Applet;
import javacard.framework.ISO7816;
import javacard.framework.ISOException;

public class jcApplet extends Applet {
	
	 /******************** Constantes ************************/

    public static final byte CLA_MONAPPLET= (byte) 0xB0;
    public static final byte INS_getLogFrequency = (byte) 0x04;
    public static final byte INS_setLogFrequency = (byte) 0x05;
    public static final byte INS_getProtocol = (byte) 0x06;
    public static final byte INS_setProtocol = (byte) 0x07;
    public static final byte INS_getNextOrder = (byte) 0x08;
    public static final byte INS_receiveLog = (byte) 0x01;
    public static final byte INS_isArrived = (byte) 0x02;
    public static final byte INS_getCypheredLog = (byte) 0x03;
    public static final byte[] planVol = {0x0A, 0x0B, 0x0C, 0x0C, 0x0D};
    
    
    /*** Attributs ***/
    private byte frequency; // pour le moment
    private byte protocol;
    private byte positionActuelle;
    private short i;
    

	private jcApplet() {
		frequency = 0x01;
		protocol = 0x00;
		i=0;
		positionActuelle = planVol[i];
	}

	public static void install(byte bArray[], short bOffset, byte bLength)
			throws ISOException {
		new jcApplet().register();
	}

	
	
	
	
	
	
	public void process(APDU apdu) throws ISOException {
		byte[] buffer= apdu.getBuffer();
		if(this.selectingApplet()) return;
		
		if(buffer[ISO7816.OFFSET_CLA]!=CLA_MONAPPLET)
            ISOException.throwIt(ISO7816.SW_CLA_NOT_SUPPORTED);
		
		switch(buffer[ISO7816.OFFSET_INS]){
		
		case INS_getLogFrequency:
			buffer[0]=frequency;
            apdu.setOutgoingAndSend((short)0, (short) 1);
            break;
            
		case INS_setLogFrequency:
			this.frequency = buffer[ISO7816.OFFSET_P1];
            break;  
            
		case INS_getProtocol:
			buffer[0]=protocol;
            apdu.setOutgoingAndSend((short)0, (short) 1);
            break; 
            
		case INS_setProtocol:
			this.protocol = buffer[ISO7816.OFFSET_P1];
            break; 
        
		case INS_getNextOrder:
			buffer[0] = positionActuelle;
			apdu.setOutgoingAndSend((short)0, (short) 1);
			i++;
			positionActuelle = planVol[i];
			if (i == planVol.length){
				positionActuelle = planVol[i];
			}
            break;     
            
		default:
            ISOException.throwIt(ISO7816.SW_INS_NOT_SUPPORTED);
		}
		
	}

}
