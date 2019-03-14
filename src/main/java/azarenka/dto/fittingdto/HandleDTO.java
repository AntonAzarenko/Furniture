package azarenka.dto.fittingdto;

import azarenka.entity.furnitures.Handle;
import azarenka.entity.furnitures.HandleColor;
import azarenka.entity.furnitures.params.HandleParams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HandleDTO {

    private Long id;

    private String article;

    private Integer centerDistance;

    private HandleColor colors;

    private String fileName;

    private List<HandleParams> params;

    private Handle handle;

    private boolean gold;
    private boolean chrome_bright;
    private boolean chrome_matt;
    private boolean satin;
    private String other;

    private boolean ninetySix;
    private boolean oneHundredTwentyEight;
    private boolean oneHundredNinetyTwo;
    private boolean twoHundredFiftySix;
    private Integer otherCenter;

    private String priceNinetySix;
    private String priceOneHundredTwentyEight;
    private String priceOneHundredNinetyTwo;
    private String priceTwoHundredFiftySix;
    private String priceOtherCenter;

    public HandleDTO() {
    }

    public Handle asHandle() {
        Handle handle = new Handle();
        handle.setArticle(article);
        handle.setFileName(fileName);
        handle.setId(id);
        return handle;
    }

    public List<HandleParams> asHandleParams(){
        List<HandleParams> params = createHandleParams();
        return params;
    }

    private List<HandleParams> createHandleParams() {
        List<HandleParams> handleParams = new ArrayList<>();
        if (ninetySix) {
            HandleParams params = new HandleParams();
            setParams(96, params, priceNinetySix);
            handleParams.add(params);
        }
        if (oneHundredTwentyEight) {
            HandleParams params = new HandleParams();
            setParams(128, params, priceOneHundredTwentyEight);
            handleParams.add(params);
        }
        if (oneHundredNinetyTwo) {
            HandleParams params = new HandleParams();
            setParams(192, params, priceOneHundredNinetyTwo);
            handleParams.add(params);
        }
        if (twoHundredFiftySix) {
            HandleParams params = new HandleParams();
            setParams(256, params, priceTwoHundredFiftySix);
            handleParams.add(params);
        }
        if (otherCenter != null) {
            HandleParams params = new HandleParams();
            setParams(otherCenter, params, priceOtherCenter);
            handleParams.add(params);
        }
        return handleParams;
    }

    private void setParams(Integer centerDistance, HandleParams params, String price) {
        params.setCenterDistance(centerDistance);
        params.setPrice(new BigDecimal(price));
        params.setColor(initHandleColor());
        params.setHandle(handle);
    }

    private Set<HandleColor> initHandleColor() {
        Set<HandleColor> handleColors = new HashSet<>();
        if (gold) handleColors.add(HandleColor.GOLD);
        if (chrome_matt) handleColors.add(HandleColor.CHROME_MATT);
        if (chrome_bright) handleColors.add(HandleColor.CHROME_BRIGHT);
        if (satin) handleColors.add(HandleColor.SATIN);
        if (other != null) handleColors.add(HandleColor.OTHER);
        return handleColors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getPriceNinetySix() {
        return priceNinetySix;
    }

    public void setPriceNinetySix(String priceNinetySix) {
        this.priceNinetySix = priceNinetySix;
    }

    public String getPriceOneHundredTwentyEight() {
        return priceOneHundredTwentyEight;
    }

    public void setPriceOneHundredTwentyEight(String priceOneHundredTwentyEight) {
        this.priceOneHundredTwentyEight = priceOneHundredTwentyEight;
    }

    public String getPriceOneHundredNinetyTwo() {
        return priceOneHundredNinetyTwo;
    }

    public void setPriceOneHundredNinetyTwo(String priceOneHundredNinetyTwo) {
        this.priceOneHundredNinetyTwo = priceOneHundredNinetyTwo;
    }

    public String getPriceTwoHundredFiftySix() {
        return priceTwoHundredFiftySix;
    }

    public void setPriceTwoHundredFiftySix(String priceTwoHundredFiftySix) {
        this.priceTwoHundredFiftySix = priceTwoHundredFiftySix;
    }

    public String getPriceOtherCenter() {
        return priceOtherCenter;
    }

    public void setPriceOtherCenter(String priceOtherCenter) {
        this.priceOtherCenter = priceOtherCenter;
    }

    public Handle getHandle() {
        return handle;
    }

    public void setHandle(Handle handle) {
        this.handle = handle;
    }

    public Integer getCenterDistance() {
        return centerDistance;
    }

    public void setCenterDistance(Integer centerDistance) {
        this.centerDistance = centerDistance;
    }

    public HandleColor getColors() {
        return colors;
    }

    public void setColors(HandleColor colors) {
        this.colors = colors;
    }

    public List<HandleParams> getParams() {
        return params;
    }

    public void setParams(List<HandleParams> params) {
        this.params = params;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isGold() {
        return gold;
    }

    public void setGold(boolean gold) {
        this.gold = gold;
    }

    public boolean isChrome_bright() {
        return chrome_bright;
    }

    public void setChrome_bright(boolean chrome_bright) {
        this.chrome_bright = chrome_bright;
    }

    public boolean isChrome_matt() {
        return chrome_matt;
    }

    public void setChrome_matt(boolean chrome_matt) {
        this.chrome_matt = chrome_matt;
    }

    public boolean isSatin() {
        return satin;
    }

    public void setSatin(boolean satin) {
        this.satin = satin;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Integer getOtherCenter() {
        return otherCenter;
    }

    public boolean isNinetySix() {
        return ninetySix;
    }

    public void setNinetySix(boolean ninetySix) {
        this.ninetySix = ninetySix;
    }

    public boolean isOneHundredTwentyEight() {
        return oneHundredTwentyEight;
    }

    public void setOneHundredTwentyEight(boolean oneHundredTwentyEight) {
        this.oneHundredTwentyEight = oneHundredTwentyEight;
    }

    public boolean isOneHundredNinetyTwo() {
        return oneHundredNinetyTwo;
    }

    public void setOneHundredNinetyTwo(boolean oneHundredNinetyTwo) {
        this.oneHundredNinetyTwo = oneHundredNinetyTwo;
    }

    public boolean isTwoHundredFiftySix() {
        return twoHundredFiftySix;
    }

    public void setTwoHundredFiftySix(boolean twoHundredFiftySix) {
        this.twoHundredFiftySix = twoHundredFiftySix;
    }

    public Integer isOtherCenter() {
        return otherCenter;
    }

    public void setOtherCenter(Integer otherCenter) {
        this.otherCenter = otherCenter;
    }
}
