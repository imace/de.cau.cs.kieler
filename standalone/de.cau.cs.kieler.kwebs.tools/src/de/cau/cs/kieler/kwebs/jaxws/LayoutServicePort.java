
package de.cau.cs.kieler.kwebs.jaxws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.3-b01-
 * Generated source version: 2.2
 * 
 */
@WebService(name = "LayoutServicePort", targetNamespace = "http://rtsys.informatik.uni-kiel.de/layout")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface LayoutServicePort {


    /**
     * 
     * @param serializedGraph
     * @param format
     * @param options
     * @return
     *     returns java.lang.String
     * @throws ServiceFault_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "graphLayout", targetNamespace = "http://rtsys.informatik.uni-kiel.de/layout", className = "de.cau.cs.kieler.kwebs.jaxws.GraphLayout")
    @ResponseWrapper(localName = "graphLayoutResponse", targetNamespace = "http://rtsys.informatik.uni-kiel.de/layout", className = "de.cau.cs.kieler.kwebs.jaxws.GraphLayoutResponse")
    @Action(input = "http://rtsys.informatik.uni-kiel.de/layout/LayoutServicePort/graphLayoutRequest", output = "http://rtsys.informatik.uni-kiel.de/layout/LayoutServicePort/graphLayoutResponse", fault = {
        @FaultAction(className = ServiceFault_Exception.class, value = "http://rtsys.informatik.uni-kiel.de/layout/LayoutServicePort/ServiceFault")
    })
    public String graphLayout(
        @WebParam(name = "serializedGraph", targetNamespace = "")
        String serializedGraph,
        @WebParam(name = "format", targetNamespace = "")
        String format,
        @WebParam(name = "options", targetNamespace = "")
        List<GraphLayoutOption> options)
        throws ServiceFault_Exception
    ;

    /**
     * 
     * @return
     *     returns java.lang.String
     * @throws ServiceFault_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getServiceData", targetNamespace = "http://rtsys.informatik.uni-kiel.de/layout", className = "de.cau.cs.kieler.kwebs.jaxws.GetServiceData")
    @ResponseWrapper(localName = "getServiceDataResponse", targetNamespace = "http://rtsys.informatik.uni-kiel.de/layout", className = "de.cau.cs.kieler.kwebs.jaxws.GetServiceDataResponse")
    @Action(input = "http://rtsys.informatik.uni-kiel.de/layout/LayoutServicePort/getServiceDataRequest", output = "http://rtsys.informatik.uni-kiel.de/layout/LayoutServicePort/getServiceDataResponse", fault = {
        @FaultAction(className = ServiceFault_Exception.class, value = "http://rtsys.informatik.uni-kiel.de/layout/LayoutServicePort/ServiceFault")
    })
    public String getServiceData()
        throws ServiceFault_Exception
    ;

    /**
     * 
     * @param previewImage
     * @return
     *     returns byte[]
     * @throws ServiceFault_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPreviewImage", targetNamespace = "http://rtsys.informatik.uni-kiel.de/layout", className = "de.cau.cs.kieler.kwebs.jaxws.GetPreviewImage")
    @ResponseWrapper(localName = "getPreviewImageResponse", targetNamespace = "http://rtsys.informatik.uni-kiel.de/layout", className = "de.cau.cs.kieler.kwebs.jaxws.GetPreviewImageResponse")
    @Action(input = "http://rtsys.informatik.uni-kiel.de/layout/LayoutServicePort/getPreviewImageRequest", output = "http://rtsys.informatik.uni-kiel.de/layout/LayoutServicePort/getPreviewImageResponse", fault = {
        @FaultAction(className = ServiceFault_Exception.class, value = "http://rtsys.informatik.uni-kiel.de/layout/LayoutServicePort/ServiceFault")
    })
    public byte[] getPreviewImage(
        @WebParam(name = "previewImage", targetNamespace = "")
        String previewImage)
        throws ServiceFault_Exception
    ;

}
