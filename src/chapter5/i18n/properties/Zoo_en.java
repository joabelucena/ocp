package chapter5.i18n.properties;

import java.util.ListResourceBundle;

public class Zoo_en extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		
		return new Object[][] {
				{"hello", "Hello"				},
				{"open"	, "The zoo is open"		}
		};
	}

}
