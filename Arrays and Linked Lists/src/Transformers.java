
class UpperCaseTransformer implements MyTransformer<String> {

	public String transformElement(String s) {
		if (s != null){
			return s.toUpperCase();
		}
		else{
			return null;
		}
	}

}

// Add your transformers here

class NegativeTransformer implements MyTransformer<Integer> {
	/*
	Multiplies every integer that 
	is the argument by -1.
	*/
	public Integer transformElement(Integer i) {
		if (i != null){
			return i * -1;
		}
		else{
			return null;
		}
	}
}

class ReverseStringTransform implements MyTransformer<String> {
	public String transformElement(String s){
		/*
		Reverses the order of the string 
		that is the argument.
		*/
		if (s != null){
			String String1 = "";
			for (int i = s.length()-1; i >= 0; i--){
				String1 += s.charAt(i);
			}
			return String1;
		}
		else{
			return null;
		}
	}
}