package ra.dev;
import java.util.Objects;
import java.util.Scanner;
public class ProductManagetment {
    static Product [] listPro = new Product[100];
    static int index = 0;
    static Catalog [] lisCata = new Catalog[100];
    static int index2 =0;
    // MENU CHÍNH
    public static void main(String[] args) {
        do{
            System.out.println(" ");
            System.out.println("******* MENU SẢN PHẨM *******"+ "\n");
            System.out.println(" 1: Quản lý danh mục sản phẩm ! ");
            System.out.println(" 2: Quản lý sản phẩm ! ");
            System.out.println(" 3: Thoát ứng dụng ! "+ "\n");
            System.out.println("Nhập vào lựa chọn của bạn !");
            Scanner sc = new Scanner(System.in);
            int pick =Integer.parseInt (sc.nextLine());
            switch (pick){
                case 1:
                    ProductManagetment.manageList();
                    break;
                case 2:
                    ProductManagetment.setListPro();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }while (true);
    }
    // DANH MỤC SẢN PHẨM
    public static void manageList(){
        do {
            Scanner sc4= new Scanner(System.in);
            System.out.println(" ");
            System.out.println("******* QUẢN LÝ DANH MỤC ******"+"\n" );
            System.out.println(" 1: Nhập thông tin danh mục ");
            System.out.println(" 2: Hiển thị danh mục theo độ ưu tiên ");
            System.out.println(" 3: Cập nhật thông tin danh mục theo mã danh mục");
            System.out.println(" 4: Chở lại Menu"+ "\n");
            System.out.println("Nhập lựa chọn của bạn :");
            int pick = Integer.parseInt(sc4.nextLine());
            switch (pick){
                case 1:
                    // NHẬP DANH MỤC
                    System.out.println("Nhập số danh mục bạn muốn thêm : ");
                    int num2 = Integer.parseInt(sc4.nextLine());
                    System.out.println("Nhập thông tin danh mục");
                    for (int i = 0; i < num2; i++) {
                        lisCata[index2]= new Catalog();
                        lisCata[index2].inputDataCata();
                        index2++;
                    }
                    break;
                case 2:
                    // SẮP XẾP DANH MỤC
                    System.out.println("Danh mục theo độ ưu tiên : ");
                    for (int i = 0; i < index2-1; i++) {
                        for (int j = i+1; j < index2; j++) {
                            if (lisCata[i].getPriority() > lisCata[j].getPriority()) {
                                Catalog temp = lisCata[i];
                                lisCata[i] = lisCata[j];
                                lisCata[j] = temp;
                            }
                        }
                    }
                    for (int i = 0; i < index2; i++) {
                        lisCata[i].displayData2();
                    }
                    break;
                case 3:
                    // CẬP NHẬT DANH MỤC
                    for (int i = 0; i < index2; i++){
                        System.out.print(" ID " + lisCata[i].getCatalogId());
                        System.out.println(" : " + lisCata[i].getCatalogName());
                    }
                    System.out.println("Nhập mã Id danh mục muốn cập nhật :");
                    int idUpdate = Integer.parseInt(sc4.nextLine());
                    for (int i = 0; i < index2; i++) {
                        if (lisCata[i].getCatalogId()==idUpdate){
                            System.out.println("Mã danh mục cũ là  : " + lisCata[i].getCatalogId());
                            System.out.print("Mã danh mục mới là      :");
                            lisCata[i].setCatalogiD(Integer.parseInt(sc4.nextLine()));
                            System.out.println("Tên danh mục cũ là : " + lisCata[i].getCatalogName());
                            System.out.print("Tên danh mục mới là     :");
                            lisCata[i].setCatalogName(sc4.nextLine());
                            System.out.println("Độ ưu tiên cũ là   : " + lisCata[i].getPriority());
                            System.out.print("Độ ưu tiên mới          :");
                            lisCata[i].setPriority(Integer.parseInt(sc4.nextLine()));
                            System.out.println("Trạng thái cũ là   : " + lisCata[i].getPriority());
                            System.out.print("Trạng thái mới là       :");
                            lisCata[i].setCatalogStatus(Boolean.parseBoolean(sc4.nextLine()));
                        }
                    }
                    break;
                case 4:
                    // QUAY LẠI MENU CHÍNH
                    return;
            }
        }while (true);
    }
    // THÔNG TIN SẢN PHẨM
   public static void setListPro (){
       do {
           Scanner num = new Scanner(System.in);
           System.out.println("   ");
           System.out.println("****** QUẢN LÝ SẢN PHẨM ******"+ "\n");
           System.out.println("1. Nhập thông tin cho n sản phẩm (n nhập từ bàn phím.)");
           System.out.println("2. Tính giá bán cho tất cả sản phẩm.");
           System.out.println("3. Hiển thị thông tin các sản phẩm.");
           System.out.println("4. Sắp xếp sản phẩm theo giá bán tăng dần.");
           System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm.");
           System.out.println("6. Thống kê và in ra sản phẩm sắp hết.");
           System.out.println("7. Cập nhật trạng thái của sản phẩm theo mã sản phẩm");
           System.out.println("8. Quay lại menu "+ "\n");
           System.out.println("Nhập vào lựa chọn của bạn !");
           System.out.println(" ");
           int so = Integer.parseInt(num.nextLine());
           switch (so) {
               case 1:
                   // NHẬP THÔNG TIN SẢN PHẨM
                       if (index2==0) {
                           System.err.println("Vui lòng tạo danh mục sản phẩm trước");
                           return;

                       } else {
                           System.out.println("Nhập mã danh mục sản phẩm bạn muốn thêm !");
                           for (int i = 0; i < index2; i++) {
                               System.out.print(" ID " + lisCata[i].getCatalogId());
                               System.out.println(" : " + lisCata[i].getCatalogName());
                           }
                           int catalog = Integer.parseInt(num.nextLine());
                           for (int i = 0; i < index2; i++) {
                               if (Objects.equals(lisCata[i].getCatalogId(), catalog)) {

                                   System.out.println("Nhập số sản phẩm muốn thêm :");
                                   int ssp = Integer.parseInt(num.nextLine());
                                   for (int j = 0; j < ssp; j++) {
                                       listPro[index] = new Product();
                                       listPro[index].inputData();
                                       listPro[index].setCatalog(lisCata[i]);
                                       index++;
                                   }
                               }
                           }
                       }
                   break;
               case 2:
                   // TÍNH GIÁ BÁN
                   for (int i = 0; i < index; i++) {
                       listPro[i].calExportPrice();
                   }
                   System.err.println("Giá đã được tính toán");
                   break;
               case 3:
                   // HIỂN THỊ THÔNG TIN SẢN PHẨM
                   System.out.println("Thông tin sản phẩm : ");
                   for (int i = 0; i < index; i++) {
                       listPro[i].displayData();
                   }
                   break;
               case 4:
                   // SĂP XẾP SẢN PHẨM
                   System.err.println("Sản phẩm sau khi sắp xếp là : ");
                   for (int i = 0; i < index-1; i++) {
                       for (int j = i+1; j < index; j++) {
                           if (listPro[i].getExportPrice() > listPro[j].getExportPrice()) {
                               Product temp = listPro[i];
                               listPro[i] = listPro[j];
                               listPro[j] = temp;
                           }
                       }
                   }
                   for (int i = 0; i < index; i++) {
                       listPro[i].displayData();
                   }
                   break;
               case 5:
                   // TÌM KIẾM SẢN PHẨM
                   System.out.println("Nhập sản phẩm bạn muốn tìm ");
                   Scanner sc1 = new Scanner(System.in);
                   String TK = sc1.nextLine();
                   for (int i = 0; i < index; i++) {
//                if (listPro[i].getProductName().startsWith(TK)){
                       if(Objects.equals(listPro[i].getProductName(), TK)){
                           System.err.println("Thông tin sản phẩm là ");
                           listPro[i].displayData();
                       }else {
                           System.err.println("Không có thông tin !");
                       }
                   }
                   break;
               case 6:
                   // THỐNG KÊ SỐ LƯỢNG HẾT HÀNG
                   System.err.println("Thống kê sản phẩm sắp hết hàng :");
                   for (int i = 0; i < index; i++) {
                       if(listPro[i].getQuantiny()<5){
                          listPro[i].displayData();
                       }
                   }
                   break;
               case 7:
                   // CẬP NHẬT TRẠNG THÁI SẢN PHẨM
                   Scanner sc3 = new Scanner(System.in);
                   System.out.println("Nhập thông tin sản phẩm muốn cập nhật");
                   String pro = sc3.nextLine();
                   for (int i = 0; i < index; i++) {
                       if(Objects.equals(listPro[i].getProductName(), pro)){
                           listPro[i].setProductStatus(false);
                       }else {
                           listPro[i].setProductStatus(true);
                       }
                   }
                   System.out.println("Trạng thái đã được thay đổi");
                   break;
               case 8:
                   // QUAY LẠI MENU CHÍNH
               return;
           }
       }while (true);

   }





}
