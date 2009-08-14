public abstract class DataComponent implements IDataComponent,
											   IExecutableExtension {

	public boolean isMultiInstantiable() {return false;}

	public String[] provideFilterKeys() {return null;}

	public KiemProperty[] provideProperties() {return null;}

	public void checkProperties(KiemProperty[] properties)
											throws KiemPropertyException {}

	public String[] provideInterfaceKeys() {return null;}

	public boolean isHistoryObserver() {return false;}

	public boolean isDeltaObserver() {return false;}

	public boolean isMaster() {return false;}

}
