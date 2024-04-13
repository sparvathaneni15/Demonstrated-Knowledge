
class LongWordChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		if (s != null){
			return s.length() > 5;
		}
		else{
			return false;
		}
	}

} 

// Add your choosers here

class UpperCaseChooser implements MyChooser<String>{
	/*
	Checks if the string that is
	the argument is upper case.
	*/
	public boolean chooseElement(String s){
		if (s != null){
			return Character.isUpperCase(s.charAt(0));
		}
		else{
			return false;
		}
	}
}

class EvenChooser implements MyChooser<Integer>{
	/*
	Checks if the integer that is 
	the argument is even.
	*/
	public boolean chooseElement(Integer num) {
		if (num != null){
			return (num % 2 == 0);
		}
		else{
			return false;
		}
	}
}