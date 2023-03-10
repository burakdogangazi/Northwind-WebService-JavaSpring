package ProductReactSpring.northwind.Api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ProductReactSpring.northwind.Business.Abstracts.IProductService;
import ProductReactSpring.northwind.Core.utilties.results.DataResult;
import ProductReactSpring.northwind.Core.utilties.results.Result;
import ProductReactSpring.northwind.Entities.Concretes.Product;
import ProductReactSpring.northwind.Entities.Dtos.ProductWithCategoryDto;
import net.bytebuddy.asm.Advice.Return;


@RestController
@RequestMapping("/api/products")
public class ProductsController {

	private IProductService productService;
		
	@Autowired
	public ProductsController(IProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	// Request body gibi içine bak parametre olarak productName olucak ondan al demek
	}
	
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> getByProductNameAndCategory(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategory(productName,categoryId);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getAllByPage")
	DataResult<List<Product>> getAll(int pageNo, int pageSize){
		return this.productService.getAll(pageNo,pageSize);
	}
	
	
	@GetMapping("/getAllAsc")
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}
	
	
	
	 
	
	
	
	
}
