package org.jboss.arquillian.container.weld.ee.embedded_2_0.mock;

import java.util.List;

import org.jboss.weld.bootstrap.spi.BeansXml;
import org.jboss.weld.bootstrap.spi.Metadata;

public final class BeansXmlUtil {

	private BeansXmlUtil() {
	}

	public static void removeDuplicate(BeansXml xml) {
		removeDuplicate(xml.getEnabledAlternativeClasses());
		removeDuplicate(xml.getEnabledAlternativeStereotypes());
		removeDuplicate(xml.getEnabledDecorators());
		removeDuplicate(xml.getEnabledInterceptors());
	}

	private static void removeDuplicate(List<Metadata<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			Metadata<String> item = list.get(i);
			for (int n = i + 1; n < list.size(); n++) {
				if (item.getValue().equals(list.get(n).getValue())) {
					list.remove(i);
					i--;
				}
			}
		}
	}
}