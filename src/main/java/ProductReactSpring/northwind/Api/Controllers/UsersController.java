package ProductReactSpring.northwind.Api.Controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ProductReactSpring.northwind.Business.Abstracts.IUserService;
import ProductReactSpring.northwind.Core.Entities.User;
import ProductReactSpring.northwind.Core.utilties.results.ErrorDataResult;

@RestController
@RequestMapping(value = "api/users")
public class UsersController {
	
	private IUserService userService;

	@Autowired
	public UsersController(IUserService userService) {
		super();
		this.userService = userService;
	}
	
	
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
		// 200 dön dedik ama farklı bir şey de dönebilir o yüzden ?
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidatonException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String,String>();
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");	
		return errors;
	}
	
	
	

}
