package diploma.Model;

public class Cart {
    private Integer id;
    private String img;
    private String title;
    private Integer price;
    private Integer article;
    private String about;
    private Integer parent_id;
    private Integer qty;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setArticle(Integer article) {
        this.article = article;
    }

    public Integer getArticle() {
        return article;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAbout() {
        return about;
    }

    public void setParent(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getParent() {
        return parent_id;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getQty() {
        return qty;
    }
}