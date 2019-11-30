package uz.qb.services.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;
import java.util.ArrayList;

@WebService(endpointInterface = "uz.qb.services.ws.TroubleshootWebServiceFSSoap")
public class WebServiceImpl implements TroubleshootWebServiceFSSoap {

    private int authCounter;
    private String xmlRequest;
    private String xmlResponse;

    private Logger logger = LoggerFactory.getLogger(WebServiceImpl.class);

    public WebServiceImpl() {
        authCounter = 1;
    }

    @Override
    public String serverVersion() {
        return null;
    }

    @Override
    public String clientVersion(String strVersion) {
        return null;
    }

    @Override
    public ArrayOfString authenticate(String strUserName, String strPassword) {
        ++authCounter;
        ArrayOfString arr = new ArrayOfString();
        arr.string = new ArrayList<String>();
        arr.string.add("Session " + authCounter + " initiated");
        logger.info("Session " + authCounter + " initiated");
        arr.string.add(""); //To use the currently open company, specify an empty string
        return arr;
    }

    @Override
    public String connectionError(String ticket, String hresult, String message) {
        return null;
    }

    @Override
    public String sendRequestXML(String ticket, String strHCPResponse, String strCompanyFileName, String qbXMLCountry, int qbXMLMajorVers, int qbXMLMinorVers) {
        logger.info("Sending request on session " + authCounter);
        return this.getXmlRequest();
    }

    @Override
    public int receiveResponseXML(String ticket, String response, String hresult, String message) {
        this.setXmlResponse(response);
        logger.info("Session " + authCounter + " received response");
        System.out.println(response);
        return 100;
    }

    @Override
    public String getLastError(String ticket) {
        return null;
    }

    @Override
    public String closeConnection(String ticket) {
        logger.info("Connection for session " + authCounter + " has been closed.");
        return null;
    }

    /*
     * Getters and setters
     */
    public String getXmlRequest() {
        return xmlRequest;
    }

    public void setXmlRequest(String xmlRequest) {
        this.xmlRequest = xmlRequest;
    }

    public String getXmlResponse() {
        return xmlResponse;
    }

    public void setXmlResponse(String xmlResponse) {
        this.xmlResponse = xmlResponse;
    }
}
