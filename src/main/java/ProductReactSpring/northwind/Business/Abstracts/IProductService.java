package ProductReactSpring.northwind.Business.Abstracts;

import java.util.List;

import ProductReactSpring.northwind.Core.utilties.results.DataResult;
import ProductReactSpring.northwind.Core.utilties.results.Result;
import ProductReactSpring.northwind.Entities.Concretes.Product;
import ProductReactSpring.northwind.Entities.Dtos.ProductWithCategoryDto;

public interface IProductService {

	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getAll(int pageNo, int pageSize);
	
	DataResult<List<Product>> getAllSorted();
	
	
	
	
	Result add(Product  product);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategory(String productName, int categoryId);
	
	 DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);
	
	 DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
	
	 DataResult<List<Product>> getByProductNameContains(String productName);
	
	 DataResult<List<Product>> getByProductNameStartsWith(String productName);

	 DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);
	
	 DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	
}
