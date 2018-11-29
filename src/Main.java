import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main {

	public static void main(String[] args) {
		int i=0;
		Scanner leitor;
		Reader arquivo = new Reader();
		String[] teste1=new String[3];
		String[] teste2;
		try {
			leitor = new Scanner(arquivo.leitura("entrada.txt"));	
			String linha = new String();
			linha=leitor.nextLine();
			teste1[i]=linha;
			while(leitor.hasNext()){
				i++;
				linha = leitor.nextLine();
				//arquivo.setValoresEntreVirgulas(linha);
				teste1[i]=linha;

			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		teste2=new String[Integer.parseInt(teste1[1])];
		teste2=teste1[2].split(" ");
		FCFS(Integer.parseInt(teste1[0]),teste2);
		SSTF(Integer.parseInt(teste1[0]),teste2);
		scanSobe(Integer.parseInt(teste1[0]),teste2);
		scanDesce(Integer.parseInt(teste1[0]),teste2);
	}
	
	public static void FCFS(int comeco, String[] resto) {
		int[] resto2=new int[resto.length+1];
		resto2[0]=comeco;
		for(int i=0;i<resto.length;i++) {
			resto2[i+1]=Integer.parseInt(resto[i]);
		}
		System.out.println("FCFS");
		System.out.print("        Ordem: ");
		for(int i=0;i<resto2.length;i++) {
			if(i==0)
				System.out.print(resto2[0]);
			else
				System.out.print(","+resto2[i]);
		}
		int cilindros=0;
		for(int i=1;i<resto2.length;i++) {
			cilindros+=Math.abs(resto2[i]-resto2[i-1]);
		}
		System.out.println("");
		System.out.println("        Cilindros:"+cilindros);
	}
	
	public static void SSTF(int comeco, String[] resto) {
		int[] resto2=new int[resto.length+1];
		resto2[0]=comeco;
		int smallerDiff=9999;
		int cilindros=0,aux;
		int currentPosition=resto2[0];
		System.out.println("SSTF");
		System.out.print("        Ordem: ");
		for(int i=0;i<resto.length;i++) {
			resto2[i+1]=Integer.parseInt(resto[i]);
		}
		for (int i = 0; i < resto2.length; i++){
	        for (int j = i; j < resto2.length; j++){
	            if (Math.abs(resto2[j] - currentPosition) < smallerDiff){
	                smallerDiff = Math.abs(resto2[j] - currentPosition);
	                aux = resto2[j];
	                resto2[j] = resto2[i];
	                resto2[i] = aux;
	            }
	        }
	        cilindros += (Math.abs(currentPosition - resto2[i]));
	        currentPosition = resto2[i];
	        smallerDiff = 999999;
	    }
		for(int i=0;i<resto2.length;i++) {
			if(i==0)
				System.out.print(resto2[0]);
			else
				System.out.print(","+resto2[i]);
		}
		System.out.println("");
		System.out.print("         Cilindros:");
		System.out.println(cilindros);
		
	}
	
	public static void scanSobe(int comeco, String[] resto) {
		int[] resto2=new int[resto.length+1];
		resto2[0]=comeco;
		int cilindros=0,aux;
		int posatual=resto2[0];
		System.out.println("scanSobe");
		System.out.print("        Ordem: ");
		for(int z=0;z<resto.length;z++) {
			resto2[z+1]=Integer.parseInt(resto[z]);
		}
		  	int i, j;
		    int maiordiferenca = -1;
		    int goingToBottom = 1;

		    int menor = achaMenor(comeco, resto);
		    int maior = achaMaior(comeco, resto);

		    for (i = 1; i < resto.length+1; i++){
		        for (j = i; j < resto.length+1; j++){
		            if (goingToBottom == 1){
		                if (resto2[j] == menor){
		                    goingToBottom = 0;
		                }
		                if (resto2[j] < posatual){
		                    aux = resto2[j];
		                    resto2[j] = resto2[i];
		                    resto2[i] = aux;
		                    break;
		                }
		            }
		            else{
		                if (maior - resto2[j] > maiordiferenca){
		                    maiordiferenca = maior - resto2[j];
		                    aux = resto2[j];
		                    resto2[j] = resto2[i];
		                    resto2[i] = aux;
		                }
		            }   
		        }
		        cilindros += (Math.abs(posatual - resto2[i]));
		        posatual = resto2[i];
		        maiordiferenca = -1;
		    }
		    for(int p=0;p<resto2.length;p++) {
				if(p==0)
					System.out.print(resto2[0]);
				else
					System.out.print(","+resto2[p]);
			}

		System.out.println("");
		System.out.print("         Cilindros:");
		System.out.println(cilindros);
		
	}
	
	public static void scanDesce(int comeco, String[] resto) {
		int[] resto2=new int[resto.length+1];
		resto2[0]=comeco;
		int cilindros=0,aux;
		int posatual=resto2[0];
		System.out.println("scanDesce");
		System.out.print("        Ordem: ");
		for(int z=0;z<resto.length;z++) {
			resto2[z+1]=Integer.parseInt(resto[z]);
		}
		  int i, j;
		    int greatestDiff = -1;
		    int goingToTop = 1;
		    int maior = achaMaior(comeco, resto);

		    for (i = 1; i < resto2.length; i++){
		        for (j = i; j < resto2.length; j++){
		            if (goingToTop == 1){
		                if (resto2[j] > posatual && Math.abs(maior - resto2[j]) > greatestDiff){
		                    greatestDiff = maior - resto2[j];
		                    aux = resto2[j];
		                    resto2[j] = resto2[i];
		                    resto2[i] = aux;
		                }
		            }
		            else{
		                if (resto2[j] > greatestDiff){
		                    greatestDiff = resto2[j];
		                    aux = resto2[j];
		                    resto2[j] = resto2[i];
		                    resto2[i] = aux;
		                }
		            }
		        }
		        if (resto2[i] == maior)
		        {
		            goingToTop = 0;
		        }

		        cilindros += Math.abs(posatual - resto2[i]);
		        posatual = resto2[i];
		        greatestDiff = -1;
		    }
		    for(int p=0;p<resto2.length;p++) {
				if(p==0)
					System.out.print(resto2[0]);
				else
					System.out.print(","+resto2[p]);
			}

		System.out.println("");
		System.out.print("         Cilindros:");
		System.out.println(cilindros);
		
	}
	
	public static int achaMenor(int comeco, String resto[]){
		int tamanho=resto.length+1;
		int[] resto2=new int[tamanho];
		resto2[0]=comeco;
		for(int i=0;i<resto.length;i++) {
			resto2[i+1]=Integer.parseInt(resto[i]);
		}
	    int menor = 999;
	    int i;

	    for (i = 0; i < tamanho; i++){
	        if (resto2[i] < menor){
	            menor = resto2[i];
	        }
	    }
	    return menor;
	}
	public static int achaMaior(int comeco, String resto[]){
		int tamanho=resto.length+1;
		int[] resto2=new int[tamanho];
		resto2[0]=comeco;
		for(int i=0;i<resto.length;i++) {
			resto2[i+1]=Integer.parseInt(resto[i]);
		}
	    int maior = 0;
	    int i;

	    for (i = 0; i < tamanho; i++){
	        if (resto2[i] > maior){
	            maior = resto2[i];
	        }
	    }
	    return maior;
	}
}


	
