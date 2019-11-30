package uz.qb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.qb.services.ws.WebServiceImpl;

import javax.xml.ws.Endpoint;
import java.util.ArrayList;

@Controller
public class MainController {
    private ModelAndView model = new ModelAndView();
    private Endpoint endpoint;
    private ArrayList<String> dataCollection;

    private String responseCustomers;
    private String responseItems;

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping(value = "/invoice")
    public ModelAndView actionCreateInvoice() {
        collectData();

        model.setViewName("invoice-create");

        return model;
    }

    private void collectData() {
        dataCollection = new ArrayList<>();

        dataCollection.add("<?xml version=\"1.0\" ?>" +
                "<?qbxml version=\"2.0\"?>\n" +
                "<QBXML>\n" +
                "  <QBXMLMsgsRq onError=\"continueOnError\">\n" +
                "    <CustomerQueryRq requestID=\"2\" /> \n" +
                "    <ItemInventoryQueryRq requestID=\"1234\" />\n" +
                "  </QBXMLMsgsRq>\n" +
                "</QBXML>");
        dataCollection.add("<?qbxml version=\"8.0\"?>\n" +
                "<QBXML>\n" +
                "   <QBXMLMsgsRq onError=\"stopOnError\">\n" +
                "      <ItemInventoryQueryRq requestID=\"1234\" />\n" +
                "   </QBXMLMsgsRq>\n" +
                "</QBXML>");

        WebServiceImpl ws = new WebServiceImpl();
        ws.setXmlRequest(dataCollection.get(0));

        endpoint = Endpoint.create(ws);
        endpoint.publish("http://localhost:8090/ws");
        responseCustomers = ws.getXmlResponse();

        System.out.println(responseCustomers);

        System.out.println(responseItems);
    }

    @GetMapping(value = "/index")
    public String actionStopEndpoint() {
        endpoint.stop();
        return "index";
    }
}