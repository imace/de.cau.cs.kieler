package de.cau.cs.kieler.kiml.ui.provider;


public interface IKimlLabelProvider {

	  public String getKimlLongLabel(Object object);

	  public String getKimlShortLabel(Object object);

	  public String getKimlHeadLabel(Object object);

	  public String getKimlCenterLabel(Object object);
	  
	  public String getKimlTailLabel(Object object);
	  
}
