package business;

import java.io.Serializable;

public class SystemException extends Exception implements Serializable {
	private static final long serialVersionUID = 3326915348398932420L;
	public SystemException(String msg) {
		super(msg);
	}
}
