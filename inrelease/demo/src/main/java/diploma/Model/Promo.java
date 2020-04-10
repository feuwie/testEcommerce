package diploma.Model;

public class Promo {

    private Integer id;
    private String txtCode;
    private String codeType;
    private Integer codeValue;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCode(String txtCode) {
        this.txtCode = txtCode;
    }

    public String getCode() {
        return txtCode;
    }

    public void setType(String codeType) {
        this.codeType = codeType;
    }

    public String getType() {
        return codeType;
    }

    public void setValue(Integer codeValue) {
        this.codeValue = codeValue;
    }

    public Integer getValue() {
        return codeValue;
    }
}