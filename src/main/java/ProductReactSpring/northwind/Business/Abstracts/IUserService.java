package ProductReactSpring.northwind.Business.Abstracts;

import ProductReactSpring.northwind.Core.Entities.User;
import ProductReactSpring.northwind.Core.utilties.results.DataResult;
import ProductReactSpring.northwind.Core.utilties.results.Result;

public interface IUserService {

	Result add(User user);
	DataResult<User> findByEmail(String email);
}
