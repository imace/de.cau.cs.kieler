public interface IDataComponent {

	public void initialize() throws KiemInitializationException;

	public void wrapup() throws KiemInitializationException;

	public boolean isProducer();

	public boolean isObserver();

	public JSONObject step(JSONObject jSONObject)
										throws KiemExecutionException;

}
