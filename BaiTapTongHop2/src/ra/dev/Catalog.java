package ra.dev;

import java.util.Scanner;

public class Catalog {
    private int catalogId;
    private String catalogName;
    private int priority;
    private Boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalog, String catalogName, int priority, Boolean catalogStatus) {
        this.catalogId = catalog;
        this.catalogName = catalogName;
        this.priority = priority;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogiD(int catalog) {
        this.catalogId = catalog;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Boolean getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(Boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputDataCata() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã danh mục sản phẩm  :");
        this.catalogId = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên danh muc sản phẩm : ");
        this.catalogName = sc.nextLine();
        System.out.print("Nhập độ ưu tiên            : ");
        this.priority = Integer.parseInt(sc.nextLine());
        System.err.print("Trạng thái danh mục        : ");
        this.catalogStatus = Boolean.parseBoolean(sc.nextLine());
        System.out.println(" ");
    }

    public void displayData2() {
        System.out.println("Managa List: \n" +
                "- Mã danh mục         :   " + this.catalogId + "\n" +
                "- Tên danh mục        :   " + this.catalogName + "\n" +
                "- Độ ưu tiên          :   " + this.priority + "\n" +
                "- Trạng thái danh mục :   " + this.catalogStatus + "\n");
    }

}
