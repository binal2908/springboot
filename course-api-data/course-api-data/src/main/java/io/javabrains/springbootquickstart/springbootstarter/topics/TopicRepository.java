package io.javabrains.springbootquickstart.springbootstarter.topics;

import org.springframework.data.repository.CrudRepository;

//here our primary key is "id" which is of type string that is why we kept ID type String, Topic is our row in table
public interface TopicRepository extends CrudRepository<Topic,String>{

}
