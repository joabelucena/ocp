package chapter5.i18n.properties;

import java.util.ListResourceBundle;

public class Tax_en_US extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		
		return new Object[][]{
				{"tax", Math.round(Math.random() * 100) }
		};
	}
	
}
