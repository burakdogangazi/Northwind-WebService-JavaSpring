package ProductReactSpring.northwind.Business.Concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ProductReactSpring.northwind.Business.Abstracts.IProductService;
import ProductReactSpring.northwind.Core.utilties.results.DataResult;
import ProductReactSpring.northwind.Core.utilties.results.Result;
import ProductReactSpring.northwind.Core.utilties.results.SuccessDataResult;
import ProductReactSpring.northwind.Core.utilties.results.SuccessResult;
import ProductReactSpring.northwind.DataAccess.Abstracts.IProductDao;
import ProductReactSpring.northwind.Entities.Concretes.Product;
import ProductReactSpring.northwind.Entities.Dtos.ProductWithCategoryDto;
import net.bytebuddy.asm.Advice.Return;
import net.bytebuddy.asm.Advice.This;

@Service
public class ProductManager implements IProductService {

	
	private IProductDao productDao;
	
	@Autowired
	public ProductManager(IProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(),"Ürün Listelendi.");
	}
	
	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize){
		Pageable pageable =  PageRequest.of(pageNo -1 , pageSize);
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}
	
	@Override
	public DataResult<List<Product>> getAllSorted() {
	
		Sort sort = Sort.by(Sort.Direction.ASC,"productName");
		return new SuccessDataResult<List<Product>>(
		this.productDao.findAll(sort),"Başarılı");
		
	}

 
	

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün Eklendi.");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName),"Ürün getirildi.");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId),"Ürün getirildi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Ürün Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategoryIn(categories),"Ürün Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),"Ürün Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"Ürün Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName,categoryId),"Ürün Listelendi.");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>
		(this.productDao.getProductWithCategoryDetails(),"Kategori ve ürünü listelendi");
				
	}

	

	


	

}
