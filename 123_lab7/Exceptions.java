class EmptyPQException extends Exception{
	String message;
	public EmptyPQException(String message){
		this.message = message;
	}
}