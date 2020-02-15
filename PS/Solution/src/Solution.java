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
		
		int a=0;
		int b=0;
		int max=0;
		int min=0;
		//최대값, 최소값 index a,b 구하기
		for(int i=0;i<numbers.length;i++) {
			if(i==0) {
				max=min=numbers[i];
			}
			else {
				if(numbers[i]>max) {
					max = numbers[i];
					b=i;
				}
				if(numbers[i]<min) {
					min = numbers[i];
					a=i;
				}
			}
		}
		
		System.out.println(a+b);
	}
}