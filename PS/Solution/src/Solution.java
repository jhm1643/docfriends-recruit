public class Solution {
	
	public static void main(String args[]) {
		String q="ab23c4d56e78f9g12h34i5j12k45l67n89m99o1k123p456q567r768s890t67u456v345w234x23y239z";
		int numbers[] = new int[0];
		char charArr[] = q.toCharArray();
		String number="";
		
		//q에서 숫자 추출하여 numbers에 넣기
		for(int i=0;i<charArr.length;i++) {
			if(charArr[i]>=48 && charArr[i]<=57) {
				number=number+charArr[i];
			}else if(!number.equals("")){
				int numbers2[] = numbers;
				numbers=new int[numbers2.length+1];
				for(int j=0;j<numbers2.length;j++) {
					numbers[j]=numbers2[j];
				}
				numbers[numbers.length-1]=Integer.parseInt(number);
				number="";
			}
		}
		
		for(int i=0;i<numbers.length;i++) {
			System.out.println(numbers[i]);
		}
	}
}