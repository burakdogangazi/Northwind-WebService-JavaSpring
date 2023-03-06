package ProductReactSpring.northwind.Business.Concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProductReactSpring.northwind.Business.Abstracts.IUserService;
import ProductReactSpring.northwind.Core.DataAccess.UserDao;
import ProductReactSpring.northwind.Core.Entities.User;
import ProductReactSpring.northwind.Core.utilties.results.DataResult;
import ProductReactSpring.northwind.Core.utilties.results.Result;
import ProductReactSpring.northwind.Core.utilties.results.SuccessDataResult;
import ProductReactSpring.northwind.Core.utilties.results.SuccessResult;
import net.bytebuddy.asm.Advice.Return;


@Service
public class UserManager implements IUserService {

	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı başarıyla eklendi");	
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı bulundu.");
	}
	

}
