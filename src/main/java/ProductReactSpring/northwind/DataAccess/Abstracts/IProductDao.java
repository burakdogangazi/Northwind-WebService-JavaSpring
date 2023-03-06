package ProductReactSpring.northwind.DataAccess.Abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ProductReactSpring.northwind.Entities.Concretes.Product;
import ProductReactSpring.northwind.Entities.Dtos.ProductWithCategoryDto;

public interface IProductDao extends JpaRepository<Product, Integer> {

 // jpa repository Product için primary key ile içine istiyor.
 //jpa ile crud hazır gelir
	
	Product getByProductName(String productName);
	//get by ile hazır jpa repo gidiyor ve productname arıyor.
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	//List<Product> getByProductNameOrCategoryId(String productName, int categoryId);
	// yukarıdaki sorguda getByProductNameOrCategoryId diyince product tablosu içinde categoryId arıyor ama yok
	//aşağıdaki doğru
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

	
	//select * from products where category_id in(1,2,3,4) // cateogry id si 1 2 3 4 olanları getir.
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);

	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName,int categoryId);
	
	
	
	@Query("Select new ProductReactSpring.northwind.Entities.Dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products p ")
	//paket ve altındaki sınıf ismine category içinde ki ürünleri atmak için ilk önce one to many ilişkisinde one olan yazılır
	//kategoriler ile onun içindeki ürünler ile ilişki kur
	
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	// select p.productId,p.productName,c.categoryName from Category c inner join Product p
	// on c.cateogryId = p.cateogryId
	
	
	
	
	
	
	
}
