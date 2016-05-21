package tec;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class LancerTests {

	static public void main(String[] args) {
		boolean estMisAssertion = false;
		assert estMisAssertion = true;

		if (!estMisAssertion) {
			System.out.println("Execution impossible sans l'option -ea");
			return;
		}

		// comment lancer les tests ?
		System.out
				.println("Il reste à faire les tests unitaires fonctionnels...");

		try {
			lancerTests(Class.forName("tec.TestEtatPassager"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			lancerTests(Class.forName("tec.TestPassagerStandard"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			lancerTests(Class.forName("tec.TestPassagerStresse"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			lancerTests(Class.forName("tec.TestPassagerLunatique"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			lancerTests(Class.forName("tec.TestJaugeNaturel"));
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}

		try {
			lancerTests(Class.forName("tec.TestAutobus"));
		} catch (ClassNotFoundException e3) {
			e3.printStackTrace();
		}
	}

	private static void lancerTests(Class c) {
		System.out.print("test pour " + c.getName() + ":debut\n");
		Method methods[] = c.getMethods();
		for (Method m : methods) {
			if (m.getName().startsWith("t")) {
				try {
					m.invoke(c.newInstance());
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | InstantiationException e) {
					e.printStackTrace();
				}

			}
		}
		System.out.print("test pour " + c.getName() + ":OK\n");
	}
}
