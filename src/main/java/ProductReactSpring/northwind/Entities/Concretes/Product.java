package ProductReactSpring.northwind.Entities.Concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import lombok.Data;

@Data// lombok kullanırsan getter setter yazmaya gerek yok AOP kullanılır. outline kısmında gözükür.
@AllArgsConstructor// tüm alanları kullanarak otomatik constructor
@NoArgsConstructor // parametre almayan boş constructor
@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;
	
	//@Column(name="category_id")
	//private int categoryId;
	
	//zaten category içinde categoryId olduğu için ayrıca burada belirtmeye gerek yok
	
	
	@Column(name="product_name")
	private String productName;
	@Column(name="unit_price")
	private double unitPrice;
	@Column(name="units_in_stock")
	private short unitsInStock;
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;
	
	
	
	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	
	
	//normalde bir tane boş ctor bir tane de full dolu ctor yazılır
	// boş olan hibernate için diğeri çalışması içindir
	//bir de getter setter olmalıdır lombok ile bunları hallettik.
	//outline üzerinden kontrol edilebilir.
	
	

	
	
}
