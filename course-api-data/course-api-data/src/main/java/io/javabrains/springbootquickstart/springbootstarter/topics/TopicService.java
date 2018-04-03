package io.javabrains.springbootquickstart.springbootstarter.topics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		// return topics;
		List<Topic> topics = new ArrayList<Topic>();
		// here findAll() method returns iterable to we have to iterate that pur
		// into list
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
		/*
		 * return topics.stream().filter(t -> t.getId().equals(id)).findFirst()
		 * .get();
		 */
		return topicRepository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		// topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topicI) {
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
		topicRepository.save(topicI);

	}

	public void deleteTopic(String id) {
		// topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}
}
