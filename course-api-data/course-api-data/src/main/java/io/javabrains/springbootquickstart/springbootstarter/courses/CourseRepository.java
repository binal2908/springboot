package io.javabrains.springbootquickstart.springbootstarter.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//here our primary key is "id" which is of type string that is why we kept ID type String, Topic is our row in table
public interface CourseRepository extends CrudRepository<Course, String> {
	// here you want to find by Id property of Topic property.
	// then you have to just declare name in "findByPropertName" format, and
	// spring data JPA will implement that method for you
	//here topic is not string type and we don't want to filter based on that as well so we have given method name "TopicId"
	public List<Course> findByTopicId(String topicId);
}
