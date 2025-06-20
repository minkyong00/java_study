package pub2504.oop;

public class Outer {

	// static member variable
	static int si = 1;
	
	// non-static member variable
	int nsi = 2;
	
	// static member class
	// static 변수만 접근 가능
	static class SIClass {
		void print() {
			System.out.println("SIClass print si => " +  si);
		}
	}
	
	// non-static memeber class
	class NSIClass {
		void print() {
			System.out.println("NSIClass print si => " + si);
			System.out.println("NSIClass print nsi => " + nsi);
		}
	}
	
	void print() {
		// local variable
		int li = 3;
		System.out.println("Outer print");
		
		// local class
		// static, non-static, local 변수 모두 접근 가능
		class LIClass {
			void print() {
				System.out.println("LIClass print si => " + si);
				System.out.println("LIClass print nsi => " + nsi);
				System.out.println("LIClass print li => " + li);
			}
		}

		LIClass liClassObj = new LIClass();
		liClassObj.print();
		
	} // print
	
} // class
