package io.javabrains.springbootstarter.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic(
			"spring", "spring framework", "spring framework description"),
			new Topic("java", "Core java", "core java description"), new Topic(
					"javascript", "javascript", "javascript description")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst()
				.get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);

	}

	public void updateTopic(String id, Topic topicI) {
//		topics.stream().filter(t -> t.getId().equals(id)).findFirst().
		int i=0;
		for(Topic topic:topics){
			
			if(topic.getId().equals(id)){
				topics.set(i, topicI);
				return;
			}
			i++;
		}
		
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
		
	}
}
