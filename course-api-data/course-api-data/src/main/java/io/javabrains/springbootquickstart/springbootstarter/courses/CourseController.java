package io.javabrains.springbootquickstart.springbootstarter.courses;

import io.javabrains.springbootquickstart.springbootstarter.topics.Topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable("topicId") String id) {
		return courseService.getAllCourses(id);
	}

	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		// here we don't catch topicId as primary key is course id and not
		// related to topicId
		return courseService.getCourse(id);
	}

	@RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
	public void addCourse(@RequestBody Course course,
			@PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "default", "default"));
		courseService.addCourse(course);
	}

	@RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course,
			@PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "default", "default"));
		courseService.updateCourse(course);
	}

	@RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}

}
