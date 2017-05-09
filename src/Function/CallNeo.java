package Function;

import java.net.MalformedURLException;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class CallNeo {
	
	
	public static String NeoRequest (String inputString, String sexVoice)  throws MalformedURLException{
		String resultCode = new String();
		String resultString = new String(); 
		String conversionNumber = new String();
		String status = new String();
		String statusCode = new String();
		String downloadUrl = new String();
		
		try {
			
			 String strEndPoint = "https://tts.neospeech.com/soap_1_1.php";
			 org.apache.axis.client.Service objService = new Service();
			 org.apache.axis.client.Call objCall = (Call) objService.createCall();
			 objCall.setTargetEndpointAddress( new java.net.URL(strEndPoint) );
			 objCall.setOperationName(
				 new QName("https://tts.neospeech.com/soap_1_1.php", "ConvertSimple"));
				 // Invoke Call to ConvertSimple
				 String[] strReturnArray = (String[]) objCall.invoke(new Object[] {
					 "xiaoxi.dong@pandadar.com",
					 "f73f212b3d",
					 "LoginKey",
					 "215b26aafca5a30fb533",
					 sexVoice,
					 "FORMAT_WAV",
					 16,
					 inputString
			 });
			 
				 
			 // Iterate through the returned string array
			 String[] strIndexArray = strReturnArray[0].split(",");
			 for (int intIndex = 1; intIndex < strReturnArray.length; intIndex++) 
			 {
				 System.out.println(
				     strIndexArray[intIndex - 1] + " = " +
				     strReturnArray[intIndex]);
				switch(strIndexArray[intIndex - 1]){
					case "resultCode": 
						 resultCode = strReturnArray[intIndex];
						 break;
					case "resultString":
						 resultString =  strReturnArray[intIndex];
							break;
					case "conversionNumber":
						conversionNumber = strReturnArray[intIndex];
						break;
					case "status":
						status = strReturnArray[intIndex];
						break;
					case "statusCode":
						statusCode = strReturnArray[intIndex];
						break;
					default:
						System.err.println("Unknown Response Parameter: "+ strReturnArray[intIndex]);
				}
				 
			 }

		}
		catch (Exception e) {
			 System.err.println(e.toString());
		}
		

		if (!resultCode.equals("0")){
			return null;
		}
		

		resultCode = new String(); 
		resultString = new String(); 
		status = new String();
		statusCode = new String();
		
		int statuscheck = 0;
		while( (statuscheck >= 0) && (statuscheck <5)){
			System.out.println("LLL");
			try {
				 String strEndPoint = "https://tts.neospeech.com/soap_1_1.php";
				 org.apache.axis.client.Service objService = new Service();
				 org.apache.axis.client.Call objCall = (Call)
				 objService.createCall();
				 objCall.setTargetEndpointAddress( new java.net.URL(strEndPoint) );
				 objCall.setOperationName(
					 new QName("https://tts.neospeech.com/soap_1_1.php", "GetConversionStatus"));
					 // Invoke Call to GetConversionStatus
					 String[] strReturnArray = (String[]) objCall.invoke(new Object[] {
							 "xiaoxi.dong@pandadar.com",
							 "f73f212b3d",
							 conversionNumber
				 });
				// Iterate through the returned string array
				 String[] strIndexArray = strReturnArray[0].split(",");
				 for (int intIndex = 1; intIndex < strReturnArray.length; intIndex++) {
					 System.out.println(
					 strIndexArray[intIndex - 1] + " = " +
					 strReturnArray[intIndex]);
					 switch(strIndexArray[intIndex - 1]){
						case "resultCode": 
							resultCode = strReturnArray[intIndex];
							break;
						case "resultString":
							resultString =  strReturnArray[intIndex];
							break;
						case "downloadUrl":
							downloadUrl = strReturnArray[intIndex];
							break;
						case "status":
							status = strReturnArray[intIndex];;
							break;
						case "statusCode":
							statusCode = strReturnArray[intIndex];
							break;
						default:
							System.err.println("Unknown Response Parameter");
					}
					 
				 }
				 
			} catch (Exception e) {
				 System.err.println(e.toString());
			}
			statuscheck++;
			if( statusCode.equals("4")){
				statuscheck = -1;
				break;
			}
		}
		return downloadUrl;
	}
}