package grammer;
import java.util.List;
import java.util.ArrayList;

public class Collection implements IUserManager{
	private List<User> useList = new ArrayList<>();
	
	private final int MAX_SIZE = 100;
	private UserManagerImpl um = new UserManagerImpl();
	
	private static UserManagerImpl() {
		
	}
	
	public static UserManagerImpl getInstance() {
		return um;
	}
	
	public void add(User user) {
		if(userList.size() < MAX_SIZE) {
			userList.add(user);
		} else {
			System.out.println("유저의 수가 100을 넘었습니다. 등록 불가");
		}
	}
	
	public User[] getList() {
		User[] res = new User[userList.size()];
		return this.userList.toArray(res);
	}
	
	public User[] getUsers() {
		List<User> list = new ArrayList<>();
		
		for(int i=0;i<userList.size;i++) {
			if(!(userList.get(i) instanceof VipUser)) {
				list.add(userList.get(i));
			}
		}
		
		User[]res = new User[list.size()];
		return list.toArray(res);
	}
}
