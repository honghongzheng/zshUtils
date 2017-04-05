package tips;



public class CopyArray {
	

	public static String []  createArray(String params []){
		if(params.length>1){
			String temp [] = new String [params.length-1];
			System.arraycopy(params, 1, temp, 0, temp.length);
			for (int i = 0; i < temp.length; i++) {
				System.out.println(temp[i]);
			}
			return temp;
		}
		return params;
	}

	public static void main(String[] args) {
		String [] params = new String[]{"1","99"};
		createArray(params);
	}
}

