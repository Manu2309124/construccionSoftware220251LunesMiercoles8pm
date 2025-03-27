package app.ports;

import app.domain.models.User;

public interface PersonPort {

	void savePerson(User user);
	
}
