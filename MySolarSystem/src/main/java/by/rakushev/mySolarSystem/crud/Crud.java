package by.rakushev.mySolarSystem.crud;

import java.io.Serializable;
import java.util.List;





public interface Crud {

	<T> T merge(T t);
	<T> void saveOrUpdate(T t) ;

	
	<T, PK extends Serializable> void delete(Class<T> type, PK id);
		
	<T> List<T> list(Class<T> type);
	
	<T, PK extends Serializable> T find(Class<T> type, PK id);
	
	<T> T getPlanet(Class<T> type, String prop);
	
	<T> T check(Class<T> type, Long id);
}
		

	