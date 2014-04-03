package edu.usc.cct.rapport.web_games.client.recording;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public interface DoublySerializable extends Serializable, IsSerializable {

	// Classes that implement this interface must support both Java serialization and GWT serialization.
	
	// DS classes exist because GWT's serialization, which is used by client-server communication code, does not support many container classes that are used as private members in the standard classes.
};
