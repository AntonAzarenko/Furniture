package azarenka.dto;

import azarenka.entity.Material;
import azarenka.entity.Module;
import azarenka.service.logic.bookers.Booker;
import azarenka.service.logic.bookers.ManagerQuadCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BookerResponse {

    @Autowired
    private Booker booker;

    @Autowired
    private ManagerQuadCount managerQuadCount;

    private String moduleName;

    private String moduleType;

    private BigDecimal priceForSquareDSP;

    private BigDecimal priceForSquareDVP;

    private BigDecimal priceForEdge;

    private BigDecimal priceForFitting;

    private BigDecimal priceForFacade;

    private BigDecimal total;

    public BookerResponse() {
    }

    public BookerResponse asBookerDTO(Module module) {
        BookerResponse bookerResponse = new BookerResponse();
        bookerResponse.setModuleName(module.getName());
        bookerResponse.setModuleType(module.getModuleType().toString());
        bookerResponse.setPriceForSquareDSP(getCostSquareDSP(module));
        bookerResponse.setPriceForSquareDVP(getCostSquareDVP(module));
        bookerResponse.setPriceForEdge(getCostLengthEdge(module));
        bookerResponse.setTotal(getPriceTotalOFModule(module));
        return bookerResponse;
    }

    private BigDecimal getPriceTotalOfOrder(Module module) {
        return booker.getPriceOrder(module.getOrder());
    }

    private BigDecimal getCostLengthEdge(Module module) {
        return booker.getPriceEdgeByModule(module);
    }

    private BigDecimal getCostSquareDSP(Module module) {
        return booker.getPriceDetailByType(module, Material.DSP);
    }

    private BigDecimal getCostSquareDVP(Module module) {
        return booker.getPriceDetailByType(module, Material.DVP);
    }

    private BigDecimal getCostSquareWOOD(Module module) {
        return booker.getPriceDetailByType(module, Material.WOOD);
    }

    private BigDecimal getCostSquareMDF(Module module) {
        return booker.getPriceDetailByType(module, Material.MDF);
    }

    private BigDecimal getPriceTotalOFModule(Module module) {
        return booker.getPriceModule(module);
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public BigDecimal getPriceForSquareDSP() {
        return priceForSquareDSP;
    }

    public void setPriceForSquareDSP(BigDecimal priceForSquareDSP) {
        this.priceForSquareDSP = priceForSquareDSP;
    }

    public BigDecimal getPriceForSquareDVP() {
        return priceForSquareDVP;
    }

    public void setPriceForSquareDVP(BigDecimal priceForSquareDVP) {
        this.priceForSquareDVP = priceForSquareDVP;
    }

    public BigDecimal getPriceForEdge() {
        return priceForEdge;
    }

    public void setPriceForEdge(BigDecimal priceForEdge) {
        this.priceForEdge = priceForEdge;
    }

    public BigDecimal getPriceForFitting() {
        return priceForFitting;
    }

    public void setPriceForFitting(BigDecimal priceForFitting) {
        this.priceForFitting = priceForFitting;
    }

    public BigDecimal getPriceForFacade() {
        return priceForFacade;
    }

    public void setPriceForFacade(BigDecimal priceForFacade) {
        this.priceForFacade = priceForFacade;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BookerDTO{" +
                "booker=" + booker +
                ", managerQuadCount=" + managerQuadCount +
                ", moduleName='" + moduleName + '\'' +
                ", moduleType='" + moduleType + '\'' +
                ", priceForSquareDSP=" + priceForSquareDSP +
                ", priceForSquareDVP=" + priceForSquareDVP +
                ", priceForEdge=" + priceForEdge +
                ", priceForFitting=" + priceForFitting +
                ", priceForFacade=" + priceForFacade +
                ", total=" + total +
                '}';
    }
}
