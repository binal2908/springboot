package io.javabrains.springbootquickstart.springbootstarter.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses(String topicId) {

		List<Course> courses = new ArrayList<Course>();
		// here findAll() method returns iterable to we have to iterate that and
		// put into list
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}

	public Course getCourse(String id) {
		/*
		 * return topics.stream().filter(t -> t.getId().equals(id)).findFirst()
		 * .get();
		 */
		return courseRepository.findById(id).get();
	}

	public void addCourse(Course course) {
		// topics.add(topic);
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		// topics.stream().filter(t -> t.getId().equals(id)).findFirst().
		// int i = 0;
		// for (Topic topic : topics) {
		//
		// if (topic.getId().equals(id)) {
		// topics.set(i, topicI);
		// return;
		// }
		// i++;
		// }

		// Here save method first checks that row with partycular exits? if yes
		// then it updates or it inserts
		courseRepository.save(course);

	}

	public void deleteCourse(String id) {
		// topics.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
	}
}
