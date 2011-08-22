package droidWork.TheBeamers.ca;

public class invalidPlayerException extends Exception {
	String mistake;

	/**
	 * serialVersionUID for versioning
	 */
	private static final long serialVersionUID = 8082830828769501992L;

	/**
	 * default constructor	
	 */
	public invalidPlayerException () {
		super();
			mistake = "unknown";
		}

	/**
	 * Override constructor
	 * 
	 * @param err
	 */
	public invalidPlayerException(String err){
		super(err);
			mistake = err;
		}
		
	/**
	 * getError text
	 * @return provided error text, or Unknown if none provided.
	 */
	public String getError() {
		return mistake;
	}
}
