package kodlamaio.humanResourcesProject.core.Security.Mernis;

public interface KPSPublic extends javax.xml.rpc.Service {
    public java.lang.String getKPSPublicSoapAddress();

    public KPSPublicSoap getKPSPublicSoap() throws javax.xml.rpc.ServiceException;

    public KPSPublicSoap getKPSPublicSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}